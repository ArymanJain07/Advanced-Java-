package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.MyUser;
import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;

public class Authentication extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		UserService uservice=new UserServiceImpl();
		MyUser u=uservice.validateUser(uname,pass);
		if(u!=null) {
			//out.println("<h3>Valid user!!</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("displayproducts");
			rd.forward(request,response);
		}else {
			out.println("<h3>InValid user, pls re enter credentials!!</h3>");
			//add the output of login file in the existing out object
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request,response);
			
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		 doGet(request,response);
	
	}

}
