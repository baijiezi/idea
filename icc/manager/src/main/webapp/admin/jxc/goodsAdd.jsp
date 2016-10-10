<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>${hospital == null ? '新增':'编辑'}医院</title>
    <!-- 引入jquery-easyui插件 -->
    <link rel="stylesheet" href="/resources/js/jquery-easyui/easyui.css" />
    <script type="text/javascript" src="/resources/js/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        $(function () {

            $('#saveForm').validator({
                ignore:false,
                fields : {
                    'code': 'required;',
                    'name': 'required;'
                } ,
                valid : function(form){
                    form.submit();
                }
            });

        });

    </script>



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
    <a id="btnReset" class="btn"><i class="icon-trash"></i> 重置</a>
    <a id="btnBack" class="btn" onclick="javascript:history.go(-1);"><i class="icon-undo"></i> 返回</a>
</div>
    <form id="saveForm" method="post" action="<%=request.getContextPath() %>/admin/jxc/goods/add">
<div class="well">
<div class="row-fluid">
    <div class="span6">
        <div class="control-group">
            <label class="control-label"><span class="required">*</span>商品名称：</label>
            <div class="controls">
                <input type="text" name="name" />
            </div>
        </div>
    </div>
    <div class="span6">
        <div class="control-group">
            <label class="control-label"><span class="required">*</span>条码：</label>
            <div class="controls">
                <input type="text" name="code" maxlength="20" />
            </div>
        </div>
    </div>
</div>

<div class="row-fluid">
    <div class="span6">
        <div class="control-group">
            <label class="control-label">商品类别：</label>
            <div class="controls">
                <input type="text" name="classes" maxlength="20" />
            </div>
        </div>
    </div>
    <div class="span6">
        <div class="control-group">
            <label class="control-label">售价：</label>
            <div class="controls">
                <input type="text" name="salePrice" />
            </div>
        </div>
    </div>
</div>

<div class="row-fluid">
    <div class="span6">
        <div class="control-group">
            <label class="control-label">库存数量：</label>
            <div class="controls">
                <input type="text" name="stockCount" maxlength="20" />
            </div>
        </div>
    </div>
    <div class="span6">
        <div class="control-group">
            <label class="control-label">备注：</label>
            <div class="controls">
                <input type="text" name="remark" maxlength="20" />
            </div>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6" align="center">
        <div class="control-group">
            <label class="control-label"><span> &nbsp;</span></label>
            <div class="controls">
                <input class="btn" type="submit" value=" 保  存 ">
            </div>
        </div>
    </div>
</div>
</div>
</form>
</div>
</body>
</html>