<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>后台-留言管理</title>
		<link rel="stylesheet" type="text/css" href="/resources/css/backheader.css">
		<link rel="stylesheet" type="text/css" href="/resources/css/leavewords.css">
		<link rel="stylesheet" type="text/css" href="/resources/css/pagecontrol.css">
	</head>
	<body>
		<div class="wrap">
			<div class="header">
				<div class="header-content">
					<h1>后台主页</h1>
					<ul class="menu">
						<li><a href="#">文章管理</a></li>
						<li><a href="#">类别管理</a></li>
						<li><a href="#">用户管理</a></li>
						<li class="current"><a href="#">留言管理</a></li>
						<li><a href="#">编写文章</a></li>
					</ul>
				</div>
			</div>
			<div class="container">
				<table  class="leavewords-table">
					<thead>
						<tr>
							<td>序号</td>
							<td>邮箱</td>
							<td>创建时间</td>
							<td>回复</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
				<div class="page-control float-right">
					<span>共<span id="total-page-number1">4</span>页</span>
					<button id="last-page-btn" class="page-btn">上一页</button>
					<span>第<span id="current-page-number">1</span>/<span id="total-page-number2">4</span>页</span>
					<button id="next-page-btn" class="page-btn">下一页</button>
					<input type="text" name="page_number" class="page-number-input">
					<button class="page-jump-btn">GO</button>
				</div>
			</div>
		</div>
	</body>
</html>