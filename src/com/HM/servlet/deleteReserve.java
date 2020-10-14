package com.HM.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HM.entity.RReserveF;
import com.HM.service.Otherservice;

/**
 * Servlet implementation class deleteReserve
 */
public class deleteReserve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteReserve() {
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
		String idcard = request.getParameter("idcard"); 
		Otherservice a = new Otherservice();
		RReserveF x = a.findbyId(idcard);
		a.deleteReserve(idcard);
		List<RReserveF> other = a.findDate(x.getRno());
		/*
		 * for (int i = 0; i < other.size(); i++) { RReserveF b = other.get(i);
		 * System.out.println(b.getName()); }
		 */
		
		if(other.size()==0){
            a.setRoomState("空闲",x.getRno()); 
		}
		 
		a.updateClientleft("已退房"," ",idcard);	
				
		List<RReserveF> b = a.findAllRe();
		request.setAttribute("reservelist", b);
		request.getRequestDispatcher("RRC.jsp").forward(request, response);
	}

}
