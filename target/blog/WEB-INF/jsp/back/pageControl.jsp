<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-control">
	<span>共<span id="total-page-number1">${result.totalPage}</span>页</span>
	<button id="pre-page-btn" class="btn btn-default btn-sm">上一页</button>
	<span>第<span id="current-page-number">${result.currentPage}</span>/<span id="total-page-number2">${result.totalPage}</span>页</span>
	<button id="next-page-btn" class="btn btn-default btn-sm">下一页</button>
	<input type="text" name="page_number" id="page-number-input" class="form-control page-number-input" value="${result.currentPage}">
	<button class="btn btn-default btn-sm" id="page-jump-btn">GO</button>
</div>