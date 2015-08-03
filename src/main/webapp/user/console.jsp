<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="user" type="com.frolov.testing.entity.user.BaseUser"--%>
<!DOCTYPE html>
<html>
<head>
    <title>${user.fullName}</title>
    <%@ include file="/dependencies.html" %>
</head>
<body ng-app="app" ng-controller="AppCtrl">

<div layout="column" layout-fill>

    <%@ include file="/components/toolbar.html" %>

    <md-tabs md-dynamic-height md-border-bottom>
        <c:choose>
            <c:when test="${user.type.name() eq 'Admin'}">
                <md-tab label="Действия">
                    <md-content class="md-padding">
                        <%@ include file="/user/admin/tab_actions_content.jsp" %>
                    </md-content>
                </md-tab>
                <md-tab label="Пользователи">
                    <md-content class="md-padding">
                        <%@ include file="/user/admin/tab_users_content.jsp" %>
                    </md-content>
                </md-tab>
            </c:when>
            <c:when test="${user.type.name() eq 'Tutor'}">
                <md-tab label="Действия">
                    <md-content class="md-padding">
                        <md-button ng-click="showCreateTestDialog($event)">Создать тест</md-button>
                        <md-button ng-click="showCreateQuestionDialog($event)">Создать вопросы</md-button>
                        <md-button ng-click="showSolveTestDialog($event)">Пройти тест</md-button>
                    </md-content>
                </md-tab>
                <md-tab label="Результаты тестировани">
                    <md-content class="md-padding">
                        <c:forEach var="session" items="${user.completedSessions}">
                            <a href="/session${session.id}">${session.test.name}</a>
                        </c:forEach>
                    </md-content>
                </md-tab>
                <md-tab label="Созданные тесты">
                    <md-content class="md-padding">
                        <c:forEach var="test" items="${user.createdTests}">
                            <a href="/test${test.id}">${test.name}</a>
                        </c:forEach>
                    </md-content>
                </md-tab>
            </c:when>
            <c:when test="${user.type.name() eq 'Student'}">
                <md-tab label="Доступные тесты">
                    <md-content class="md-padding">
                        <c:forEach var="test" items="${user.toPassTests}">
                            <a href="/test${test.id}">${test.name}</a>
                        </c:forEach>
                    </md-content>
                </md-tab>
                <md-tab label="Результаты тестирования">
                    <md-content class="md-padding">
                        <c:forEach var="session" items="${user.sessions}">
                            <a href="/session${session.id}">${session.test.name}</a>
                        </c:forEach>
                    </md-content>
                </md-tab>
            </c:when>
        </c:choose>
        <md-tab label="Аккаунт">
            <md-content class="md-padding">
                <h1 class="md-headline">${user.fullName}</h1>
                <h3 class="md-subhead">${user.email}</h3>
                <h5 class="md-caption">${user.type.name()}</h5>
            </md-content>
        </md-tab>
    </md-tabs>

    <%--<md-content layout-padding>--%>
    <%--</md-content>--%>

</div>

</body>
</html>