package com.choid.file.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choid.file.model.vo.FileVO;
import com.choid.file.service.FileService;
import com.choid.file.service.IFileService;

/**
 * @Controller needs annotation
 * @Getmapping�� �ҽ����� �ڿ��� �����´�
 * @RequestMapping("/file") if not stated elsewhere
 */


@Controller
public class FileController {

	@Autowired
	private IFileService fileService;
	
		@GetMapping("/new")
		public String uploadFile(ModelMap model) {
			model.addAttribute("dir", "/");
			return "/file/form";
		}
		
		@PostMapping("/save")
		public String uploadFile(@RequestParam(value="dir", required=false, defaultValue="/")String dir,
				@RequestParam MultipartFile file, RedirectAttributes redi) {
			try {
				if (file!=null && !file.isEmpty()) {
					FileVO newFile = new FileVO();
					newFile.setDirectoryName(dir);
					newFile.setFileName(file.getOriginalFilename());
					newFile.setFileSize(file.getSize());
					newFile.setFileContentType(file.getContentType());
					newFile.setFileData(file.getBytes());
					fileService.uploadFile(newFile);
				}
			} catch (IOException e) {
				e.printStackTrace();
				redi.addFlashAttribute("message", e.getMessage());
			}
			return "redirect:/list";
		}
		
		@GetMapping("/img/{fileId}")
		public ResponseEntity<byte[]> getImageFile(@PathVariable int fileId) {
			FileVO file = fileService.getFile(fileId);
			// �̹��������� header�� �ִ� �����͸� ������ ������ �ؾ��Ѵ�.
			// ����� content-type = image, ����Ʈ ������ ���� �־
			final HttpHeaders headers = new HttpHeaders();
			if(file != null) {
				String[] mediaTypes = file.getFileContentType().split("/");
				// ������ image/e.png �� ����Ǿ��ִµ� /�� �ɰ��ָ� ������ ������ Ÿ���� �����Ѵ�
				headers.setContentType(new MediaType(mediaTypes[0], mediaTypes[2]));
				headers.setContentDispositionFormData("attachment", file.getFileName());
				headers.setContentLength(file.getFileSize());
				// ������ ���� ��� �������̼����� �۾��� �ϰ� �ش� ���� ��°�θ� �����Ѵ�
				return new ResponseEntity<byte[]>(file.getFileData(), headers, HttpStatus.OK);	
			} else {
				return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
				// ������ 404 ����
			}
		}
		
		@GetMapping("/list")
		public String getAllFileList(Model model) {
			model.addAttribute("fileList", fileService.getAllFileList());
			return "/file/list";	
		}

		@GetMapping("/list/{dir}")
		public String getAllFileListByDir(Model model, @PathVariable String dir) {
			model.addAttribute("fileList", fileService.getFileListByDir("/" + dir));
			return "/file/list";
		}
		
		//list�� file/���ϸ��� ���ؼ� �޴� ��
		@GetMapping("/info/{fileId}")
		public String getFileInfo(Model model, @PathVariable int fileId) {
			FileVO file = new FileVO();
			model.addAttribute("file", fileService.getFile(fileId));
			return "/file/info";
		}
		
		//home���� search by id�� �����ִ� action�±�; get ���
		@GetMapping("/info")
		public String getFileInfoBySearch(Model model, int fileId) {
			if (fileService.getMaxFileId() < fileId || fileId==0) {
				return "/file/failPage";
			}
			FileVO file = fileService.getFile(fileId);
			model.addAttribute("file", file);
			return "/file/info";
			
		}
		
		@GetMapping("/delete/{fileId}")
		public String deleteFile(@PathVariable int fileId) {
			if (fileId==0 || fileService.getMaxFileId() < fileId) {
				return "/file/failPage";
			}
			fileService.deleteFile(fileId);
			return "redirect:/list";
		}
		
		
}
