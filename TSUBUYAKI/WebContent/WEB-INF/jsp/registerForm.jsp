<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
<link href="${pageContext.request.contextPath}/css/registerForm.css"
	rel="stylesheet">
</head>
<body>
	<div class="main">
		<h1>新規会員の登録</h1>
		<p>※すべての項目を入力してください</p>
		<br>
		<form action="/TSUBUYAKI/RegisterServlet" method="post">
			<p class="li">ユーザーID</p>
			<input class="inp" type="text" name="userID" maxlength="10" size="10" required placeholder="10桁以内で入力してください">
			<p class="li">パスワード</p>
			<input class="inp" type="password" name="pass" maxlength="10" size="10" required placeholder="10桁以内で入力してください">
			<p class="li">メールアドレス</p>
			<input class="inp" type="email" name="mail" maxlength="100" size="30" required placeholder="xxx@test.com">
			<p class="li">名前</p>
			<input class="inp" type="text" name="name" maxlength="40" size="20" required>
			<p class="li">年齢</p>
			<input class="inp" type="number" name="age" maxlength="3" size="5" required>
			<p>
				<input class="btn" type="submit" value="確認画面へ">
				<a class = "btn" class="btn" href="/TSUBUYAKI/WelcomeServlet">トップページへ</a>
			</p>
		</form>
		
	</div>
</body>
</html>