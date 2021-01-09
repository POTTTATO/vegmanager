<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021/1/6
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
    <h2>${remind}</h2>
    <h1>登录页面</h1>

    <form action="login" method="post">
        登录名:<input type="text" name="name"><br/>
        密码为:<input type="password" name="password"><br/>
        <input type="submit" value="登录">
    </form>

    <h5>还未注册，快来注册</h5>
    <a href="register">注册</a>
</body>
</html>
