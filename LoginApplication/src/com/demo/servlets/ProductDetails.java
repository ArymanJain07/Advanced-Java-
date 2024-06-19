package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class ProductDetails extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter(); 
		
		ProductService pserv=new ProductServiceImpl();
		
		List<Product> plist =pserv.getAllProducts();
		
		out.println("<table border='2'><tr><th>Product Id"
				+ "<th> Name"
				+ "<th>Quantity"
				+ "<th>Price</tr> ");
		
		for(Product p : plist)
		{
			out.println("<tr><td>"+p.getPid()
					+ "<td>"+p.getPname()
					+ "<td>"+p.getQty()
					+ "<td>"+p.getPrice()+"</tr>");
		}
		
		out.println("</table>");
		
	}
	
}
