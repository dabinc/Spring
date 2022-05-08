package com.care.root.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;

public interface BoardService {
	
	void boardList(Model model, int page);

	void boardDelete(String id);

	String uploadProcess(MultipartHttpServletRequest req);

	BoardDTO view(String writeNo);
	
	String update(MultipartHttpServletRequest req);

	void addReply(BoardRepDTO dto);



	List<BoardRepDTO> showReply(int write_group);

}
