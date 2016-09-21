<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
    <title>${hospital == null ? '新增':'编辑'}医院</title>
    <!-- 引入jquery-easyui插件 -->
    <link rel="stylesheet" href="/resources/js/jquery-easyui/easyui.css" />
    <script type="text/javascript" src="/resources/js/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#pc").uploadPreview({ Img: "showPcPhoto", Width: 300, Height: 260 });
            $("#app").uploadPreview({ Img: "showAppPhoto", Width: 300, Height: 260 });

            init();

            $('#saveForm').validator({
                fields : {
                    'hospitalId': 'required;',
                    'hospitalName': 'required;' ,
                    'shortName': 'required;' ,
                    '#area': '所在地区:select;',
                    'grade': '医院等级:select;',
                    'nature': '经营性质:select;',
                    'desc': 'required;'
                } ,
                valid : function(form){
                    form.submit();
                }
            });

            $("#btnSave").click(function () {
                $('#saveForm').trigger("submit");
            });

            $("#btnReset").click(function () {
                $("#saveForm")[0].reset();
                init();
            });

            $("#province").change(function(){
                var url= "/admin/hospital/selectCitys";
                $("#city option[value!='-1']").remove();
                $("#area option[value!='-1']").remove();
                $.getJSON(url,{'provinceId':$("#province").val()},function(data){
                    $.each(data['obj'],function(i,ele){
                        if(ele!=null){
                            $("#city").append("<option value='"+ele['cityId']+"'>"+ele['city']+"</option>");
                        }
                    });
                });
            });

            $("#city").change(function(){
                var url= "/admin/hospital/selectAreas";
                $("#area option[value!='-1']").remove();
                $.post(url,{'cityId':$("#city").val()},function(data){
                    $.each(data['obj'],function(i,ele){
                        if(ele!=null){
                            $("#area").append("<option value='"+ele['areaId']+"'>"+ele['area']+"</option>");
                        }
                    });
                });
            });

            $("#desc").limiter(4000, $("#descCount"));
            $("#orderRules").limiter(4000, $("#ruleCount"));
            $("#traffic").limiter(4000, $("#trafficCount"));


            $('#parentHospital').combotree({ data: ${parentHospitals} });
        });

        function init(){
            $("#province").val("${hospital.provinceId}");
            $("#city").val("${hospital.cityId}");
            $("#area").val("${hospital.areaId}");
            $("#grade").val("${hospital.grade}");
            $("#nature").val("${hospital.nature}");
        }
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
    <a id="btnSave" class="btn"><i class="icon-save"></i> 保存</a>
    <a id="btnReset" class="btn"><i class="icon-trash"></i> 重置</a>
    <a id="btnBack" class="btn" onclick="javascript:history.go(-1);"><i class="icon-undo"></i> 返回</a>
</div>
<form id="saveForm" method="post" action="/admin/hospital/save" class="form-horizontal" enctype="multipart/form-data">
<div class="well">
<div class="row-fluid">
    <div class="span6">
        <div class="control-group">
            <label class="control-label"><span class="required">*</span>医院ID：</label>
            <div class="controls">
                <input type="text" name="hospitalId" maxlength="20" value="${hospital.hospitalId}" <c:if test="${hospital!=null}">readonly="readonly" </c:if> placeholder="必填项"/>
                <c:if test="${hospital!=null}">
                    <input type="hidden" name="createdAt" value="${hospital.createdAt}"/>
                </c:if>
                <input type="hidden" name="pcImageId" value="${hospital.pcImageId}"/>
                <input type="hidden" name="appImageId" value="${hospital.appImageId}"/>
            </div>
        </div>
    </div>
    <div class="span6">
        <div class="control-group">
            <label class="control-label"><span class="required">*</span>医院名称：</label>
            <div class="controls">
                <input type="text" name="hospitalName" value="${hospital.hospitalName}" placeholder="必填项"/>
            </div>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6">
        <div class="control-group">
            <label class="control-label">上级医院：</label>
            <div class="controls">
                <input name="parentId" id="parentHospital" class="easyui-combotree" value="${hospital.parentId}" style="width:200px;">
            </div>
        </div>
    </div>
    <div class="span6">
        <div class="control-group">
            <label class="control-label"><span class="required">*</span>科室显示层级：</label>
            <div class="controls">
                <input type="text" name="deptLevel" value="${hospital.deptLevel}" placeholder="必填项"/>
            </div>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6">
        <div class="control-group">
            <label class="control-label"><span class="required">*</span>医院简称：</label>
            <div class="controls">
                <input type="text" name="shortName" value="${hospital.shortName}" placeholder="必填项"/>
            </div>
        </div>
    </div>
    <div class="span6">
        <div class="control-group">
            <label class="control-label"><span class="required">*</span>app列表排序：</label>
            <div class="controls">
                <input type="text" name="sortNo" value="${hospital.sortNo}" placeholder="必填项"/>
            </div>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6">
        <div class="control-group">
            <label class="control-label"><span class="required">*</span>所在地区：</label>
            <div class="controls">
                <select id="province">
                    <option value="-1">请选择省份</option>
                    <c:forEach items="${provinces}" var="province">
                        <option value="${province.provinceId}">${province.province}</option>
                    </c:forEach>
                </select>

                <select id="city">
                    <option value="-1">请选择城市</option>
                    <c:forEach items="${citys}" var="city">
                        <option value="${city.cityId}">${city.city}</option>
                    </c:forEach>
                </select>
                <select id="area" name="areaId">
                    <option value="-1">请选择地区</option>
                    <c:forEach items="${areas}" var="area">
                        <option value="${area.areaId}">${area.area}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6">
        <div class="control-group">
            <label class="control-label"><span class="required">*</span>医院等级：</label>
            <div class="controls">
                <select name="grade" id="grade">
                    <option value="-1">请选择医院等级</option>
                    <c:forEach items="${hospitalGrades}" var="grade">
                        <option value="${grade}">${grade}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <div class="span6">
        <div class="control-group">
            <label class="control-label"><span class="required">*</span>经营性质：</label>
            <div class="controls">
                <select name="nature" id="nature">
                    <option value="-1">请选择经营性质</option>
                    <c:forEach items="${hospitalNatures}" var="nature">
                        <option value="${nature}">${nature}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span6">
        <div class="control-group">
            <label class="control-label">医院电脑显示图片：</label>
            <div class="controls">
                <img id="showPcPhoto" src="${hospital.pcImageUrl==null?'/resources/images/hospital.jpg': hospital.pcImageUrl}" alt="医院电脑显示图片" style="width:300px;height: 260px;">
                <input type="file" name="photo" id="pc"/>
            </div>
        </div>
    </div>
    <div class="span6">
        <div class="control-group">
            <label class="control-label">医院手机显示图片：</label>
            <div class="controls">
                <img id="showAppPhoto" src="${hospital.appImageUrl==null?'/resources/images/hospital.jpg': hospital.appImageUrl}" alt="医院手机显示图片" style="width:300px;height: 260px;">
                <input type="file" name="appPhoto" id="app"/>
            </div>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span10">
        <div class="control-group">
            <label class="control-label"><span class="required">*</span>医院简介：</label>
            <div class="controls">
                <textarea rows="5" id="desc" name="desc" placeholder="必填项" class="input-block-level">${hospital.desc}</textarea>
                最多还可输入<label id="descCount" style="display: inline;">4000</label>个字符
            </div>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span10">
        <div class="control-group">
            <label class="control-label">预约规则：</label>
            <div class="controls">
                <textarea rows="5" id="orderRules" name="orderRules" class="input-block-level">${hospital.orderRules}</textarea>
                最多还可输入<label id="ruleCount" style="display: inline;">4000</label>个字符
            </div>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span10">
        <div class="control-group">
            <label class="control-label">医院地址：</label>
            <div class="controls">
                <input type="text" id="address" name="address" value="${hospital.address}" class="input-block-level" />
            </div>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span10">
        <div class="control-group">
            <label class="control-label">交通指引：</label>
            <div class="controls">
                <textarea rows="3" name="traffic" id="traffic" class="input-block-level">${hospital.traffic}</textarea>
                最多还可输入<label id="trafficCount" style="display: inline;">4000</label>个字符
            </div>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span10">
        <div class="control-group">
            <label class="control-label">联系电话：</label>
            <div class="controls">
                <input type="text" name="contact" value="${hospital.contact}"  class="input-block-level"/>
            </div>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span10">
        <div class="control-group">
            <label class="control-label">是否启用：</label>
            <div class="controls">
                <label class="radio inline">
                    <input type="radio" name="served" value="1"<c:if test="${hospital==null || hospital.served}">checked</c:if>> 启用
                </label>
                <label class="radio inline">
                    <input type="radio" name="served" value="0" <c:if test="${hospital!=null && !hospital.served}">checked</c:if>> 禁用
                </label>
            </div>
        </div>
    </div>
</div>
</div>
</form>
</div>
</body>
</html>