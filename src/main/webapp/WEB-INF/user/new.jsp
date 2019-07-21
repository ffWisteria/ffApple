<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- ユーザ登録ページ --%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sample</title>
</head>
<body>

    <form method="post" action="sessions/new">
        <h1>ユーザ登録</h1>
        <p>名前<br><input name="name" type="text"></p>
        <p>メールアドレス<br><input name="email" type="text"></p>
        <p>パスワード<br><input name="password" type="password"></p>
        <p>パスワード再確認<br><input name="spassword" type="password"></p>
        <input type="submit" value="ユーザ登録">
    </form>

</body>
</html>