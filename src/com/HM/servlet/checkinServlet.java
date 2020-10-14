package com.HM.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HM.entity.RReserveF;
import com.HM.service.Otherservice;

/**
 * Servlet implementation class checkinServlet
 */
public class checkinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkinServlet() {
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
		RReserveF b = a.findbyId(idcard);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(b==null){
			request.setAttribute("checkin_msg", "抱歉您没有预约");
			request.getRequestDispatcher("checkin.jsp").forward(request, response);
		}
		else {
			String nowdate = sdf.format(new Date()); 
			String startdate =sdf.format(b.getStartdate());
			String enddate = sdf.format(b.getEnddate());
			int x = nowdate.compareTo(startdate); 
			int y = enddate.compareTo(nowdate);
			if(x>=0&&y>=0) { 
				a.updateClientState("入住", idcard); 
				request.setAttribute("checkin_msg","入住成功");
			    request.getRequestDispatcher("checkin.jsp").forward(request, response);
			}
			else { 
				RReserveF z = a.findbyId(idcard); 
                String q =sdf.format(z.getStartdate()); 
                request.setAttribute("checkin_msg","您的预约在"+q+"请按时入住");
			    request.getRequestDispatcher("checkin.jsp").forward(request, response); }
		    }
		
		}
		
	}


