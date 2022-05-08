package com.care.file.mybatis;

import java.util.ArrayList;

import com.care.file.dto.FileDTO;

public interface IFileMapper {
//
//	int uploadFile(FileDTO file);
//
//	int downloadFile(FileDTO file);
//
//	FileDTO getFile(String fileId);
//
//	ArrayList<FileDTO> getAllFileList();

	public void saveFile(FileDTO dto);

	public ArrayList<FileDTO> getFileList();
	
}
