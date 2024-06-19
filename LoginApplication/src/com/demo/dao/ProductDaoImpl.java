package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {
	
	static Connection conn;
	static PreparedStatement pgetall;
	static {
		conn=DBUtil.getMyConnection();
		try {
			pgetall=conn.prepareStatement("select * from product");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		
		try {
			ResultSet rs = pgetall.executeQuery();
			List<Product> plist = new ArrayList<>();
			while(rs.next())
			{
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4));
				
				plist.add(p);
				
			}
			return plist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
