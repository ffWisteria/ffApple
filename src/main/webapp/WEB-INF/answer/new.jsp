<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- アンケート回答ページ --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ffApple</title>
</head>
<body>
    <form action="/answers/new?id=${questionnaireID}" method="post">
        <c:forEach var="question" items="${questions}">
            質問番号<c:out value="${question.getNumber()}"/><br>
            <c:out value="${question.getContent()}"/><br>
            <input type="radio" name="evaluation_${question.getNumber()}" value="5">5
            <input type="radio" name="evaluation_${question.getNumber()}" value="4">4
            <input type="radio" name="evaluation_${question.getNumber()}" value="3" checked="checked">3
            <input type="radio" name="evaluation_${question.getNumber()}" value="2">2
            <input type="radio" name="evaluation_${question.getNumber()}" value="1">1
            <br>
            その理由を記述してください。<input type="text" name="free_text">
            <br>
            <br>
        </c:forEach>
        <input type="submit" value="回答を送信する">
    </form>
</body>
</html>