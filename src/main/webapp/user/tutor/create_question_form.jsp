<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="question_count" type="java.lang.String"--%>
<%--@elvariable id="answer_count" type="java.lang.String"--%>

<c:set var="answerCount" value="5"></c:set>

<form name="createTestForm" method="post" action="/create-questions">

    <md-tabs md-dynamic-height md-border-bottom>

        <c:forEach var="questionNumber" begin="1" end="${answerCount}">

        <md-tab label="${questionNumber}">

            <md-content class="md-padding">

                <md-input-container flex>
                    <label>Содержание вопроса ${questionNumber}</label>
                    <textarea name="question${questionNumber}" required></textarea>
                </md-input-container>

                <md-radio-group ng-model="question${questionNumber}.answer.correct">
                    <div layout="column">
                        <c:forEach var="answerNumber" begin="1" end="${answerCount}">
                            <div layout="row">
                                <md-radio-button value="${answerNumber}" class="md-primary"></md-radio-button>
                                <md-input-container flex>
                                    <label>Вариант ответа ${answerNumber}</label>
                                    <input type="text" name="answer${answerNumber}" required>
                                </md-input-container>
                            </div>
                        </c:forEach>
                    </div>
                </md-radio-group>

                <input type="hidden" name="question${questionNumber}AnswerCorrect" value="{{question${questionNumber}.answer.correct}}">

            </md-content>

        </md-tab>

        </c:forEach>

    </md-tabs>

    <div class="md-actions" layout="row" layout-align="end center">
        <md-button type="submit" class="md-accent md-raised">Создать и продолжить</md-button>
    </div>

</form>