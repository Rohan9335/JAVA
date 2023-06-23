package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.demo.bean.MyUser;
//import org.apache.tomcat.jni.User;
import com.demo.bean.RegisterUser;
import com.demo.bean.MyUser;
import com.mysql.cj.protocol.Resultset;

public class LoginDaoImpl implements LoginDao{
	
	private static Connection con;
	private static PreparedStatement psins,psuserins,psregins;
	static {
		con=DBUtil.getMyconnection();
		try {
			psins=con.prepareStatement("select * from user where uname=? and passwd=?");
			psregins=con.prepareStatement("insert into registeruser values(?,?,?,?,?,?,?,?)");
			psuserins=con.prepareStatement("insert into user values(?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public MyUser authenticateUser(String uname, String passwd) {
		try {
			psins.setString(1, uname);
			psins.setString(2, passwd);
			ResultSet rs=psins.executeQuery();
			while(rs.next()) {
			return new MyUser(uname,passwd,rs.getString(3));
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int registerUser(RegisterUser ru, MyUser user) {
//		psregins.set
		try {
			//Registration Table
			psregins.setInt(1, ru.getUid());
			psregins.setString(2, ru.getName());
			psregins.setString(3, ru.getAddr());
			psregins.setString(4, ru.getGender());
			psregins.setString(5,ru.getSkills()[0]);
			//java.sql.Date dt=(java.sql.Date)ob.getDt();
			psregins.setDate(6, null);
			psregins.setString(7, ru.getCity());
			psregins.setString(8,ru.getUname());
			psregins.executeUpdate();
			// User table
			psuserins.setString(1,user.getUname() );
			psuserins.setString(2, user.getPasswd());
			psuserins.setString(3, user.getRole());
			return psuserins.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}






