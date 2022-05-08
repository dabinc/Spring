package com.care.root.member.controller;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;
import com.care.root.session.name.MemberSession;


@Controller
@RequestMapping("/member")
public class MemberController implements MemberSession{
	/**
	 * session의 LOGIN이라는 객체를 마음대로 쓰기위해 상속을 받는다
	 */
	

	@Autowired
	private MemberService memberService;
	
	/**
	 * info, login, memberInfo, register, successLogin
	 * url값을 받아서 매퍼를 통해 구현한 뒤 해당 뷰에 맞게 *.jsp 페이지로 돌려보내는 컨트롤러
	 * 
	 */
	@GetMapping("/login")
	public String memberLogin() {
		return "member/login";			
	}
	
	public int confirmResult() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to proceed?","Warning", dialogButton);
		return dialogResult; //no is 1, yes is 0
	}
	
	@GetMapping("/logout")
	public String memberLogout(HttpSession session, HttpServletRequest request, HttpServletResponse response, 
			@CookieValue(value="loginCookie", required=false) Cookie loginCookie) throws IOException {
		if(session.getAttribute(LOGIN) != null) { //login 되있다면
			
			if(confirmResult()==0){			
				if(loginCookie != null) {//logout when auto-login applied
					loginCookie.setMaxAge(0);
					loginCookie.setPath("/");
					response.addCookie(loginCookie);
					memberService.keepLogin("nan", new java.sql.Date(System.currentTimeMillis()),
							(String)session.getAttribute(LOGIN));
				}
				session.invalidate();
				return "redirect:login";
			} else {
			// request.getRequestURI()); this directs to current page (logout in this case)
			// if selected no, go back to previous page
			String referer = request.getHeader("Referer");
			return "redirect:"+ referer;
			}
		}
		// if not logged in (error handle)
		return "redirect:login";
	}
	
	@PostMapping("/userCheck") 
	public String userCheck(HttpServletRequest req, RedirectAttributes redi) {
		int result = memberService.userCheck(req);
		if (result == 1) {
			redi.addAttribute("id", req.getParameter("id"));
			redi.addAttribute("autoLogin", req.getParameter("autoLogin"));
			// login 성공시에 successLogin으로 id를 보낸다.
			return "redirect:successLogin";
		}
		return "redirect:login";
	}
	
	@RequestMapping("/successLogin") 
	public String successLogin(HttpServletRequest req, HttpSession session, HttpServletResponse res) {
		if (req.getParameter("autoLogin")!= null) {
			int cookieExpiry = 60*60*24*90; //90 days
			Cookie autoLogin = new Cookie("loginCookie", session.getId());
			autoLogin.setPath("/");
			autoLogin.setMaxAge(cookieExpiry);
			res.addCookie(autoLogin);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(new java.util.Date());
			cal.add(Calendar.MONTH, 3); // 3개월 후로 시간설정을 하겠다
			
			java.sql.Date limitDate = new java.sql.Date(cal.getTimeInMillis());
			memberService.keepLogin(session.getId(), limitDate, req.getParameter("id"));
			//해당 아이디와 일치하는 사용자에 대하여, 90일의시간동안 자동 로그인을 설정한다.
		}
		session.setAttribute(LOGIN, req.getParameter("id")); // 상속받았으니까 ~
		return "member/successLogin";
	}

	@GetMapping("/memberList")
	public String memberList(Model model) {
		model.addAttribute("memberList", memberService.memberList());
		return "member/memberList";
	}
	
	@GetMapping("/memberInfo")
	public String memberInfo(@RequestParam String id, Model model, HttpSession session) {
		model.addAttribute("memberInfo", memberService.memberInfo(id));
		model.addAttribute("loggedUser", session.getAttribute(LOGIN));
		return "member/memberInfo";
	}
	
	@GetMapping("/register")
	public String register() {
		return "member/register.backup";
	}
	
	@PostMapping("/register")
	public String register(MemberDTO dto) {
		int result = memberService.register(dto);
		if (result == 1) {
			JOptionPane.showConfirmDialog(null,
	                "Registration Successful",
	                "Success",
	                JOptionPane.DEFAULT_OPTION,
	                JOptionPane.PLAIN_MESSAGE);
			return "redirect:login";			
		} else {
			JOptionPane.showConfirmDialog(null,
	                "Registration Failed",
	                "Fail",
	                JOptionPane.DEFAULT_OPTION,
	                JOptionPane.PLAIN_MESSAGE);
			return "error/error_duplicate";
		}
	}

	@GetMapping("modify_form")
	public String modifyForm(@RequestParam String id,
							Model model) {
		memberService.getMember(id, model);
		return "member/modify_form";
	}
	
	@PostMapping("modify")
	public String modify(MemberDTO dto, HttpSession session) {
		if (!session.getAttribute(LOGIN).equals(dto.getId())){
			return "error/error_different";
		}
		memberService.modify(dto);
		return "redirect:memberInfo?id="+dto.getId();
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam String id, HttpSession session) {
		String loggedUser = (String) session.getAttribute(LOGIN);
		if (!loggedUser.equals(id)&& !loggedUser.equals("admin")) {
			//not admin && not account owner.
			return "error/error_different";
		}
		if (confirmResult() == 1) {
			// clicked NO
			return "redirect:memberInfo?id=" + id;
		} // clicked YES
		if (loggedUser.equals("admin")) {
			memberService.delete(id);
			return "redirect:memberList";	
		} else {
			memberService.delete(id);
			session.invalidate();
			return "redirect:logout";
		}
	}
	

	
	@GetMapping("checkDup")
	@ResponseBody
	public int checkDuplicateIds(@RequestParam String id) {
		return memberService.checkDup(id);
	}
	
}

