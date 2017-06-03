<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>后台主页</title>
        <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/resources/css/page.control.css">
        <style>
            .space-10 {margin-right: 10px;}
            .header{margin:30px 0;}
            table {margin-top: 20px;}
            body {padding-bottom: 40px;}
            table a {margin: 0 5px;}
        </style>
	</head>
	<body>
		<div class="container">
			<div class="header">
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="/back/article/list">文章管理</a></li>
					<li role="presentation"><a href="/back/catalog/all">类别管理</a></li>
					<li role="presentation"><a href="#">用户管理</a></li>
					<li role="presentation"><a href="/back/comment/list">评论管理</a></li>
                    <li role="presentation"><a href="/back/article/edit">编写文章</a></li>
				</ul>
			</div>
			<div>
                <form class="form-inline ">
                    <div class="form-group space-10">
                        <label for="title">标题: </label>
                        <input type="text" class="form-control" id="title">
                    </div>
                    <div class="form-group space-10">
                        <label for="catalog">类别: </label>
                        <select class="form-control" id="catalog">
                            <option value="0">全部</option>
                            <c:forEach items="${catalogs}" var="catalog">
                                <option value="${catalog.id}">${catalog.catalog}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group space-10">
                        <label for="start-time">起始日期: </label>
                        <input type="date" class="form-control" id="start-time">
                    </div>
                    <div class="form-group space-10">
                        <label for="end-time">结尾日期: </label>
                        <input type="date" class="form-control" id="end-time">
                    </div>
                    <button class="btn btn-default">
                        <span class="glyphicon glyphicon-search"></span>
                        搜索
                    </button>
                </form>
				<table  class="table table-bordered table-hover table-responsive table-striped">
					<thead>
						<tr class="lightgray-background">
							<th class="td-10">文章ID</th>
							<th class="td-25">标题</th>
							<th class="td-10">类别</th>
							<th class="td-10">作者</th>
							<th class="td-16">创建时间</th>
							<th class="td-16">修改时间</th>
							<th class="td-13">操作</th>
						</tr>
					</thead>
					<tbody id="article-list">
						
					</tbody>
				</table>
				<%@include file="pageControl.jsp"%>
			</div>
		</div>
        <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
        <script type="text/javascript" src="/resources/editor/editormd.js"></script>
        <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/resources/js/page.control.js"></script>
        <script type="text/javascript" src="/resources/js/date.format.js"></script>
        <script type="text/javascript" src="/resources/js/back/article.list.js"></script>
	</body>
</html>