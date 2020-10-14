package com.HM.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HM.entity.FStuff;
import com.HM.service.FIMservice;

/**
 * Servlet implementation class FIIServlet
 */
public class FIIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FIIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String no = request.getParameter("no");
		String password = request.getParameter("password");
		String name =request.getParameter("name");
		response.setContentType("text/html;charset=utf-8");
		int x= no.compareTo("1707310100");
		int y= no.compareTo("1707310200");
		if(x>=0&&y<=0) {
			FIMservice a = new FIMservice();
			FStuff b = a.findRe(no);
			if(b==null) {
				a.insert(no, password, name);
			    request.setAttribute("insert_msg","添加成功");
			    RequestDispatcher a1=request.getRequestDispatcher("FII.jsp"); 
			    a1.forward(request, response);
		     }  
			else{
				request.setAttribute("insert_msg","该用户已存在"); 
				RequestDispatcher a2=request.getRequestDispatcher("FII.jsp");
				a2.forward(request, response);
			  
			  }
		}
		else {
			request.setAttribute("insert_msg","请输入正确的用户名");
		    RequestDispatcher a3=request.getRequestDispatcher("FII.jsp"); 
		    a3.forward(request, response);
		}
		
		 
		 
		
		
		
		
	}

}
