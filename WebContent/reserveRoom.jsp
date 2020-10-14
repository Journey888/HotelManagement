<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Bmain.css">
<link rel="stylesheet" href="FormCSS.css">
<script type="text/javascript">
         //js代码
         function clearMsg(){
             var spanEle = document.getElementById("reserveSpan");
             spanEle.innerHTML ="";
             }
    </script>
</head>
<body>
<% HttpSession sessionHttpSession = request.getSession();
String Rno = request.getParameter("rno");
session.setAttribute("chooseRno", Rno);
String Rent = request.getParameter("rent");
session.setAttribute("chooseRent",Rent);%>
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
     <form action="reserveServlet?Rno=${sessionScope.chooseRno}&&startdate=${sessionScope.startdate}&&enddate=${sessionScope.enddate}&&Rent=${sessionScope.chooseRent}&&Size=${sessionScope.size}" method="post">
     <h2>请填写其他入住信息</h2>
     <font>房间号：${sessionScope.chooseRno}</font>
     </br>
     <fond>房间类型：${sessionScope.size}</fond>
     </br>
     <font>租金：${sessionScope.chooseRent}/天</font>
     </br>
     <font>入住日期：${sessionScope.startdate}</font>
     </br>
     <font>结束日期：${sessionScope.enddate}</font>
     
     <input type="text" placeholder="姓名" name="name" class="txtb" onfocus="clearMsg();">
     <input type="text" placeholder="身份证号码" name="idcard" class="txtb">   
     <input type="text" placeholder="电话" name="phone" class="txtb">
     <input type="text" placeholder="电子邮箱" name="email" class="txtb">
     <select name ="sex">
               <option value="0">男</option>  
               <option value="1">女</option>
        </select>
        <span id=reserveSpan>${requestScope.reserve_msg}</span>
     <input type="submit" value="确认" class="signup-btn"> 
     </form>
   </div>
</body>
</html>