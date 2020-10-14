package com.HM.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

public class LoginFilter implements Filter {
    /**
     * 关闭服务器销毁方法
     */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
    
	/**
	 * 过滤处理
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//若在web.xml设置所有请求都过滤，则需直到请求是谁确保有的请求直接放行，
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		System.out.println("URL:"+ req.getRequestURL());
		String url = req.getRequestURL().toString();
		//判断要过滤的请求
		if(url.endsWith("/Login.jsp")) {
			//放行执行下一个过滤器，没有则完成访问
			arg2.doFilter(req,resp);
		}
		else if(url.endsWith("/HomePage.html")) {
			//放行执行下一个过滤器，没有则完成访问
			arg2.doFilter(req,resp);
		}
		//过滤，引导至登录界面
		else {
			resp.sendRedirect("Login.jsp");
		}
	}
    /**
     * 开启服务器初始化方法
     */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
