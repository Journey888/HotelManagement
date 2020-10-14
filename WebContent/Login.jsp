<!-- jsp声明 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="Login.css">
    <link href="https://fonts.googleapis.com/css?family=Permanent+Marker" rel="stylesheet">
    
   <!--  <style type="text/css">
    body{
        margin: 0;
        padding: 0;
        background:#003366;
    }
    </style> -->
  
    <script type="text/javascript">
         //js代码
         function clearMsg(){
             var spanEle = document.getElementById("loginSpan");
             spanEle.innerHTML ="";
             }
    </script>
  </head>
  <body>
    <div class="signup-form">
      <form action="login" method="post">
        <h1>Welcome sign</h1>
        <input id="1" type="text" placeholder="用户名" name="no"  onfocus="clearMsg();" class="txtb">
        <input id="1" type="password" placeholder="密码" name="password" class="txtb">
        <%--  <%
              //获取request对象；request对象可以直接使用。
              
              String FloginMsg = (String)request.getAttribute("login_msg");
        %>
        <span><%=loginMsg==null?"":loginMsg %></span> --%>
        
        <!-- EL表达式默认从 pageScope、requestScope、sessionScope、applicationScope中查找数据 
                       为空默认不输出-->
        <span id=loginSpan>${requestScope.login_msg}</span>
        <br>
        <select name ="usertype">
               <option value="0">前台登录</option>  
               <option value="1">后台登录</option>
        </select>        
        <input type="submit" value="登录" class="signup-btn">
        <a href=#>忘记密码?</a>
      </form>
    </div>
  </body>
</html>
