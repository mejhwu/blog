<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>后台主页</title>
		<link rel="stylesheet" type="text/css" href="/resources/css/backheader.css">
		<link rel="stylesheet" type="text/css" href="/resources/css/articlelist.css">
		<link rel="stylesheet" type="text/css" href="/resources/css/pagecontrol.css">
	</head>
	<body>
		<div class="wrap">
			<div class="header">
				<div class="header-content">
					<h1>后台主页</h1>
					<ul class="menu">
						<li class="current"><a href="#">文章管理</a></li>
						<li><a href="#">类别管理</a></li>
						<li><a href="#">用户管理</a></li>
						<li><a href="#">留言管理</a></li>
						<li><a href="/back/article/goEdit">编写文章</a></li>
					</ul>
				</div>
			</div>
			<div class="container">
				<div class="search-panel">
					<div id="search-content" class="float-left">
						<span>标题:</span>
						<input type="text" class="search-input" name="title" id="title">
						<span>类别:</span>
						<select id="catalog" class="select-type" name="catalog">
							<option  value="0">全部</option>
							<c:forEach items="${catalogs}" var="catalog">
								<option value="${catalog.id}">${catalog.catalog}</option>
							</c:forEach>
						</select>
						<input type="button" class="search-btn float-right" value="搜索" id="search-btn">
						<br>
						<span>日期:</span>
						<input type="date" name="startTime" class="search-input" id="start-time">
						<span>-</span>
						<input type="date" name="endTime" class="search-input" id="end-time">
						
					</div>
				</div>
				<table  class="article-table">
					<thead>
						<tr class="lightgray-background">
							<td class="td-5">序号</td>
							<td class="td-35">标题</td>
							<td>类别</td>
							<td>作者</td>
							<td class="td-15">创建时间</td>
							<td class="td-15">修改时间</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="article-list">
						
					</tbody>
				</table>
				<div class="page-control float-right">
					<span>共<span id="total-page-number1">${result.totalPage}</span>页</span>
					<button id="pre-page-btn" class="page-btn">上一页</button>
					<span>第<span id="current-page-number">${result.currentPage}</span>/<span id="total-page-number2">${result.totalPage}</span>页</span>
					<button id="next-page-btn" class="page-btn">下一页</button>
					<input type="text" name="page_number" id="page-number-input" class="page-number-input" value="${result.currentPage}">
					<button class="page-jump-btn" id="page-jump-btn">GO</button>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/js/pageControl.js"></script>
	<script type="text/javascript" src="/resources/js/articlelist.js"></script>
</html>