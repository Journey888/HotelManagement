package com.HM.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HM.entity.FStuff;
import com.HM.service.FIMservice;

/**
 * Servlet implementation class deleteFIServlet
 */
public class deleteFIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteFIServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String no = request.getParameter("No");
		/* System.out.println(no); */
		FIMservice a = new FIMservice();
		a.deleteFI(no);
		List<FStuff> stuffList = a.findAll();
		/*
		 * for (int i = 0; i < stuffList.size(); i++) { FStuff d = stuffList.get(i);
		 * System.out.println(d.getNo()+d.getPassword()+d.getName()); }
		 */
		//转发前绑定数据
		request.setAttribute("stuffList", stuffList);
		//转发
		request.getRequestDispatcher("FIC.jsp").forward(request, response);
		
	}

}
