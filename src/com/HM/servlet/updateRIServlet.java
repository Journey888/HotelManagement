package com.HM.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HM.entity.Room;
import com.HM.service.RIMservice;

/**
 * Servlet implementation class updateRIServlet
 */
public class updateRIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateRIServlet() {
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
		String rno = request.getParameter("Rno");
		String size = request.getParameter("size");
		String rent =request.getParameter("rent");
		String type = "单人间";
		if(size.equals("1")) type = "双人间";
		RIMservice a = new RIMservice();
		a.updateRI(rno, type, rent);
		
		List<Room> roomList = a.findAll();
		  
		//转发前绑定数据 
		request.setAttribute("roomList", roomList); 
		//转发
		request.getRequestDispatcher("RIC.jsp").forward(request, response);
		
	}

}
