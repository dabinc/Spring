package com.care.root.member.service;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {

	int userCheck(HttpServletRequest req);
	
	void register(HttpServletRequest req, Model model);
	
	int	checkDup(String id);
	
	ArrayList<MemberDTO> memberList();

	MemberDTO memberInfo(String id);

	int register(MemberDTO dto);

	void keepLogin(String sessionId, Date limitDate, String id);

	MemberDTO getUserSessionId(String id);

	void modify(MemberDTO dto);

	void delete(String id);

	void getMember(String id, Model model);
}
