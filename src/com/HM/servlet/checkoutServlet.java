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
 * Servlet implementation class checkoutServlet
 */
public class checkoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkoutServlet() {
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String idcard = request.getParameter("idcard");
		Otherservice a = new Otherservice();
		RReserveF b = a.findbyId(idcard);
		if(b==null){
			request.setAttribute("checkout_msg", "抱歉您没有入住");
			//获取转发器
			RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
			//开始转发
		 	rd.forward(request, response);
		}
		else {
			String nowdate = sdf.format(new Date());
			String enddate = sdf.format(b.getEnddate());
			String startdate = sdf.format(b.getStartdate());
			int y = enddate.compareTo(nowdate);
			if(y==0){
				RReserveF x = a.findbyId(idcard);
				long startSec = x.getStartdate().getTime();
				long endSec = x.getEnddate().getTime();
				long sec = endSec-startSec;
				long days = sec/(1000*60*60*24);
				int rent = Integer.valueOf(x.getRent());
				double earnings = (days+1)*rent;
				a.insertForm(x.getRno(), x.getName(), x.getIdcard(), startdate, enddate, x.getSize(), x.getRent(), earnings);
				a.deleteReserve(idcard); 
				request.setAttribute("earnings",earnings);
				//获取转发器
				RequestDispatcher rd = request.getRequestDispatcher("pay.jsp");
				//开始转发
			 	rd.forward(request, response);
			}
			else {
				request.setAttribute("checkout_msg", "您的入住截止至"+enddate+"请按时结账");
				//获取转发器
				RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
				//开始转发
			 	rd.forward(request, response);
			}
		  }
		
	}

}
