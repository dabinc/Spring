package com.care.root.mybatis.member;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {

	int register(MemberDTO memberDTO);

	MemberDTO memberInfo(String id);

	int userCheck(HttpServletRequest req);

	MemberDTO userCheck(String id);

	ArrayList<MemberDTO> memberList();

	int countMember();

	void keepLogin(Map<String, Object> map);
	
	MemberDTO getUserSessionId(String sessionId);

	int update(MemberDTO dto);

	void delete(String id);

	void modify(MemberDTO dto);

	int checkDup(String id);
}
