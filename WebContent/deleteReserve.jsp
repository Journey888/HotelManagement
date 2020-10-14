<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Bmain.css">
<link rel="stylesheet" href="FormCSS.css">
</head>
<body>
<% HttpSession sessionHttpSession = request.getSession();
String Rno = request.getParameter("rno");
String Name = request.getParameter("name");
String startDate = request.getParameter("startdate");
String endDate = request.getParameter("enddate");
String Idcard = request.getParameter("idcard");
session.setAttribute("deleteRrno", Rno);
session.setAttribute("deleteRname",Name);
session.setAttribute("deleteRstartdate", startDate);
session.setAttribute("deleteRenddate", endDate);
session.setAttribute("deleteRidcard",Idcard);
%>
<div class="menu1">
     <ul>
       <li><a href="#">客房预订</a>
        <ul>
            <li><a href="RRCServlet">查看预约</a>
            <li><a href="RReserve.jsp">即时预约</a>
        </ul>
        </li>
       <li><a href="checkin.jsp">入住登记</a></li>
       <li><a href="#">房客查询</a>
         <ul>
            <li><a href="selectByname.jsp">根据姓名查询</a>
            <li><a href="selectBylastname.jsp">根据姓氏查询</a>
            <li><a href="selectByidcard.jsp">根据身份证查询</a>
            <li><a href="selectByphone.jsp">根据电话号码查询</a>
            <li><a href="selectByemail.jsp">根据email查询</a>
            <li><a href="selectByrno.jsp">根据房号查询</a>
        </ul>  
       </li>
        <li><a href="#">收费管理</a>
          <ul>
            <li><a href="checkout.jsp">即时结账</a>
            <li><a href="selectcheckoutServlet">今日账单</a>
          </ul> 
       </li>
       <li><a href="#"><font>用户${sessionScope.loginUser}</font></a>
         <ul>
            <li><a href="Login.jsp">用户注销</a>
         </ul>
       </li>
    </ul>
   </div>  
   <div class="signup-form">
    <form action="deleteReserve?idcard=${sessionScope.deleteRidcard}" method="post">
       <h1 align="center">是否删除该房客的信息</h1>
       姓名：<font>${sessionScope.deleteRname}</font>
       <br>
       房号：<font>${sessionScope.deleteRrno}</font>
       <br>
       入住日期：<font>${sessionScope.deleteRstartdate}</font>
       <br>
       退房日期：<font>${sessionScope.deleteRenddate}</font>
       
       <input type = "submit" value="确认删除" class="signup-btn">
    </form>
  </div> 

</body>
</html>