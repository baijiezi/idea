App.controller('UITypographyController', function ($scope, $routeParams){
    

	var ui_typography = function() {

	    var handleWordRotate = function() {
	        $('.word-rotate-items').each(function () {
	            var me = $(this);
	            var count = $(' > span', me).length;
	            var i = 1;

	            setInterval(function () {
	                if (i < count) {
	                    me.css('-webkit-transform', 'translate3d(0,-' + i + '00%,0)');
	                    i++;
	                }
	                else {
	                    i = 0;
	                }
	            }, 1000);
	        });
	    };
	   


	    return{
	        init: function () {
	            handleWordRotate();

	        }
	    };

	}(jQuery);
	ui_typography.init();
});