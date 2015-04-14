<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Test</title>
</head>
<body>
    <h1>Create Test</h1>
    <form name="createTestForm" method="post" action="/create-test">
        <input type="text" name="title" placeholder="Title"><br>
        <input type="text" name="discipline" placeholder="Discipline"><br>
        <input type="number" name="minutesToPass" placeholder="Minutes to pass"><br>
        <input type="number" name="questionCount" placeholder="Question count"><br>
        <input type="number" name="answerCount" placeholder="Answer count"><br>
        <input type="checkbox" name="active">Active<br>
        <input type="submit" value="Create"><br>
    </form>
</body>
</html>
