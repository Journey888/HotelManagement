<%@page import="java.util.List"%>
<%@page import="com.HM.entity.Rno"%>
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
      <h1>请选择房间号</h1>
      <font>入住日期:${sessionScope.startdate}</font>
      <br>
      <font>结束日期:${sessionScope.enddate}</font>
      </br>
      <fond>房间类型:${sessionScope.size}</fond>
                <%
                 List<Rno> availableRno = (List<Rno>) request.getAttribute("availableRno");
                 if(availableRno.size()==0) {
                %>
                   <h3>非常抱歉，暂时没有符合您要求的房间，请选择其他时间段试试呢</h3>
                   <% }
                   for(Rno rno:availableRno){
                	 %>
                	   <a href="reserveRoom.jsp?rno=<%=rno.getRno()%>&&rent=<%=rno.getRent() %>"><%=rno.getRno()%>(<%=rno.getRent() %>元/天)</a>
                	   <%}
                 %>
      </div>
</body>
</html>