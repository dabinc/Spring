package com.care.root.mybatis.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;

public interface BoardMapper {

	ArrayList<BoardDTO> boardList(
			@Param("s") int start, @Param("e")int end);
	// 두개 이상 값 넘어오면 mapper 에러발생 ; 
	// @Param이라는걸 넣어줘야한다.
	// 그게 싫다면 dto로 만들어서 주든 해야 한다.
	
	int update(BoardDTO dto);
	
	int getBoardCount();
	
	void boardDelete(String id);

	BoardDTO view(String id);

	void update(HttpServletRequest req);

	BoardDTO getAuthor(String writeNo);

	int upload(BoardDTO dto);
	
	void upHit(String writeNo);

	void addReply(BoardRepDTO dto);
	
	List<BoardRepDTO> showReply(int write_group);
}
