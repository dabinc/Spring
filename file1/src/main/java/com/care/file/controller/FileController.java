package com.care.file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.resource.HttpResource;

import com.care.file.dto.FileDTO;
import com.care.file.service.FileService;
import com.care.file.service.IFileService;

@Controller
@RequestMapping("/")
public class FileController {

	@Autowired
	IFileService fileService;
	
	@RequestMapping("upload")
	public String form() {
		return "/file/uploadForm";
	}	
	
	@PostMapping("upload")
	public String upload(MultipartHttpServletRequest multiReq) {
		fileService.fileProcess(multiReq);
		return "redirect:/list";
	}		
	
	@GetMapping("download")
	public void download(@RequestParam("file") String saveName, HttpServletResponse response) throws IOException {
		response.addHeader("Content-disposition", "attachment; fileName="+saveName);
		System.out.println("saveName requestParam value :" + saveName);
		File file = new File(FileService.IMAGE_REPO+"/"+saveName); //리포에 있는 파일 가져와서 저장하기
		FileInputStream in = new FileInputStream(file);
		FileCopyUtils.copy(in, response.getOutputStream()); // 들어온걸 사용자에게 넘겨주겠다.
		in.close();
	}
	
	@GetMapping("/list")
	public String getFileList(Model model) {
		fileService.getFileList(model);
		return "/file/list";
	}
}
