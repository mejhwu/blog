<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>主页</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/front/index.css">
    <link type="text/css" rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="wrap">
        <div class="header">
            <form class="form-inline">
                <div class="form-group">
                    <label for="catalog" class="sr-only">Catalog</label>
                    <select id="catalog" class="form-control">
                        <option value="0">全部</option>
                        <c:forEach items="${catalogs}" var="catalog">
                            <option value="${catalog.id}">${catalog.catalog}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="search-content" class="sr-only">SearchContent</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="search-content">
                        <span class="input-group-btn">
							<button class="btn btn-info" id="search-btn">
								<span class="glyphicon glyphicon-search"></span>
                            </button>
						</span>
                    </div>
                </div>
            
            </form>
        </div>
        <div id="content">
        
        </div>
        <div class="footer">
        
        </div>
    </div>

</div>
</body>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="/resources/editor/editormd.min.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/page.control.js"></script>
<script type="text/javascript" src="/resources/js/date.format.js"></script>
<script type="text/javascript" src="/resources/js/front/index.js"></script>
</html>