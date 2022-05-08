package com.care.file.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.file.dto.FileDTO;
import com.care.file.mybatis.IFileMapper;

@Service
public class FileService implements IFileService{
	
	@Autowired
	IFileMapper fileMapper;
	@Override
	public void fileProcess(MultipartHttpServletRequest multiReq) {
		/**
		* This method enables - file uploads
		* making different file names so that nothing gets overridden
		* ex) 202212250000-fileName.jpg
		*/
		FileDTO dto = new FileDTO();
		dto.setId(multiReq.getParameter("id"));
		dto.setName(multiReq.getParameter("name"));
	
		MultipartFile file = multiReq.getFile("file");
		if (!file.isEmpty()) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String time = format.format(calendar.getTime());
		
			String sysFileName = time + file.getOriginalFilename();
			dto.setSaveName(sysFileName);
			File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			dto.setSaveName("none");
		}
		fileMapper.saveFile(dto);
	}
	@Override
	public void getFileList(Model model) {
		/**
		* This method get all files to list
		*/
		model.addAttribute("fileList", fileMapper.getFileList());	
	}
	
}
