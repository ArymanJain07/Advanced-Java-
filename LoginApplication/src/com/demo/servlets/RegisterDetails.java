package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.RegisterUser;
import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;

public class RegisterDetails extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("nm");
		String gender=request.getParameter("gender");
		String[] skill=request.getParameterValues("skill");
		String uname=request.getParameter("unm");
		String password=request.getParameter("pass");
		String que=request.getParameter("que");
		String ans=request.getParameter("ans");
		RegisterUser r=new RegisterUser(name,gender,uname,password,que,ans,skill);
		UserService uservice=new UserServiceImpl();
		boolean status=uservice.registerUserDetails(r);
		if(status)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.forward(request,response);
		}
	}
}

