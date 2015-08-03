<%@ page import="java.io.StringWriter" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="description" type="java.lang.String"--%>
<html>
<head>
    <title>Ошибка!</title>
    <%@ include file="/dependencies.html" %>
</head>
<body ng-app="app" ng-controller="AppCtrl">

<div layout="row" layout-fill style="background-color: #607D8B; color: #ECEFF1;">

<div flex></div>

<div layout="column" flex="66">

    <h1 class="md-display-4 md-primary">Ой, что-то пошло не так :(</h1>

    <%--<h3 class="md-headline">Описание:</h3>--%>
    <%--<p class="md-subhead">--%>
        <%--${description}--%>
    <%--</p>--%>

    <h3 class="md-headline">Что случилось?</h3>
    <span class="md-subhead">
        <%= exception.getMessage() %>
    </span>

    <br>

    <h3 class="md-headline">Где это произошло?</h3>
    <span class="md-subhead">
    <%= exception %>
    </span>

    <br>

    <h3 class="md-headline">На эльфийском</h3>
    <span class="md-caption" style="font-family: monospace;">
        <%
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        out.println(stringWriter);
        printWriter.close();
        stringWriter.close();
        %>
    </span>

    <br>

</div>

<div flex></div>

</div>

</body>
</html>
