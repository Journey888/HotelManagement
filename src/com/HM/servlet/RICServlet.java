package com.HM.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HM.entity.Room;
import com.HM.service.RIMservice;

public class RICServlet extends HttpServlet {

	
	public RICServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		//PrintWriter out =response.getWriter();
		//out.println("#");
		
		RIMservice a = new RIMservice();
		List<Room> roomList = a.findAll();
		
		//转发前绑定数据
		request.setAttribute("roomList", roomList);
		//转发
		request.getRequestDispatcher("RIC.jsp").forward(request, response);
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
