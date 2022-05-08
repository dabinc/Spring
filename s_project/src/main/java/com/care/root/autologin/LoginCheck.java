package com.care.root.autologin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.care.root.session.name.MemberSession;

public class LoginCheck extends HandlerInterceptorAdapter implements MemberSession{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/**
		 * This method checks if a user is logged in
		 * 
		 * true -> true
		 * false -> prints on user's screen 
		 * 
		 * post step - make sure you add a bean with this intercepter in servletcontext.xml
		 */
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute(LOGIN));
		if(session.getAttribute(LOGIN) == null) {
	         response.setContentType("text/html;charset=utf-8");
	         PrintWriter out = response.getWriter();
	         String str = "<script>";
	         str += "alert('You must log in to perform this action');";
	         str += "location.href='/root/member/login';";
	         str += "</script>";
	         out.print(str);
	         return false;
		}
		return true;
	}
	/** 
	 * intercepts (중간에 가로채) and checks if user is already logged in
	 * this removes if statements	
	 */

}
