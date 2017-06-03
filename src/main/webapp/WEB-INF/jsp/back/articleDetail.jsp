<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<title>后台-文章-详情</title>
    <link rel="stylesheet" type="text/css" href="/resources/editor/css/editormd.min.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
		*{margin: 0; padding: 0}
        .header{margin:30px 0;}
		.container .title-panel{padding: 0 20px;}
		.catalog-time {color: gray;}
		.catalog-time span {margin-right: 10px;}
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
            <div class="title-panel">
                <h3>
                    <span class="title">${article.title}</span><br>
                </h3>
                <small class="catalog-time">
                    <span>类别:${article.catalog}</span>
                    <span>创建日期:<fmt:formatDate value="${article.createTime}"
                                               pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></span>
                </small>
            </div>
            <div id="content">
                <textarea style="display:none;" name="editormd">${article.editContent}</textarea>
            </div>
		</div>
	</div>
    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/editor/lib/marked.min.js"></script>
    <script src="/resources/editor/lib/prettify.min.js"></script>
    <script src="/resources/editor/lib/raphael.min.js"></script>
    <script src="/resources/editor/lib/underscore.min.js"></script>
    <script src="/resources/editor/lib/sequence-diagram.min.js"></script>
    <script src="/resources/editor/lib/flowchart.min.js"></script>
    <script src="/resources/editor/lib/jquery.flowchart.min.js"></script>
    <script src="/resources/editor/editormd.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/page.control.js"></script>
    <script src="/resources/js/date.format.js"></script>

    <script>
        $(document).ready(function() {
            editormd.markdownToHTML("content", {
                htmlDecode      : "style,script,iframe|on*",  // you can filter tags decode
                emoji           : true,
                taskList        : true,
                tex             : true,  // 默认不解析
                flowChart       : true,  // 默认不解析
                sequenceDiagram : true,  // 默认不解析
                tocm : true,//菜单
                tocContainer : "",
                tocDropdown   : false
            });
        });
    </script>
</body>
</html>
