<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Тьютор</title>
    <%@ include file="/dependencies.html" %>
</head>
<body>
<div ng-app="app" ng-controller="AppCtrl">
    <div layout="column" layout-fill>
        <%@ include file="/components/toolbar.html" %>
        <md-content layout-padding>
            <h1>Тьютор</h1>
            <br>
        </md-content>
    </div>
</div>
</body>
</html>