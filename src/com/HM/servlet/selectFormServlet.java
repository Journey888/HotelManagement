package com.HM.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HM.entity.Form;
import com.HM.service.Otherservice;

/**
 * Servlet implementation class selectFormServlet
 */
public class selectFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectFormServlet() {
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
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		int y = startdate.compareTo(enddate);
		if(y>0) {
			request.setAttribute("selectform_msg","请输入正确的查询区间");
			//获取转发器
			RequestDispatcher rd = request.getRequestDispatcher("selectForm.jsp");
			//开始转发
			rd.forward(request, response);
		}
		else {
			Otherservice a = new Otherservice();
			List<Form> b = a.selectForm(startdate, enddate);
			int  total= 0;
			if(b.size()==0) {
				request.setAttribute("selectform_msg","该时间段没有成交订单" );
				//获取转发器
				RequestDispatcher rd = request.getRequestDispatcher("selectForm.jsp");
				//开始转发
				rd.forward(request, response);
			}
			else {
		       for( int i = 0;  i < b.size() ; i++) {
					Form x = b.get(i);
					total=total+x.getEarnings();
		       }
		       request.setAttribute("total",total);
			   request.setAttribute("formlist", b);
			   request.getRequestDispatcher("Form.jsp").forward(request, response);
		    }
		}
		
		
	}
}
