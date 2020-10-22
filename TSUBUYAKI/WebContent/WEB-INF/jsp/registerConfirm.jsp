<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.User"%>


<%
	User u = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録内容確認</title>
<link href="${pageContext.request.contextPath}/css/registerConfirm.css"
	rel="stylesheet">

</head>
<body>

	<div class="main">
		<h1>登録内容確認</h1>

		<ul>
			<li class="li-title">ユーザーID</li>
			<li class="input-content"><%=u.getUserID()%></li>
			<li class="li-title">パスワード</li>
			<li class="input-content">？？？</li>
			<li class="li-title">メールアドレス</li>
			<li class="input-content"><%=u.getMail()%></li>
			<li class="li-title">名前</li>
			<li class="input-content"><%=u.getName()%></li>
			<li class="li-title">年齢</li>
			<li class="input-content"><%=u.getAge()%>歳</li>
		</ul>

		<p>この内容で登録しますか？</p>
		<a class="btn" href="/TSUBUYAKI/RegisterServlet">内容を修正</a> <a
			class="btn" href="/TSUBUYAKI/RegisterServlet?action=done">登録</a>

	</div>
</body>
</html>

