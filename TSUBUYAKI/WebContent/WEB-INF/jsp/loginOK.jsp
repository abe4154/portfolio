<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Login"%>

<%
	Login login = (Login) session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TSUBUYAKI</title>
</head>
<body>
	<h1>
		ようこそ<%=login.getUserID()%>さん
	</h1>
	<ul>
		<li><a href="/TSUBUYAKI/WelcomeServlet">トップページへ</a></li>
		<li><a href="/TSUBUYAKI/MainServlet">メイン画面へ</a></li>

	</ul>
</body>
</html>