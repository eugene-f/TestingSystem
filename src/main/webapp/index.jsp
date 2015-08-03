<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contester</title>
    <%@ include file="/dependencies.html" %>
</head>
<body ng-app="app" ng-controller="AppCtrl" style="background-color: #E0E0E0">

<div layout="column" layout-align="center center" layout-fill>
    <md-card>
        <md-toolbar class="md-card-image">
            <div class="md-toolbar-tools">Вход</div>
        </md-toolbar>
        <md-card-content>
            <%@ include file="components/login_form.html" %>
        </md-card-content>
    </md-card>
    <md-button ng-click="showRegistrationDialog($event)">Регистрация</md-button>
</div>

</body>
</html>