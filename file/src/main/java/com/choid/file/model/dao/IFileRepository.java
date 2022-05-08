package com.choid.file.model.dao;

import java.util.List;

import com.choid.file.model.vo.FileVO;

public interface IFileRepository {

	int getMaxFileId();
	void uploadFile(FileVO file);
	FileVO getFile(int fileId);
	List<FileVO> getAllFileList();
	List<FileVO> getAllFileList(String dir);
	void deleteFile(int fileId);
	
}
