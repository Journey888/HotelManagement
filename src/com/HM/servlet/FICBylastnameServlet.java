package com.HM.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HM.entity.FStuff;
import com.HM.service.FIMservice;

/**
 * Servlet implementation class FICBylastnameServlet
 */
public class FICBylastnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FICBylastnameServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		String lastname = request.getParameter("lastname");
		lastname = lastname.concat("%");
		FIMservice a = new FIMservice();
		List<FStuff> stuffList = a.FICBylastname(lastname);
		if(stuffList.size()==0) {
			request.setAttribute("fstuffselect_msg","没有该姓氏的前台操作员" );
			//获取转发器
			RequestDispatcher rd = request.getRequestDispatcher("FICBylastname.jsp");
			//开始转发
			rd.forward(request, response);
		}
		else {
			request.setAttribute("stuffList",stuffList);
			//获取转发器
			RequestDispatcher rd = request.getRequestDispatcher("FIC.jsp");
			//开始转发
		 	rd.forward(request, response);
		    }
		
	}

}
