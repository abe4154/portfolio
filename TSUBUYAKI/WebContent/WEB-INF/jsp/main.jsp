<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Login,model.Mutter,java.util.List"%>

<%
Login l= (Login)session.getAttribute("login");
@SuppressWarnings("unchecked")
List<Mutter> mutterList = (List<Mutter>)request.getAttribute("mutterList");
String errorMsg = (String)request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TSUBUYAKIホーム</title>
<link href="${pageContext.request.contextPath}/css/main.css"
	rel="stylesheet">
</head>
<body>
	<h1>TSUBUYAKIメイン</h1>
	<div class="prof">
		<p><%= l.getUserID()%>さんログイン中
		</p>
		<p>
			<a class="btn logout" href="/TSUBUYAKI/LogoutServlet">ログアウト</a>
		</p>
		<p>
			<a class="btn renew" href="/TSUBUYAKI/MainServlet">更新</a>
		</p>
	</div>
	<form action="/TSUBUYAKI/MainServlet" method="post">
		<div class="inp">
			<textarea name="text" placeholder="さあつぶやこう"></textarea>
			<p>
				<input class="submit" type="submit" value="つぶやく">
			</p>
		</div>
	</form>
	<%if(errorMsg!=null){%>

	<p><%= errorMsg %></p>
	<% }%>

	<% for(Mutter mutter:mutterList){%>
	<div class="mutter">
		<p><%=mutter.getUserID()%>(<%=mutter.getDate()%>)
		</p>

		<p><%=mutter.getText()%></p>
	</div>
	<%}%>
</body>

</html>
