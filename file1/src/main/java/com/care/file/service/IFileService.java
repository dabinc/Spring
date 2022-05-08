package com.care.file.service;

import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.file.dto.FileDTO;

public interface IFileService {
	
	public String IMAGE_REPO = "c:/spring/image_repo";
	
	//int upload(FileDTO file);
//	int	download(FileDTO file);
//	FileDTO	getFile(String fileId);
	void fileProcess(MultipartHttpServletRequest multiReq);

	void getFileList(Model model);	
	}
