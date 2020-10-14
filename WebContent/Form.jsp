<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.HM.entity.Form"%>
<%@page import="java.util.List"%>
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
       <li><a href="#">前台操作员信息管理</a>
         <ul>
            <li><a href="FICServlet">前台操作员信息查询</a>
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
     <caption>统计报表</caption>
               <tr>
                   <th>房号</th>
                   <th>姓名</th>
                   <th>身份证号</th>
                   <th>入住日期</th>
                   <th>退房日期</th>
                   <th>房间类型</th>
                   <th>每日租金(元)</th>
                   <th>支付(元)</th>
               </tr>
               <%
                 List<Form> formlist = (List<Form>) request.getAttribute("formlist");
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
               int total =0;
                 for(Form form:formlist){
                	 String startdate = sdf.format(form.getStartdate());
                	 String enddate = sdf.format(form.getEnddate());
                	 %>
                	 <tr align="center">
                	   <td><%=form.getRno()%></td>
                	   <td><%=form.getName()%></td>
                	   <td><%=form.getIdcard()%></td>
                	   <td><%=startdate%></td>
                	   <td><%=enddate%></td>
                	   <td><%=form.getSize()%></td>
                	   <td><%=form.getRent()%></td>
                	   <td><%=form.getEarnings()%></td>
                	   <td>
                	</tr>
                	<% 
                 }
               %>
               <tr align="center">
                   <td>总收入:<font>${requestScope.total}</font></td>
               </tr>
      </table>
   </div> 
</body>
</html>