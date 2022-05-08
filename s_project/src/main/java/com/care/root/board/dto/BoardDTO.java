package com.care.root.board.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class BoardDTO {
	/**
	 * SQL> create table mvc_board(
	 *2  Write_no number(10) primary key,
	  3  Title varchar2(100),
	  4  Content varchar2(300),
	  5  Savedate date default sysdate,
	  6  Hit number(10) default 0,
	  7  Image_file_name varchar(100),
	  8  Id varchar(20) not null,
	  9  constraint fk_test foreign key(id) references membership(id) on delete cascade
	 10  );
	 *
	 */
	private int writeNo, hit;
	private String title;
	private String content;
	private String imageFileName;
	private String id;
	private String saveDate;
	
	public int getWriteNo() {
		return writeNo;
	}
	public void setWriteNo(int writeNo) {
		this.writeNo = writeNo;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSaveDate() {
		return saveDate;
	}
	/**
	 * change time format to prettier one
	 *
	 * public void setSaveDate(String saveDate) {
	 *	this.saveDate = saveDate;
	}*
	 */
	
	public void setSaveDate(Timestamp saveDate) {
		SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		this.saveDate = s.format(saveDate);
	}
	
	
	
}