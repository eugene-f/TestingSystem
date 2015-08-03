<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="question_count" type="java.lang.String"--%>
<%--@elvariable id="answer_count" type="java.lang.String"--%>
<html>
<head>
    <title>Create Test</title>
</head>
<body>
    <h1>Create Test</h1>
    <form name="createQuestionForm" method="post" action="/create-questions">
        <c:forEach begin="1" end="${question_count}" varStatus="loop" var="questionNumber">
            Question ${questionNumber}<br>
            <input type="text" name="question_content_${questionNumber}" placeholder="Question Content"><br><br>
            <c:forEach begin="1" end="${answer_count}" varStatus="loop" var="answerNumber">
                Answer ${answerNumber}<br>
                <input type="text" name="answer_content_${questionNumber}_${answerNumber}" placeholder="Answer Content">
                <input type="checkbox" name="answer_correct_${questionNumber}_${answerNumber}">Correct<br>
            </c:forEach>
            <br><hr><br>
        </c:forEach>
        <input type="submit" value="Create"><br>
    </form>
</body>
</html>
