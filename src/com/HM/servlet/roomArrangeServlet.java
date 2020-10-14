package com.HM.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HM.entity.Arrange;
import com.HM.service.Otherservice;

/**
 * Servlet implementation class roomArrangeServlet
 */
public class roomArrangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public roomArrangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Otherservice a = new Otherservice();
		List<Arrange> ArrangeList = a.selectArrange();
		request.setAttribute("ArrangeList", ArrangeList);
		request.getRequestDispatcher("Arrange.jsp").forward(request, response);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*
		 * for(int i=0;i<ArrangeList.size();i++) { Arrange s=ArrangeList.get(i); String
		 * startdate = sdf.format(s.getStartdate()); String enddate =
		 * sdf.format(s.getEnddate()); System.out.println(startdate+enddate);
		 * System.out.println(s.getName()); System.out.println(s.getRno()); }
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
