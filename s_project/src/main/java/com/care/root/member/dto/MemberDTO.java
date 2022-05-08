package com.care.root.member.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.datetime.DateFormatter;

public class MemberDTO {
	private String id;
	private String pw;
	private String addr;
	private int number;
	private String regDate;
	private java.sql.Date limitTime; //for auto login cookie
	private String sessionId;
	
	public java.sql.Date getCookieExpiry() {
		return limitTime;
	}

	public void setCookieExpiry(java.sql.Date limitTime) {
		this.limitTime = limitTime;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
