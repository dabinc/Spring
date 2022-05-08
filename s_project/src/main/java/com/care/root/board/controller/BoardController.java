package com.care.root.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;
import com.care.root.board.service.BoardFileService;
import com.care.root.board.service.BoardService;
import com.care.root.session.name.MemberSession;

@Controller
@RequestMapping("board")
public class BoardController implements MemberSession {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("list")
	public String boardList(Model model, HttpSession session, 
			@RequestParam(value="page", required = false, defaultValue = "1") int page) {
			// if no page num set, use 1 as default.
			
		if (session.getId()!= null) {
			boardService.boardList(model, page);
			return "board/list";
		}
		return "error/error_general";
	}
	
	
	@GetMapping("upload")
	public String boardUpload() {
		return "board/upload";
	}
	
	@PostMapping("upload")
	public void uploadFile(MultipartHttpServletRequest req, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
	    response.setContentType("text/html;charset=utf-8");
	    out.print(boardService.uploadProcess(req));
	}
	
	@GetMapping ("view")
	public String view(@RequestParam String writeNo, Model model, HttpSession session) {
		try {
		model.addAttribute("loggedUser", session.getAttribute(LOGIN));
		BoardDTO output = boardService.view(writeNo);
		model.addAttribute("dto", output);
		
		if(output == null) {
			return "error/error_invalid";
		}
		} catch (Exception e){
			e.printStackTrace();
			return "error/error_invalid";
		}
		return "board/view";
		}
	
	public int confirmResult() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to proceed?","Warning", dialogButton);
		return dialogResult; //no is 1, yes is 0
	}
	
	@GetMapping("update")
	public String update(@RequestParam String writeNo, Model model, HttpSession session) {
		String loggedUser = (String) session.getAttribute(LOGIN);
		if (loggedUser.equals("admin") || loggedUser.equals(boardService.view(writeNo).getId())){
			model.addAttribute("dto", boardService.view(writeNo));
			return "board/update";
		}
		else {
			return "error/error_different";
		}
	}
	
	@PostMapping("update")
	public void update(MultipartHttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
	    res.setContentType("text/html;charset=utf-8");
	    out.print(boardService.update(req));
	}	
	
	@GetMapping("delete")
	public String boardDelete(@RequestParam String writeNo, HttpSession session){
		String loggedUser = (String) session.getAttribute(LOGIN);
		if (loggedUser.equals("admin") || loggedUser.equals(boardService.view(writeNo).getId())){
			if (confirmResult()==0) {
				boardService.boardDelete(writeNo);		
				}
			return "redirect:list";
			} // else 
		return "error/error_different";
	}
	
	@GetMapping("download")
	public void download(@RequestParam("file") String saveName, HttpServletResponse response) throws IOException {
		response.addHeader("Content-disposition", "attachment; fileName="+saveName);
		File file = new File(BoardFileService.IMAGE_REPO+"/"+saveName); //리포에 있는 파일 가져와서 저장하기
		FileInputStream in = new FileInputStream(file);
		FileCopyUtils.copy(in, response.getOutputStream()); // 들어온걸 사용자에게 넘겨주겠다.
		in.close();
	}
}
