<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="answerCount" value="5"></c:set>

<form name="createTestForm" method="post" action="/solve-test">

    <md-tabs md-dynamic-height md-border-bottom>

        <c:forEach var="questionNumber" begin="1" end="${answerCount}">

        <md-tab label="${questionNumber}">

            <md-content class="md-padding">

                <h1 class="md-headline">Вопрос ${questionNumber}</h1>
                <md-radio-group ng-model="question${questionNumber}.answer.correct">
                        <c:forEach var="answerNumber" begin="1" end="${answerCount}">
                                <md-radio-button value="${answerNumber}" class="md-primary md-subhead">Ответ ${answerNumber}</md-radio-button>
                        </c:forEach>
                </md-radio-group>

                <input type="hidden" name="question${questionNumber}AnswerCorrect" value="{{question${questionNumber}.answer.correct}}">

            </md-content>

        </md-tab>

        </c:forEach>

    </md-tabs>

    <div class="md-actions" layout="row" layout-align="end center">
        <span flex></span>
        <md-button><md-icon>chevron_left</md-icon></md-button>
        <md-button>Вопрос ${questionNumber} из ${answerCount}</md-button>
        <md-button><md-icon>chevron_right</md-icon></md-button>
        <span flex></span>
        <md-button type="submit" class="md-accent md-raised">Завершить тестирование</md-button>
    </div>

</form>
