
var rootUrl = "";
var returnUrl = "";
function setRootUrl(str){
    rootUrl = str;
}

function setReturnUrl(str){
    returnUrl = str;
}

/*更换登录验证码*/
function updateCode(id){
    $("#"+id).hide().attr('src',rootUrl+'/image/getImage?'+Math.floor(Math.random()*100)).fadeIn();
}


function isMobile(mobile){ //验证是否是手机号码
    if (/^1\d{10}$/.test(mobile)) {
        return true;
    }
    return false;
}

function  isEmail(str){ //验证是否是邮箱地址
    var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/
    if(re.test(str)){
      return true;
    }else{
        return false;
    }
}

function isChinaFont(str){ //是否是汉字
// [\u4E00-\uFA29]|[\uE7C7-\uE7F3]汉字编码范围
    var re1 = new RegExp("^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[a-zA-Z0-9])*$");
    if (!re1.test(str)){
        return false;
    }
    return true;
}



/*表单的异步提交*/
function doPostByAjax(form,returnUrl){
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
            if(!(typeof(returnUrl) == "undefined") && result.success ){
                location.href = returnUrl;
            }
        },
        error: function (data) {
            alert("error:" + data.responseText);
        }
    });
}


function isIdCardNo(num) {
    var factorArr = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1);
    var parityBit = new Array("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2");
    var varArray = new Array();
    var intValue;
    var lngProduct = 0;
    var intCheckDigit;
    var intStrLen = num.length;
    var idNumber = num;
    // initialize
    if ((intStrLen != 15) && (intStrLen != 18)) {
        return false;
    }
    // check and set value
    for (i = 0; i < intStrLen; i++) {
        varArray[i] = idNumber.charAt(i);
        if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
            return false;
        } else if (i < 17) {
            varArray[i] = varArray[i] * factorArr[i];
        }
    }

    if (intStrLen == 18) {
        //check date
        var date8 = idNumber.substring(6, 14);
        if (isDate8(date8) == false) {
            return false;
        }
        // calculate the sum of the products
        for (i = 0; i < 17; i++) {
            lngProduct = lngProduct + varArray[i];
        }
        // calculate the check digit
        intCheckDigit = parityBit[lngProduct % 11];
        // check last digit
        if (varArray[17] != intCheckDigit) {
            return false;
        }
    }
    else {        //length is 15
        //check date
        var date6 = idNumber.substring(6, 12);
        if (isDate6(date6) == false) {
            return false;
        }
    }
    return true;
}


function isDate6(sDate) {
    if (!/^[0-9]{6}$/.test(sDate)) {
        return false;
    }
    var year, month, day;
    year = sDate.substring(0, 4);
    month = sDate.substring(4, 6);
    if (year < 1700 || year > 2500) return false
    if (month < 1 || month > 12) return false
    return true
}


function isDate8(sDate) {
    if (!/^[0-9]{8}$/.test(sDate)) {
        return false;
    }
    var year, month, day;
    year = sDate.substring(0, 4);
    month = sDate.substring(4, 6);
    day = sDate.substring(6, 8);
    var iaMonthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    if (year < 1700 || year > 2500) return false
    if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) iaMonthDays[1] = 29;
    if (month < 1 || month > 12) return false
    if (day < 1 || day > iaMonthDays[month - 1]) return false
    return true
}
