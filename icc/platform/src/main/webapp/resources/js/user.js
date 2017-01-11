

function validateCode(code){
    $.ajax({
        url: "/image/validateCode?loginRandomImg="+code,
        type: 'post',
        dataType: 'json',
        data: '',
        success: function(data) {
            if(data.success){
               return true;
            }else{
               return false;
            }
        }
    });
}

function validateLogin(url){
    $.ajax({
        url: "/outUser/user/validateLogin",
        type: 'post',
        dataType: 'json',
        data: '',
        success: function(data) {
            if(data.success){
                if(url!=""){
                    location.href = url;
                }
            }else{
                $('.js-login').trigger("click");
            }
        }
    });
}

/*表单的异步提交*/
function doLoginByAjax(){

    var username = $("#username").val();
    if(username == ""){
        $("#loginFormShowMsg").text("用户账号不能为空");
        return;
    }

    var password = $("#password").val();
    if(password == ""){
        $("#loginFormShowMsg").text("账户密码不能为空");
        return;
    }

    var code = $("#code").val();
    if(code == ""){
        $("#loginFormShowMsg").text("请填写验证码");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/outUser/user/actLogin?username="+username+"&password="+password+"&code="+code,
        success: function (result) {
            if(result.success){
                location.href = returnUrl;
            }else {
                $("#loginFormShowMsg").text(result.msg);
            }

        },
        error: function (data) {
            $("#loginFormShowMsg").text(data.responseText);
        }
    });
}