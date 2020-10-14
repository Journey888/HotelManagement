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
session.setAttribute("updateRno", Rno); %>
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
    <form action="updateRI?Rno=${sessionScope.updateRno}" method="post">
       <h1 align="center">修改<font>${sessionScope.updateRno}</font>号房间的类型与租金</h1>
            <br>
            
            <!-- 房间类型 ：单人间<input type="radio"  name="size" value="0"/> 
                              双人间<input type="radio"  name="size" value="1"/>  -->
              <input type="text" placeholder="每日租金" name="rent"  class="txtb">
              房间类型<select name ="size">
               <option value="0">单人间</option>  
               <option value="1">双人间</option>
           </select>
           <input type = "submit" value="确认修改" class="signup-btn">
    </form>
  </div>

</body>
</html>