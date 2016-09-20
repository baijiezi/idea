var OnMessage = function (e) {
	try{
		var m = eval(e.data);
		switch(m.funcname){
		case "pasteperson":
			pasteperson(m.funcparam);
			break;
		default:
			break;
		}
	}catch(e1){
		
	}	
};

function initmessage() {
	if (window.addEventListener) {  // all browsers except IE before version 9
		window.addEventListener("message", OnMessage, false);
	} else {
		if (window.attachEvent) {   // IE before version 9
			window.attachEvent("onmessage", OnMessage);
        }
    }
}

initmessage();

function showdialog(){
	try{
		opc.show();
	}catch(e){
		
	}
}

function hidedialog(){
	try{
		opc.hide();
	}catch(e){
		
	}
}

//function signticket(xhr,status,args){
//	if (args.info){
//		signDialogWidget.show();
//		try{
//			opc.signticket(args.info);
//		}catch(e){
//
//		}
//	}
//}

//function signticket(info){
//    if (info){
//        try{
//            opc.signticket(info);
//        }catch(e){
//
//        }
//    }
//}
