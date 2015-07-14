<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="admin" type="com.frolov.testing.entity.user.Admin"--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Консоль</title>
    <%@ include file="/dependencies.html" %>
</head>
<body>
<div ng-app="app" ng-controller="AppCtrl">
    <div layout="column" layout-fill>
        <%@ include file="/components/toolbar.html" %>
        <md-content layout-padding>
            <h1>Консоль</h1>
            <br>
            <md-button>Зарегестрировать тьютора</md-button><br>
            <md-button>Зарегестрировать студента</md-button><br>
            <md-button>Добавить факультеты, кафедры, группы</md-button><br>
        </md-content>
    </div>
</div>
</body>
</html>