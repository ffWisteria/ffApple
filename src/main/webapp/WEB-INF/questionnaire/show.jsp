<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- アンケート表示ページ --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sample</title>
</head>
<body>


    <form method="get" action="answers/new">
        <input name="answer" value="回答する">
    </form>

    <form method="get" action="questionnaires">
        <input name="get_answer" value="アンケート結果閲覧">
    </form>


</body>
</html>