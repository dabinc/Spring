package org.choid.practice;

import org.springframework.stereotype.Service;

@Service
public class PracticeService {

	public String practice(String message) {
		return "������ �޼��� : " + message;
	}
}
