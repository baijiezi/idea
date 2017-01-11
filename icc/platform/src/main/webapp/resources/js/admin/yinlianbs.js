// 左导航
    $(document).ready(
            function(){
                 $(".jsnav").click(
                    function(){
                        $(this).siblings().addClass("in")
                        $(this).parent().siblings().children().removeClass("in")
                    }
                 );
            }
            
        );
    $(document).ready(
            function(){
                 $(".jsin a").click(
                    function(){
                        $(this).addClass("on").parent().siblings().children().removeClass("on")
                        $(this).parent().parent().parent().siblings().children().children().children("a").removeClass("on")
                    
                    }
                 );
            }
            
        );
    // 绑定卡
    $(document).ready(
            function(){
                 $(".js-sure").click(
                    function(){
                        $(".js-bg").removeClass("disn");
                        $(".js-systemtips").removeClass("disn");
                        var username = $("#username").val();
                        var cardNumber = $("#cardNumber").val();
                        $.post("/admin/user/payCard/bandUser?username="+username+"&cardNumber="+cardNumber,
                            function(result){
                                if(result.success){
                                    $("#vidateShowMsg").text("验证成功！已成功绑定账号"+username);
                                    $(".js-bg").removeClass("disn");
                                    $(".js-showMsg").removeClass("disn");
                                    $("#needReload").val(1);
                                }else {
                                    $("#vidateShowMsg").text(result.msg);
                                    $(".js-bg").removeClass("disn");
                                    $(".js-showMsg").removeClass("disn");
                                }
                            });
                    }
                 );
            }
        );
$(document).ready(
            function(){
                 $(".js-close,.js-cancel").click(
                    function(){
                        $(".js-bg").addClass("disn")
                        $(".js-systemtips").addClass("disn")
                    }
                 );
            }       
        );

$(document).ready(
    function(){
        $(".js-show-close,.js-show-cancel").click(
            function(){
                $(".js-bg").addClass("disn");
                $(".js-showMsg").addClass("disn");
                var reload = $("#needReload").val();
                if(reload == 1){
                    location.href = "/admin/user/payCard/ybCardList";
                }
            }
        );
    }
);

