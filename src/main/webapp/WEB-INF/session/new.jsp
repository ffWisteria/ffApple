<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- ログインページ --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ffApple</title>
</head>
<body>
    <form method="post" action="/sessions/new">
        <h1>ログイン</h1>
        <p>メールアドレス<br><input name="email" type="text"></p>
        <p>パスワード<br><input name="password" type="password"></p>

        <input type="submit" value="ログイン"><br>
    </form>

    <a href="/users/new">アカウントをお持ちでない方はこちら</a>
</body>
</html>