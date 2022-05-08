package com.choid.file.service;


import java.util.List;

import com.choid.file.model.vo.FileVO;

/**
 *  service는 모델이 아니기때문에 com.choid.file.service로 표현
 *  IFileRepos에 먼저 구현한 메소드를 옮겨온다.
 *  실제 구현은 FileService
 */

public interface IFileService {

	int getMaxFileId();
	void uploadFile(FileVO file);
	FileVO getFile(int fileId);
	
	List<FileVO> getAllFileList();
	List<FileVO> getFileListByDir(String dir);
	void deleteFile(int fileId);
	
}
