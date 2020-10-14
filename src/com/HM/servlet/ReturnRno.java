package com.HM.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HM.entity.RReserveF;
import com.HM.entity.Rno;
import com.HM.service.Otherservice;
import com.HM.service.RIMservice;

/**
 * Servlet implementation class ReturnRno
 */
public class ReturnRno extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReturnRno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		/*
		 * PrintWriter out =response.getWriter(); out.println("受到请求");
		 */
		String startdate = request.getParameter("startdate"); 
		String enddate =request.getParameter("enddate");
		String size = request.getParameter("size");
		String type ="单人间";
		if(size.equals("1")) type = "双人间";
		/* System.out.println(type); */
		/*
		 * int a = startdate.compareTo(date); int b = enddate.compareTo(date);
		 * 
		 * System.out.println(a); System.out.println(b);
		 */
		/* System.out.println(startdate+enddate); */
		Otherservice ax = new Otherservice();
		
		//先保存空闲的房间号，然后保存预约表中符合要求的房间号
		List<Rno> availableRno = ax.findFree(type);
		
		//存放预约表大小符合要求的房间
		List<Rno> rno = ax.findRno(type);
		
		//保存某一房间的预约情况
		List<RReserveF> roomdate;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		int ia,fa,ga,ha,hb;
		
		//预约表不为空则从预约表中查找符合需求的房间号
		if(rno!=null) {
			//逐个房间确定
			for (int i = 0; i < rno.size(); i++) { 
				Rno y = rno.get(i);
				/* System.out.println(y.getRno()+"  "); */
				//获取该房间的预约情况
				roomdate = ax.findDate(y.getRno());
				//确定时间是否冲突
				for (int j = 0; j < roomdate.size(); j++) {
					RReserveF b = roomdate.get(j);
					String  Fend =  sdf.format(b.getEnddate());
					String  Fstart =  sdf.format(b.getStartdate());
					if(j+1== roomdate.size()) {
						/* System.out.println("结束了"); */
						ha = startdate.compareTo(Fend);
					    hb = enddate.compareTo(Fstart);
						if(ha>0||(hb<0&&roomdate.size()==1)) {
							/* System.out.println(y.getRno()+"这样也行"); */
							availableRno.add(y);
							break;
						}	
					}
					else {
						RReserveF c = roomdate.get(j+1);
						/* System.out.println(b.getName()+c.getName()); */
					    String  Sstart =  sdf.format(c.getStartdate());
					    ia = enddate.compareTo(Fstart);
						fa = startdate.compareTo(Fend);
						ga = enddate.compareTo(Sstart);
						
						/* if(fa==1) System.out.println("shide"); */
						/*
						 * System.out.println(startdate+Fend+enddate+Sstart+fa+ga); if(ga==-1)
						 * System.out.println("shid");
						 */
						 
					    if((fa>0 && ga<0)||(ia<0&&j==0)) {
					    	availableRno.add(y);
					    	break;
					    }
					}  
			   }
		   }
		}
		
		/* for(Rno x:availableRno ) { System.out.println(x.getRno()); } */
		HttpSession session = request.getSession();
		session.setAttribute("startdate", startdate);
		session.setAttribute("enddate", enddate);
		session.setAttribute("size", type);
		request.setAttribute("availableRno", availableRno);
		request.getRequestDispatcher("chooseRno.jsp").forward(request, response);
		 
		
	}

}
