<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sandbox</title>
    <%@ include file="/dependencies.html" %>
</head>
<body>
    <div ng-app="app" ng-controller="AppCtrl">
        <div layout="column" layout-fill>
            <%@ include file="components/toolbar.html" %>
            <md-content layout-padding>
                <%@ include file="components/test_template_form.html" %>
            </md-content>
        </div>
    </div>
</body>
</html>