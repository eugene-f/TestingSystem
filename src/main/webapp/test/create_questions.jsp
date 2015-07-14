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
        <c:forEach begin="1" end="${question_count}" varStatus="loop" var="q">
            Question ${q}<br>
            <input type="text" name="question_content_${q}" placeholder="Question Content"><br><br>
            <c:forEach begin="1" end="${answer_count}" varStatus="loop" var="a">
                Answer ${a}<br>
                <input type="text" name="answer_content_${q}_${a}" placeholder="Answer Content">
                <input type="checkbox" name="answer_correct_${q}_${a}">Correct<br>
            </c:forEach>
            <br><hr><br>
        </c:forEach>
        <input type="submit" value="Create"><br>
    </form>
</body>
</html>
