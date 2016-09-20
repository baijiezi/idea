$(document).ready(
			function(){
				var nowimg = 0;
				$(".right_but").click(
					function(){
						//在改变信号量之前，让原来的信号量的li，淡出
						$(".tuul li").eq(nowimg).fadeOut(600);
						//改变信号量的值
						nowimg ++;
						nowimg = nowimg % $(".tuul li").length;	//用求余数运算来控制信号量
						//让新的信号量的li，淡入
						$(".tuul li").eq(nowimg).fadeIn(600);

						//小圆点的业务
						$(".dianul li").eq(nowimg).addClass("cur").siblings().removeClass("cur");
					}
				);

				$(".left_but").click(
					function(){
						//在改变信号量之前，让原来的信号量的li，淡出
						$(".tuul li").eq(nowimg).fadeOut(600);
						//折腾信号量，无法使用%运算
						if(nowimg > 0){
							nowimg -- ;
						}else{
							nowimg = $(".tuul li").length - 1;
						}
						console.log(nowimg);
						//让新的信号量的li，淡入
						$(".tuul li").eq(nowimg).fadeIn(600);
						//小圆点的业务
						$(".dianul li").eq(nowimg).addClass("cur").siblings().removeClass("cur");
					}
				);


				$(".dianul li").click(
					function(){
						if(!$(".tuul li").eq(nowimg).is(":animated")){
							//在改变信号量之前，让原来的信号量的li，淡出
							$(".tuul li").eq(nowimg).fadeOut(600);
							//信号量带着效果飞
							nowimg = $(this).index();	//用户点第几个，信号量变成几
							//让新的信号量的li，淡入
							$(".tuul li").eq(nowimg).fadeIn(600);
							//小圆点的业务
							$(".dianul li").eq(nowimg).addClass("cur").siblings().removeClass("cur");
						}
					}
				);
			}
		);

//按医院找
$(document).ready(
			function(){
				 $(".js-tabs a").mouseover(
				 	function(){
				 		
				 		$(this).addClass("on").siblings().removeClass("on")
				 		
				 		$(".js-memu ul").eq($(this).index()).show().siblings().hide()
				 	}
				 );
			}
			
		);


// 登陆框
$(document).ready(
			function(){
				 $(".js-login").click(
				 	function(){
				 		
				 		$(".js-entry-box").removeClass("disn")
				 		
				 		$("#unionpaym-bg").removeClass("disn")
				 	}
				 );
			}		
		);
$(document).ready(
			function(){
				 $(".js-close").click(
				 	function(){
				 		
				 		$(".js-entry-box").addClass("disn")
				 		
				 		$("#unionpaym-bg").addClass("disn")
				 	}
				 );
			}		
		);


// gdhospital切换
$(document).ready(
			function(){
				 $(".js-qiehuan").click(
				 	function(){
				 		
				 		$(".js-area").css("display","block").css("z-index","3500")
				 		
				 		$("#unionpaym-bg").addClass("disn")
				 	}
				 );
			}		
		);
// 展开
$(document).ready(
			function(){
				 $(".js-more").click(
				 	function(){
				 		$(this).addClass("disn")
				 		$(".js-morehos").removeClass("condition-collapse").addClass("condition-expand")
				 		$(".js-small").removeClass("disn")
				 	}
				 );
			}		
		);
$(document).ready(
			function(){
				 $(".js-small").click(
				 	function(){
				 		
				 		$(this).addClass("disn")
				 		$(".js-morehos").removeClass("condition-expand").addClass("condition-collapse")
				 		
				 		$(".js-more").removeClass("disn")
				 	}
				 );
			}		
		);
// hospitalnews更多
$(document).ready(
			function(){
				 $(".js-much").click(
				 	function(){
				 		$(".js-more-box").removeClass("disn").css("display","block")
				 	}
				 );
			}		
		);
$(document).ready(
			function(){
				 $(".js-more-up").click(
				 	function(){
				 		$(".js-more-box").addClass("disn").css("display","none")
				 	}
				 );
			}		
		);
// 更多2同一个页面有两个更多
$(document).ready(
			function(){
				 $(".js-much1").click(
				 	function(){
				 		$(".js-more-box1").removeClass("disn").css("display","block")
				 	}
				 );
			}		
		);
$(document).ready(
			function(){
				 $(".js-more-up1").click(
				 	function(){
				 		$(".js-more-box1").addClass("disn").css("display","none")
				 	}
				 );
			}		
		);





// 预约时候时段选择
$(document).ready(
			function(){
				 $(".js-meeting").click(
				 	function(){
				 		$(".js-meeting1").removeClass("disn")
				 		$("#unionpaym-bg").removeClass("disn")
				 	}
				 );
			}		
		);
$(document).ready(
			function(){
				 $(".js-close1").click(
				 	function(){
				 		
				 		$(".js-meeting1").addClass("disn")
				 		
				 		$("#unionpaym-bg").addClass("disn")
				 	}
				 );
			}		
		);
// order信息显示
$(document).ready(
			function(){
				 $(".js-on").mouseover(
				 	function(){
				 		$(this).children(".js-gai").css("display","block")	
				 	}
				 );
			}		
		);
$(document).ready(
			function(){
				 $(".js-on").mouseout(
				 	function(){
				 		$(this).children(".js-gai").css("display","none")	
				 	}
				 );
			}		
		);
// 新增就诊人
$(document).ready(
			function(){
				 $(".js-useradd,.js-myself").click(
				 	function(){
				 		
				 		$(".js-newadd").removeClass("disn").css("display","block")
				 		
				 		$("#unionpaym-bg").removeClass("disn")
				 	}
				 );
			}		
		);

$(document).ready(
			function(){
				 $(".js-closes,.js-closess").click(
				 	function(){
				 		
				 		$(".js-newadd").addClass("disn")
				 		
				 		$("#unionpaym-bg").addClass("disn")
				 	}
				 );
			}		
		);

 // 选择就诊人
$(document).ready(
			function(){
				 $(".js-mr").mouseover(
				 	function(){
				 		
				 		$(this).addClass("hover")
				 		

				 	}
				 );
			}		
		);
$(document).ready(
			function(){
				 $(".js-mr").mouseout(
				 	function(){
				 		
				 		$(this).removeClass("hover")
				 		

				 	}
				 );
			}		
		);
$(document).ready(
			function(){
				 $(".js-mr").click(
				 	function(){
				 		$(this).addClass("on")
				 		$(this).siblings().removeClass("on")
				 		

				 	}
				 );
			}		
		);


// 取消订单
var onOff = null;
$(document).ready(
			function(){
				 $(".js-cancel").click(
				 	function(){
				 		onOff = $(this).parents("tr").index();
				 		$(".js-cancelbox").removeClass("disn").css("display","block")
				 		$("#unionpaym-bg").removeClass("disn")
				 	}
				 );
			}		
		);
$(document).ready(
			function(){
				 $(".js-cancelclose,.js-cancelback,.js-sure").click(
				 	function(){
				 		$(".js-cancelbox").addClass("disn").css("display","none")
				 		$(".js-cancelboxsure").addClass("disn").css("display","none")
				 		$("#unionpaym-bg").addClass("disn")
				 	}
				 );
			}		
		);
$(function(){
    $(".js-cancelapp").click(function(){
        var orderId = $("#cancelOrderId").val();
        $.post("/user/order/cancel?orderId="+orderId,
            function(data){
                //location.href = "${urlPath}/user/order/list";
                $(".js-cancelbox").addClass("disn").css("display","none")
                if(!data.success){
                    $(".js-cancelboxsure").find(".success").html(data.msg);
                }
                $(".js-cancelboxsure").removeClass("disn").css("display","block")
                $("#table1 tbody tr").eq(onOff).find("td").eq($("#table1 tbody tr").eq(0).find("td").length-1).html("");
                $("#table1 tbody tr").eq(onOff).find("td").eq($("#table1 tbody tr").eq(0).find("td").length-2).children("p").html(data.msg);
            });
    })
})


// hospitalschedule


 var   x=53;
 var   y=25;
$(function(){
	$(".js-datenews1").mouseover(function(){
        var regStatus = $(this).find("input[name='regStatus']").val();
        if(regStatus == '停诊'){
            $(".js-datenews").find("p").eq(0).html("此号源已停诊");
        }
        else{
            $(".js-datenews").find("p").eq(0).html("点击查看号源情况");
        }
        $(".js-datenews").find("p").eq(1).html("门诊类型：" + $(this).find("input[name='doctorTitle']").val());
        $(".js-datenews").find("p").eq(2).html("出诊时间：" + $(this).find("input[name='scheduleTime']").val());
        $(".js-datenews").find("p").eq(3).html("科室：" + $(this).find("input[name='deptName']").val());
        $(".js-datenews").find("p").eq(4).html("挂号费：<label style=\"color:red\">" + $(this).find("input[name='fee']").val()/100 + "元</label>");
		var offset=$(this).offset();
		var left = offset.left;
		var top = offset.top;
		$(".js-datenews").removeClass("disn").css({
			"top":(top+x) +"px",
			"left":(left+y) +"px"
		})
})
})
$(function(){
	$(".js-datenews1").mouseout(function(){
		

		$(".js-datenews").addClass("disn")
		})
})



// 新增就诊人
$(document).ready(
			function(){
				 $(".js-addusers").click(
				 	function(){
				 		
				 		$(".js-addusersbox").css("display","block").siblings(".js-patient-info").css("display","none")
				 	}
				 );
			}		
		);
$(document).ready(
			function(){
				 $(".js-close-link").click(
				 	function(){
				 		
				 		$(".js-addusersbox").css("display","none")
				 	}
				 );
			}		
		);

// 详情
$(document).ready(
			function(){
				 $(".js-detail").click(
				 	function(){
				 		
				 		$(".js-detailsbox").css("display","block").siblings(".js-patient-info").css("display","none")
				 	}
				 );
			}		
		);
$(document).ready(
			function(){
				 $(".js-close-link").click(
				 	function(){
				 		
				 		$(".js-detailsbox").css("display","none")
				 	}
				 );
			}		
		);
// 修改
$(document).ready(
			function(){
				 $(".js-edits").click(
				 	function(){
				 		
				 		$(".js-editsbox").css("display","block").siblings(".js-patient-info").css("display","none")
				 	}
				 );
			}		
		);
$(document).ready(
			function(){
				 $(".js-close-link").click(
				 	function(){
				 		
				 		$(".js-editsbox").css("display","none")
				 	}
				 );
			}		
		);
// 删除
$(document).ready(
			function(){
				 $(".js-dels").click(
				 	function(){
				 		
				 		$(this).parent().parent().remove()
				 	}
				 );
			}		
		);
// centerlove
$(document).ready(
			function(){
				 $(".js-tab a").click(
				 	function(){
				 		//让自己加上cur，自己的兄弟去掉cur。
				 		$(this).addClass("current").siblings().removeClass("current")
				 		//对应的.bd中的ul显示，其余隐藏。
				 		$(".js-tabbox").children().eq($(this).index()).show().siblings().hide()
				 	}
				 );
			}
			
		);
// centerlove1
// 取消收藏
var onOfflove = null;
// bekeygai 
$(document).ready(
			function(){
				 $(".js-dellove").click(
				 	function(){
				 		onOfflove = $(this).parents(".unionpay-tab-content").index();
				 		onOffloveli = $(this).parents("li").index();
				 		$(".js-cancelbox").removeClass("disn").css("display","block")
				 		$("#unionpaym-bg").removeClass("disn")
				 	}
				 );
			}		
		);
$(document).ready(
            function(){
                $(".js-cancelback").click(
                    function(){
                        $(".js-cancelbox").addClass("disn").css("display","none")
                        $(".js-cancelboxsure").addClass("disn").css("display","none")
                        $("#unionpaym-bg").addClass("disn")
                    }
                );

                $(".js-cancelclose,.js-sure").click(
                    function(){
                        $(".js-cancelbox").addClass("disn").css("display","none")
                        $(".js-cancelboxsure").addClass("disn").css("display","none")
                        $("#unionpaym-bg").addClass("disn")
                        location.reload();
                    }
                );

                $(".js-cancelclose,.js-orderCancelSure").click(
                    function(){
                        $(".js-cancelbox").addClass("disn").css("display","none")
                        $(".js-cancelboxsure").addClass("disn").css("display","none")
                        $("#unionpaym-bg").addClass("disn")
                        location.href = "/user/order/list";
                    }
                );
            }
		);
// 不可改
$(function(){
	$(".js-cancelapp1").click(function(){
		$(".js-cancelbox").addClass("disn").css("display","none")
		$(".js-cancelboxsure").removeClass("disn").css("display","block")
	$(".unionpay-tab-content").eq(onOfflove).find("li").eq(onOffloveli).addClass("disn").css("display","none");
	
})
})



// 个人信息
$(document).ready(
			function(){
				 $(".js-Setvalues").click(
				 	function(){
				 		$(this).css("display","none")
				 		$(".js-gfm-input").css("display","inline-block")
				 		$(".js-actions").css("display","inline-block")
				 	}
				 );
			}		
		);



// bxslider
 $(document).ready(function(){
        $('.bxslider').bxSlider({
              minSlides: 5,
              maxSlides: 5,
            slideWidth:100,
        slideMargin:0,
              auto: false,
              infiniteLoop: false,
  hideControlOnEnd: true,
                SlideIndex:true,
                pager: false

        });
    });


//substr 字符串截取
$(function () {
    jQuery.fn.substr=function(){
        var self = $("*[limit]");
        self.each(
            function(){
                var objString = $.trim($(this).text());
                var objLength = $.trim($(this).text()).length;
                var num = $(this).attr("limit");
                if(objLength > num){
                    $(this).attr("title",objString);
                    objString = $(this).text(objString.substring(0,num) + "...");
                }
            }
        )
    }
});