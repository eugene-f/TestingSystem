<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="user" type="com.frolov.testing.entity.user.BaseUser"--%>
<!DOCTYPE html>
<html>
<head>
    <title>Создание теста</title>
    <%@ include file="/dependencies.html" %>
</head>
<body ng-app="app" ng-controller="AppCtrl">

<div layout="column" layout-fill>

    <%@ include file="/components/toolbar.html" %>

    <%--<h1 class="md-headline">Создание теста</h1>--%>
    <%@ include file="create_question_form.jsp" %>

    <%--<md-content layout-padding>--%>
    <%--</md-content>--%>

</div>

</body>
</html>
