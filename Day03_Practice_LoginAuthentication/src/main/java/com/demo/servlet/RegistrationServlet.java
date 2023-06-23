package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.MyUser;
import com.demo.bean.RegisterUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

public class RegistrationServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		int uid=Integer.parseInt(req.getParameter("uid"));
		String nm=req.getParameter("nm");
		String addr=req.getParameter("addr");
		String uname=req.getParameter("uname");
		String passwd=req.getParameter("pass");
		String[] skill=req.getParameterValues("skill");
		String gender=req.getParameter("gender");
		String dt=req.getParameter("dt");
		String city=req.getParameter("city");
		//int uid, String name, String addr, String gender, String[] skills, Date dt, String city,
		//String uname
		LoginService ls=new LoginServiceImpl();
		LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		RegisterUser ru=new RegisterUser(uid,nm,addr,gender,skill,ldt,city,uname);
		MyUser user=new MyUser(uname,passwd,"user");
		int ret=ls.addRegisterUser(ru, user);
		if(ret>0) {
			out.println("User regitered Succesfully");
		}
		else {
			out.println("User registered Not succesfully");
		}
		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		rd.forward(req, res);
	}
}
