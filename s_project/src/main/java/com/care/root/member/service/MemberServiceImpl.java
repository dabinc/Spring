package com.care.root.member.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService{
	
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public void register(HttpServletRequest req, Model model) {
		if (userCheck(req) == 0) {
			MemberDTO member = new MemberDTO();
			member.setId(req.getParameter("id"));
			member.setPw(req.getParameter("pw"));
			member.setAddr(req.getParameter("addr"));
			memberMapper.register(member);	
		} else {
			model.addAttribute("msg", "ID is already in usage.");
		}
	}

	
	
	@Override
	public int userCheck(HttpServletRequest req) {
		MemberDTO dto = memberMapper.userCheck(req.getParameter("id"));
		if (dto != null) { // 데이터가 존재할 때
//			if (dto.getPw().equals(req.getParameter("pw"))) {
			if(encoder.matches(req.getParameter("pw"), dto.getPw() ) || dto.getPw().equals(req.getParameter("pw")) ) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public ArrayList<MemberDTO> memberList() {
		return memberMapper.memberList();
	}

	@Override
	public MemberDTO memberInfo(String id) {
		return memberMapper.userCheck(id);
	}
	
	
	@Override
	   public int register(MemberDTO dto) {
			dto.setPw(encoder.encode(dto.getPw()));
			if(memberMapper.userCheck(dto.getId()) == null) {
	    		return memberMapper.register(dto);
	    	  	} else {
	    	  		return 0;
	    	  	}
	   }

	@Override
	public void keepLogin(String sessionId, Date limitDate, String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("sessionId", sessionId);
		map.put("limitDate", limitDate);
		map.put("id", id);
		memberMapper.keepLogin(map);
	}

	@Override
	public MemberDTO getUserSessionId(String sessionId) {
		return memberMapper.getUserSessionId(sessionId);
	}

	public void delete(String id) {
		memberMapper.delete(id);
	}
	public void getMember(String id, Model model) {
		MemberDTO dto = memberMapper.userCheck(id);
		String[] addr = dto.getAddr().split("/");
		model.addAttribute("memberInfo",memberMapper.userCheck(id));
		model.addAttribute("addr",addr);
	}
	public void modify(MemberDTO dto) {
		MemberDTO d = memberMapper.userCheck(dto.getId());
		if(!d.getPw().equals(dto.getPw())) {
			System.out.println("비밀번호가 변경 되었다면");
			dto.setPw( encoder.encode(dto.getPw()) );
		}
		memberMapper.modify(dto);
	}

	@Override
	public int checkDup(String id) {
		/**
		* This method checks dups -
		*/
		if (memberMapper.checkDup(id) == 0) {
			// if no dups
			return 0;
		} // if duplicated
		return 1;
	}
}

