<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>后台-类别管理</title>
		<link rel="stylesheet" type="text/css" href="/resources/css/backheader.css">
		<link rel="stylesheet" type="text/css" href="/resources/css/catalog.css">
	</head>
	<body>
		<div class="wrap">
			<div class="header">
				<div class="header-content">
					<h1>后台主页</h1>
					<ul class="menu">
						<li><a href="#">文章管理</a></li>
						<li class="current"><a href="#">类别管理</a></li>
						<li><a href="#">用户管理</a></li>
						<li><a href="#">留言管理</a></li>
						<li><a href="#">编写文章</a></li>
					</ul>
				</div>
			</div>
			<div class="container">
				<button id="add-catalog-btn" class="float-right">添加</button>
				<table  class="catalog-table">
					<thead>
						<tr>
							<td>序号</td>
							<td>类别</td>
							<td>创建时间</td>
							<td>修改时间</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>