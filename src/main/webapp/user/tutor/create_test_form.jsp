<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="questionCountBegin" value="1"></c:set>
<c:set var="questionCountEnd" value="25"></c:set>
<c:set var="questionCountStep" value="5"></c:set>

<c:set var="answerCountBegin" value="1"></c:set>
<c:set var="answerCountEnd" value="5"></c:set>
<c:set var="answerCountStep" value="1"></c:set>

<form name="createTestForm" method="post" action="/create-test">

    <md-input-container class="md-icon-float" flex>
        <label>Название</label>
        <md-icon>create</md-icon>
        <input type="text" name="title" required>
    </md-input-container>

    <md-input-container class="md-icon-float" flex>
        <label>Дисциплина</label>
        <md-icon>label</md-icon>
        <input type="text" name="discipline" required>
    </md-input-container>

    <%--<md-input-container class="md-icon-float" flex>--%>
        <%--<label>Количество вопросов</label>--%>
        <%--<md-icon>apps</md-icon>--%>
        <%--<input type="number" name="questionCount" required>--%>
    <%--</md-input-container>--%>

    <%--<md-input-container class="md-icon-float" flex>--%>
        <%--<label>Количество вариантов ответов</label>--%>
        <%--<md-icon>list</md-icon>--%>
        <%--<input type="number" name="answerCount" required>--%>
    <%--</md-input-container>--%>

    <div layout="column" layout-align="center center" layout-fill flex>

        <md-select placeholder="Количество вопросов" ng-model="question.count" class="md-icon-float" flex required>
            <c:forEach var="questionCount" begin="${questionCountBegin}" end="${questionCountEnd}" step="${questionCountStep}">
                <md-option value="${questionCount}">${questionCount} вопросов</md-option>
            </c:forEach>
        </md-select>

        <input type="hidden" name="questionCountHidden" value="{{question.count}}">

        <md-select placeholder="Количество вариантов ответов" ng-model="answer.count" required>
            <c:forEach var="answerCount" begin="${answerCountBegin}" end="${answerCountEnd}" step="${answerCountStep}">
                <md-option value="${answerCount}">${answerCount}
                    <c:choose>
                        <c:when test="${answerCount != 5}">
                            вариантa ответов
                        </c:when>
                        <c:when test="${answerCount == 5}">
                            вариантов ответов
                        </c:when>
                    </c:choose>
                </md-option>
            </c:forEach>
        </md-select>

        <input type="hidden" name="answerCountHidden" value="{{answer.count}}">

    </div>

    <md-checkbox name="publicated">Опубликовать</md-checkbox>

    <div class="md-actions" layout="row" layout-align="end center">
        <md-button type="submit" class="md-accent md-raised">Создать и продолжить</md-button>
    </div>

</form>
