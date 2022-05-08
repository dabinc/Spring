package com.care.root.autologin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class FileConfig {

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		/**
		 * create file bean with size limit of 50MB, encode as UTF-8
		 * This is same as <beans:bean> in xml files.
		 */
		CommonsMultipartResolver mr = new CommonsMultipartResolver();
		mr.setMaxUploadSize(52428800);
		mr.setDefaultEncoding("utf-8");
		
		return mr;
	}
	
}
