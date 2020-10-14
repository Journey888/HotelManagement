<%@page import="com.HM.entity.FStuff"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Bmain.css">
<style type="text/css">
body{
  margin: 0;
  padding: 0;
  background: #CBE7CE;
}
.signup-form{
  width: 500px;
  padding: 20px;
  position: absolute;
  background:#ffffff;
  top: 80%;
  left: 50%;
  transform: translate(-50%,-50%);
  overflow: hidden;
}
.signup-form a{
  text-decoration: none;
  color: #111;
  font-family: "montserrat",sans-serif;
  font-size: 14px;
  padding: 10px;
  display: block;
}
.signup-form a:hover{
  background: #CBE7CE;
}
.signup-form table{
  padding: 20px;
  border:1px;
  align:center ;
  cellspacing:1px;
}

</style>
</head>
<body>
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
            <table border="1px"  align="center" cellspacing="0px">
            <caption>前台操作员信息表</caption>
               <tr>
                   <th>用户名</th>
                   <th>密码</th>
                   <th>姓名</th>
                   <th>信息更新</th>
                   <th>删除该员工</th>
               </tr>
               <!-- 循环显示信息-->
               <%
                 List<FStuff> stuffList = (List<FStuff>) request.getAttribute("stuffList");
                 
                 for(FStuff fstuff:stuffList){
                	 %>
                	 <tr align="center">
                	   <td><%=fstuff.getNo() %></td>
                	   <td><%=fstuff.getPassword() %></td>
                	   <td><%=fstuff.getName() %></td>
                	     <td><a href="updateFI.jsp?no=<%=fstuff.getNo()%>">修改密码</a></td> 
                	    <td><a href="deleteFI.jsp?no=<%=fstuff.getNo()%>">删除该员工</a></td>
                     </tr>
                	 <% 
                 }
               %>
            </table>
            </div>
</body>
</html>