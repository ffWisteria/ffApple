<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ffApple</title>
</head>
<body>

    <c:forEach var="question" items="${questions}">
        <h3>問題番号<c:out value="${question.getNumber()}"/>
            &nbsp;＜質問＞<c:out value="${question.getContent()}"/></h3><br>
        <c:forEach var="answer" items="${question.answers}">
            ５段階評価：<c:out value=" ${answer.getEvaluation()}"/>&nbsp;&nbsp;
            理由：<c:out value=" ${answer.getComment()}"/><br><br>
        </c:forEach>
    </c:forEach>

    <a href="/home">マイページへ戻る</a>

</body>
</html>