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
 * Servlet implementation class selectByrno
 */
public class selectByrno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectByrno() {
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
		String rno = request.getParameter("rno");
		int x = rno.compareTo("100");
		int y = rno.compareTo("160");
		if(x>=0&&y<=0) {
			Otherservice a = new Otherservice();
			List<Client> b = a.selectByrno(rno);
			if(b.size()==0) {
				request.setAttribute("select_msg","该用户未入住过本酒店" );
				//获取转发器
				RequestDispatcher rd = request.getRequestDispatcher("selectByrno.jsp");
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
		else {
			request.setAttribute("select_msg","请输入正确的房间号（（提示：100~160号）" );
			//获取转发器
			RequestDispatcher rd = request.getRequestDispatcher("selectByrno.jsp");
			//开始转发
		 	rd.forward(request, response);
		}
		
	}

}
