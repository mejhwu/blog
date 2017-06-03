<%@ taglib prefix="c" uri="https://aoindustries.com/ao-taglib/" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>后台-留言管理</title>
        <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="/resources/css/page.control.css">
        <style>
            .header{margin:30px 0;}
            table {margin-top: 20px;}
            body {padding-bottom: 40px;}
        </style>
	</head>
	<body>
		<div class="container">
			<div class="header">
				<ul class="nav nav-tabs">
					<li role="presentation"><a href="/back/article/list">文章管理</a></li>
					<li role="presentation"><a href="/back/catalog/all">类别管理</a></li>
					<li role="presentation"><a href="#">用户管理</a></li>
					<li role="presentation" class="active"><a href="/back/comment/list">评论管理</a></li>
					<li role="presentation"><a href="/back/article/edit">编写文章</a></li>
				</ul>
			</div>
			<div>
                <form class="form-inline">
                    <div class="form-group">
                        <label for="article-id">文章ID: </label>
                        <input type="number" class="form-control" id="article-id">
                    </div>
                    <div class="form-group">
                        <label for="commented"></label>
                        <select class="form-control" id="commented">
                            <option value="0">全部</option>
                            <option value="1">未回复</option>
                            <option value="2">已回复</option>
                        </select>
                    </div>
                    <button class="btn btn-default" id="search-btn">
                        <span class="glyphicon glyphicon-search"></span>
                        搜索
                    </button>
                </form>
				<table  class="table  table-responsive table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th>文章ID</th>
							<th>昵称</th>
							<th>邮箱</th>
							<th>创建时间</th>
                            <th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="comment-list">
						
					</tbody>
				</table>
				<div class="page-control float-right">
					<%@include file="pageControl.jsp"%>
				</div>
			</div>
		</div>
        <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
        <script type="text/javascript" src="/resources/editor/editormd.js"></script>
        <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/resources/js/page.control.js"></script>
        <script type="text/javascript" src="/resources/js/date.format.js"></script>
        <script type="text/javascript" src="/resources/js/back/comment.js"></script>
	</body>
</html>