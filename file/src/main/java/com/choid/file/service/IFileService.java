package com.choid.file.service;


import java.util.List;

import com.choid.file.model.vo.FileVO;

/**
 *  service�� ���� �ƴϱ⶧���� com.choid.file.service�� ǥ��
 *  IFileRepos�� ���� ������ �޼ҵ带 �Űܿ´�.
 *  ���� ������ FileService
 */

public interface IFileService {

	int getMaxFileId();
	void uploadFile(FileVO file);
	FileVO getFile(int fileId);
	
	List<FileVO> getAllFileList();
	List<FileVO> getFileListByDir(String dir);
	void deleteFile(int fileId);
	
}
