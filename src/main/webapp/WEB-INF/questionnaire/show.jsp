<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- アンケート表示ページ --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ffApple</title>
</head>
<body>

    <c:forEach var="question" items="${questions}">
        質問番号<c:out value="${question.getNumber()}"/><br>
        <c:out value="${question.getContent()}"/><br>
    </c:forEach>

    <a href="/answers/new?id=${questionnaireID}">回答する</a><br>
    <a href="/answers?id=${questionnaireID}">アンケート結果閲覧</a>
</body>
</html>