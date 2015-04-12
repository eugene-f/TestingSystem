<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <input type="submit" value="Reg"><br>
    </form>
</body>
</html>
