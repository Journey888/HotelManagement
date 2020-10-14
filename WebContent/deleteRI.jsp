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
session.setAttribute("deleteRno", Rno); %>
  <div class="menu1">
    <ul>
       <li><a href="#">前台操作员信息管理</a>
         <ul>
            <li><a href="FICServlet">查看前台操作员信息</a>
            <li><a href="FICBylastname.jsp">根据姓氏查询</a>
            <li><a href="FII.jsp">添加前台操作员信息</a>
        </ul>
       </li>
       <li><a href="#">客房信息管理</a>
          <ul>
            <li><a href="RICServlet">客房信息查询</a>
            <li><a href="RII.jsp">添加客房信息</a>
        </ul>
       </li>
       <li><a href="roomArrangeServlet">客房安排信息查询</a></li>
       <li><a href="selectForm.jsp">统计报表</a></li>
       <li><a href="#"><font>用户${sessionScope.loginUser}</font></a>
         <ul>
            <li><a href="Login.jsp">用户注销</a>
         </ul>
       </li>
    </ul>
  </div>  
  <div class="signup-form">
    <form action="deleteRI?Rno=${sessionScope.deleteRno}" method="post">
       <h1 align="center">删除<font>${sessionScope.deleteRno}</font>号房间的信息</h1>
           <%-- 房间号：<%=request.getParameter("rno") %> --%>
       
       <input type = "submit" value="确认删除" class="signup-btn">
    </form>
  </div>

</body>
</html>