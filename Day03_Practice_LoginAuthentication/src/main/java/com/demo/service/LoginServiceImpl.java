package com.demo.service;

import com.demo.bean.MyUser;
import com.demo.bean.RegisterUser;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService{
		
	 private LoginDao loginDao;
	  
	 public LoginServiceImpl() {
		loginDao=new LoginDaoImpl();
	}
	@Override
	public MyUser ValidateUser(String uname, String passwd) {
		
		return loginDao.authenticateUser(uname,passwd);
	}
	@Override
	public int addRegisterUser(RegisterUser ru, MyUser user) {
		return loginDao.registerUser(ru,user);
	}

}
