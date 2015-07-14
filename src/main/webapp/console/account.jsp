<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="user" type="com.frolov.testing.entity.user.BaseUser"--%>
<html>
<head>
    <title>Account</title>
</head>
<body>
  <h1>Account</h1>
  ${user.lastName} ${user.firstName}<br>
  ${user.type.name()}<br>
  <br><br><br>
  <h3>Sessions</h3>
  <c:forEach var="session" items="${tutor.completedSessions[user]}">
    <a href="/session${session.id}">${session.test.name}</a>
  </c:forEach>
</body>
</html>
