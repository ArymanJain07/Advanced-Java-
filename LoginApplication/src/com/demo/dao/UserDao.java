package com.demo.dao;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;

public interface UserDao {

	MyUser validatedetails(String uname, String pass);

	boolean registerDetails(RegisterUser r);

}
