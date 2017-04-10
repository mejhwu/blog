<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<title>登录</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/login.css">
</head>
<body>
<div class="wrap">
	<div class="container">
		<form method="post" action="/back/login/login" class="login-panel">
			<div class="warning">${message}</div>
			<span>用户名:</span><input type="text" class="text-input" name="userName"><br>
			<span>密&nbsp;&nbsp;&nbsp;&nbsp;码:</span><input type="password" class="text-input" name="password"><br>
			<input type="submit" class="submit-btn" value="登录">
		</form>
	</div>
</div>
</body>
<script type="text/javascript" src="/resources/js/login.js"></script>
</html>

