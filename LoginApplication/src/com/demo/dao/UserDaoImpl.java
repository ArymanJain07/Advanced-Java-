package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;

public class UserDaoImpl implements UserDao{
    static Connection conn;
    static PreparedStatement psearch,pregister,puserAdd;
    static {
    	
    	try {
    		conn=DBUtil.getMyConnection();
			psearch=conn.prepareStatement("select uname,password,role from user where uname=? and password=?");
			pregister=conn.prepareStatement("insert into registration values(?,?,?,?,?,?,?)");
			puserAdd=conn.prepareStatement("insert into user(uname,password,role,user_id) values(?,?,'user',1)");
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	@Override
	public MyUser validatedetails(String uname, String pass) {
		try {
			psearch.setString(1,uname);
			psearch.setString(2,pass);
			ResultSet rs=psearch.executeQuery();
			if(rs.next()) {
				MyUser u=new MyUser(rs.getString(1),rs.getString(2),rs.getString(3));
				System.out.println(u);
				return u;		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	@Override
	public boolean registerDetails(RegisterUser r) {
		try {
			pregister.setString(1,r.getName());
			pregister.setString(2,r.getGender());
			pregister.setString(3,r.getSkills()[0]);
			pregister.setString(4,r.getSkills()[1]);
			pregister.setString(5,r.getUsername());
			pregister.setString(6,r.getQuestion());
			pregister.setString(7,r.getAnswer());
			pregister.executeUpdate();
			puserAdd.setString(1,r.getUsername());
			puserAdd.setString(2,r.getPassword());
			puserAdd.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
