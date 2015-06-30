<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="userType" type="com.frolov.testing.entity.user.UserType"--%>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h1>Registration</h1>
    <form name="registrationForm" method="post" action="/registration">
        <input type="text" name="firstName" placeholder="First Name"><br>
        <input type="text" name="lastName" placeholder="Last Name"><br>
        <input type="email" name="email" placeholder="E-mail"><br>
        <input type="password" name="password" placeholder="Password"><br>
        <input type="password" name="confirmPassword" placeholder="Confirm Password"><br>
        <%--<c:forEach var="type" items="${userType}" begin="0" end="${Enum}" varStatus="loop">--%>
            <%--<input type="radio" name="userType" value="${type}">${type}<br>--%>
        <%--</c:forEach>--%>
        <input type="radio" name="userType" value="student">Student<br>
        <input type="radio" name="userType" value="tutor">Tutor<br>
        <input type="radio" name="userType" value="admin">Admin<br>
        <input type="submit" value="Register"><br>
    </form>
</body>
</html>
