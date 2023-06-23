package com.demo.service;

import com.demo.bean.MyUser;
import com.demo.bean.RegisterUser;

public interface LoginService {

	MyUser ValidateUser(String uname, String passwd);

	int addRegisterUser(RegisterUser ru, MyUser user);

}
