<%--
  Created by IntelliJ IDEA.
  User: 哇哈哈
  Date: 2021/3/14
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>精品课程网站</title>
    <link type="text/css" rel="stylesheet" href="./view/login.css">
    <script type="text/javascript" src="./view/login.js" defer charset="UTF-8" language="JavaScript"></script>
</head>
<body >
<div class="loginWicket">
    <form action="login" method="post" onsubmit="return check(this)">
        请输入账号：<input type="text" name="userid" value="" class="loginText" id="id"><br>
        请输入密码：<br><input type="password" name="password" value="" class="loginText"><br>
        <div id="errorMes">${requestScope.errorMes}</div><br>
        <input type="submit"  class="loginButton" id="submitButton" value="">
    </form>
</div>
</body>
</html>
