package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;

import com.demo.beans.Movies;

public class MoviesDaoImpl implements MoviesDao{

	static Connection conn;
	static PreparedStatement mInsert,mDelete,mSelect,mUpdate,mFindId;
	
	static {
		conn = DBUtil.getMyConnection();
		
		try {
			mInsert = conn.prepareStatement("insert into movies values (?,?,?)");
			mDelete = conn.prepareCall("delete from movies where id=?");
			mSelect = conn.prepareStatement("Select * from movies");
			mUpdate = conn.prepareStatement("update movies set title=?,category=? where id=?");
			mFindId = conn.prepareStatement("select * from movies where id=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stopConn() {
		DBUtil.closeMyConnection();
	}
	
	@Override
	public void save(Movies m) {
		
		try {
			mInsert.setInt(1, m.getmId());
			mInsert.setString(2,m.getTitle());
			mInsert.setString(3, m.getCategory());
			
			int n =mInsert.executeUpdate();
			if(n>0) {
				System.out.println("Insertion into table Done");
			}else {
				System.out.println("Error Occured");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean removeById(int id) {
		
		try {
			mDelete.setInt(1, id);
			int n =mDelete.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Movies> findAll() {
		try {
			ResultSet rs = mSelect.executeQuery();
			List<Movies> mlst= new ArrayList<>();
			while(rs.next()) {
				Movies m = new Movies(rs.getInt(1),rs.getString(2),rs.getString(3));
				mlst.add(m);
			}
			return mlst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean update(int mid, String title, String catag) {
		
		try {
		
			mUpdate.setString(1, title);
			mUpdate.setString(2, catag);
			mUpdate.setInt(3, mid);
			int n =mUpdate.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Movies findById(int id) {
		
		try {
			mFindId.setInt(1,id);
			ResultSet rs =mFindId.executeQuery();
			if(rs.next()) {
				Movies m = new Movies(rs.getInt(1),rs.getString(2),rs.getString(3));
				return m;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	
	
}
