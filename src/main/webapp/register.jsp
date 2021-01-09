<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>registerPage</title>
</head>
<body>

    <h2>${remind}</h2>
    <h1>注册页面</h1>
    <form action="register" method="post">
        登录名：<input type="text" name="usr"><br />
        密码：<input type="password" name="pwd"><br />
        <input type="submit" value="注册">
    </form>
</body>
</html>
