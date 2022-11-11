<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-19
  Time: 오후 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>이름 : ${bean.className}</h1>
  <h1>지역 : ${bean.location}</h1>
  <h1>번호 : ${bean.studentNumber}</h1>
  <h1>점수 : ${bean.score}</h1>
  <h1>평균 : ${bean.avg}</h1>
</body>
</html>
