<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>后台-类别管理</title>
		<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
        <style>
            .header {margin: 30px 0;}
        </style>
	</head>
	<body>
		<div class="container">
			<div class="header">
				<ul class="nav nav-tabs">
					<li role="presentation"><a href="/back/article/list">文章管理</a></li>
					<li role="presentation"  class="active"><a href="/back/catalog/all">类别管理</a></li>
					<li role="presentation"><a href="#">用户管理</a></li>
					<li role="presentation"><a href="/back/comment/list">评论管理</a></li>
					<li role="presentation"><a href="/back/article/goEdit">编写文章</a></li>
				</ul>
			</div>
			<div class="content">
				<table  class="table  table-responsive table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th>序号</th>
							<th>类别</th>
							<th>创建时间</th>
							<th>修改时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${catalogs}" var="catalog" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td>${catalog.catalog}</td>
								<td><fmt:formatDate value="${catalog.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
								<td><fmt:formatDate value="${catalog.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
								<td><a href="javascript:void(0)" data-id="${catalog.id}" name="delete">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form action="/back/catalog/add" method="post" class="form-inline">
                    <div class="form-group">
                        <label for="catalog-input">添加类型:</label>
                        <input type="text" class="form-control" id="catalog-input" name="catalogInput">
                    </div>
                    <div class="form-group">
                        <label for="catalog-submit" class="sr-only">提交</label>
                        <input type="submit" class="form-control" id="catalog-submit" value="提交">
                    </div>
				</form>
			</div>
		</div>
        <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
        <script type="text/javascript" src="/resources/editor/editormd.js"></script>
        <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/resources/js/page.control.js"></script>
        <script type="text/javascript" src="/resources/js/date.format.js"></script>
        <script type="text/javascript" src="/resources/js/back/catalog.js"></script>
	</body>
</html>