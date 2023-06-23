package com.demo.dao;

import com.demo.bean.MyUser;
import com.demo.bean.RegisterUser;

public interface LoginDao {

	MyUser authenticateUser(String uname, String passwd);

	int registerUser(RegisterUser ru, MyUser user);

}
