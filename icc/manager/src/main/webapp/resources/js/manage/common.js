/*====验证身份证格式是否正确====*/
function chk_idCard(id){
    var value = $.trim($('#'+id).val()).replace(/\s/g, '');
    var len = value.length;
    value = value.toUpperCase();
    if (len!=18&&len!=15){
        return false;
    }
    if(len == 15){//15位的身份证，验证了生日是否有效
        var year =  value.substring(6,8);
        var month = value.substring(8,10);
        var day = value.substring(10,12);
        var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));
        if(temp_date.getYear()!=parseFloat(year) || temp_date.getMonth()!=parseFloat(month)-1 || temp_date.getDate()!=parseFloat(day)){
            return false;
        }
        return true;
    }
    if(len == 18){//18位的身份证，验证最后一位校验位
        var endChar=value.charAt(len-1);//身份证的最后一为字符
        value=value.substr(0,17);
        var table = new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2);
        var table2 =new Array('1','0','X','9','8','7','6','5','4','3','2');
        var cNum=toCharArray(value);
        var sum = 0;
        var rs=0;
        for(var i =0;i<cNum.length;i++){
            // 其中(cNum[i]-48)表示第i位置上的身份证号码数字值，table[i]表示第i位置上的加权因子，
            var num=cNum[i].charCodeAt(0);
            var num1=parseInt(table[i]);
            sum=sum*1+(num-48) * num1;
        }
        // 以11对计算结果取模
        var index =Number(sum%11);
        // 根据模的值得到对应的校验码,即身份证上的最后一位为校验码
        var verfiyCode=table2[index];
        if (endChar!=verfiyCode){
            return false;
        }
        return true;
    }
}

/*将输入的字符串转化为字符数组*/
function toCharArray(str) {
    var charArr = new Array();
    for (var i = 0; i < str.length; i++){
        charArr[i] =str.charAt(i);
    }
    return charArr;
}

/*全选复选框*/
$("#table_th_checkbox").click(function(){
    if($("#table_th_checkbox").attr("checked") == "checked"){
        $("input[name='table_td_checkbox']").attr("checked","true");
    }else{
        $("input[name='table_td_checkbox']").removeAttr("checked");
    }
});

/*表单的异步提交*/
function doPost(form,returnUrl){
    var f = $(form);
    var params = f.serialize();
    $.ajax({
        type: "POST",
        url: form.action,
        data: params,
        success: function (result) {
            if(typeof(result.msg) == "undefined") {
                document.write(result);
                return;
            }
            alert(result.msg);
            if(!(typeof(returnUrl) == "undefined") && result.success){
                location.href = returnUrl;
            }
        },
        error: function (data) {
            alert("error:" + data.responseText);
        }
    });
}

/* validator插件全局配置 */
$.validator.config ({
    stopOnError: false,
    timely: false,
    focusCleanup:true,
    ignore: ':hidden',
    rules: {
        longitude:[/^[\-\+]?(0?\d{1,2}\.\d{1,5}|1[0-7]?\d{1}\.\d{1,5}|180\.0{1,5})$/,"请输入正确的经度值"],
        latitude:[/^[\-\+]?([0-8]?\d{1}\.\d{1,5}|90\.0{1,5})$/,"请输入正确的纬度值"] ,
        select: [/^(?!-1).*$/,"请选择{0}"],
        fee:[/^(([1-9]\d*)|0)(\.\d{1,2})?$/,"请输入正确的{0}"]
    }
});

$(function() {
    $("#table_th_checkbox").click(function() {
        $('input[name="table_td_checkbox"]').attr("checked",this.checked);
    });
    var $subBox = $("input[name='table_td_checkbox']");
    $subBox.click(function(){
        $("#table_th_checkbox").attr("checked",$subBox.length == $("input[name='table_td_checkbox']:checked").length ? true : false);
    });
});

$(document).ready(
    function(){
        $(".checkboxes").click(
            function(){
                if($(this).is(":checkbox"))
                {
                    $(this).parents("tr").toggleClass("yellowgreen").removeClass("white");
                }
                else{
                    $(this).parents("tr").toggleClass("yellowgreen").siblings().removeClass("yellowgreen");
                }
            }
        );
    }
);

$(document).ready(
    function(){
        $("#table_th_checkbox").click(
            function(){
                if($(this).is(":checked"))
                {
                    $(this).parents("thead").siblings("tbody").children("tr").addClass("yellowgreen").removeClass("white");
                }
                else{
                    $(this).parents("thead").siblings("tbody").children("tr").addClass("white").removeClass("yellowgreen");
                }
            }
        );
    }
);

function opcAlert(msg){
    try {
        opc.alert(msg);
    } catch (e) {
        alert(msg);
    }
}

/*
* limiter
* 计算还可以输入多少字符插件
* */
jQuery.fn.extend( {
    limiter: function(limit, elem) {
        $(this).on("keyup", function() {
            setCount(this, elem);
        });
        function setCount(src, elem) {
            var chars = src.value.length;
            if (chars > limit) {
                src.value = src.value.substr(0, limit);
                chars = limit;
            }
            elem.html( limit - chars );
        }
        setCount($(this)[0], elem);
    }
});


/**
 * 图片上传本地预览插件
 */
jQuery.fn.extend({
    uploadPreview: function (opts) {
        var _self = this,
            _this = $(this);
        opts = jQuery.extend({
            Img: "ImgPr",
            Width: 100,
            Height: 100,
            ImgType: ["gif", "jpeg", "jpg", "bmp", "png"],
            Callback: function () {}
        }, opts || {});
        _self.getObjectURL = function (file) {
            var url = null;
            if (window.createObjectURL != undefined) {
                url = window.createObjectURL(file)
            } else if (window.URL != undefined) {
                url = window.URL.createObjectURL(file)
            } else if (window.webkitURL != undefined) {
                url = window.webkitURL.createObjectURL(file)
            }
            return url
        };
        _this.change(function () {
            if (this.value) {
                if (!RegExp("\.(" + opts.ImgType.join("|") + ")$", "i").test(this.value.toLowerCase())) {
                    alert("选择文件错误,图片类型必须是" + opts.ImgType.join("，") + "中的一种");
                    this.value = "";
                    return false
                }
                if ($.browser.msie) {
                    try {
                        $("#" + opts.Img).attr('src', _self.getObjectURL(this.files[0]))
                    } catch (e) {
                        var src = "";
                        var obj = $("#" + opts.Img);
                        var div = obj.parent("div")[0];
                        _self.select();
                        if (top != self) {
                            window.parent.document.body.focus()
                        } else {
                            _self.blur()
                        }
                        src = document.selection.createRange().text;
                        document.selection.empty();
                        obj.hide();
                        obj.parent("div").css({
                            'filter': 'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)',
                            'width': opts.Width + 'px',
                            'height': opts.Height + 'px'
                        });
                        div.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = src
                    }
                } else {
                    $("#" + opts.Img).attr('src', _self.getObjectURL(this.files[0]))
                }
                opts.Callback()
            }
        })
    }
});



