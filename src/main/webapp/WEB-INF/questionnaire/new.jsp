<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- アンケート作成ページ --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ffApple</title>
</head>
<body>
    <c:if test="${number == null}">
        <form method="get" action="/questionnaires/new">
            <p>質問項目はいくつですか？<input type="number" name="number"></p>
    <%--        質問項目入力　　　　--%>
            <input type="submit" value="アンケート作成">
        </form>
    </c:if>
    <c:if test="${number != null}">
        <form method="post" action="/questionnaires/new">
            <p>アンケートの題名<input type="text" name="name"></p><br>
            <br>
            <c:forEach begin="1" end="${number}">
                <p>質問項目<input type="text" name="content"></p><br>
            </c:forEach>
            <input type="submit" value="アンケート完成">
        </form>
    </c:if>
</body>
</html>