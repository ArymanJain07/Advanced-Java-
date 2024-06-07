package com.demo.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestConnection {

	public static void main(String[] args) throws SQLException {
		 Connection conn = null;
		try {
			
			//Register Driver			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.150:3306/dac16";
			// get Connection
			conn=DriverManager.getConnection(url,"dac16","welcome");
			// checking connection
			if(conn!=null) {
				System.out.println("Connection Done");
			}
			// create statement
			Statement st = conn.createStatement();
			displaydata(st);
			
			//SQL Injection problem 
			
			String s1 ="3001' or amt='18.69";
			String query ="select * from orders where onum='"+s1+"'";
			System.out.println(query);
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				System.out.println("Order Num :"+rs.getInt(1));
				System.out.println("Amount : "+rs.getString(2));
				System.out.println("Order Date :"+rs.getDate(3));
				System.out.println("-------------->");
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
	}
	
	private static void displaydata(Statement st) {
		
		ResultSet rs;
		
		try {
			rs=st.executeQuery("select * from orders");
			
			while(rs.next()) {
				System.out.println("Order Num :"+rs.getInt(1));
				System.out.println("Amount : "+rs.getString(2));
				System.out.println("Order Date :"+rs.getDate(3));
				System.out.println("-------------->");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
