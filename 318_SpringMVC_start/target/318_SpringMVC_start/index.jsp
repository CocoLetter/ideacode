<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>



<a href="/AServlet?username=中国">中国</a>
<form action="/AServlet" method="POST">
    用户名<input type="text" name="username" value="中国" >
    <input type ="submit">
</form>

<form action="/param/useRequestBody" method="post">
    用户名称：<input type="text" name="username" ><br/>
    用户密码：<input type="password" name="password" ><br/>
    用户年龄：<input type="text" name="age" ><br/>
    <input type="submit" value="保存">
</form>


<form action="/param/saveAccount" method="post">
    用户名称：<input type="text" name="username"><br/>
    用户密码：<input type="password" name="password" ><br/>
    用户余额：<input type="text" name="money" ><br/>
    <input type="submit" value="保存">
</form>

</body>
</html>
