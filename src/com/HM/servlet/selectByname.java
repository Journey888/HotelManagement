package com.HM.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HM.entity.Client;
import com.HM.service.Otherservice;

/**
 * Servlet implementation class selectByname
 */
public class selectByname extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectByname() {
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
		String name = request.getParameter("name");
		Otherservice a = new Otherservice();
		List<Client> b = a.selectByname(name);
		if(b.size()==0) {
			request.setAttribute("select_msg","该用户未入住过本酒店" );
			//获取转发器
			RequestDispatcher rd = request.getRequestDispatcher("selectByname.jsp");
			//开始转发
			rd.forward(request, response);
		}
		else {
		request.setAttribute("Client",b );
		//获取转发器
		RequestDispatcher rd = request.getRequestDispatcher("returnselect.jsp");
		//开始转发
	 	rd.forward(request, response);
	    }
	}

}
