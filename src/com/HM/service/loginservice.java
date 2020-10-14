package com.HM.service;

import org.apache.ibatis.session.SqlSession;

import com.HM.dao.LoginMapper;
import com.HM.entity.BStuff;
import com.HM.entity.FStuff;

import util.SessionUtil;

public class loginservice {
	

	public int login(String no , String psw, String type) {
		//1、接收用户的输入用户名和密码 ( 来自于UI显示层)
		//2、接收的用户名和密码进行数据库查询
		SqlSession session = SessionUtil.getSession();
		LoginMapper mapper  = session.getMapper(LoginMapper.class);
		
		if(type.equals("0")) {
		FStuff  a =  mapper.login0(no, psw);  //数据库查询到的数据

			//前台登录成功返回1
		   if(a != null) {
			    session.close();
		    	return 1;
			 
		   }
		   //没有数据，返回0
		   session.close();
		   return 0;
	    }
		else{
			BStuff a =  mapper.login1(no, psw);
			//后台登录成功返回2
			 if(a != null) {
				    session.close();
			    	return 2;
				 
			   }
			//没有数据，返回0
			   session.close();
			   return 0;
		}
    }
}
