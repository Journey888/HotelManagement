<%@page import="java.util.List"%>
<%@page import="com.HM.entity.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Bmain.css">
<link rel="stylesheet" href="table.css">
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
   <table border="1px"  align="center" cellspacing="0px">
     <caption>用户入住信息</caption>
               <tr>
                   <th>姓名</th>
                   <th>性别</th>
                   <th>房号</th>
                   <th>身份证</th>
                   <th>入住情况</th>
               </tr>
               <%
                 List<Client> ClientList = (List<Client>) request.getAttribute("Client");
                 
                 for(Client client:ClientList){
                	 %>
                	 <tr align="center">
                	   <td><%=client.getName() %></td>
                	   <td><%=client.getSex() %></td>
                	   <td><%=client.getRno() %></td>
                	   <td><%=client.getIdcard() %></td>
                	   <td><%=client.getState() %></td>
                     </tr>
                     <% 
                 }
               %>
                
    </table>
    </div>
</body>
</html>