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
             var spanEle = document.getElementById("selectSpan");
             spanEle.innerHTML ="";
             }
    </script>
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
      <form action="selectFormServlet" method="post">
      <h1>请选择查询时间区间</h1>
      从<input type="date" name="startdate" onfocus="clearMsg();">至<input type="date" name="enddate">
      <span id=selectSpan>${requestScope.selectform_msg}</span>
      <input type="submit" value="提交" class="signup-btn">
      </form>
  </div>
</body>
</html>