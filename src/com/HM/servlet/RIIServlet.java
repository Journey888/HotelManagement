package com.HM.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HM.entity.Room;
import com.HM.service.RIMservice;

/**
 * Servlet implementation class RIIServlet
 */
public class RIIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RIIServlet() {
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
		String rno = request.getParameter("rno");
		String size = request.getParameter("size");
		String rent =request.getParameter("rent");
		response.setContentType("text/html;charset=utf-8");
		int x = rno.compareTo("100");
		int y = rno.compareTo("160");
		if(x>=0&&y<=0) {
			int z =rent.compareTo("0");
			int u =rent.compareTo("1000");
			if(z>=0&&u<=0) {
				RIMservice a = new RIMservice();
				Room b = a.findRe(rno);
				if(b==null) {
					String type = "单人间";
					if(size.equals("1")) type = "双人间";
					a.insert(rno, type, rent, "空闲");
				    request.setAttribute("insert_msg","添加成功");
				    RequestDispatcher a1=request.getRequestDispatcher("RII.jsp"); 
				    a1.forward(request, response);
			     }  
				else{
					request.setAttribute("insert_msg","该房间已存在"); 
					RequestDispatcher a2=request.getRequestDispatcher("RII.jsp");
					a2.forward(request, response);
			   }
			}
			else {
				request.setAttribute("insert_msg","请输入正确的每日租金（1000元以内）"); 
				RequestDispatcher a3=request.getRequestDispatcher("RII.jsp");
				a3.forward(request, response);
			}
			
		}
		else {
			request.setAttribute("insert_msg","请输入正确的房间号（提示：100~160号）"); 
			RequestDispatcher a4=request.getRequestDispatcher("RII.jsp");
			a4.forward(request, response);
		}
		
	}
}
