<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<title>登录</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/back/login.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
</head>
<body>
<div class="wrap">
	<div class="container">
		<form method="post" action="/back/login/login" class="login-panel form-horizontal">
            <label class="text-warning">${message}</label>
			<div class="form-group">
				<label for="user-name" class="sr-only">用户名</label>
                <input type="text" class="form-control" id="user-name" name="userName" placeholder="用户名">
			</div>
            <div class="form-group">
                <label for="password"  class="sr-only">密码</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="密码">
            </div>
            <button class="btn btn-info center-block">登录</button>
		</form>
	</div>
</div>
</body>
<script type="text/javascript" src="/resources/js/back/login.js"></script>
</html>

