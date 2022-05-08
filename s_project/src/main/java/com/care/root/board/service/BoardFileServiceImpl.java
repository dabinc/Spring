package com.care.root.board.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardFileServiceImpl implements BoardFileService {

	@Override
	public String getMessage(String msg, String url) {
		/**
		* This method parses msg and url to return
		*/
		
		String message = 
				"<script>alert('"+msg+"');";
		message += "location.href='"+url+"'";
		message += "</script>";
		return message;
	}

	@Override
	public String saveFile(MultipartFile file) {
		/**
		* This method enables file downloads when clicking the designated image name.
		*/
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss-");
		Calendar cal = Calendar.getInstance();
		String time = format.format(cal.getTime());
		
		String sysFileName = time + file.getOriginalFilename();
			
		File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return sysFileName;
	}

	@Override
	public void deleteOriginalImage(String imageName) {
		/**
		* This method removes files (existing files before update)
		*/
		File d = new File(IMAGE_REPO + "/" + imageName);
		d.delete();
	}
}
