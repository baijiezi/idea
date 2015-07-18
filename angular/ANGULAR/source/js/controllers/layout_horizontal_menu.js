App.controller('LayoutHorizontalMenuController', function ($scope, $routeParams){
    var layout_horizontal_menu = function() {

	    var handleHorizontalMenu = function () {
	        $('.logo-wrapper').removeClass('in-sidebar');
        	$('#footer').css('padding-left','0px');
	    };

	    return{
	        init: function () {
	            handleHorizontalMenu();
	        }
	    };

	}(jQuery);
	layout_horizontal_menu.init();
});