<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ffApple</title>
</head>
<body>
<form method="post" action="/users/edit">
    <h1>ユーザ情報更新</h1>
    <p>名前<br><input name="name" type="text"></p>
    <p>メールアドレス<br><input name="email" type="text"></p>
    <p>パスワード<br><input name="password" type="password"></p>
    <input type="submit" value="ユーザ情報更新">
</form>
</body>
</html>