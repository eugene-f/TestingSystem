<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.StringWriter" %>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="description" type="java.lang.String"--%>
<html>
<head>
    <title>Ошибка</title>
</head>
<body>
    <h1>Ой, что-то пошло не так :(</h1>
    <h5>${description}</h5>
    <p><%= exception %></p>

    Message:
    <%=exception.getMessage()%>

    StackTrace:
    <%
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        out.println(stringWriter);
        printWriter.close();
        stringWriter.close();
    %>

</body>
</html>
