<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.User"%>

<%
User u = (User)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録完了</title>
<link href="${pageContext.request.contextPath}/css/registerDone.css"
	rel="stylesheet">

</head>
<body>

	<div class="main">
		<h1>登録完了しました</h1>

		<a class="btn" href="/TSUBUYAKI/WelcomeServlet">メニューへ</a>

	</div>
</body>
</html>