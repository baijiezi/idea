<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
    <title>${hospital == null ? '新增':'编辑'}医院</title>
    <!-- 引入jquery-easyui插件 -->
    <link rel="stylesheet" href="/resources/js/jquery-easyui/easyui.css" />
    <script type="text/javascript" src="/resources/js/jquery-easyui/jquery.easyui.min.js"></script>

</head>
<body>
<div class="header">
    <h5>基础信息管理
        <span style="color:darkgrey"> / </span>
        <a href="/admin/hospital/list">医院管理</a>
        <span style="color:darkgrey"> /  ${hospital == null ? '新增':'编辑'}医院</span>
    </h5>
</div>

<div style="margin-left:10px; margin-right:10px;font-size:13px;">
<div class="btn-toolbar">
    <a id="btnSave" class="btn"><i class="icon-save"></i> 保存</a>
    <a id="btnReset" class="btn"><i class="icon-trash"></i> 重置</a>
    <a id="btnBack" class="btn" onclick="javascript:history.go(-1);"><i class="icon-undo"></i> 返回</a>
</div>
    <form method="post" action="<%=request.getContextPath() %>/admin/jxc/goods/add">
        bookname:<input type="text" name="code" id="name">
        author:<input type="text" name="name" id="author">
        <input type="submit" value="Add">
    </form>
</div>
</body>
</html>