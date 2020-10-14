package com.HM.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HM.entity.RReserveF;
import com.HM.service.Otherservice;

/**
 * Servlet implementation class reserveServlet
 */
public class reserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reserveServlet() {
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
		String rno = request.getParameter("Rno");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String rent = request.getParameter("Rent");
		String x = request.getParameter("sex");
		String sex="男";
		if(x.equals("1")) sex="女";
		String idcard = request.getParameter("idcard");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String size = request.getParameter("Size");
		
		Otherservice a = new Otherservice();
		
		RReserveF b = a.findbyId(idcard);
		
		if(b!=null) {
			request.setAttribute("reserve_msg","预约失败，您已存在预约"); 
			RequestDispatcher re=request.getRequestDispatcher("RReserve.jsp");
			re.forward(request, response);
		}
		else {
			/*
			 * a.insertRF(rno, name, idcard, startdate, enddate, size, rent);
			 * response.sendRedirect("Fmain.jsp");
			 */
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String nowdate = sdf.format(new Date());
			
			String roomstate = "预约";
			String clientstate = "预约";
			request.setAttribute("reserve_msg","预约成功");
			if(startdate.equals(nowdate)) {
				roomstate = "入住";
				clientstate = "入住";
				request.setAttribute("reserve_msg","欢迎入住");
			}
			/* System.out.println(roomstate+rno); */
			if(a.findClient(idcard)==null) {
				a.insertClient(name, sex, phone, email, rno, idcard, clientstate); 
			}
		    else {
				a.updateClient(idcard, rno, name, sex, phone, email,clientstate);
			}
			 a.insertRF(rno, name, idcard, startdate, enddate, size, rent); 
			 a.setRoomState(roomstate, rno);
			 
			 
			RequestDispatcher re=request.getRequestDispatcher("RReserve.jsp");
			re.forward(request, response);
		}
		
	}

}
