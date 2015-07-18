App.controller('FormEditorController', function ($scope, $routeParams){
    var form_editor = function() {

	    var handleCKeditor = function(){
	        CKEDITOR.replace('content');
	    };
	    return{
	        init: function () {
	        	$("[data-provide='markdown']").markdown({autofocus:false,savable:false});
	            handleCKeditor();
	        }
	    };
	}(jQuery);
	$.fn.Button.core();
	form_editor.init();
});