App.controller('PageSigninController', function ($scope, $routeParams){
	
    $("body>.fluid").replaceWith($('.page-signin'));

    $('input[type="checkbox"]').iCheck({
        checkboxClass: 'icheckbox_minimal-grey',
        increaseArea: '20%' // optional
    });
    
});