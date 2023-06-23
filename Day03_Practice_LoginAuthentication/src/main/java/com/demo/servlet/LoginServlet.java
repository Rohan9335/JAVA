package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.MyUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

public class LoginServlet extends HttpServlet{
		
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws  ServletException,IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String uname=req.getParameter("uname");
		String passwd=req.getParameter("pass");
		LoginService ls=new LoginServiceImpl();
		MyUser u=ls.ValidateUser(uname,passwd);
		
		if(u==null) {
			out.println("<h2>Invalid Credentials</h2>");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, res);
		}
		else {
			out.println("<h2>Successfull Login<h2/>");
		}
		
	}
}
