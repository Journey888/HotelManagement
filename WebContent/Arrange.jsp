<%@page import="com.HM.entity.Arrange"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
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
  width: 700px;
  padding: 20px;
  position: absolute;
  background:#ffffff;
  top: 60%;
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
     <table border="1px" align="center" cellspacing="0px">
     <caption>客房安排信息表</caption>
               <tr>
                   <th>房号</th>
                   <th>房间类型</th>
                   <th>每日租金</th>
                   <th>姓名</th>
                   <th>房间状态</th>
                   <th>入住日期</th>
                   <th>退房日期</th>
               </tr>
               <%
                 List<Arrange> arrangelist = (List<Arrange>) request.getAttribute("ArrangeList");
                 SimpleDateFormat sb = new SimpleDateFormat("yyyy-MM-dd");
                 for(Arrange arrange:arrangelist){
                	 String start = null;
                	 String end = null;
                	 if(arrange.getStartdate()!=null){
                	  start = sb.format(arrange.getStartdate());
                	  end = sb.format(arrange.getEnddate()); 
                	 }
                	 %>
                	 <tr align="center">
                	   <td><%=arrange.getRno()%></td>
                	   <td><%=arrange.getSize()%></td>
                	   <td><%=arrange.getRent()%></td>
                	   <td><%=arrange.getName()%></td>
                	   <td><%=arrange.getState() %></td>
                	   <td><%=start%></td>
                	   <td><%=end%></td>
                     </tr>
                	 <% 
                 }
               %>
     </table>
   </div> 
</body>
</html>