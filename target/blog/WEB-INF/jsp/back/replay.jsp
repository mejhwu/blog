<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>后台-留言管理</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/editor/css/editormd.css"/>
    <style>
        .container .header {
            margin: 30px 0;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="wrap">
        <div class="header">
            <ul class="nav nav-tabs">
                <li role="presentation"><a href="/back/article/list">文章管理</a></li>
                <li role="presentation"><a href="/back/catalog/all">类别管理</a></li>
                <li role="presentation"><a href="#">用户管理</a></li>
                <li role="presentation"><a href="/back/comment/list">评论管理</a></li>
                <li role="presentation" class="active"><a href="/back/article/goEdit">编写文章</a></li>
            </ul>
        </div>
        <div>
            <div>
                <div class="form-group">
                    <label for="title">文章标题:</label>
                    <input type="text" class="form-control" id="title" readonly value="${title}">
                </div>
                <div class="form-group">
                    <label for="name">作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者:</label>
                    <input type="text" class="form-control" id="name" readonly value="${comment.name}">
                </div>
                <div class="form-group">
                    <label for="email">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</label>
                    <input type="text" class="form-control" id="email" readonly value="${comment.email}">
                </div>
                <div class="form-group">
                    <label for="create-time">创建时间:</label>
                    <input type="text" class="form-control" id="create-time" readonly value="<fmt:formatDate
                                value="${comment.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>">
                </div>
                <div class="form-group">
                    <label>评论内容:</label>
                    ${comment.htmlContent}
                </div>
            </div>
            
            <!--文本编器开始:使用开源项目[editor.md(https://pandao.github.io/editor.md)]-->
            <div class="editormd" id="editormd">
                <textarea id="edit-content" class="editormd-markdown-textarea" name="editContent"></textarea>
            </div>
            <!--文本编辑器结束-->
            <button id="replay-btn" class="btn btn-default">回复</button>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="/resources/editor/editormd.js"></script>
<script type="text/javascript">
    var editor;
    $(function () {
        editor = editormd("editormd", {
            width: "100%",
            height: 300,
            syncScrolling: "single",
            path: "/resources/editor/lib/",
            pluginPath: "/resources/editor/plugins/",
            imageUpload: true,
            imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL: "/back/file/uploadfile",
            tex: true,                     // 开启科学公式TeX语言支持，默认关闭
            flowChart: true,             // 开启流程图支持，默认关闭
            sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,
            //theme : "dark",
            //previewTheme : "dark",
            //editorTheme : "pastel-on-dark",
            codeFold: true,
            //syncScrolling : false,
            //saveHTMLToTextarea : true,    // 保存 HTML 到 Textarea
            searchReplace: true,
            //watch : false,                // 关闭实时预览
            htmlDecode: true,
            //htmlDecode : "style,script,iframe|on*",            // 开启 HTML 标签解析，为了安全性，默认不开启
            //toolbar  : false,             //关闭工具栏
            //previewCodeHighlight : false, // 关闭预览 HTML 的代码块高亮，默认开启
            emoji: true,
            taskList: true,
            tocm: true,         // Using [TOCM]
            //dialogLockScreen : false,   // 设置弹出层对话框不锁屏，全局通用，默认为true
            //dialogShowMask : false,     // 设置弹出层对话框显示透明遮罩层，全局通用，默认为true
            //dialogDraggable : false,    // 设置弹出层对话框不可拖动，全局通用，默认为true
            //dialogMaskOpacity : 0.4,    // 设置透明遮罩层的透明度，全局通用，默认值为0.1
            //dialogMaskBgColor : "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为#fff
            //onload : function() {
            //console.log('onload', this);
            //this.fullscreen();
            //this.unwatch();
            //this.watch().fullscreen();
            
            //this.setMarkdown("#PHP");
            //this.width("100%");
            //this.height(480);
            //this.resize("100%", 640);
            //}
        });
    });
    $('#replay-btn').on('click', function () {
        var editContent = $('#edit-content').val();
        var htmlContent = $('.editormd-preview').html();
        var commentId = ${comment.id};
        
        if (editContent == null || editContent == '') {
            alert('未填写回复内容!');
            return false;
        }
        if (htmlContent == null || htmlContent == '') {
            alert('未读取到任何内容!');
            return false;
        }
        
        var dat = {
            'id': commentId,
            'editContent': editContent,
            'htmlContent': htmlContent
        }
        $.ajax({
            url: '',
            type: 'post',
            data: dat,
            success: function () {
                
            },
            error: function () {
                
            }
        });
    })
</script>
</html>