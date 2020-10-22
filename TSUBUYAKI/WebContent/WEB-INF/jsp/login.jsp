<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link href="${pageContext.request.contextPath}/css/login.css"
	rel="stylesheet">
</head>
<body>
	<h1>ログイン</h1>
	<form action="/TSUBUYAKI/LoginServlet" method="post">
		<p>ユーザーID</p>
		<input class="inp" type="text" name="userID" maxlength="10" required
			placeholder="10桁以内で入力">
		<p>パスワード</p>
		<input class="inp" type="password" name="pass" maxlength="10" required
			placeholder="10桁以内で入力"> <br> <input class="btn"
			type="submit" value="ログイン">
	</form>
</body>
</html>