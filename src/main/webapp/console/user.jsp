<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="user" type="com.frolov.testing.entity.user.BaseUser"--%>
<%--@elvariable id="tutor" type="com.frolov.testing.entity.user.Tutor"--%>
<%--@elvariable id="student" type="com.frolov.testing.entity.user.Student"--%>
<!DOCTYPE html>
<html>
<head>
    <title>${user.firstName} ${user.lastName}</title>
    <%@ include file="/dependencies.html" %>
</head>
<body ng-app="app" ng-controller="AppCtrl">

    <div layout="column" layout-fill>

        <%@ include file="/components/toolbar.html" %>

        <md-content layout-padding>

            <h3>${user.firstName} ${user.lastName}</h3>
            <h5>${user.email}</h5>
            ${user.type.name()}

            <h3>Результаты тестирования</h3>
            <c:forEach var="session" items="${tutor.completedSessions}">
                <a href="/session${session.id}">${session.test.name}</a>
            </c:forEach>

            <h3>Созданные тесты</h3>
            <c:forEach var="test" items="${tutor.createdTests}">
                <a href="/test${test.id}">${test.name}</a>
            </c:forEach>



            <h3>Доступные тесты</h3>
            <c:forEach var="test" items="${student.toPassTests}">
                <a href="/test${test.id}">${test.name}</a>
            </c:forEach>

            <h3>Результаты тестирования</h3>
            <c:forEach var="session" items="${student.sessions}">
                <a href="/session${session.id}">${session.test.name}</a>
            </c:forEach>

        </md-content>

    </div>

</body>
</html>