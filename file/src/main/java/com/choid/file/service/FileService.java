package com.choid.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choid.file.model.dao.IFileRepository;
import com.choid.file.model.vo.FileVO;

@Service
public class FileService implements IFileService {
	
	/**
	 * FileService ����, IRepos�� �ҷ����� (���� �۾�)
	 * new() ��� @Autowired injection
	 * @Service annotation�� ���񽺿� �ٿ����Ѵ�.
	 */
	
	@Autowired
	private IFileRepository fileRepository;
	
	@Override
	public int getMaxFileId() {
		return fileRepository.getMaxFileId();
	}

	@Override
	public void uploadFile(FileVO file) {
		file.setFileId(getMaxFileId()+1);
		//auto-increment by 1
		fileRepository.uploadFile(file);

	}

	@Override
	public FileVO getFile(int fileId) {
		return fileRepository.getFile(fileId);
	}

	@Override
	public List<FileVO> getAllFileList() {
		return fileRepository.getAllFileList();
	}

	@Override
	public List<FileVO> getFileListByDir(String dir) {
		return fileRepository.getAllFileList(dir);
	}

	@Override
	public void deleteFile(int fileId) {
		// TODO Auto-generated method stub
		fileRepository.deleteFile(fileId);
		
	}

}
