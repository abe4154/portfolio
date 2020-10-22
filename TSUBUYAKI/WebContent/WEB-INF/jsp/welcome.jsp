<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TSUBUYAKI</title>
<link href="${pageContext.request.contextPath}/css/welcome.css"
	rel="stylesheet">
</head>
<body>
	<div class="main">
		<h1>ようこそSNSサービスへ</h1>
		<p>🔲未会員の方はコチラ</p>
		<a class="btn register" href="/TSUBUYAKI/RegisterServlet">新規登録</a>
		<p>🔲会員登録済みの方はコチラ</p>
		<a class="btn login" href="/TSUBUYAKI/LoginServlet">ログイン</a>
	</div>
</body>
</html>