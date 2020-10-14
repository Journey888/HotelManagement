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
             var spanEle = document.getElementById("insertSpan");
             spanEle.innerHTML ="";
             }
    </script>
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
        <form action="Finsert"  method="post">
        <h1 align="center">请添加前台操作员信息</h1>
        <input type="text" placeholder="用户名" name="no"  onfocus="clearMsg();" class="txtb">
        <input type="password" placeholder="密码" name="password" class="txtb">
        <input type="text" placeholder="姓名" name="name"  class="txtb">
        <span id=insertSpan>${requestScope.insert_msg}</span>
        <br>
        <input type="submit" value="提交" class="signup-btn">
        </form>
    </div>

</body>
</html>