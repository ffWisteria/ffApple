<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- アンケート一覧ページ --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ffApple</title>
</head>
<body>
<%--    アンケ-ト作成機能--%>
<header>
    <a href="/questionnaires/new">アンケート作成</a><br>
    <a href="/home">ホームページに戻る</a>
    <br>
</header>
<%--    //アンケート題名による検索--%>
    <h3>アンケート検索</h3>
    <form action="/questionnaires" method="post">
        アンケート題名による検索<input type="text" name="title">
        ユーザー名による検索<input type="text" name="user_name">
        <input type="submit" value="検索">
    </form>

    <h1>全てのアンケート</h1>
    <c:forEach var="questionnaire" items="${questionnaires}">
        <a href="/questionnaires/show?id=${questionnaire.getId()}">アンケートの題名<c:out value="${questionnaire.getName()}"/> </a>
        <br><br>
    </c:forEach>


<%--アンケートの題名、作成者を表示する--%>


</body>
</html>