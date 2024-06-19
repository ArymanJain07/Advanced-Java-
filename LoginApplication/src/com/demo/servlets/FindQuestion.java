package com.demo.servlets;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.RegisterUser;
import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;

public class FindQuestion extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("uname");
		UserService uservice=new UserServiceImpl();
		RegisterUser r=uservice.findQuestion(uname);
		out.println("<form action='checkanswer' method='post'>");
		out.println("Question : "+r.getQuestion());
		out.println("Answer : <input type='text' name='ans' id='ans'>");
		out.println("<button type='submit' name='btn' id='btn' >Change Password</button>");
		
		out.println("</form>");
	}
}
