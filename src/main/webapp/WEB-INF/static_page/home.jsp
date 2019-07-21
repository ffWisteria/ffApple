<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- ホームページ --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sample</title>
</head>
    <body>
        <h1>マイページ</h1>
        <header>
            <nav>
                <ul>
                    <li><a href="users/new">ユーザ情報更新</a></li>
                    <li><a href="sessions/new">ログアウト</a></li>
                </ul>
            </nav>
        </header>

<%--    検索機能をつける
　　　　　→アンケート一覧ページへ
--%>


        <form method="get" action="questionnaires/new">
            <input type="submit" value="アンケートを作成する">
        </form>

<%--    自分が作成したアンケートを表示
　　　　　→アンケート表示ページへ
--%>

    </body>
</html>