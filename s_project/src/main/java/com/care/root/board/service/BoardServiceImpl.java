package com.care.root.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardMapper boardMapper;
	@Autowired
	BoardFileService boardFileService;
	
	
	@Override
	public void boardList(Model model, int page) {
		/**
		* This method returns all boardDTO items
		* each page contains 5 items.
		*/
		int perPage = 5; //restricted to show only 5 per page
		int size = boardMapper.getBoardCount();
		System.out.println(size + "size");
		int totalPages = Math.floorDiv(size, perPage) + Math.floorMod(size, perPage);
		System.out.println(Math.floorDiv(size, perPage));
		System.out.println(Math.floorMod(size, perPage));
		System.out.println(totalPages + "total pages");
		int end;
		System.out.println("page" + page);
		if (page <= 1) {
			end = 5;			
		} else if (page > totalPages){
			end = totalPages * perPage;
		} else {
			end = perPage * page;
		}
		// if page is 30 and only have 5 pages to show,
		// start index is 21 and end is 25
		// if page is 5, end index is 25 and start is 21
		// if page is 1, end index is 5 and start is 1
		// if page is 0, end index is 5 and start is 1
		int start = end + 1 - perPage;
		System.out.println("end " + end);
		System.out.println("start " + start);
				
		model.addAttribute("repeat", totalPages);
		model.addAttribute("boardList", boardMapper.boardList(start, end));
	}

	@Override
	public void boardDelete(String id) {
		/**
		* This method deletes a board
		*/
		boardMapper.boardDelete(id);
	}

	@Override
	public String uploadProcess(MultipartHttpServletRequest req) {
		/**
		* This method processes a file for uploading
		*/
		BoardDTO dto = new BoardDTO();
		dto.setId(req.getParameter("id"));
		dto.setTitle(req.getParameter("title"));
		dto.setContent(req.getParameter("content"));
		MultipartFile file = req.getFile("imageFileName");
		
		if(file.getSize() != 0) {
			dto.setImageFileName(boardFileService.saveFile(file));
		}
		else {
			dto.setImageFileName("none");
		}
		// success = 1
		int result = boardMapper.upload(dto);
		String msg, url;
		if (result == 1) {
			msg = "Upload Successful !";
			url = "/root/board/list";
		} else {
			msg = "Upload failed !";
			url = "/root/board/list";
		}
		return boardFileService.getMessage(msg, url);
	}

	@Override
	public BoardDTO view(String writeNo) {
		/**
		* This method shows all content of a board item
		*/
		upHit(writeNo);
		return boardMapper.view(writeNo);
	}

	private void upHit(String writeNo) {
		/**
		* This method increase view count by 1
		*/
	
		boardMapper.upHit(writeNo);
		
	}

	@Override
	public String update(MultipartHttpServletRequest req) {
		/**
		* This method updates a board item
		*/
		BoardDTO dto = new BoardDTO();
		dto.setWriteNo(Integer.parseInt(req.getParameter("writeNo")));
		dto.setTitle(req.getParameter("title"));
		dto.setContent(req.getParameter("content"));
		MultipartFile file = req.getFile("imageFileName");
		
		if(!file.isEmpty() || file.getSize() != 0) {
			// if image exist 
			dto.setImageFileName(boardFileService.saveFile(file));
			boardFileService.deleteOriginalImage(req.getParameter("originalFileName"));
		}
		else {
			dto.setImageFileName(req.getParameter("originalFileName"));
		}
		// success = 1
		int result = boardMapper.update(dto);
		String msg, url;
		if (result == 1) {
			msg = "Update Successful !";
			url = "/root/board/view?writeNo=" + dto.getWriteNo();
		} else {
			msg = "Update failed !";
			url = "/root/board/update?writeNo=" + dto.getWriteNo();
		}
		return boardFileService.getMessage(msg, url);
	}

	@Override
	public void addReply(BoardRepDTO dto) {
		/**
		* This method adds reply to the board content ${writeNo}
		*/
		boardMapper.addReply(dto);
	}

	@Override
	public List<BoardRepDTO> showReply(int write_group) {
		/**
		* This method returns all replies associated with one board content
		*/
		return boardMapper.showReply(write_group);
	}


	
	
}
