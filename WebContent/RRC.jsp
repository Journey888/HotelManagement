<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="com.HM.entity.RReserveF"%>
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
  width: 800px;
  padding: 20px;
  position: absolute;
  background:#ffffff;
  top: 75%;
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
     <table border="1px" align="center" cellspacing="0px" padding=20px>
     <caption>客房预约信息表</caption>
               <tr>
                   <th>房号</th>
                   <th>姓名</th>
                   <th>身份证号</th>
                   <th>入住日期</th>
                   <th>退房日期</th>
                   <th>房间类型</th>
                   <th>每日租金</th>
                   <th>删除该预约</th>
               </tr>
               <%
                 List<RReserveF> reservelist = (List<RReserveF>) request.getAttribute("reservelist");
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                 for(RReserveF reserve:reservelist){
                	 String startdate = sdf.format(reserve.getStartdate());
                	 String enddate = sdf.format(reserve.getEnddate());
                	 %>
                	 <tr align="center">
                	   <td><%=reserve.getRno()%></td>
                	   <td><%=reserve.getName()%></td>
                	   <td><%=reserve.getIdcard()%></td>
                	   <td><%=startdate%></td>
                	   <td><%=enddate%></td>
                	   <td><%=reserve.getSize()%></td>
                	   <td><%=reserve.getRent()%></td>
                	   <td>
                	   <%
                	   //与当前时间作比较
                	   boolean x = reserve.getStartdate().before(Calendar.getInstance().getTime());
                	   if(x==false){ %>
                          <a href="deleteReserve.jsp?rno=<%=reserve.getRno()%>&&name=<%=reserve.getName()%>&&startdate=<%=reserve.getStartdate()%>&&enddate=<%=reserve.getEnddate()%>&&idcard=<%=reserve.getIdcard()%>">删除该预约</a>               	   
                	   <%}%>
                        </td>
                     </tr>
                	 <% 
                 }
               %>
     </table>
   </div> 
</body>
</html>