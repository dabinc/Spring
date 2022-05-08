package com.care.ajax;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("none_ajax")
	public String njax(HttpServletRequest req) {
		System.out.println("NONE ajax 실행");
		System.out.println(req.getServletPath());
		return "none_ajax1";
	}
	
	@GetMapping("ajax2")
	public String ajax2(HttpServletRequest req) {
		System.out.println("ajax 실행");
		System.out.println(req.getServletPath());
		return "ajax2";
	}
	
	@GetMapping("ajax3")
	public String ajax3() {
		return "ajax3_result";
	}
	
	static int count = 0;
	@GetMapping("result3")
	@ResponseBody //jsp 페이지가 아닌 데이터 값을 반환할때 써야한다
	public String result3() {
		return ++count + "";
	}
	
	@GetMapping("ajax4")
	public String ajax4() {
		return "ajax4";
	}
	
	@PostMapping (value="result4",
			produces="application/json; charset=utf-8")
	@ResponseBody
	public InfoDTO result4(@RequestBody InfoDTO dto){
		System.out.println(dto.getAge());
		System.out.println(dto.getName());
		dto.setName("changed");
		dto.setAge(100);
		return dto;
	}
	
	@PostMapping (value="result4_1",
			produces="application/json; charset=utf-8")
	@ResponseBody
	public Map result4(@RequestBody Map dto){
		System.out.println(dto.get("age"));
		System.out.println(dto.get("name"));
		System.out.println(dto.get("phone"));
		
		InfoDTO a = new InfoDTO();
		a.setAge(66);
		a.setName("changed");
		dto.put("age", 66);
		dto.put("name", "changed");
		dto.put("phone", "1111-1111");
		dto.put("info", a);
		return dto;
	}
	
	@GetMapping("ajax5")
	public String ajax5() {
		return "ajax5";
	}
	
	@GetMapping("ajax6")
	public String ajax6() {
		return "ajax6_restController";
	}
	
	
	
}
