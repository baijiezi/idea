App.controller('UiDatepaginatorController', function ($scope, $routeParams){
	var ui_datepaginator = function() {
	    var handleDP = function() {
	        $('.paginator').datepaginator();
	        $('.paginator-select').datepaginator({
	            onSelectedDateChanged: function (event, date) {
	                alert("Selected date: " + moment(date).format("Do, MMM YYYY"));
	            }
	        });
	    };
	    return{
	        init: function () {
	            handleDP();
	        }
	    };
	}(jQuery);

	setTimeout(function(){
		ui_datepaginator.init();
	},100);
});