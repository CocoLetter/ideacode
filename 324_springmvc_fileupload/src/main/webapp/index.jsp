<%--
  Created by IntelliJ IDEA.
  User: LiuSheng
  Date: 2020/3/25
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

上传回顾
<form action="/user/upload1" method="post" enctype="multipart/form-data">
    选择文件<input type="file" name="upload"/><br>
    <input type="submit" value="提交"/>
</form>

springmvc上传
<form action="/user/upload2" method="post" enctype="multipart/form-data">
    选择文件<input type="file" name="upload"/><br>
    <input type="submit" value="提交"/>
</form>
跨服务器上传
<form action="/user/upload3" method="post" enctype="multipart/form-data">
    选择文件<input type="file" name="upload"/><br>
    <input type="submit" value="提交"/>
</form>






</body>
</html>
