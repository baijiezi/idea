App.controller('FormComponentsController', function ($scope, $routeParams){
    var form_components = function() {
    	var handleBootstrapSwitch = function() {
    		$('#demo-bootstrap-switch .make-switch').bootstrapSwitch();
    	};
	    //BEGIN CHARACTER COUNT
	    var handleCharacterCount = function(){
	        $("#message1, #message2").charCount();
	        $("#message3").charCount({
	            allowed: 50,
	            warning: 20,
	            counterText: 'Characters left: '
	        });
	    };
	    //END CHARACTER COUNT

	    //BEGIN MASK INPUT
	    var handleMaskInput = function(){
	        $("#date").mask("99/99/9999");
	        $("#phone").mask("(999) 999-9999");
	        $("#product-key").mask("(aa) 99-999");
	    };
	    //END MASK INPUT

	    return{
	        init: function () {
	        	handleBootstrapSwitch();
	            handleCharacterCount();
	            handleMaskInput();
	        }
	    };
	}(jQuery);
	//$.fn.Button.core(); 
	form_components.init();

});