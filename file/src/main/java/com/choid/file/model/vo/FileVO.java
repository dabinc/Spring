package com.choid.file.model.vo;

import java.sql.Timestamp;

public class FileVO {
	/** 파일 value object의 필드는 총 7개 **/
	private int fileId;
	private String directoryName;
	private String fileName;
	private long fileSize;
	private String fileContentType;
	private Timestamp fileUploadDate;
	private byte[] fileData;
	
	/**
	SQL> create table files (
	  2  files_id number(10) primary key,
	  3  directory_name varchar2(128) null,
	  4  file_name varchar2(128) not null,
	  5  file_size varchar2(45) null,
	  6  file_content_type varchar2(50) null,
	  7  file_upload_date timestamp not null,
	  8  file_data blob )
	 -->
	*/
	
	
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getDirectoryName() {
		return directoryName;
	}
	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public Timestamp getFileUploadDate() {
		return fileUploadDate;
	}
	public void setFileUploadDate(Timestamp fileUploadDate) {
		this.fileUploadDate = fileUploadDate;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
}
