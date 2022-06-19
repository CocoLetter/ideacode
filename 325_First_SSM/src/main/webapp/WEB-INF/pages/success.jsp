<%--
  Created by IntelliJ IDEA.
  User: LiuSheng
  Date: 2020/3/25
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

success!

<c:forEach items="${list}" var="account">
    ${account.name}
</c:forEach>


</body>
</html>
