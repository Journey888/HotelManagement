package com.HM.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HM.service.loginservice;

/**
 * 处理登录请求的Servlet
 * 
 * Servlet是sun公司制定的标准，Tomcat(web应用服务器，Servlet容器）实现了这些标准
 *
 *HttpServlet
 */

public class LoginServlet extends HttpServlet{
    
	/**
	 * 常用方法： doGet  doSet  service
	 * doGet：处理客户端的get方法的请求
	 * doPost：处理客户端的post方法的请求
	 * 
	 * service：根据具体的请求方式去调用doGet 和doPost
	 */
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//登录功能的实现，
		req.setCharacterEncoding("utf-8");
		String no = req.getParameter("no");
		String password = req.getParameter("password");
		String usertype =req.getParameter("usertype");
		resp.setContentType("text/html;charset=utf-8");
		
		HttpSession session = req.getSession();
		
		/* PrintWriter out =resp.getWriter(); */
		//out.println("登录成功");
	    
		loginservice a = new loginservice();
		int b = a.login(no, password, usertype);
	    if(b == 1){
            session.setAttribute("loginUser", no);
			resp.sendRedirect("Fmain.jsp");
		}
		else if(b == 2) {
			//out.println("后台登录成功")
			//登录用户设置到session中
			/* HttpSession session = req.getSession(); */
			
			session.setAttribute("loginUser", no);
			
			resp.sendRedirect("Bmain.jsp");
		}
		else{
			//1.登录失败通过重定向的方式去往登录页面
			/*
			 * 服务器给浏览器发送一个302状态码以及一个新的地址
			 */
			//resp.sendRedirect("Flogin.jsp");
			
			/*
			 * 2.登录失败后，转发
			 */
			//转发之前，绑定数据,就是将想要交给 下一个组件（jsp）处理的数据，绑定到request对象中
			req.setAttribute("login_msg","用户名或密码错误" );
			//获取转发器
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			//开始转发
			rd.forward(req, resp);
		}
		
	}
			
} 
	

