<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- ログインページ --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sample</title>
</head>
<body>


    <form method="get" action="/home">
        <h1>ログイン</h1>
        <p>メールアドレス<br><input name="email" type="text"></p>
        <p>パスワード<br><input name="password" type="password"></p>

        <input type="submit" value="ログイン"><br>
    </form>

    <form method="get" action="users/new">
        <input type="submit" value="アカウントをお持ちでない方はこちら"><br>
    </form>


</body>
</html>