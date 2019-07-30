<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- ホームページ --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ffApple</title>
</head>
    <body>
        <h1>マイページ</h1>
        <header>
            <nav>
                <ul>
                    <li><a href="/users/edit">ユーザ情報更新</a></li>
                    <li><a href="/sessions/delete">ログアウト</a></li>
                    <li><a href="/questionnaires">アンケート一覧</a> </li>
                </ul>
            </nav>
        </header>

<%--    自分が作成したアンケートを表示
　　　　　→アンケート表示ページへ
--%>

        <h2>作成したアンケート一覧</h2><br>
    <c:forEach var="questionnaire" items="${myQuestionnaires}">
        <a href="/questionnaires/show?id=${questionnaire.getId()}">アンケートの題名：<c:out value="${questionnaire.getName()}"/></a><br><br>
    </c:forEach>
    </body>
</html>