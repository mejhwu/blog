<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>编辑</title>
        <link rel="stylesheet" type="text/css" href="/resources/editor/css/editormd.css" />
        <link rel="stylesheet" type="text/css" href="/resources/css/edit.css">
        <link rel="stylesheet" type="text/css" href="/resources/css/backheader.css">
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
						<li><a href="#">留言管理</a></li>
						<li class="current"><a href="#">编写文章</a></li>
					</ul>
				</div>
			</div>
			<div class="title-panel">
				<div class="container">
					<span>标&nbsp;&nbsp;题:</span>
					<input type="text" id="title"
						<c:if test="${article != null}">
							value="${article.title}"
						</c:if>
					>
					<button id="save-btn">保存</button>
					<br>
					<span>类&nbsp;&nbsp;别:</span>
					<select id="catalog">
						<c:forEach items="${catalogs}" var="catalog">
							<option value="${catalog.id}">${catalog.catalog}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<!--文本编器开始:使用开源项目[editor.md(https://pandao.github.io/editor.md)]-->
            <div id="editormd">
                <textarea id="edit-content" style="display:none;"><c:if test="${article != null}">${article.editContent}</c:if></textarea>
			</div>
			<!--文本编辑器结束-->
		</div>
		<script src="/resources/js/jquery.min.js"></script>
        <script src="/resources/editor/editormd.min.js"></script>
		<script src="/resources/js/edit.js"></script>
        <script type="text/javascript">
			var editor;
			var flag = true;
			var id = ${article.id};
            $(function() {
                editor = editormd("editormd", {
                    width   : "90%",
                    height  : 640,
                    syncScrolling : "single",
                    path    : "/resources/editor/lib/",
                    pluginPath: "/resources/editor/plugins/"
                });
            });
			<c:if test="${article != null}">
				$('#catalog').val(${article.catalogId});
				flag = false;
			</c:if>
        </script>
	</body>
</html>