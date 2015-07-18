"use strict";
var App = angular.module('mtek', ['ngRoute', 'ui.bootstrap', 'ui.router', 'oc.lazyLoad',]);
App.config(function($stateProvider, $urlRouterProvider) {
  //
    // For any unmatched url, redirect to /state1
    $urlRouterProvider.otherwise("/index");
    //
    // Now set up the states
    $stateProvider
        .state('index', {
            url: "/index", 
            templateUrl: 'templates/states/main.html',
            controller: 'MainController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: [
                                'assets/vendors/jquery-jvectormap/jquery-jvectormap-2.0.1.css',
                                'assets/vendors/jquery-jvectormap/jquery-jvectormap-us-lcc-en.js',
                                'assets/vendors/jquery-jvectormap/gdp-data.js',
                                'assets/vendors/flot-chart/jquery.flot.js',
                                'assets/vendors/flot-chart/jquery.flot.categories.js',
                                'assets/vendors/flot-chart/jquery.flot.pie.js',
                                'assets/vendors/flot-chart/jquery.flot.tooltip.js',
                                'assets/vendors/flot-chart/jquery.flot.resize.js',
                                'assets/vendors/flot-chart/jquery.flot.fillbetween.js',
                                'assets/vendors/flot-chart/jquery.flot.stack.js',
                                'assets/vendors/flot-chart/jquery.flot.spline.js',
                                'assets/vendors/jquery-animateNumber/jquery.animateNumber.min.js',
                                'assets/vendors/jquery.sparkline.min.js',
                                'assets/vendors/skycons/skycons.js'
                                ]
                     });
                }]
            }
        })
        .state('layout_full_width', {
          url:"/layout_full_width",
          templateUrl: 'templates/states/layout_full_width.html'
        })
        .state('layout_boxed', {
          url:"/layout_boxed",
          templateUrl: 'templates/states/layout_boxed.html'
        })
        .state('layout_sidebar_collapsed', {
          url:"/layout_sidebar_collapsed",
          templateUrl: 'templates/states/layout_sidebar_collapsed.html'
        })
        .state('layout_sidebar_fixed', {
          url:"/layout_sidebar_fixed",
          templateUrl: 'templates/states/layout_sidebar_fixed.html',
          controller: 'LayoutSidebarFixedController'
        })
        .state('layout_sidebar_collapsed_fixed', {
          url:"/layout_sidebar_collapsed_fixed",
          templateUrl: 'templates/states/layout_sidebar_collapsed_fixed.html'
        })
        .state('layout_horizontal_menu', {
          url:"/layout_horizontal_menu",
          templateUrl: 'templates/states/layout_horizontal_menu.html',
          controller: 'LayoutHorizontalMenuController'
        })
        .state('layout_header_fixed', {
          url:"/layout_header_fixed",
          templateUrl: 'templates/states/layout_header_fixed.html'
        })
        .state('ui_general', {
          url:"/ui_general",
          templateUrl: 'templates/states/ui_general.html'
        })
        .state('ui_buttons', {
          url:"/ui_buttons",
          templateUrl: 'templates/states/ui_buttons.html'
        })
        .state('ui_typography', {
          url:"/ui_typography",
          templateUrl: 'templates/states/ui_typography.html',
          controller: 'UITypographyController'
        })
        .state('ui_tabs_accordions', {
          url:"/ui_tabs_accordions",
          templateUrl: 'templates/states/ui_tabs_accordions.html',
          controller: 'UiTabsAccordionsController'
        })
        .state('ui_modals', {
            url: "/ui_modals", 
            templateUrl: 'templates/states/ui_modals.html',
            controller: 'UiModalsController'
        })
        .state('ui_treeview', {
          url:"/ui_treeview",
          templateUrl: 'templates/states/ui_treeview.html',
          controller: 'UiTreeviewController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/zTree_v3/css/zTreeStyle/zTreeStyle.css',
                                'assets/vendors/zTree_v3/js/jquery.ztree.all-3.5.js']
                     });
                }]
            }
        })
        .state('ui_icons', {
            url: "/ui_icons", 
            templateUrl: 'templates/states/ui_icons.html'
        })
        .state('ui_panels', {
          url:"/ui_panels",
          templateUrl: 'templates/states/ui_panels.html',
          controller: 'UiPanelsController'
        })
        .state('ui_nestable_list', {
            url: "/ui_nestable_list", 
            templateUrl: 'templates/states/ui_nestable_list.html',
            controller: 'UiNestableListController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/jquery-nestable/nestable.css',
                                'assets/vendors/jquery-nestable/jquery.nestable.js']
                     });
                }]
            }
        })
        .state('ui_datepaginator', {
            url: "/ui_datepaginator", 
            templateUrl: 'templates/states/ui_datepaginator.html',
            controller: 'UiDatepaginatorController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/bootstrap-datepaginator/bootstrap-datepaginator.min.css',
                                'assets/vendors/bootstrap-datepaginator/datepicker.css',
                                'assets/vendors/bootstrap-datepaginator/bootstrap-datepaginator.min.js',
                                'assets/vendors/bootstrap-datepaginator/bootstrap-datepicker.js']
                     });
                }]
            }
        })
        .state('ui_toastr', {
            url:"/ui_toastr",
            templateUrl: 'templates/states/ui_toastr.html',
            controller: 'UiToastrListController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/jquery-toastr/toastr.css',
                                'assets/vendors/jquery-toastr/toastr.js']
                     });
                }]
            }
        })
        .state('form_components', {
            url:"/form_components",
            templateUrl: 'templates/states/form_components.html',
            controller: 'FormComponentsController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/jquery-maskedinput/jquery-maskedinput.js',
                                'assets/vendors/charCount.js']
                     });
                }]
            }
        })
        .state('form_wizard', {
            url: "/form_wizard", 
            templateUrl: 'templates/states/form_wizard.html',
            controller: 'FormWizardController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/jquery-steps/css/jquery.steps.css',
                                'assets/vendors/jquery-validation/dist/jquery.validate.js',
                                'assets/vendors/jquery-steps/js/jquery.steps.min.js',
                                'assets/vendors/jquery-bootstrap-wizard/jquery.bootstrap.wizard.js']
                     });
                }]
            }
        })
        .state('form_validation', {
            url: "/form_validation", 
            templateUrl: 'templates/states/form_validation.html',
            controller: 'FormValidationController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/jquery-validation/dist/jquery.validate.js']
                     });
                }]
            }
        })
        .state('form_picker', {
            url: "/form_picker", 
            templateUrl: 'templates/states/form_picker.html',
            controller: 'FormPickerController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/bootstrap-datepicker/css/datepicker.css',
                                'assets/vendors/bootstrap-colorpicker/css/colorpicker.css',
                                'assets/vendors/bootstrap-daterangepicker/daterangepicker-bs3.css',
                                'assets/vendors/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css',
                                'assets/vendors/bootstrap-timepicker/css/bootstrap-timepicker.min.css',
                                'assets/vendors/bootstrap-clockface/css/clockface.css',
                                'assets/vendors/bootstrap-daterangepicker/moment.js',
                                'assets/vendors/bootstrap-datepicker/js/bootstrap-datepicker.js',
                                'assets/vendors/bootstrap-colorpicker/js/bootstrap-colorpicker.js',
                                'assets/vendors/bootstrap-daterangepicker/daterangepicker.js',
                                'assets/vendors/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js',
                                'assets/vendors/bootstrap-timepicker/js/bootstrap-timepicker.js',
                                'assets/vendors/bootstrap-clockface/js/clockface.js']
                     });
                }]
            }
        })
        .state('form_select', {
          url:"/form_select",
          templateUrl: 'templates/states/form_select.html',
           controller: 'FormSelectController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['global/vendors/select2/select2-custom.css',
                                'assets/vendors/bootstrap-select/bootstrap-select.min.css',
                                'assets/vendors/multi-select/css/multi-select-madmin.css',
                                'global/vendors/select2/select2.min.js',
                                'assets/vendors/bootstrap-select/bootstrap-select.min.js',
                                'assets/vendors/multi-select/js/jquery.multi-select.js']
                     });
                }]
            }
        })
        .state('form_editor', {
            url: "/form_editor", 
            templateUrl: 'templates/states/form_editor.html',
            controller: 'FormEditorController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/bootstrap-markdown/css/bootstrap-markdown.min.css',
                                'assets/vendors/bootstrap-markdown/js/bootstrap-markdown.js',
                                'assets/vendors/bootstrap-markdown/js/to-markdown.js',
                                'assets/vendors/bootstrap-markdown/js/markdown.js',
                                'assets/vendors/ckeditor/ckeditor.js']
                     });
                }]
            }
        })
        .state('form_multiple_file_upload', {
            url: "/form_multiple_file_upload", 
            templateUrl: 'templates/states/form_multiple_file_upload.html',
            controller: 'FormMultipleFileController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/jquery-file-upload/css/jquery.fileupload.css',
                                'assets/vendors/jquery-file-upload/css/jquery.fileupload-ui.css',
                                'assets/vendors/jquery-file-upload/css/blueimp-gallery.min.css',
                                'assets/vendors/jquery-file-upload/js/vendor/jquery.ui.widget.js',
                                'assets/vendors/jquery-file-upload/js/vendor/tmpl.min.js',
                                'assets/vendors/jquery-file-upload/js/vendor/load-image.min.js',
                                'assets/vendors/jquery-file-upload/js/vendor/canvas-to-blob.min.js',
                                'assets/vendors/jquery-file-upload/js/vendor/jquery.blueimp-gallery.min.js',
                                'assets/vendors/jquery-file-upload/js/jquery.iframe-transport.js',
                                'assets/vendors/jquery-file-upload/js/jquery.fileupload.js',
                                'assets/vendors/jquery-file-upload/js/jquery.fileupload-process.js',
                                'assets/vendors/jquery-file-upload/js/jquery.fileupload-image.js',
                                'assets/vendors/jquery-file-upload/js/jquery.fileupload-audio.js',
                                'assets/vendors/jquery-file-upload/js/jquery.fileupload-video.js',
                                'assets/vendors/jquery-file-upload/js/jquery.fileupload-validate.js',
                                'assets/vendors/jquery-file-upload/js/jquery.fileupload-ui.js',
                                'assets/vendors/jquery-file-upload/js/cors/jquery.xdr-transport.js']
                     });
                }]
            }
        })
        .state('form_dropzone', {
            url: "/form_dropzone", 
            templateUrl: 'templates/states/form_dropzone.html',
            controller: 'FormDropzoneController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/dropzone/css/dropzone.css',
                                'assets/vendors/dropzone/js/dropzone.min.js']
                     });
                }]
            }
        })
        
        .state('table_basic', {
            url: "/table_basic", 
            templateUrl: 'templates/states/table_basic.html'
        })
        
        .state('table_responsive', {
            url: "/table_responsive", 
            templateUrl: 'templates/states/table_responsive.html'
        })
        .state('table_advanced', {
            url: "/table_advanced", 
            templateUrl: 'templates/states/table_advanced.html',
            controller: 'TableAdvancedController',
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/DataTables/media/css/jquery.dataTables.css',
                                'assets/vendors/DataTables/extensions/TableTools/css/dataTables.tableTools.min.css',
                                'assets/vendors/DataTables/media/css/dataTables.bootstrap.css',
                                'assets/vendors/DataTables/media/js/jquery.dataTables.js',
                                'assets/vendors/DataTables/media/js/dataTables.bootstrap.js',
                                'assets/vendors/DataTables/extensions/TableTools/js/dataTables.tableTools.min.js']
                     });
                }]
            }
        })
        .state('table_treegrid', {
            url: "/table_treegrid", 
            templateUrl: 'templates/states/table_treegrid.html',
            controller: 'TableTreegridController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/treegrid/css/jquery.treegrid.css',
                                'assets/vendors/treegrid/js/jquery.treegrid.js',
                                'assets/vendors/treegrid/js/jquery.treegrid.bootstrap3.js']
                     });
                }]
            }
        })
        .state('page_profile', {
            url: "/page_profile", 
            templateUrl: 'templates/states/page_profile.html',
            controller: 'NoneController'
        })
        .state('page_timeline', {
            url: "/page_timeline", 
            templateUrl: 'templates/states/page_timeline.html',
            controller: 'NoneController'
        })
        .state('page_gallery', {
            url: "/page_gallery", 
            templateUrl: 'templates/states/page_gallery.html',
            controller: 'PageGalleryController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/lightbox/css/lightbox.css',
                                'assets/vendors/mixitup/src/jquery.mixitup.js'
                                ]
                     });
                }]
            }
        })
        .state('page_calendar', {
            url: "/page_calendar", 
            templateUrl: 'templates/states/page_calendar.html',
            controller: 'PageCalendarController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/fullcalendar/fullcalendar.css',
                                'assets/vendors/fullcalendar/fullcalendar.min.js']
                     });
                }]
            }
        })
        .state('page_pricing_table', {
            url: "/page_pricing_table", 
            templateUrl: 'templates/states/page_pricing_table.html'
        })
        .state('page_invoice', {
            url: "/page_invoice", 
            templateUrl: 'templates/states/page_invoice.html'
        })
        
        .state('page_search', {
          url:"/page_search",
          templateUrl: 'templates/states/page_search.html'
        })
        
        .state('page_mail', {
          url:"/page_mail",
          templateUrl: 'templates/states/page_mail.html',
          controller: 'PageMailController', 
          resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css',
                                'assets/vendors/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js']
                     });
                }]
          }
        })

        .state('page_signin', {
            url: "/page_signin", 
            templateUrl: 'templates/states/page_signin.html',
            controller: 'PageSigninController'
        })
        .state('page_signup', {
            url: "/page_signup", 
            templateUrl: 'templates/states/page_signup.html',
            controller: 'PageSignupController'
        })
        .state('page_lock_screen', {
            url: "/page_lock_screen", 
            templateUrl: 'templates/states/page_lock_screen.html',
            controller: 'PageLockScreenController'
        })
        .state('page_404', {
            url: "/page_404", 
            templateUrl: 'templates/states/page_404.html',
            controller: 'Page404Controller'
        })
        .state('page_500', {
            url: "/page_500", 
            templateUrl: 'templates/states/page_500.html',
            controller: 'Page500Controller'
        })
        .state('charts_flot', {
            url: "/charts_flot", 
            templateUrl: 'templates/states/charts_flot.html',
            controller: 'ChartsFlotController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: [
                                'assets/vendors/flot-chart/jquery.flot.categories.js',
                                'assets/vendors/flot-chart/jquery.flot.pie.js',
                                'assets/vendors/flot-chart/jquery.flot.tooltip.js',
                                'assets/vendors/flot-chart/jquery.flot.resize.js',
                                'assets/vendors/flot-chart/jquery.flot.fillbetween.js',
                                'assets/vendors/flot-chart/jquery.flot.stack.js',
                                'assets/vendors/flot-chart/jquery.flot.spline.js']
                     });
                }]
            }
        })
        
        .state('charts_chartjs', {
            url: "/charts_chartjs", 
            templateUrl: 'templates/states/charts_chartjs.html',
            controller: 'ChartsChartjsController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/chart.js/Chart.min.js']
                     });
                }]
            }
        })
        .state('charts_sparklines', {
            url: "/charts_sparklines", 
            templateUrl: 'templates/states/charts_sparklines.html',
            controller: 'ChartsSparklinesController', 
            resolve: { 
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                     return $ocLazyLoad.load({
                        files: ['assets/vendors/jquery.sparkline.min.js']
                     });
                }]
            }
        })
    ;
});

App.controller('AppController', function ($scope, $rootScope, $routeParams, $location){
    $scope.data = {};
    $scope.effect = '';
    $scope.header = {
        animation:'',
		boxed:'',
        layout_menu:'',
        header_topbar:'static',
        menu_style:'sidebar-default',	
		layout_horizontal_menu:'',		
    };

    // HANDLE CHANGE PAGE
    $scope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams){
        $scope.header.animation = 'fadeInUp';
    
        setTimeout(function(){
            $scope.header.animation = '';
            $.fn.Data.Button();
        }, 100);

        $scope.data = $.fn.Data.get(toState.url);
        window.scrollTo(0,0);
		
		$scope.header.boxed = '';
		$scope.header.footer = true;

		if('/layout_horizontal_menu' === toState.url){
            $scope.header.layout_menu = 'layout-full-width'; 
		}
        else if('/layout_full_width' === toState.url){
            $scope.header.layout_menu = ''; 
        }
		else if('/layout_sidebar_collapsed' === toState.url){
			$scope.header.layout_menu = 'layout-sidebar-collapsed'; 
		}
		else if('/layout_sidebar_fixed' === toState.url){
			$scope.header.layout_menu = 'layout-sidebar-fixed';	
		}
		else if('/layout_sidebar_collapsed_fixed' === toState.url){
			$scope.header.layout_menu = 'layout-sidebar-collapsed layout-sidebar-fixed';	
		}
		else if('/layout_header_fixed' === toState.url){
			$scope.header.layout_menu = 'layout-header-fixed';			
		}
		else if('/layout_boxed' === toState.url){
			$scope.header.boxed = 'container';			
		}
        if('/index' !== toState.url){
            $(".charts-inline").addClass("hidden");       
        }
        else $(".charts-inline").removeClass("hidden");        
    });

    // CORE FUNCTION FOR GLOBAL 
    var Layout = function() {
        //BEGIN MENU MAIN
        var handleSidebarMain = function(){
            $('#sidebar-main').metisMenu();
        };
        //END MENU MAIN

        //END MENU TOGGLE
        var handleMenuToggle = function(){
            $('#menu-toggle.show-collapsed').live('click',function(){
                if($(window).width() > 992){ // Error with 768
                    $('#setting-sidebar-collapsed').bootstrapSwitch('toggleState');
                } else {
                    if(!$(this).hasClass('active')){
                        $(this).addClass('active').animate({'left':'250px'},50);
                        $('.sidebar').animate({'left':0},10);
                        $('.page-content').animate({'left':'250px'},50);
                    }
                    else{
                        $(this).removeClass('active').animate({'left':0},50);
                        $('.sidebar').animate({'left':-250},50);
                        $('.page-content').animate({'left':0},50);
                    }
                }
            });

            $('#menu-toggle.show-hide').live('click',function(){
                $('#setting-sidebar-hide').bootstrapSwitch('toggleState');
            });

            $('.page-content').click(function(){
                $('#menu-toggle').removeClass('active').animate({'left':0},50);
                $('.sidebar').animate({'left':-250},50);
                $('.page-content').animate({'left':0},50);
            });
        };
        //END MENU TOGGLE

        //BEGIN SLIMSCROLL TOPBAR
        var handleSlimscrollTopbar = function () {
            $('.dropdown-slimscroll').slimScroll({
                "width": '100%',
                "height": '250px',
                "wheelStep": 25
            });
        };
        //END SLIMSCROLL TOPBAR

        //BEGIN SIDEBAR SECOND TO DO'S LIST
        var handleSlimscrollTodo = function(){
            $('.list-todo-scroll').slimScroll({
                "width": '100%',
                "height": '250px',
                "wheelStep": 25
            });
        };
        //END SIDEBAR SECOND TO DO'S LIST

        //BEGIN TEMPLATE SETTING
        var handleTemplateSetting = function(){
            $('#template-setting .make-switch').bootstrapSwitch();
            $('a.btn-template-setting').click(function(){
                if($('#template-setting').css('right') < '0'){
                    $('#template-setting').css('right', '0');
                } else {
                    $('#template-setting').css('right', '-255px');
                }
            });

            $('ul.sidebar-color > li').click(function () {
                var color = $(this).attr('data-style');
                $('ul.sidebar-color > li').removeClass('active');
                $(this).addClass('active');
                switch(color) {
                    case 'default':
                        $('body').removeClass(function (index, css) {
                            return (css.match (/(^|\s)sidebar-color-\S+/g) || []).join(' ');
                        });
                        break;
                    case 'orange':
                        $('body').removeClass(function (index, css) {
                            return (css.match (/(^|\s)sidebar-color-\S+/g) || []).join(' ');
                        }).addClass('sidebar-color-orange');
                        break;
                    case 'green':
                        $('body').removeClass(function (index, css) {
                            return (css.match (/(^|\s)sidebar-color-\S+/g) || []).join(' ');
                        }).addClass('sidebar-color-green');
                        break;
                    case 'white':
                        $('body').removeClass(function (index, css) {
                            return (css.match (/(^|\s)sidebar-color-\S+/g) || []).join(' ');
                        }).addClass('sidebar-color-white');
                        break;
                    case 'blue':
                        $('body').removeClass(function (index, css) {
                            return (css.match (/(^|\s)sidebar-color-\S+/g) || []).join(' ');
                        }).addClass('sidebar-color-blue');
                        break;
                    case 'grey':
                        $('body').removeClass(function (index, css) {
                            return (css.match(/(^|\s)sidebar-color-\S+/g) || []).join(' ');
                        }).addClass('sidebar-color-grey');
                        break;
                }
            });

            $('#setting-sidebar-collapsed').on('switch-change', function () {
                $('body').toggleClass('layout-sidebar-collapsed');
                if ($('body').hasClass('layout-sidebar-fixed')){
                    alert('Please go on "Layout sidebar fixed & collapsed" menu');
                }
            });

            $('#setting-sidebar-fixed').on('switch-change', function () {
                if ($('body').hasClass('layout-sidebar-collapsed')){
                    alert('Please go on "Layout sidebar fixed & collapsed" menu to use this option');
                    //return false;
                } else if ($('.fluid').hasClass('container')) {
                    alert('Unfortunately, you have to edit litte to use this option');
                } else {
                    $('body').toggleClass('layout-sidebar-fixed');
                    if ($("#sidebar-main").parent().hasClass('slimScrollDiv') || $('body').hasClass('layout-sidebar-collapsed')) {
                        destroySlimscroll('sidebar-main');
                    } else {
                        handleSidebarFixed();
                    }
                }
            });

            $('#setting-sidebar-hide').on('switch-change', function () {
                $('body').toggleClass('layout-sidebar-hide');
            });


            $('#setting-header-fixed').on('switch-change', function () {
                $('body').toggleClass('layout-header-fixed');
            });

            $('#setting-header-dark').on('switch-change', function () {
                $('body').toggleClass('layout-header-dark');
            });

            $('#setting-horizontal-menu').on('switch-change', function () {
                $('body').toggleClass('layout-full-width');
                $('.logo-wrapper').removeClass('in-sidebar');
            });

            $('#setting-layout-boxed').on('switch-change', function () {
                if ($('body').hasClass('layout-sidebar-fixed')){
                    alert('Unfortunately, you have to edit litte to use this option');
                } else {
                    $('.fluid').toggleClass('container');
                }
            });

            $('#setting-logo-status').on('switch-change', function () {
                $('#topbar .logo-wrapper').toggleClass('in-sidebar');
            });

            $('#setting-toggle-status').on('switch-change', function () {
                $('#menu-toggle').toggleClass('show-collapsed');
                $('#menu-toggle').toggleClass('show-hide');
            });

            $('#setting-footer-light').on('switch-change', function () {
                $('#footer').toggleClass('light');
            });

            $('#setting-theme-chat').on('switch-change', function () {
                $('.chat-form-wrapper').toggleClass('light');
            });

            $( "select#font-select" )
              .change(function() {
                var value;
                var $font_link = $('#font-layout');
                $( "select#font-select option:selected" ).each(function() {
                  value = $( this ).val();
                });

                switch(value) {
                    case 'open-sans':
                        handleRemoveClassFont();
                        break;
                    case 'roboto':
                        handleRemoveClassFont();
                        $font_link.attr('href','http://fonts.googleapis.com/css?family=Roboto');
                        $('body').addClass('font-roboto');
                        break;
                    case 'lato':
                        handleRemoveClassFont();
                        $font_link.attr('href','http://fonts.googleapis.com/css?family=Lato');
                        $('body').addClass('font-lato');
                        break;
                    case 'source-sans-pro':
                        handleRemoveClassFont();
                        $font_link.attr('href','http://fonts.googleapis.com/css?family=Source+Sans+Pro');
                        $('body').addClass('font-source-sans-pro');
                        break;
                    case 'helvetica':
                        handleRemoveClassFont();
                        $('body').addClass('font-helvetica');
                        break;
                    case 'lora':
                        handleRemoveClassFont();
                        $font_link.attr('href','http://fonts.googleapis.com/css?family=Lora');
                        $('body').addClass('font-lora');
                        break;
                }
              });
            //set cookie when click save
            $('#save-setting').live('click',function(){
                var cookie_sidebar_color = $('.sidebar-color li.active').attr('data-style');
                var cookie_font = $('select#font-select').val();
                var cookie_array = [];
                if ($('#setting-header-fixed > div').hasClass('switch-on')){
                    cookie_array.push('layout-header-fixed');
                } 
                if ($('#setting-sidebar-collapsed > div').hasClass('switch-on')){
                    cookie_array.push('layout-sidebar-collapsed');
                } 
                if ($('#setting-sidebar-hide > div').hasClass('switch-on')){
                    cookie_array.push('layout-sidebar-hide');
                } 
                if ($('#setting-sidebar-fixed > div').hasClass('switch-on')){
                    cookie_array.push('layout-sidebar-fixed');
                } 
                if ($('#setting-toggle-status > div').hasClass('switch-on')){
                    cookie_array.push('layout-toggle-status');
                } 
                if ($('#setting-header-dark > div').hasClass('switch-on')){
                    cookie_array.push('layout-header-dark');
                } 
                if ($('#setting-logo-status > div').hasClass('switch-on')){
                    cookie_array.push('layout-logo-status');
                } 
                if ($('#setting-horizontal-menu > div').hasClass('switch-on')){
                    cookie_array.push('layout-full-width');
                } 
                if ($('#setting-footer-light > div').hasClass('switch-on')){
                    cookie_array.push('layout-footer-light');
                } 

                $.cookie('sidebar-color',cookie_sidebar_color);
                $.cookie('font-layout', cookie_font);
                $.cookie('setting',cookie_array.join(' '));
            });
            //load cookie on document ready
            if ($.cookie('setting')){
                var cookie_load_array = $.cookie('setting').split(' ');
                if ($.inArray('layout-header-fixed',cookie_load_array) !== -1) {
                    $('#setting-header-fixed').bootstrapSwitch('toggleState');
                }
                if ($.inArray('layout-sidebar-collapsed',cookie_load_array) !== -1) {
                    $('#setting-sidebar-collapsed').bootstrapSwitch('toggleState');
                }
                if ($.inArray('layout-sidebar-fixed',cookie_load_array) !== -1) {
                    $('#setting-sidebar-fixed').bootstrapSwitch('toggleState');
                }
                if ($.inArray('layout-sidebar-hide',cookie_load_array) !== -1) {
                    $('#setting-sidebar-hide').bootstrapSwitch('toggleState');
                }
                if ($.inArray('layout-header-dark',cookie_load_array) !== -1) {
                    $('#setting-header-dark').bootstrapSwitch('toggleState');
                }
                if ($.inArray('layout-toggle-status',cookie_load_array) !== -1) {
                    $('#setting-toggle-status').bootstrapSwitch('toggleState');
                }
                if ($.inArray('layout-logo-status',cookie_load_array) !== -1) {
                    $('#setting-logo-status').bootstrapSwitch('toggleState');
                }
                if ($.inArray('layout-full-width',cookie_load_array) !== -1) {
                    $('#setting-horizontal-menu').bootstrapSwitch('toggleState');
                }
                if ($.inArray('layout-footer-light',cookie_load_array) !== -1) {
                    $('#setting-footer-light').bootstrapSwitch('toggleState');
                }
            }

            if ($.cookie('sidebar-color')) {
                $('body').addClass('sidebar-color-'+$.cookie('sidebar-color'));
                $('.sidebar-color li').removeClass('active');
                $('.sidebar-color li.'+$.cookie('sidebar-color')).addClass('active');
            }

            if ($.cookie('font-layout')) {
                $('select#font-select').val($.cookie('font-layout'));
                setFont($.cookie('font-layout'));
            }

            function setFont(value) {
                var $font_layout = $('#font-layout');
                switch(value) {
                    case 'open-sans':
                        handleRemoveClassFont();
                        break;
                    case 'roboto':
                        handleRemoveClassFont();
                        $font_layout.attr('href','http://fonts.googleapis.com/css?family=Roboto');
                        $('body').addClass('font-roboto');
                        break;
                    case 'lato':
                        handleRemoveClassFont();
                        $font_layout.attr('href','http://fonts.googleapis.com/css?family=Lato');
                        $('body').addClass('font-lato');
                        break;
                    case 'source-sans-pro':
                        handleRemoveClassFont();
                        $font_layout.attr('href','http://fonts.googleapis.com/css?family=Source+Sans+Pro');
                        $('body').addClass('font-source-sans-pro');
                        break;
                    case 'helvetica':
                        handleRemoveClassFont();
                        $('body').addClass('font-helvetica');
                        break;
                    case 'lora':
                        handleRemoveClassFont();
                        $font_layout.attr('href','http://fonts.googleapis.com/css?family=Lora');
                        $('body').addClass('font-lora');
                        break;
                }
            }
        };
        //END TEMPLATE SETTING

        // BEGIN FORM CHAT
        var handleFormChat = function(){
            $('#chat-form .make-switch').bootstrapSwitch();
            //Open chat form
            $('.btn-chat').click(function () {
                if($('#chat-box').is(':visible')){
                    $('#chat-form').toggle('slide', {
                        direction: 'right'
                    }, 200);
                    $('#chat-form').slimScroll();
                    $('#chat-box').hide();
                } else {
                    $('#chat-form').toggle('slide', {
                        direction: 'right'
                    }, 200);
                    $('#chat-form > .chat-inner').slimScroll({
                        "height": $(window).height(),
                        'width': '280px',
                        "wheelStep": 30
                    });
                }
                $('.chat-box-wrapper').css({'right':'280px'});
            });

            //Close event
            $('.chat-box-close').click(function(){
                $('#chat-box').hide();
                $('.chat-box-minimize').hide();
                $('#chat-form .chat-group a').removeClass('active');
            });
            $('.chat-form-close').click(function(){
                $('#chat-form').toggle('slide', {
                    direction: 'right'
                }, 200);
                $('#chat-box').hide();
                $('.chat-box-wrapper').css({'right':'0px'});
            });

            $('.chat-box-minimize-btn').click(function(){
                $('#chat-box').hide();
                $('.chat-box-minimize').show();
            });

            $('.chat-box-minimize img').click(function(){
                $('#chat-box').show();
            });

            //Open chat box
            $('#chat-form .chat-group a').unbind('*').click(function(){
                $('#chat-box').hide();
                $('#chat-form .chat-group a').removeClass('active');
                $(this).addClass('active');
                //get user information to set for chat box
                var strUserName = $('> small', this).text();
                $('.display-name', '#chat-box').html(strUserName);
                var userStatus = $(this).find('span.user-status').attr('class');
                $('#chat-box > .chat-box-header > span.user-status').removeClass().addClass(userStatus);
                var userAvatar = $(this).find('img').attr('src');
                $('.chat-box-minimize').find('img').attr('src',userAvatar);
                var chatBoxStatus = $('span.user-status', '#chat-box');
                var chatBoxStatusShow = $('#chat-box > .chat-box-header > small');
                if(chatBoxStatus.hasClass('is-online')){
                    chatBoxStatusShow.html('Online');
                } else if(chatBoxStatus.hasClass('is-offline')){
                    chatBoxStatusShow.html('Offline');
                } else if(chatBoxStatus.hasClass('is-busy')){
                    chatBoxStatusShow.html('Busy');
                } else if(chatBoxStatus.hasClass('is-idle')){
                    chatBoxStatusShow.html('Idle');
                }

                $('#chat-box').css({'top': 'auto'});

                if(!$('#chat-box').is(':visible')){
                    $('#chat-box').toggle();
                    $('.chat-box-minimize').toggle();
                }
                // focus to input tag when click an user
                $("#chat-box .chat-textarea input").focus();
                $('.chat-content > .chat-box-body').slimScroll({
                    "height": "250px",
                    'width': '340px',
                    "wheelStep": 30,
                    "scrollTo": $(this).height()
                });
            });
            // Add content to form
            $('.chat-textarea input').on("keypress", function(e){
                var $obj = $(this);
                var $me = $obj.parent().parent().find('ul.chat-box-body');
                var $my_avt = 'http://api.randomuser.me/portraits/men/27.jpg';
                var $your_avt = 'https://s3.amazonaws.com/uifaces/faces/twitter/claudioguglieri/48.jpg';
                if (e.which == 13) {
                    var $content = $obj.val();

                    if ($content !== "") {
                        var d = new Date();
                        var h = d.getHours();
                        var m = d.getMinutes();
                        if (m < 10) m = "0" + m;
                        $obj.val(""); // CLEAR TEXT IN INPUT

                        var $element = "";
                        $element += "<li>";
                        $element += "<p>";
                        $element += "<img class='avt' src='"+$my_avt+"'>";
                        $element += "<span class='user'>You</span>";
                        $element += "<span class='time'>" + h + ":" + m + "</span>";
                        $element += "</p>";
                        $element = $element + "<p>" + $content +  "</p>";
                        $element += "</li>";

                        $me.append($element);
                        var height = 0;
                        $me.find('li').each(function(i, value){
                            height += parseInt($(this).height());
                        });

                        height += '';
                        $me.scrollTop(height);

                        // RANDOM RESPOND CHAT
                        var $res = "";
                        $res += "<li class='odd'>";
                        $res += "<p>";
                        $res += "<img class='avt' src='"+$your_avt+"'>";
                        $res += "<span class='user'>Jake Rochleau</span>";
                        $res += "<span class='time'>" + h + ":" + m + "</span>";
                        $res += "</p>";
                        $res = $res + "<p>" + "This is a demo respond anwser" + "</p>";
                        $res += "</li>";
                        setTimeout(function(){
                            $me.append($res);
                            $me.scrollTop(height+100);
                        }, 1000);
                    }
                }
            });
        };
        //END FORM CHAT

        var destroySlimscroll = function(objectId) {
            $("#"+objectId).parent().replaceWith($("#"+objectId));
            $("#"+objectId).css('height', 'auto');
            $("#"+objectId).css('width', 'auto');
        };

        //BEGIN JQUERY VIEW CODE
        var handleViewCode = function(){

            $('#setting-view-code').on('switch-change', function () {
                $(".btn-view-code").toggleClass('hide');
            });

            var $button = $("<a href='javascript:;' class='btn-view-code'><i class='fa fa-code'></i></a>").click(function(){
                var source = $(this).parent().html();
                source = cleanSource(source);
                $("#source-modal pre").text(source);
                prettyPrint();
                $("#source-modal").modal();
            });

            $(".bs-example").hover(function(){
                $(this).append($button);
                $button.show();
            }, function(){
                $button.hide();
            });

            function cleanSource(source) {
                var lines = source.split(/\n/);
                lines.shift();
                lines.splice(-1, 1);

                var indentSize = lines[0].length - lines[0].trim().length,
                    re = new RegExp(" {" + indentSize + "}");

                lines = lines.map(function(line){
                    if (line.match(re)) {
                        line = line.substring(indentSize);
                    }

                    return line;
                });

                lines = lines.join("\n");

                return lines;
            }

        };
        //END JQUERY VIEW CODE

        //BEGIN PULSATE
        var handlePulsate = function() {
            $("[data-pulsate]").each(function () {
                var me = $(this);
                var data = "(" + $(this).attr('data-pulsate') + ")";
                if (data.onClick == "one" || data.onClick == "crazy") {
                    me.click(function () {
                        me.pulsate(data);
                    });
                }
                if (data.onClick == "toggle") {
                    me.toggle(function () {
                        me.pulsate(data.repeat = false);
                    }, function () {
                        me.pulsate(data);
                    });
                }
                if (data.onClick == "stop") {

                    me.pulsate(data);
                    if (data.parent === true) {
                        me.parent().one('click', function () {
                            me.pulsate({repeat: false});
                        });
                    }
                    else {
                        me.one('click', function () {
                            me.pulsate({repeat: false});
                        });
                    }
                }
                if (data.onClick === undefined)
                    me.pulsate(data);
            });
        };
        //END PULSATE

        //BEGIN NOTE APP
        var handleNoteApp = function() {
            //open note app
            $("#note-app-toggle").live('click',function (e) {
                e.preventDefault();
                if($(this).hasClass('open')){
                    $(this).removeClass('open');
                    $("#note-app-wrapper").fadeOut(function () {
                        $(this).css({right: 0, top: window.innerHeight - 300, left: "auto"});
                        $(" .note-app-content", this).css({height: 200});
                    });
                }
                else{
                    $(this).addClass('open');
                    $("#note-app-wrapper").css({right: 0, top: window.innerHeight - 300, left: "auto"}).fadeIn();
                }

            });
            //drag drop
            $( "#note-app-wrapper").draggable();

            //save function

            function saveTextAsFile(textWrite,fileName){
                var textFileAsBlob = new Blob([textWrite], {type:'text/plain'});

                var downloadLink = document.createElement("a");
                downloadLink.download = fileName+".txt";
                downloadLink.innerHTML = "Download File";

                if (window.webkitURL !== null)
                {
                    // Chrome allows the link to be clicked
                    // without actually adding it to the DOM.
                    downloadLink.href = window.webkitURL.createObjectURL(textFileAsBlob);
                }
                else
                {
                    // Firefox requires the link to be added to the DOM
                    // before it can be clicked.
                    downloadLink.href = window.URL.createObjectURL(textFileAsBlob);
                    downloadLink.onclick = destroyClickedElement;
                    downloadLink.style.display = "none";
                    document.body.appendChild(downloadLink);
                }
                downloadLink.click();
            }

            function destroyClickedElement(event){
                document.body.removeChild(event.target);
            }

            $('.note-app-tools > i').live('click',function(){
                var me = $(this);
                //close
                if(me.hasClass("icon-close")){
                    $("#note-app-toggle").removeClass('open');
                    $( "#note-app-wrapper").fadeOut();
                }
                //save
                if(me.hasClass("fa-save")){
                    var fileName = prompt("Enter file name: ","note");
                    if(fileName !== null) {
                        var textToWrite =$(".note-app-title").val() + "</title>" + $(".note-app-content").val();
                        saveTextAsFile(textToWrite, fileName);
                    }
                }
                //import
                if(me.hasClass("fa-sign-in")){
                    $('#note-app-file').val('');
                    $('#note-app-file').click();
                    var fileInput = document.getElementById('note-app-file');
                    var fileDisplayArea = $('.note-app-content'),
                        fileDisplayTitle = $('.note-app-title');

                    fileInput.addEventListener('change', function(e) {
                        var file = fileInput.files[0];
                        var textType = /text.*/;

                        fileDisplayArea.val("");
                        fileDisplayTitle.val("");

                        if (file.type.match(textType)) {
                            var reader = new FileReader();
                            reader.onload = function(e) {
                                var title = reader.result.toString().split('</title>')[0];
                                if(title ==reader.result ) {
                                    fileDisplayArea.val(reader.result);
                                }
                                else{
                                    fileDisplayTitle.val(title);
                                    fileDisplayArea.val(reader.result.replace(title+'</title>',""));
                                }

                            };
                            reader.readAsText(file);
                        } else {
                            fileDisplayArea.innerText = "File not supported!";
                        }
                    });
                }
                //new note
                if(me.hasClass("icon-note")){
                    $(".note-app-title").val("");
                    $(".note-app-content").val("");
                    $('#note-app-file').val('');
                }
            });

        };
        //END NOTE APP

        // use for change font function
        var handleRemoveClassFont = function(){
            $("body").removeClass (function (index, css) {
                return (css.match (/(^|\s)font-\S+/g) || []).join(' ');
            });
        };

        // use for toggle sidebar fixed
        var handleSidebarFixed = function(){
            if ($('body.layout-sidebar-fixed').hasClass('layout-sidebar-collapsed')) {
                destroySlimscroll('sidebar-main');
            } else {
                $('#sidebar-main').slimScroll({
                    'width': '100%',
                    'height': $(window).height()-80,
                    "wheelStep": 25
                });
            }
        };

        return{
            init: function () {
                handleMenuToggle();
                handleSlimscrollTopbar();
                handleSlimscrollTodo();
                handleTemplateSetting();
                handleNoteApp();
                handleViewCode();
                handleFormChat();
            }
        };
    }(jQuery);

    setTimeout(function(){
        Layout.init();
    },500);
                
});

App.controller('MainController', function ($scope, $routeParams){
    var index = function() {

        var handleFlotCharts = function(){
            var data = [],
                totalPoints = 100;

            function getRandomData() {

                if (data.length > 0)
                    data = data.slice(1);

                // Do a random walk

                while (data.length < totalPoints) {

                    data.push(generateNumber(2, 100));
                }

                // Zip the generated y values with the x values

                var res = [];
                for (var i = 0; i < data.length; ++i) {
                    res.push([i, data[i]]);
                }

                return res;
            }

            // Set up the control widget

            var updateInterval = 1000;

            var plot =
                $.plot("#placeholder", [{
                    data: getRandomData()
                }], {
                    series: {
                        shadowSize: 0,
                        bars: {
                            fill: 0.01,
                            show: true,
                            barWidth: 0.3
                        }
                    },
                    colors: [ "#ff5722"],
                    tooltip: false,
                    xaxis: {
                        show:false,
                        tickColor: "#f0f1f2"
                    },
                    yaxis: {
                        min: 0,
                        max: 100,
                        tickSize: 25,
                        tickFormatter: function(t) {
                            return t % 25 === 0 ? t : 100;
                        },
                        tickColor: "#e4e4e4"
                    },
                    grid: {
                        hoverable: !0,
                        clickable: !0,
                        borderWidth: 0,
                        tickColor: "#f0f1f2"
                    },
                    shadowSize: 0
                });


            function update() {
                plot.setData([getRandomData()]);
                plot.draw();
                setTimeout(update, updateInterval);
            }

            update();
        };

        function generateNumber(min, max) {
            min = typeof min !== 'undefined' ? min : 1;
            max = typeof max !== 'undefined' ? max : 100;

            return Math.floor((Math.random() * max) + min);
        }
        var handleAAPL = function(){


                setInterval(function() {
                    $('.info-aapl span').each(function(index, elem) {
                        $(elem).animate({
                            height: generateNumber(1, 40)
                        });
                    });

                }, 3000);



        };
        var handleChartSmall= function(){
            var comma_separator_number_step = $.animateNumber.numberStepFactories.separator(',');
            $('#earning-number').animateNumber({
                number: 50645,
                numberStep: comma_separator_number_step
            }, 5000);
            $('#new-customer-number').animateNumber({
                number: 3420,
                numberStep: comma_separator_number_step
            }, 5000);

            //BEGIN CHART EARNING
            var d2 = [["Jan", 200],["Feb", 80],["Mar", 199],["Apr", 147],["May", 293],["Jun", 192]];
            $.plot("#earning-chart", [{
                data: d2,
                color: "#ffce54"
            }], {
                series: {
                    lines: {
                        show: !0,
                        fill: 0.01
                    },
                    points: {
                        show: !0,
                        radius: 4
                    }
                },
                grid: {
                    borderColor: "#f0f1f2",
                    borderWidth: 1,
                    hoverable: !0
                },
                tooltip: !0,
                tooltipOpts: {
                    content: "%x : %y",
                    defaultTheme: false
                },
                xaxis: {
                    tickColor: "#f0f1f2",
                    mode: "categories"
                },
                yaxis: {
                    tickColor: "#f0f1f2"
                },
                shadowSize: 0
            });
            //END CHART EARNING



            //BEGIN CHART NEW CUSTOMER
            var d7 = [["Jan", 93],["Feb", 78],["Mar", 47],["Apr", 35],["May", 48],["Jun", 26]];
            $.plot("#new-customer-chart", [{
                data: d7,
                color: "#2196f3"
            }], {
                series: {
                    bars: {
                        align: "center",
                        lineWidth: 0,
                        show: !0,
                        barWidth: 0.6,
                        fill: 0.9
                    }
                },
                grid: {
                    borderColor: "#f0f1f2",
                    borderWidth: 1,
                    hoverable: !0
                },
                tooltip: !0,
                tooltipOpts: {
                    content: "%x : %y",
                    defaultTheme: false
                },
                xaxis: {
                    tickColor: "#f0f1f2",
                    mode: "categories"
                },
                yaxis: {
                    tickColor: "#f0f1f2"
                },
                shadowSize: 0
            });
            //END CHART NEW CUSTOMER


        };
        var handleMarkers = function(){
            var cityAreaData = [
                700.70,
                210.69,
                920.17,
                150.35,
                630.22
                ],
                key = [
                    'Monaco' ,
                     'Saint Kitts and Nevis' ,
                     'Grenada' ,
                     'Bahrain' ,
                     'São Tomé and Príncipe'
                ];

            var cityAreaDataKey =[];
            for( var i = 0, lengt = cityAreaData.length; i<lengt;i++){
                cityAreaDataKey[i] = {
                    label: key[i],
                    data: cityAreaData[i]
                };
            }

            $.plot("#map-visitor-chart", cityAreaDataKey, {
                series: {
                    pie: {
                        innerRadius: 0.5,
                        show: true
                    }
                }
            });

            $('#map-visitor-markers').vectorMap({
                map: 'world_mill_en',
                normalizeFunction: 'polynomial',
                zoomOnScroll:true,
                focusOn:{
                    x: 0,
                    y: 0,
                    scale: 0.9
                },
                zoomMin:0.9,
                hoverColor: false,
                regionStyle:{
                    initial: {
                        fill: '#2196f3',
                        "fill-opacity": 1,
                        stroke: '#a5ded9',
                        "stroke-width": 0,
                        "stroke-opacity": 0
                    },
                    hover: {
                        "fill-opacity": 0.5
                    }
                },
                markerStyle: {
                    initial: {
                        fill: '#ff5722',
                        stroke: 'rgba(230,140,110,.8)',
                        "fill-opacity": 1,
                        "stroke-width": 9,
                        "stroke-opacity": 0.5,
                        r: 3
                    },
                    hover: {
                        stroke: '#D83400',
                        "stroke-width": 2
                    },
                    selected: {
                        fill: 'blue'
                    },
                    selectedHover: {
                    }
                },
                backgroundColor: '#ffffff',
                markers :[

                    {latLng: [43.73, 7.41], name: 'Monaco'},
                    {latLng: [17.3, -62.73], name: 'Saint Kitts and Nevis'},
                    {latLng: [12.05, -61.75], name: 'Grenada'},
                    {latLng: [26.02, 50.55], name: 'Bahrain'},
                    {latLng: [0.33, 6.73], name: 'São Tomé and Príncipe'}

                ],
                series: {
                    markers: [{
                        attribute: 'r',
                        scale: [3, 7],
                        values: cityAreaData
                    }]
                }
            });
        };
        var handleSparkline = function() {
            $(".sparkline1").sparkline([5,6,7,2,0,4,2,4,5,6,7,2,3,4,2,4,2,1,3,6,3,5,2,7,4,2,1,3,6,3,5,2,7,4,6], {
                type: 'bar',
                height: '80px',
                barWidth: 8,
                zeroAxis: false,
                barColor: '#07bf29'
            });
            // Bar charts using inline values
            $('.sparkbar.green').sparkline('html', {type: 'bar', barColor: '#55F072', height: '20'});
            $('.sparkbar.default').sparkline('html', {type: 'bar', barColor: '#ccc', height: '20'});
        };

        var handleNumber = function() {
            $('#number-blogs').animateNumber({ number: 1240 }, 4000);
            $('#number-following').animateNumber({ number: 60 }, 3500);
            $('#number-follower').animateNumber({ number: 117 }, 3500);
            $('#number-humidity').animateNumber({ number: 88 }, 3500);
        };

        var handleSkycons = function() {
            //BEGIN SKYCON
            var icons = new Skycons({"color": "white"});

            icons.set("icon1", Skycons.SNOW);
            icons.set("icon2", Skycons.RAIN);
            icons.set("icon3", Skycons.PARTLY_CLOUDY_DAY);
            icons.set("icon4", Skycons.PARTLY_CLOUDY_NIGHT);
            icons.set("icon5", Skycons.WIND);
            icons.set("icon6", Skycons.RAIN);
            icons.set("icon7", Skycons.SLEET);
            icons.set("wind", Skycons.WIND);
            icons.set("fog", Skycons.FOG);

            icons.play();
            //END SKYCON
        };
        return{
            init: function () {
                handleMarkers();
                handleFlotCharts();
                handleAAPL();
                handleChartSmall();
                handleSparkline();
                handleSkycons();
                handleNumber();
            }
        };

    }(jQuery);

    setTimeout(function(){
        index.init();
    },500);
});    
App.controller('ChartsChartjsController', function ($scope, $routeParams){
    var charts_chartjs = function() {

	    var handleLineChart = function(){
	        var lineChartData = {
	            labels : ["January","February","March","April","May","June","July"],
	            datasets : [
	                {
	                    fillColor : "rgba(220,220,220,0.5)",
	                    strokeColor : "rgba(220,220,220,1)",
	                    pointColor : "rgba(220,220,220,1)",
	                    pointStrokeColor : "#fff",
	                    data : [65,59,90,81,56,55,40]
	                },
	                {
	                    fillColor : "rgba(151,187,205,0.5)",
	                    strokeColor : "rgba(151,187,205,1)",
	                    pointColor : "rgba(151,187,205,1)",
	                    pointStrokeColor : "#fff",
	                    data : [28,48,40,19,96,27,100]
	                }
	            ],
	            responsive: true
	        };

	        var myLine = new Chart(document.getElementById("line-chart").getContext("2d")).Line(lineChartData);
	    };

	    var handleBarChart = function(){
	        var barChartData = {
	            labels : ["January","February","March","April","May","June","July"],
	            datasets : [
	                {
	                    fillColor : "rgba(220,220,220,0.5)",
	                    strokeColor : "rgba(220,220,220,1)",
	                    data : [65,59,90,81,56,55,40]
	                },
	                {
	                    fillColor : "rgba(151,187,205,0.5)",
	                    strokeColor : "rgba(151,187,205,1)",
	                    data : [28,48,40,19,96,27,100]
	                }
	            ]

	        };

	        var myLine = new Chart(document.getElementById("bar-chart").getContext("2d")).Bar(barChartData);
	    };

	    var handleRadarChart = function(){
	        var radarChartData = {
	            labels : ["Eating","Drinking","Sleeping","Designing","Coding","Partying","Running"],
	            datasets : [
	                {
	                    fillColor : "#ff5722",
	                    strokeColor : "#ea2e49",
	                    pointColor : "#ff5722",
	                    pointStrokeColor : "#fff",
	                    data : [65,59,90,81,56,55,40]
	                },
	                {
	                    fillColor : "rgba(151,187,205,0.5)",
	                    strokeColor : "rgba(151,187,205,1)",
	                    pointColor : "rgba(151,187,205,1)",
	                    pointStrokeColor : "#fff",
	                    data : [28,48,40,19,96,27,100]
	                }
	            ]

	        };

	        var myRadar = new Chart(document.getElementById("radar-chart").getContext("2d")).Radar(radarChartData,{scaleShowLabels : false, pointLabelFontSize : 10});
	    };

	    var handleAreaChart = function(){
	        var chartData = [
	            {
	                value : Math.random(),
	                color: "#07bf29"
	            },
	            {
	                value : Math.random(),
	                color: "#ff5722"
	            },
	            {
	                value : Math.random(),
	                color: "#2196f3"
	            },
	            {
	                value : Math.random(),
	                color: "#ffc107"
	            },
	            {
	                value : Math.random(),
	                color: "#ea2e49"
	            },
	            {
	                value : Math.random(),
	                color: "#584A5E"
	            }
	        ];
	        var myPolarArea = new Chart(document.getElementById("polar-area-chart").getContext("2d")).PolarArea(chartData);
	    };

	    var handlePieChart = function(){
	        var pieData = [
	            {
	                value: 30,
	                color:"#ffc107"
	            },
	            {
	                value : 50,
	                color : "#ccc"
	            },
	            {
	                value : 100,
	                color : "#2196f3"
	            }

	        ];

	        var myPie = new Chart(document.getElementById("pie-chart").getContext("2d")).Pie(pieData);
	    };

	    var handleDoughnutChart = function(){
	        var doughnutData = [
	            {
	                value: 30,
	                color:"#ea2e49"
	            },
	            {
	                value : 50,
	                color : "#2196f3"
	            },
	            {
	                value : 100,
	                color : "#ccc"
	            },
	            {
	                value : 40,
	                color : "#949FB1"
	            },
	            {
	                value : 120,
	                color : "#07bf29"
	            }

	        ];

	        var myDoughnut = new Chart(document.getElementById("doughnut-chart").getContext("2d")).Doughnut(doughnutData);
	    };

	    return{
	        init: function () {
	            handleLineChart();
	            handleBarChart();
	            handleRadarChart();
	            handleAreaChart();
	            handlePieChart();
	            handleDoughnutChart();
	        }
	    };
	}(jQuery);
	charts_chartjs.init();

});
App.controller('ChartsFlotController', function ($scope, $routeParams){
    var charts_flot = function() {

	    var handleLineChart = function(){
	        var d1_1 = [["Jan", 200],["Feb", 201],["Mar", 199],["Apr", 187],["May", 193],["Jun", 192],["Jul", 206]];
	        var d1_2 = [["Jan", 122],["Feb", 170],["Mar", 163],["Apr", 161],["May", 122],["Jun", 136],["Jul", 130]];
	        var d1_3 = [["Jan", 81],["Feb", 92],["Mar", 98],["Apr", 102],["May", 80],["Jun", 97],["Jul", 86]];
	        $.plot("#line-chart", [{
	            data: d1_1,
	            label: "Chrome",
	            color: "#ffc107"
	        },{
	            data: d1_2,
	            label: "Firefox",
	            color: "#ff5722"
	        },{
	            data: d1_3,
	            label: "Safari",
	            color: "#2196f3"
	        }], {
	            series: {
	                lines: {
	                    show: !0,
	                    fill: 0.01
	                },
	                points: {
	                    show: !0,
	                    radius: 4
	                }
	            },
	            grid: {
	                borderColor: "#fafafa",
	                borderWidth: 1,
	                hoverable: !0
	            },
	            tooltip: !0,
	            tooltipOpts: {
	                content: "%x : %y",
	                defaultTheme: false
	            },
	            xaxis: {
	                tickColor: "#fafafa",
	                mode: "categories"
	            },
	            yaxis: {
	                tickColor: "#fafafa"
	            },
	            shadowSize: 0
	        });
	    };

	    var handleSplineLineChart = function(){
	        var d2_1 = [["Jan", 181],["Feb", 184],["Mar", 189],["Apr", 180],["May", 208],["Jun", 183],["Jul", 185]];
	        var d2_2 = [["Jan", 170],["Feb", 152],["Mar", 133],["Apr", 146],["May", 164],["Jun", 151],["Jul", 120]];
	        var d2_3 = [["Jan", 102],["Feb", 91],["Mar", 106],["Apr", 89],["May", 90],["Jun", 94],["Jul", 86]];
	        $.plot("#line-chart-spline", [{
	            data: d2_1,
	            label: "Chrome",
	            color: "#ffc107"
	        },{
	            data: d2_2,
	            label: "Firefox",
	            color: "#ff5722"
	        },{
	            data: d2_3,
	            label: "Safari",
	            color: "#2196f3"
	        }], {
	            series: {
	                lines: {
	                    show: !1
	                },
	                splines: {
	                    show: !0,
	                    tension: 0.4,
	                    lineWidth: 2,
	                    fill: 0
	                },
	                points: {
	                    show: !0,
	                    radius: 4
	                }
	            },
	            grid: {
	                borderColor: "#fafafa",
	                borderWidth: 1,
	                hoverable: !0
	            },
	            tooltip: !0,
	            tooltipOpts: {
	                content: "%x : %y",
	                defaultTheme: false
	            },
	            xaxis: {
	                tickColor: "#fafafa",
	                mode: "categories"
	            },
	            yaxis: {
	                tickColor: "#fafafa"
	            },
	            shadowSize: 0
	        });
	    };

	    var handleBarChart = function(){
	        var d3 = [["Jan", 93],["Feb", 78],["Mar", 47],["Apr", 35],["May", 48],["Jun", 26],["Jul", 49],["Aug", 96],["Sep", 54],["Oct", 99],["Nov", 92],["Dec", 43]];
	        $.plot("#bar-chart", [{
	            data: d3,
	            label: "Revenue",
	            color: "#2196f3"
	        }], {
	            series: {
	                bars: {
	                    align: "center",
	                    lineWidth: 0,
	                    show: !0,
	                    barWidth: 0.6,
	                    fill: 0.9
	                }
	            },
	            grid: {
	                borderColor: "#fafafa",
	                borderWidth: 1,
	                hoverable: !0
	            },
	            tooltip: !0,
	            tooltipOpts: {
	                content: "%x : %y",
	                defaultTheme: false
	            },
	            xaxis: {
	                tickColor: "#fafafa",
	                mode: "categories"
	            },
	            yaxis: {
	                tickColor: "#fafafa"
	            },
	            shadowSize: 0
	        });
	    };

	    var handleStackBarChart = function(){
	        var d4_1 = [["Jan", 126],["Feb", 73],["Mar", 94],["Apr", 54],["May", 92],["Jun", 141],["Jul", 29],["Aug", 44],["Sep", 30],["Oct", 40],["Nov", 67],["Dec", 92]];
	        var d4_2 = [["Jan", 58],["Feb", 61],["Mar", 46],["Apr", 35],["May", 55],["Jun", 46],["Jul", 57],["Aug", 80],["Sep", 100],["Oct", 91],["Nov", 35],["Dec", 57]];
	        $.plot("#bar-chart-stack", [{
	            data: d4_1,
	            label: "New Visitor",
	            color: "#07bf29"
	        },{
	            data: d4_2,
	            label: "Returning Visitor",
	            color: "#ffc107"
	        }], {
	            series: {
	                stack: !0,
	                bars: {
	                    align: "center",
	                    lineWidth: 0,
	                    show: !0,
	                    barWidth: 0.6,
	                    fill: 0.9
	                }
	            },
	            grid: {
	                borderColor: "#fafafa",
	                borderWidth: 1,
	                hoverable: !0
	            },
	            tooltip: !0,
	            tooltipOpts: {
	                content: "%x : %y",
	                defaultTheme: false
	            },
	            xaxis: {
	                tickColor: "#fafafa",
	                mode: "categories"
	            },
	            yaxis: {
	                tickColor: "#fafafa"
	            },
	            shadowSize: 0
	        });
	    };

	    var handleAreaChart = function(){
	        var d5_1 = [["Jan", 35],["Feb", 60],["Mar", 85],["Apr", 46],["May", 99],["Jun", 82],["Jul", 96]];
	        var d5_2 = [["Jan", 47],["Feb", 74],["Mar", 36],["Apr", 83],["May", 39],["Jun", 10],["Jul", 51]];
	        $.plot("#area-chart", [{
	            data: d5_1,
	            label: "New Visitor",
	            color: "#ea2e49"
	        },{
	            data: d5_2,
	            label: "Returning Visitor",
	            color: "#07bf29"
	        }], {
	            series: {
	                lines: {
	                    show: !0,
	                    fill: 0.8
	                },
	                points: {
	                    show: !0,
	                    radius: 4
	                }
	            },
	            grid: {
	                borderColor: "#fafafa",
	                borderWidth: 1,
	                hoverable: !0
	            },
	            tooltip: !0,
	            tooltipOpts: {
	                content: "%x : %y",
	                defaultTheme: false
	            },
	            xaxis: {
	                tickColor: "#fafafa",
	                mode: "categories"
	            },
	            yaxis: {
	                tickColor: "#fafafa"
	            },
	            shadowSize: 0
	        });
	    };

	    var handleSplineAreaChart = function(){
	        var d6_1 = [["Jan", 67],["Feb", 91],["Mar", 36],["Apr", 150],["May", 28],["Jun", 123],["Jul", 38]];
	        var d6_2 = [["Jan", 59],["Feb", 49],["Mar", 45],["Apr", 94],["May", 76],["Jun", 22],["Jul", 31]];
	        $.plot("#area-chart-spline", [{
	            data: d6_1,
	            label: "New Visitor",
	            color: "#ff5722"
	        },{
	            data: d6_2,
	            label: "Returning Visitor",
	            color: "#ccc"
	        }], {
	            series: {
	                lines: {
	                    show: !1
	                },
	                splines: {
	                    show: !0,
	                    tension: 0.4,
	                    lineWidth: 2,
	                    fill: 0.8
	                },
	                points: {
	                    show: !0,
	                    radius: 4
	                }
	            },
	            grid: {
	                borderColor: "#fafafa",
	                borderWidth: 1,
	                hoverable: !0
	            },
	            tooltip: !0,
	            tooltipOpts: {
	                content: "%x : %y",
	                defaultTheme: false
	            },
	            xaxis: {
	                tickColor: "#fafafa",
	                mode: "categories"
	            },
	            yaxis: {
	                tickColor: "#fafafa"
	            },
	            shadowSize: 0
	        });
	    };

	    var handlePieChart = function(){
	        var d7_1 = [40];
	        var d7_2 = [20];
	        var d7_3 = [40];
	        $.plot('#pie-chart', [{
	            data: d7_1,
	            label: "Search Engines",
	            color: "#3DB9D3"
	        },
	            {
	                data: d7_2,
	                label: "Referrals",
	                color: "#ffce54"
	            },
	            {
	                data: d7_3,
	                label: "Direct",
	                color: "#fc6e51"
	            }], {
	            series: {
	                pie: {
	                    show: true,
	                    radius: 1,
	                    label: {
	                        show: true,
	                        radius: 3/4,
	                        background: {
	                            opacity: 0.5,
	                            color: '#000'
	                        }
	                    }
	                }
	            }
	        });
	    };

	    var handlePercentilesChart = function(){
	        var males = {"15%": [[2, 88.0], [3, 93.3], [4, 102.0], [5, 108.5], [6, 115.7], [7, 115.6], [8, 124.6], [9, 130.3], [10, 134.3], [11, 141.4], [12, 146.5], [13, 151.7], [14, 159.9], [15, 165.4], [16, 167.8], [17, 168.7], [18, 169.5], [19, 168.0]], "90%": [[2, 96.8], [3, 105.2], [4, 113.9], [5, 120.8], [6, 127.0], [7, 133.1], [8, 139.1], [9, 143.9], [10, 151.3], [11, 161.1], [12, 164.8], [13, 173.5], [14, 179.0], [15, 182.0], [16, 186.9], [17, 185.2], [18, 186.3], [19, 186.6]], "25%": [[2, 89.2], [3, 94.9], [4, 104.4], [5, 111.4], [6, 117.5], [7, 120.2], [8, 127.1], [9, 132.9], [10, 136.8], [11, 144.4], [12, 149.5], [13, 154.1], [14, 163.1], [15, 169.2], [16, 170.4], [17, 171.2], [18, 172.4], [19, 170.8]], "10%": [[2, 86.9], [3, 92.6], [4, 99.9], [5, 107.0], [6, 114.0], [7, 113.5], [8, 123.6], [9, 129.2], [10, 133.0], [11, 140.6], [12, 145.2], [13, 149.7], [14, 158.4], [15, 163.5], [16, 166.9], [17, 167.5], [18, 167.1], [19, 165.3]], "mean": [[2, 91.9], [3, 98.5], [4, 107.1], [5, 114.4], [6, 120.6], [7, 124.7], [8, 131.1], [9, 136.8], [10, 142.3], [11, 150.0], [12, 154.7], [13, 161.9], [14, 168.7], [15, 173.6], [16, 175.9], [17, 176.6], [18, 176.8], [19, 176.7]], "75%": [[2, 94.5], [3, 102.1], [4, 110.8], [5, 117.9], [6, 124.0], [7, 129.3], [8, 134.6], [9, 141.4], [10, 147.0], [11, 156.1], [12, 160.3], [13, 168.3], [14, 174.7], [15, 178.0], [16, 180.2], [17, 181.7], [18, 181.3], [19, 182.5]], "85%": [[2, 96.2], [3, 103.8], [4, 111.8], [5, 119.6], [6, 125.6], [7, 131.5], [8, 138.0], [9, 143.3], [10, 149.3], [11, 159.8], [12, 162.5], [13, 171.3], [14, 177.5], [15, 180.2], [16, 183.8], [17, 183.4], [18, 183.5], [19, 185.5]], "50%": [[2, 91.9], [3, 98.2], [4, 106.8], [5, 114.6], [6, 120.8], [7, 125.2], [8, 130.3], [9, 137.1], [10, 141.5], [11, 149.4], [12, 153.9], [13, 162.2], [14, 169.0], [15, 174.8], [16, 176.0], [17, 176.8], [18, 176.4], [19, 177.4]]};

	        var females = {"15%": [[2, 84.8], [3, 93.7], [4, 100.6], [5, 105.8], [6, 113.3], [7, 119.3], [8, 124.3], [9, 131.4], [10, 136.9], [11, 143.8], [12, 149.4], [13, 151.2], [14, 152.3], [15, 155.9], [16, 154.7], [17, 157.0], [18, 156.1], [19, 155.4]], "90%": [[2, 95.6], [3, 104.1], [4, 111.9], [5, 119.6], [6, 127.6], [7, 133.1], [8, 138.7], [9, 147.1], [10, 152.8], [11, 161.3], [12, 166.6], [13, 167.9], [14, 169.3], [15, 170.1], [16, 172.4], [17, 169.2], [18, 171.1], [19, 172.4]], "25%": [[2, 87.2], [3, 95.9], [4, 101.9], [5, 107.4], [6, 114.8], [7, 121.4], [8, 126.8], [9, 133.4], [10, 138.6], [11, 146.2], [12, 152.0], [13, 153.8], [14, 155.7], [15, 158.4], [16, 157.0], [17, 158.5], [18, 158.4], [19, 158.1]], "10%": [[2, 84.0], [3, 91.9], [4, 99.2], [5, 105.2], [6, 112.7], [7, 118.0], [8, 123.3], [9, 130.2], [10, 135.0], [11, 141.1], [12, 148.3], [13, 150.0], [14, 150.7], [15, 154.3], [16, 153.6], [17, 155.6], [18, 154.7], [19, 153.1]], "mean": [[2, 90.2], [3, 98.3], [4, 105.2], [5, 112.2], [6, 119.0], [7, 125.8], [8, 131.3], [9, 138.6], [10, 144.2], [11, 151.3], [12, 156.7], [13, 158.6], [14, 160.5], [15, 162.1], [16, 162.9], [17, 162.2], [18, 163.0], [19, 163.1]], "75%": [[2, 93.2], [3, 101.5], [4, 107.9], [5, 116.6], [6, 122.8], [7, 129.3], [8, 135.2], [9, 143.7], [10, 148.7], [11, 156.9], [12, 160.8], [13, 163.0], [14, 165.0], [15, 165.8], [16, 168.7], [17, 166.2], [18, 167.6], [19, 168.0]], "85%": [[2, 94.5], [3, 102.8], [4, 110.4], [5, 119.0], [6, 125.7], [7, 131.5], [8, 137.9], [9, 146.0], [10, 151.3], [11, 159.9], [12, 164.0], [13, 166.5], [14, 167.5], [15, 168.5], [16, 171.5], [17, 168.0], [18, 169.8], [19, 170.3]], "50%": [[2, 90.2], [3, 98.1], [4, 105.2], [5, 111.7], [6, 118.2], [7, 125.6], [8, 130.5], [9, 138.3], [10, 143.7], [11, 151.4], [12, 156.7], [13, 157.7], [14, 161.0], [15, 162.0], [16, 162.8], [17, 162.2], [18, 162.8], [19, 163.3]]};

	        var data = [
	            { label: "Female mean", data: females.mean, lines: { show: true }, color: "#87318c" },
	            { id: "f15%", data: females["15%"], lines: { show: true, lineWidth: 0, fill: false }, color: "#87318c" },
	            { id: "f25%", data: females["25%"], lines: { show: true, lineWidth: 0, fill: 0.2 }, color: "#87318c", fillBetween: "f15%" },
	            { id: "f50%", data: females["50%"], lines: { show: true, lineWidth: 0.5, fill: 0.4, shadowSize: 0 }, color: "#87318c", fillBetween: "f25%" },
	            { id: "f75%", data: females["75%"], lines: { show: true, lineWidth: 0, fill: 0.4 }, color: "#87318c", fillBetween: "f50%" },
	            { id: "f85%", data: females["85%"], lines: { show: true, lineWidth: 0, fill: 0.2 }, color: "#87318c", fillBetween: "f75%" },

	            { label: "Male mean", data: males.mean, lines: { show: true }, color: "#01b6ad" },
	            { id: "m15%", data: males["15%"], lines: { show: true, lineWidth: 0, fill: false }, color: "#01b6ad" },
	            { id: "m25%", data: males["25%"], lines: { show: true, lineWidth: 0, fill: 0.2 }, color: "#01b6ad", fillBetween: "m15%" },
	            { id: "m50%", data: males["50%"], lines: { show: true, lineWidth: 0.5, fill: 0.4, shadowSize: 0 }, color: "#01b6ad", fillBetween: "m25%" },
	            { id: "m75%", data: males["75%"], lines: { show: true, lineWidth: 0, fill: 0.4 }, color: "#01b6ad", fillBetween: "m50%" },
	            { id: "m85%", data: males["85%"], lines: { show: true, lineWidth: 0, fill: 0.2 }, color: "#01b6ad", fillBetween: "m75%" }
	        ];

	        $.plot($("#percentiles-chart"), data, {
	            grid: {
	                borderColor: "#fafafa",
	                borderWidth: 1,
	                hoverable: !0
	            },
	            xaxis: {
	                tickDecimals: 0
	            },
	            yaxis: {
	                tickFormatter: function (v) {
	                    return v + " cm";
	                }
	            },
	            legend: {
	                position: "se"
	            }
	        });
	    };


	    return{
	        init: function () {
	            handleLineChart();
	            handleSplineLineChart();
	            handleBarChart();
	            handleStackBarChart();
	            handleAreaChart();
	            handleSplineAreaChart();
	            handlePieChart();
	            handlePercentilesChart();
	        }
	    };
	}(jQuery);
    
	setTimeout(function(){
        charts_flot.init();
    },500);
});
App.controller('ChartsSparklinesController', function ($scope, $routeParams){
    var charts_sparklines = function(){
	    /** handle all the example sparklines on the index page **/
	    function handleDocSparklines() {

	        // Bar + line composite charts
	        $('#compositebar').sparkline('html', { type: 'bar', barColor: '#aaf' });
	        $('#compositebar').sparkline([4,1,5,7,9,9,8,7,6,6,4,7,8,4,3,2,2,5,6,7],
	            { composite: true, fillColor: false, lineColor: 'red' });


	        // Line charts taking their values from the tag
	        $('.sparkline').sparkline();

	        // Larger line charts for the docs
	        $('.largeline').sparkline('html',
	            { type: 'line', height: '2.5em', width: '4em' });

	        // Customized line chart
	        $('#linecustom').sparkline('html',
	            {height: '1.5em', width: '8em', lineColor: '#f00', fillColor: '#ffa',
	                minSpotColor: false, maxSpotColor: false, spotColor: '#77f', spotRadius: 3});

	        // Bar charts using inline values
	        $('.sparkbar').sparkline('html', {type: 'bar'});

	        $('.barformat').sparkline([1, 3, 5, 3, 8], {
	            type: 'bar',
	            tooltipFormat: '{{value:levels}} - {{value}}',
	            tooltipValueLookups: {
	                levels: $.range_map({ ':2': 'Low', '3:6': 'Medium', '7:': 'High' })
	            }
	        });

	        // Tri-state charts using inline values
	        $('.sparktristate').sparkline('html', {type: 'tristate'});
	        $('.sparktristatecols').sparkline('html',
	            {type: 'tristate', colorMap: {'-2': '#fa7', '2': '#44f'} });

	        // Composite line charts, the second using values supplied via javascript
	        $('#compositeline').sparkline('html', { fillColor: false, changeRangeMin: 0, chartRangeMax: 10 });
	        $('#compositeline').sparkline([4,1,5,7,9,9,8,7,6,6,4,7,8,4,3,2,2,5,6,7],
	            { composite: true, fillColor: false, lineColor: 'red', changeRangeMin: 0, chartRangeMax: 10 });

	        // Line charts with normal range marker
	        $('#normalline').sparkline('html',
	            { fillColor: false, normalRangeMin: -1, normalRangeMax: 8 });
	        $('#normalExample').sparkline('html',
	            { fillColor: false, normalRangeMin: 80, normalRangeMax: 95, normalRangeColor: '#4f4' });

	        // Discrete charts
	        $('.discrete1').sparkline('html',
	            { type: 'discrete', lineColor: 'blue', xwidth: 18 });
	        $('#discrete2').sparkline('html',
	            { type: 'discrete', lineColor: 'blue', thresholdColor: 'red', thresholdValue: 4 });

	        // Bullet charts
	        $('.sparkbullet').sparkline('html', { type: 'bullet' });

	        // Pie charts
	        $('.sparkpie').sparkline('html', { type: 'pie', height: '1.0em' });

	        // Box plots
	        $('.sparkboxplot').sparkline('html', { type: 'box'});
	        $('.sparkboxplotraw').sparkline([ 1, 3, 5, 8, 10, 15, 18 ],
	            {type:'box', raw: true, showOutliers:true, target: 6});

	        // Box plot with specific field order
	        $('.boxfieldorder').sparkline('html', {
	            type: 'box',
	            tooltipFormatFieldlist: ['med', 'lq', 'uq'],
	            tooltipFormatFieldlistKey: 'field'
	        });

	        // click event demo sparkline
	        $('.clickdemo').sparkline();
	        $('.clickdemo').bind('sparklineClick', function(ev) {
	            var sparkline = ev.sparklines[0],
	                region = sparkline.getCurrentRegionFields();
	            value = region.y;
	            alert("Clicked on x="+region.x+" y="+region.y);
	        });

	        // mouseover event demo sparkline
	        $('.mouseoverdemo').sparkline();
	        $('.mouseoverdemo').bind('sparklineRegionChange', function(ev) {
	            var sparkline = ev.sparklines[0],
	                region = sparkline.getCurrentRegionFields();
	            value = region.y;
	            $('.mouseoverregion').text("x="+region.x+" y="+region.y);
	        }).bind('mouseleave', function() {
	            $('.mouseoverregion').text('');
	        });
	        //big demo
	        $("#bigpie").sparkline([2,1,8,1 ], {type: 'pie', height: '200px'});

	        $("#bigline").sparkline([5,4,4,7,6,9,5,8,2,1,4,2,0,3,6,2,6,4,6,7,4,2,1,5,7,3], {
	            type: 'line',
	            width: '100%',
	            height: '200px',
	            lineColor: '#ea2e49',
	            fillColor: 'rgba(0, 0, 0, 0.02)',
	            highlightSpotColor: '#ea2e49',
	            highlightLineColor: '#ea2e49',
	            spotRadius: 4});
	        $("#bigline").sparkline([4,3,0,6,6,8,5,9,3,8,7,8,7,6,6,4,5,6,3,3,4,3,3,5,5,6], {
	            type: 'line',
	            width: '100%',
	            height: '200px',
	            lineColor: '#07bf29',
	            fillColor: false,
	            highlightSpotColor: '#07bf29',
	            highlightLineColor: '#07bf29',
	            composite: true,
	            spotRadius: 4});
	        $('#bigcomposite').sparkline([5,4,5,7,2,3,5,3,7,9,7,6,-9,-5,-8,-2,6,4,6,7,6,4,2,1,4,6,2], {
	            type: 'bar',
	            barColor: '#2196f3',
	            negBarColor: '#ea2e49',
	            height: '200px',
	            width: '100%',
	            barWidth: 10,
	            barSpacing: 5});
	        $('#bigcomposite').sparkline([4,1,5,7,9,9,8,7,-6,-6,-4,7,8,4,3,2,2,5,6,7,8], {
	            composite: true, fillColor: false, lineColor: 'red', height: '200px', width: '100%' });

	        //event click
	        $("#eventclick").sparkline([5,6,7,9,5,3,2,4,6,7,5,6,7,9,5,6,7,5,6,7,9,5,3,2,7,2,2,4,6,7,9], {
	            type: 'line',
	            height: '90px',
	            width: '100%'});
	        $('#eventclick').bind('sparklineClick', function(ev) {
	            var sparkline = ev.sparklines[0],
	                region = sparkline.getCurrentRegionFields();
	            alert("Clicked on x="+region.x+" y="+region.y);
	        });
	    }

	    function handleMouseSpeedDemo() {
	        var mrefreshinterval = 500; // update display every 500ms
	        var lastmousex=-1;
	        var lastmousey=-1;
	        var lastmousetime;
	        var mousetravel = 0;
	        var mpoints = [];
	        var mpoints_max = 30;
	        $('html').mousemove(function(e) {
	            var mousex = e.pageX;
	            var mousey = e.pageY;
	            if (lastmousex > -1) {
	                mousetravel += Math.max( Math.abs(mousex-lastmousex), Math.abs(mousey-lastmousey) );
	            }
	            lastmousex = mousex;
	            lastmousey = mousey;
	        });
	        var mhandle = function() {
	            var md = new Date();
	            var timenow = md.getTime();
	            if (lastmousetime && lastmousetime!=timenow) {
	                var pps = Math.round(mousetravel / (timenow - lastmousetime) * 1000);
	                mpoints.push(pps);
	                if (mpoints.length > mpoints_max)
	                    mpoints.splice(0,1);
	                mousetravel = 0;
	                $('#mousespeed').sparkline(mpoints, { width: mpoints.length*2, tooltipSuffix: ' pixels per second' });
	            }
	            lastmousetime = timenow;
	            setTimeout(mhandle, mrefreshinterval);
	        };
	        // We could use setInterval instead, but I prefer to do it this way
	        setTimeout(mhandle, mrefreshinterval);
	    }

	    return{
	        init: function () {
	            handleDocSparklines();
	            handleMouseSpeedDemo();
	            //handleBuildYourOwnSparkline();
	        }
	    };
	}(jQuery);
	charts_sparklines.init();
});
;(function($){
    $.fn.Data = function(){};
    var $this = $.fn.Data;

    $.fn.Data.pages = {
        '/index': {title:'Dashboard', 'breadcrumb':['Dashboard']},
        '/charts_chartjs': {title:'Charts Chartjs', 'breadcrumb':['Charts', 'Charts Chartjs']},
        '/charts_flot': {title:'Charts Flot', 'breadcrumb':['Charts', 'Charts Flot']},
        '/charts_sparklines': {title:'Charts Sparklines', 'breadcrumb':['Charts', 'Charts Sparklines']},
        '/form_components': {title:'Form Components', 'breadcrumb':['Form', 'Form Components']},
        '/form_dropzone': {title:'Form Dropzone', 'breadcrumb':['Form', 'Form Dropzone']},
        '/form_editor': {title:'Form Editor', 'breadcrumb':['Form', 'Form Editor']},
        '/form_multiple_file_upload': {title:'Form Multiple File Upload', 'breadcrumb':['Form', 'Form Multiple File Upload']},
        '/form_picker': {title:'Form Picker', 'breadcrumb':['Form', 'Form Picker']},
        '/form_select': {title:'Form Select', 'breadcrumb':['Form', 'Form Select']},
        '/form_validation': {title:'Form Validation', 'breadcrumb':['Form', 'Form Validation']},
        '/form_wizard': {title:'Form Wizard', 'breadcrumb':['Form', 'Form Wizard']},
        '/layout_boxed': {title:'Layout Boxed', 'breadcrumb':['Layout', 'Layout Boxed']},
        '/layout_full_width': {title:'Layout Full Width', 'breadcrumb':['Layout', 'Layout Full Width']},
        '/layout_header_fixed': {title:'Layout Header Fixed', 'breadcrumb':['Layout', 'Layout Header Fixed']},
        '/layout_horizontal_menu': {title:'Layout Horizontal Menu', 'breadcrumb':['Layout', 'Layout Horizontal Menu']},
        '/layout_sidebar_collapsed': {title:'Layout Sidebar Collapsed', 'breadcrumb':['Layout', 'Layout Sidebar Collapsed']},
        '/layout_sidebar_collapsed_fixed': {title:'Layout Sidebar Collapsed Fixed', 'breadcrumb':['Layout', 'Layout Sidebar Collapsed Fixed']},
        '/layout_sidebar_fixed': {title:'Layout Sidebar Fixed', 'breadcrumb':['Layout', 'Layout Sidebar Fixed']},
        '/page_404': {title:'Page 404', 'breadcrumb':['Page', 'Page 404']},
        '/page_500': {title:'Page 500', 'breadcrumb':['Page', 'Page 500']},
        '/page_calendar': {title:'Page Calendar', 'breadcrumb':['Page', 'Page Calendar']},
        '/page_gallery': {title:'Page Gallery', 'breadcrumb':['Page', 'Page Gallery']},
        '/page_invoice': {title:'Page Invoice', 'breadcrumb':['Page', 'Page Invoice']},
        '/page_lock_screen': {title:'Page Lock Screen', 'breadcrumb':['Page', 'Page Lock Screen']},
        '/page_mail': {title:'Page Mail', 'breadcrumb':['Page', 'Page Mail']},
        '/page_pricing_table': {title:'Page Pricing Table', 'breadcrumb':['Page', 'Page Pricing Table']},
        '/page_profile': {title:'Page Profile', 'breadcrumb':['Page', 'Page Profile']},
        '/page_timeline': {title:'Page Timeline', 'breadcrumb':['Page', 'Page Timeline']},
        '/page_search': {title:'Page Search', 'breadcrumb':['Page', 'Page Search']},
        '/page_signin': {title:'Page Signin', 'breadcrumb':['Page', 'Page Signin']},
        '/page_signup': {title:'Page Signup', 'breadcrumb':['Page', 'Page Signup']},
        '/table_advanced': {title:'Table Advanced', 'breadcrumb':['Table', 'Table Advanced']},
        '/table_basic': {title:'Table Basic', 'breadcrumb':['Table', 'Table Basic']},
        '/table_responsive': {title:'Table Responsive', 'breadcrumb':['Table', 'Table Responsive']},
        '/table_treegrid': {title:'Table Treegrid', 'breadcrumb':['Table', 'Table Treegrid']},
        '/ui_buttons': {title:'Ui Buttons', 'breadcrumb':['Ui', 'Ui Buttons']},
        '/ui_datepaginator': {title:'Ui Datepaginator', 'breadcrumb':['Ui', 'Ui Datepaginator']},
        '/ui_general': {title:'Ui General', 'breadcrumb':['Ui', 'Ui General']},
        '/ui_icons': {title:'Ui Icons', 'breadcrumb':['Ui', 'Ui Icons']},
        '/ui_modals': {title:'Ui Modals', 'breadcrumb':['Ui', 'Ui Modals']},
        '/ui_nestable_list': {title:'Ui Nestable List', 'breadcrumb':['Ui', 'Ui Nestable List']},
        '/ui_panels': {title:'Ui Panels', 'breadcrumb':['Ui', 'Ui Panels']},
        '/ui_sortable_list': {title:'Ui Sortable List', 'breadcrumb':['Ui', 'Ui Sortable List']},
        '/ui_tabs_accordions': {title:'Ui Tabs Accordions', 'breadcrumb':['Ui', 'Ui Tabs Accordions']},
        '/ui_toastr': {title:'Ui Toastr', 'breadcrumb':['Ui', 'Ui Toastr']},
        '/ui_treeview': {title:'Ui Treeview', 'breadcrumb':['Ui', 'Ui Treeview']},
        '/ui_typography': {title:'Ui Typography', 'breadcrumb':['Ui', 'Ui Typography']}

    };

    $.fn.Data.get = function(id){
        if(id && $this.pages[id]){
            return $this.pages[id];
        }
    };

    $.fn.Data.checkbox = function(){
        if($('#demo-checkbox-radio').length <= 0){
            $('input[type="checkbox"]:not(".switch")').iCheck({
                checkboxClass: 'icheckbox_minimal-grey',
                increaseArea: '20%' // optional
            });
            $('input[type="radio"]:not(".switch")').iCheck({
                radioClass: 'iradio_minimal-grey',
                increaseArea: '20%' // optional
            });
        }
    };

    $.fn.Data.Button = function() {

        //BEGIN TOOTLIP
        $("[data-toggle='tooltip'], [data-hover='tooltip']").tooltip();
        //END TOOLTIP

        //BEGIN POPOVER
        $("[data-toggle='popover'], [data-hover='popover']").popover();
        //END POPOVER

        //BEGIN JQUERY ICHECK
        if($('#demo-checkbox-radio').length <= 0){

            $('input[type="checkbox"]:not(".switch")').iCheck({
                checkboxClass: 'icheckbox_square-blue ',
                increaseArea: '20%' // optional
            });
            $('input[type="radio"]:not(".switch")').iCheck({
                radioClass: 'iradio_square-blue',
                increaseArea: '20%' // optional
            });
            $('input.form-control-shadow[type="checkbox"]').iCheck({
                checkboxClass: 'icheckbox_square-blue form-control-shadow',
                increaseArea: '20%' // optional
            });
            $('input.form-control-shadow[type="radio"]').iCheck({
                radioClass: 'iradio_square-blue form-control-shadow border-circle',
                increaseArea: '20%' // optional
            });
        }
        //END JQUERY ICHECK
    };

})(jQuery);
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
App.controller('FormDropzoneController', function ($scope, $routeParams){
    var form_dropzone = function() {

	    var handleDropzone = function(){
	        Dropzone.options.myDropzone = {
	            init: function() {
	                this.on("addedfile", function(file) {

	                    // Create the remove button
	                    var removeButton = Dropzone.createElement("<button class='btn btn-danger'>Remove file</button>");


	                    // Capture the Dropzone instance as closure.
	                    var _this = this;

	                    // Listen to the click event
	                    removeButton.addEventListener("click", function(e) {
	                        // Make sure the button click doesn't submit the form:
	                        e.preventDefault();
	                        e.stopPropagation();

	                        // Remove the file preview.
	                        _this.removeFile(file);
	                        // If you want to the delete the file on the server as well,
	                        // you can do the AJAX request here.
	                    });

	                    // Add the button to the file preview element.
	                    file.previewElement.appendChild(removeButton);
	                });
	            }
	        };
	    };

	    return{
	        init: function () {
	            handleDropzone();
	        }
	    };
	}(jQuery);
	form_dropzone.init();
	
});
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
App.controller('FormMultipleFileController', function ($scope, $routeParams){
    var form_multiple_file_upload = function() {

	    var handleMultipleFileUpload = function(){
	        // Initialize the jQuery File Upload widget:
	        $('#fileupload').fileupload({
	            disableImageResize: false,
	            // Uncomment the following to send cross-domain cookies:
	            //xhrFields: {withCredentials: true},
	            url: '../vendors/jquery-file-upload/server/php/'
	        });

	        // Enable iframe cross-domain access via redirect option:
	        $('#fileupload').fileupload(
	            'option',
	            'redirect',
	            window.location.href.replace(
	                /\/[^\/]*$/,
	                '/cors/result.html?%s'
	            )
	        );

	        // Demo settings:
	        $('#fileupload').fileupload('option', {
	            url: '../vendors/jquery-file-upload/server/php/',
	            // Enable image resizing, except for Android and Opera,
	            // which actually support image resizing, but fail to
	            // send Blob objects via XHR requests:
	            disableImageResize: /Android(?!.*Chrome)|Opera/
	                .test(window.navigator.userAgent),
	            maxFileSize: 5000000,
	            acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i
	        });
	        // Upload server status check for browsers with CORS support:
	        if ($.support.cors) {
	            $.ajax({
	                url: '../vendors/jquery-file-upload/server/php/',
	                type: 'HEAD'
	            }).fail(function () {
	                $('<div class="alert alert-danger alert-custom"/>')
	                    .text('Upload server currently unavailable - ' +
	                        new Date())
	                    .appendTo('#fileupload');
	            });
	        }

	    };

	    return{
	        init: function () {
	            handleMultipleFileUpload();
	        }
	    };
	}(jQuery);
	$.fn.Button.core();
	form_multiple_file_upload.init();
});
App.controller('FormPickerController', function ($scope, $routeParams, $modal){
    var form_picker = function() {

	    //BEGIN COLOR PICKER
	    var handleColorPicker = function(){
	        $('.colorpicker-default').colorpicker();
	        $('.colorpicker-rgba').colorpicker();
	        $('.colorpicker-component').colorpicker({
	            format: 'hex'
	        }).on('changeColor', function(ev) {
	                $('.colorpicker-component span i').css('color',ev.color.toHex());
	                $('.colorpicker-component input').val(ev.color.toHex());
	            });
	    };
	    //END COLOR PICKER

	    //BEGIN DATETIME PICKER
	    var handleDateTimePicker = function() {
	        $('.datetimepicker-default').datetimepicker();
	        $('.datetimepicker-disable-date').datetimepicker({
	            pickDate: false
	        });
	        $('.datetimepicker-disable-time').datetimepicker({
	            pickTime: false
	        });
	        $('.datetimepicker-start').datetimepicker();
	        $('.datetimepicker-end').datetimepicker();
	        $('.datetimepicker-start').on("change.dp",function (e) {
	            $('.datetimepicker-end').data("DateTimePicker").setStartDate(e.date);
	        });
	        $('.datetimepicker-end').on("change.dp",function (e) {
	            $('.datetimepicker-start').data("DateTimePicker").setEndDate(e.date);
	        });
	    };
	    //END DATETIME PICKER

	    //BEGIN TIME PICKER
	    var handleTimePicker = function() {
	        $('.timepicker-default').timepicker();
	        $('.timepicker-24hr').timepicker({
	            autoclose: true,
	            minuteStep: 1,
	            showSeconds: true,
	            showMeridian: false
	        });
	    };
	    //END TIME PICKER

	    //BEGIN CLOCKFACE
	    var handleClockFace = function() {
	        $('.clockface-default').clockface();
	        $('.clockface-component').clockface({
	            format: 'HH:mm',
	            trigger: 'manual'
	        });

	        $('.btn-clockface-component').click(function(e){
	            e.stopPropagation();
	            $('.clockface-component').clockface('toggle');
	        });

	        $('.clockface-inline').clockface({
	            format: 'H:mm'
	        }).clockface('show', '14:30');
	    };
	    //END CLOCKFACE

	    //BEGIN DATE PICKER
	    var handleDatePicker = function() {
	        $('.datepicker-default').datepicker();
	        $('.datepicker-years').datepicker({
	            startView: 1,
	            minViewMode: 2
	        });
	        $('.input-daterange').datepicker({
	            format: "dd-mm-yyyy"
	        });
	        $('.datepicker-inline').datepicker({
	            format: "dd-mm-yyyy",
	            startView: 2,
	            minViewMode: 1
	        });
	    };
	    //END DATE PICKER

	    //BEGIN DATE RANGE PICKER
	    var handleDateRangePicker = function(){
	        $('input[name="daterangepicker-default"]').daterangepicker();
	        $('input[name="daterangepicker-date-time"]').daterangepicker({ timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A' });
	        $('.reportrange').daterangepicker(
	            {
	                ranges: {
	                    'Today': [moment(), moment()],
	                    'Yesterday': [moment().subtract('days', 1), moment().subtract('days', 1)],
	                    'Last 7 Days': [moment().subtract('days', 6), moment()],
	                    'Last 30 Days': [moment().subtract('days', 29), moment()],
	                    'This Month': [moment().startOf('month'), moment().endOf('month')],
	                    'Last Month': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
	                },
	                startDate: moment().subtract('days', 29),
	                endDate: moment(),
	                opens: 'left'
	            },
	            function(start, end) {
	                $('.reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
	                $('input[name="datestart"]').val(start.format("YYYY-MM-DD"));
	                $('input[name="endstart"]').val(end.format("YYYY-MM-DD"));
	            }
	        );
	        $('.reportrange span').html(moment().subtract('days', 29).format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));
	    };
	    //END DATE RANGE PICKER

	    return{
	        init: function () {
	            handleColorPicker();
	            handleDateRangePicker();
	            handleDateTimePicker();
	            handleTimePicker();
	            handleClockFace();
	            handleDatePicker();
	        }
	    };
	}(jQuery);
	
	form_picker.init();	
});
App.controller('FormSelectController', function ($scope, $routeParams){
    var form_select = function() {
	    	var handleSelect2 = function(){
	        //BEGIN PLUGINS SELECT2
	        $('.select2-category').select2({
	            placeholder: "Select an option",
	            allowClear: true
	        });
	        $(".select2-tagging-support").select2({
	            tags:["red", "green", "blue", "yellow", "green"]
	        });
	        $(".select2-multi-value").select2();
	        $('.select2-size').select2({
	            placeholder: "Select an option",
	            allowClear: true
	        });
	        function movieFormatResult(movie) {
	            var markup = "<table class='movie-result'><tr>";
	            if (movie.posters !== undefined && movie.posters.thumbnail !== undefined) {
	                markup += "<td valign='top'><img src='" + movie.posters.thumbnail + "' style='margin-right: 10px;' /></td>";
	            }
	            markup += "<td valign='top'><strong style='margin-bottom: 7px;'>" + movie.title + "</strong>";
	            if (movie.critics_consensus !== undefined) {
	                markup += "<div class='movie-synopsis' style='font-size: 12px;'>" + movie.critics_consensus + "</div>";
	            } else if (movie.synopsis !== undefined) {
	                markup += "<div class='movie-synopsis' style='font-size: 12px;'>" + movie.synopsis + "</div>";
	            }
	            markup += "</td></tr></table>";
	            return markup;
	        }

	        function movieFormatSelection(movie) {
	            return movie.title;
	        }

	        $(".select2-loading-remote-data").select2({
	            placeholder: "Search for a movie",
	            minimumInputLength: 1,
	            ajax: { // instead of writing the function to execute the request we use Select2's convenient helper
	                url: "http://api.rottentomatoes.com/api/public/v1.0/movies.json",
	                dataType: 'jsonp',
	                data: function (term, page) {
	                    return {
	                        q: term, // search term
	                        page_limit: 10,
	                        apikey: "ju6z9mjyajq2djue3gbvv26t" // please do not use so this example keeps working
	                    };
	                },
	                results: function (data, page) { // parse the results into the format expected by Select2.
	                    // since we are using custom formatting functions we do not need to alter remote JSON data
	                    return {
	                        results: data.movies
	                    };
	                }
	            },
	            initSelection: function (element, callback) {
	                // the input tag has a value attribute preloaded that points to a preselected movie's id
	                // this function resolves that id attribute to an object that select2 can render
	                // using its formatResult renderer - that way the movie name is shown preselected
	                var id = $(element).val();
	                if (id !== "") {
	                    $.ajax("http://api.rottentomatoes.com/api/public/v1.0/movies/" + id + ".json", {
	                        data: {
	                            apikey: "ju6z9mjyajq2djue3gbvv26t"
	                        },
	                        dataType: "jsonp"
	                    }).done(function (data) {
	                        callback(data);
	                    });
	                }
	            },
	            formatResult: movieFormatResult, // omitted for brevity, see the source of this page
	            formatSelection: movieFormatSelection, // omitted for brevity, see the source of this page
	            dropdownCssClass: "bigdrop", // apply css that makes the dropdown taller
	            escapeMarkup: function (m) {
	                return m;
	            } // we do not want to escape markup since we are displaying html in results
	        });
	        $(".select2-loading-data").select2({
	            minimumInputLength: 1,
	            query: function (query) {
	                var data = {results: []}, i, j, s;
	                for (i = 1; i < 5; i++) {
	                    s = "";
	                    for (j = 0; j < i; j++) {s = s + query.term;}
	                    data.results.push({id: query.term + i, text: s});
	                }
	                query.callback(data);
	            }
	        });
	        //END PLUGINS SELECT2
	    };

	    var handleBootstrapSelect = function(){
	        //BEGIN PLUGINS BOOTSTRAP SELECT
	        $('.selectpicker').selectpicker({
	            iconBase: 'fa',
	            tickIcon: 'fa-check'
	        });
	        //END PLUGINS BOOTSTRAP SELECT
	    };

	    var handleMultiSelect = function(){
	        //BEGIN PLUGINS MULTI SELECT
	        $('#pre-selected-options').multiSelect();
	        $('#callbacks').multiSelect({
	            afterSelect: function(values){
	                alert("Select value: "+values);
	            },
	            afterDeselect: function(values){
	                alert("Deselect value: "+values);
	            }
	        });
	        $('#keep-order').multiSelect({ keepOrder: true });
	        $('#public-methods').multiSelect();
	        $('#select-all').click(function(){
	            $('#public-methods').multiSelect('select_all');
	            return false;
	        });
	        $('#deselect-all').click(function(){
	            $('#public-methods').multiSelect('deselect_all');
	            return false;
	        });
	        var arr = [];

	        for (var i = 0; i < 20; i++){
	            arr[i] = 'elem_'+(i+1);
	        }
	        $('#select-20').click(function(){
	            $('#public-methods').multiSelect('select', arr);
	            return false;
	        });
	        $('#deselect-20').click(function(){
	            $('#public-methods').multiSelect('deselect', arr);
	            return false;
	        });
	        $('#refresh').on('click', function(){
	            $('#public-methods').multiSelect('refresh');
	            return false;
	        });
	        $('#add-option').on('click', function(){
	            $('#public-methods').multiSelect('addOption', { value: 21, text: 'test 21', index: 0 });
	            return false;
	        });
	        $('#optgroup').multiSelect({ selectableOptgroup: true });
	        //END PLUGINS MULTI SELECT
	    };

	    return{
	        init: function () {
	            handleSelect2();
	            handleBootstrapSelect();
	            handleMultiSelect();
	        }
	    };
	}(jQuery);

	form_select.init();
});
App.controller('FormWizardController', function ($scope, $routeParams){
    var form_wizard = function() {

	    var handleWizard = function(){
	        var form = $("#example-form");
	        form.validate({
	            rules: {
	                userName: {
	                    required: true,
	                    minlength: 5
	                },
	                password: {
	                    required: true,
	                    minlength: 5
	                },
	                confirm: {
	                    required: true,
	                    minlength: 5,
	                    equalTo: '#password'
	                },
	                email: {
	                    required: true,
	                    email: true
	                }
	            },
	            messages: {
	                userName:
	                {
	                    required: 'Please enter your Username'
	                },
	                password:
	                {
	                    minlength: "Your password must be at least 5 characters long",
	                    required: 'Please enter your password'
	                },
	                confirm: {
	                    minlength: "Your password must be at least 5 characters long",
	                    required: 'Please enter your password',
	                    equalTo: "Please enter the same password as above"
	                },
	                email: {
	                    required: 'Please enter you Email',
	                    email: 'Please enter available email'
	                }
	            },
	            errorPlacement: function(error, element)
	            {
	                error.insertAfter(element);
	            }
	        });
	        form.children("div").steps({
	            headerTag: "h3",
	            bodyTag: "section",
	            transitionEffect: "slideLeft",
	            onStepChanging: function (event, currentIndex, newIndex)
	            {
	                form.validate().settings.ignore = ":disabled,:hidden";
	                return form.valid();
	            },
	            onFinishing: function (event, currentIndex)
	            {
	                form.validate().settings.ignore = ":disabled";
	                return form.valid();
	            },
	            onFinished: function (event, currentIndex)
	            {
	                alert("Submitted!");
	            }
	        });

	        var wizard_3 = $("#wizard-3").steps({
	            transitionEffect: "slideLeft",
	            stepsOrientation: "vertical",
	            onStepChanging: function (event, currentIndex, newIndex)
	            {
	                $("#form-3").validate().settings.ignore = ":disabled,:hidden";
	                return $("#form-3").valid();
	            },
	            onFinishing: function (event, currentIndex)
	            {
	                $("#form-3").validate().settings.ignore = ":disabled";
	                return $("#form-3").valid();
	            },
	            onFinished: function (event, currentIndex)
	            {
	                alert("Submitted!");
	            }
	        });
	        wizard_3.steps("add", {
	            title: "Account",
	            content: '<fieldset><legend>Account Information</legend><div class="form-group"><label for="userName1">Username <span class="require">*</span></label><div><input id="userName1" name="userName1" type="text" class="form-control required"></div></div><div class="form-group"><label for="password1">Password <span class="require">*</span></label><div><input id="password1" name="password1" type="text" class="form-control required"></div></div><div class="form-group"><label for="confirm1">Confirm Password <span class="require">*</span></label><div><input id="confirm1" name="confirm1" type="text" class="form-control required"></div></div></fieldset>'
	        });
	        wizard_3.steps("add", {
	            title: "Profile",
	            content: '<fieldset><legend>Profile Information</legend><div class="form-group"><label for="name1">First name <span class="require">*</span></label><div><input id="name1" name="name1" type="text" class="form-control required"></div></div><div class="form-group"><label for="surname1">Last name <span class="require">*</span></label><div><input id="surname1" name="surname1" type="text" class="form-control required"></div></div><div class="form-group"><label for="email1">Email <span class="require">*</span></label><div><input id="email1" name="email1" type="text" class="form-control required email"></div></div><div class="form-group"><label for="address1">Address</label><div><input id="address1" name="address1" type="text" class="form-control"></div></div><div class="form-group"><label for="age1">Age (The warning step will show up if age is less than 18) *</label><div><input id="age1" name="age1" type="text" class="form-control required number"></div></div></fieldset>'
	        });
	        wizard_3.steps("add", {
	            title: "Warning",
	            content: '<fieldset><legend>You are to young</legend><p>Please go away ;-)</p></fieldset>'
	        });
	        wizard_3.steps("add", {
	            title: "Finish",
	            content: '<fieldset><legend>Terms and Conditions</legend><input id="acceptTerms1" name="acceptTerms1" type="checkbox" class="required"> <label for="acceptTerms1">I agree with the Terms and Conditions.</label></fieldset>'
	        });


	        $('#rootwizard').bootstrapWizard({tabClass:'nav',onTabShow: function(tab, navigation, index) {
	            
	            var $total = navigation.find('li').length;
	            var $current = index+1;
	            var $percent = ($current/$total) * 100;
	            $('#rootwizard').find('.bar').css({width:$percent+'%'});
	            $('.next>a,.previous>a').click(function(e){
	                e.preventDefault();
	            });
	        }});
	    };
	    return{
	        init: function () {
	            handleWizard();
	        }
	    };
	}(jQuery);
	form_wizard.init();	
	
});
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
App.controller('LayoutSidebarFixedController', function ($scope, $routeParams){
    var layout_sidebar_fixed = function() {

	    var handleSlimscrollSidebar = function () {
	        $('#sidebar-main').slimScroll({
	            'width': '100%',
	            'height': $(window).height()-80,
	            "wheelStep": 5
	        });
	    };

	    return{
	        init: function () {
	            handleSlimscrollSidebar();
	        }
	    };

	}(jQuery);
	layout_sidebar_fixed.init();
});
App.controller('NoneController', function ($scope, $routeParams){
    var none_controller = function() {
        return false;
    };
});
App.controller('Page404Controller', function ($scope, $routeParams){
    $("body>.fluid").replaceWith($('.page-404'));
});
App.controller('Page500Controller', function ($scope, $routeParams){
    $("body>.fluid").replaceWith($('.page-500'));
});
App.controller('PageLockScreenController', function ($scope, $routeParams){
    $("body>.fluid").replaceWith($('.page-lock-screen'));
});
App.controller('PageSigninController', function ($scope, $routeParams){
	
    $("body>.fluid").replaceWith($('.page-signin'));

    $('input[type="checkbox"]').iCheck({
        checkboxClass: 'icheckbox_minimal-grey',
        increaseArea: '20%' // optional
    });
    
});
App.controller('PageSignupController', function ($scope, $routeParams){
    $("body>.fluid").replaceWith($('.page-signup'));

    $('input[type="checkbox"]').iCheck({
        checkboxClass: 'icheckbox_minimal-grey',
        increaseArea: '20%' // optional
    });
    $('input[type="radio"]').iCheck({
        radioClass: 'iradio_minimal-grey',
        increaseArea: '20%' // optional
    });

    $("#signup-form").validate({
        rules:{
            username:
            {
                required: true
            },
            email:
            {
                required: true,
                email: true
            },
            password:
            {
                required: true,
                minlength: 3,
                maxlength: 20
            },
            passwordConfirm:
            {
                required: true,
                minlength: 3,
                maxlength: 20,
                equalTo: '#password'
            },
            firstname:
            {
                required: true
            },
            lastname:
            {
                required: true
            },
            gender:
            {
                required: true
            }
        },

        // Messages for form validation
        messages:
        {
            login:
            {
                required: 'Please enter your login'
            },
            email:
            {
                required: 'Please enter your email address',
                email: 'Please enter a VALID email address'
            },
            password:
            {
                required: 'Please enter your password'
            },
            passwordConfirm:
            {
                required: 'Please enter your password one more time',
                equalTo: 'Please enter the same password as above'
            },
            firstname:
            {
                required: 'Please select your first name'
            },
            lastname:
            {
                required: 'Please select your last name'
            },
            gender:
            {
                required: 'Please select your gender'
            }
        },

        // Do not change code below
        errorPlacement: function(error, element)
        {
            error.insertAfter(element.parent());
        }
    });
});
App.controller('PageCalendarController', function ($scope, $routeParams){
    
   var page_calendar = function() {
       var handleFullCalendar = function() {
           //BEGIN END SIDEBAR LEFT EDIT OR REMOVE
           $('ul.sidebar-list-info li a i.icon-trash').live('click', function () {
               var $ok = window.confirm('Are you sure you want to delete ?');
               if ($ok === true) {
                   $(this).parents('li').remove();
               }

           });

           $("ul.sidebar-list-info li a i.icon-note").live('click', function () {
               var $key_cut = $(this).parent().siblings('span.label').text(),
                   $old_name = $(this).parents('a').text();
               if ($key_cut !== "") {
                   $old_name = $(this).parents('a').text().split($key_cut)[0];
               }
               var $old_list_emp = '<input type="text" value="' + $old_name + '" id="txt-new-list" maxlength="15" >';
               // alert($key_cut);
               $(this).parents('a').hide();
               $(this).parents('li').append($old_list_emp);

               $("#txt-new-list").select().blur(function () {
                   if ($(this).val().length !== 0) {
                       var $new_name = '<i class="icon-check"></i>' + $(this).val() + '<span class="label label-primary">' + $key_cut + '</span>' +
                           '<div class="pull-right tab-tools">' +
                           '<i class="icon-note"></i>' +
                           '<i class="icon-trash"></i></div>';
                       $(this).siblings('a').html($new_name).show();
                       $(this).remove();
                   } else alert("Name list not null!");
                   //alert("sad");
               }).keyup(function (e) {
                   if (e.keyCode == 13) {
                       if ($(this).val().length !== 0) {
                           var $new_name = '<i class="icon-check"></i>' + $(this).val() + '<span class="label label-primary">' + $key_cut + '</span>' +
                               '<div class="pull-right tab-tools">' +
                               '<i class="icon-note"></i>' +
                               '<i class="icon-trash"></i></div>';
                           $(this).siblings('a').html($new_name).show();
                           $(this).remove();
                       } else alert("Name list not null!");
                   }
               });
           });
           //BEGIN END SIDEBAR LEFT EDIT OR REMOVE

           /* initialize the external events
            -----------------------------------------------------------------*/

           var eventDrag = function (el) {
               // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
               // it doesn't need to have a start or end
               var $option;
               if ($(el).hasClass('btn-default')) {
                   $option = 'btn-default';
               } else if ($(el).hasClass('btn-success')) {
                   $option = 'btn-success';
               } else if ($(el).hasClass('btn-warning')) {
                   $option = 'btn-warning';
               } else if ($(el).hasClass('btn-danger')) {
                   $option = 'btn-danger';
               }
               var eventObject = {
                   title: $.trim(el.text()), // use the element's text as the event title
                   className: $option //add class corlor
               };

               // store the Event Object in the DOM element so we can get to it later
               el.data('eventObject', eventObject);

               // make the event draggable using jQuery UI
               el.draggable({
                   zIndex: 999,
                   revert: true,      // will cause the event to go back to its
                   revertDuration: 0  //  original position after the drag
               });
           };

           $('#external-events div.external-event').each(function () {
               eventDrag($(this));
           });


           /* initialize the calendar
            -----------------------------------------------------------------*/

           $('#calendar').fullCalendar({
               header: {
                   left: 'prev,next today',
                   center: 'title',
                   right: 'month,agendaWeek,agendaDay'
               },
               editable: true,
               droppable: true, // this allows things to be dropped onto the calendar !!!
               drop: function (date, allDay) { // this function is called when something is dropped

                   // retrieve the dropped element's stored Event Object
                   var originalEventObject = $(this).data('eventObject');

                   // we need to copy it, so that multiple events don't have a reference to the same object
                   var copiedEventObject = $.extend({}, originalEventObject);
                   // alert(copiedEventObject);
                   // assign it the date that was reported
                   copiedEventObject.start = date;
                   copiedEventObject.allDay = allDay;

                   // render the event on the calendar
                   // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)

                   $('#calendar').fullCalendar('renderEvent', copiedEventObject, true);


                   // is the "remove after drop" checkbox checked?
                   if ($('#drop-remove').is(':checked')) {
                       // if so, remove the element from the "Draggable Events" list
                       $(this).remove();
                       // alert("dsd");
                   }

               },
               selectable: true,
               selectHelper: true,
               select: function (start, end) {
                   var title = prompt('Event Title:');
                   var eventData;
                   if (title) {
                       eventData = {
                           title: title,
                           start: start,
                           end: end,
                           className: 'btn-default'
                       };
                       $('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
                   }
                   $('#calendar').fullCalendar('unselect');
               },
               eventLimit: true, // allow "more" link when too many events
               events: [
                   {
                       title: 'All Day Event',
                       start: '2014-10-01',
                       className: 'btn-default'
                   },
                   {
                       title: 'Long Event',
                       start: '2014-10-07',
                       end: '2014-10-10',
                       className: 'btn-success'
                   },
                   {
                       id: 999,
                       title: 'Repeating Event',
                       start: '2014-10-09T16:00:00',
                       className: 'btn-success'
                   },
                   {
                       id: 999,
                       title: 'Repeating Event',
                       start: '2014-10-16T16:00:00',
                       className: 'btn-default'
                   },
                   {
                       title: 'Conference',
                       start: '2014-10-11',
                       end: '2014-10-13',
                       className: 'btn-danger'
                   },
                   {
                       title: 'Meeting',
                       start: '2014-10-12T10:30:00',
                       end: '2014-10-12T12:30:00',
                       className: 'btn-danger',
                       allDay: false

                   },
                   {
                       title: 'Lunch',
                       start: '2014-10-12T12:00:00',
                       className: 'btn-success'
                   },
                   {
                       title: 'Meeting',
                       start: '2014-10-12T14:30:00',
                       className: 'btn-warning'
                   },
                   {
                       title: 'Happy Hour',
                       start: '2014-10-12T17:30:00',
                       className: 'btn-success'
                   },
                   {
                       title: 'Dinner',
                       start: '2014-10-12T20:00:00',
                       className: 'btn-warning'
                   },
                   {
                       title: 'Birthday Party',
                       start: '2014-10-13T07:00:00',
                       className: 'btn-danger'
                   },
                   {
                       title: 'Click for Google',
                       start: '2014-10-28',
                       className: 'btn-success'
                   }
               ]
           });


           //BEGIN ADD CALENDARS

           $('#btn-add-calendar').live('click', function () {
               var $new_list_emp = '<input type="text" value="New Calendar" id="txt-new-list" maxlength="15" >';

               $('ul.sidebar-calendar').append($new_list_emp);
               $('#txt-new-list').select().blur(function () {
                   if ($(this).val().length !== 0) {
                       var $new_list = ' <li>' +
                           '<a href="#tab-inbox" role="tab" class="btn-group dropup btn-block dropdown-toggle" data-hover="dropdown">' +
                           '<i class="icon-check"></i>' +
                           $(this).val() +
                           ' <span class="label label-primary"></span>' +
                           '<span class="pull-right tab-tools">' +
                           ' <i class="icon-note"></i>' +
                           '<i class="icon-trash"></i>' +
                           '</span> </a>' +
                           '<div id="external-events" class="dropdown-menu" role="menu">' +
                           ' <h4>Draggable Events' +
                           '<span class="pull-right"> <a href="#" id="btn-add-event" class="btn-xs"> <i class="icon-plus"></i>' +
                           '</a></span></h4><div class="external-event fc-event ui-draggable empty"></div>' +
                           '<p><input type="checkbox" id="drop-remove">' +
                           ' <label for="drop-remove"> Remove after drop</label></p></div></li>';
                       $('ul.sidebar-calendar').append($new_list);

                       $(this).remove();
                       $('[data-hover="dropdown"]').dropdownHover();
                   } else alert("Name list not null!");
               }).keyup(function (e) {
                   if (e.keyCode == 13) {
                       if ($(this).val().length !== 0) {
                           var $new_list = ' <li>' +
                               '<a href="#tab-inbox" role="tab" class="btn-group dropup btn-block dropdown-toggle" data-hover="dropdown">' +
                               '<i class="icon-check"></i>' +
                               $(this).val() +
                               ' <span class="label label-primary"></span>' +
                               '<span class="pull-right tab-tools">' +
                               ' <i class="icon-note"></i>' +
                               '<i class="icon-trash"></i>' +
                               '</span> </a>' +
                               '<div id="external-events" class="dropdown-menu" role="menu">' +
                               ' <h4>Draggable Events' +
                               '<span class="pull-right"> <a href="#" id="btn-add-event" class="btn-xs"> <i class="icon-plus"></i>' +
                               '</a></span></h4><div class="external-event fc-event ui-draggable empty"></div>' +
                               '<p><input type="checkbox" id="drop-remove">' +
                               ' <label for="drop-remove"> Remove after drop</label></p></div></li>';
                           $('ul.sidebar-calendar').append($new_list);

                           $(this).remove();
                           $('[data-hover="dropdown"]').dropdownHover();

                       } else alert("Name list not null!");
                   }
               });
               // alert('asd');
           });

           //BEGIN ADD CALENDARS

           //BEGIN DELETE EVENT
           $('#external-events .tab-tools i.icon-trash').live('click', function () {
               var $ok = window.confirm('Are you sure you want to delete ?');
               if ($ok === true) {
                   $(this).parents('.external-event').remove();
               }

           });

           //BEGIN ADD EVENT
           $('.option-event .event').live('click', function () {
               $('.option-event .event').removeClass('active');
               $(this).addClass('active');
           });
           $('#txt-new').live('click', function () {
               $(this).select();
           });
           $('a#btn-add-event').live('click', function (e) {
               e.preventDefault();
               var $new_list_emp = '<div class="option-event"> <input type="text" value="New Event" id="txt-new" maxlength="15" >' +
                   '  <span data-hover="tooltip"  class="event not-specified active" title="Not Specified"></span>   ' +
                   ' <span data-hover="tooltip"  class="event low" title="Low"></span>   ' +
                   ' <span data-hover="tooltip" class="event medium" title="Medium"></span>    ' +
                   '<span data-hover="tooltip"  class="event high" title="High"></span></div>';
               var $me = $(this).parents('#external-events').find('.external-event:last');
               $($new_list_emp).insertAfter($me);
               $('#txt-new').select();
               $('.option-event').keyup(function (e) {
                   if (e.keyCode == 13) {
                       if ($('#txt-new').val().length !== 0) {
                           var $option;
                           if ($('.event.active').hasClass('not-specified')) {
                               $option = 'btn-default';
                           } else if ($('.event.active').hasClass('low')) {
                               $option = 'btn-success';
                           } else if ($('.event.active').hasClass('medium')) {
                               $option = 'btn-warning';
                           } else if ($('.event.active').hasClass('high')) {
                               $option = 'btn-danger';
                           }
                           var $new_list = '<div class="external-event fc-event ' + $option + '">' + $('#txt-new').val() +
                               '<div class="pull-right tab-tools">' +
                               '<i class="icon-note"></i>' +
                               '<i class="icon-trash"></i>' +
                               '</div> </div>';
                           $($new_list).insertAfter($me);
                           $('#external-events div.external-event').each(function () {
                               eventDrag($(this));
                           });
                           edit_event();
                           $(this).remove();
                       } else alert("Name not null!");
                   }
               });
           });
           //END ADD EVENT

           //BEGIN EDIT EVENT
           var edit_event = function () {
               $('.external-event i.icon-note').live('click', function () {
                   var $me = $(this).parents('.external-event'),
                       $text = $me.text(),
                       $index = $me.index(),
                       $option;
                   if ($me.hasClass('btn-success')) {
                       $option = 'low';
                   }
                   else if ($me.hasClass('btn-default')) {
                       $option = 'not-specified';
                   }
                   else if ($me.hasClass('btn-warning')) {
                       $option = 'medium';
                   }
                   else if ($me.hasClass('btn-danger')) {
                       $option = 'high';
                   }

                   var $edit_event = '<div class="option-event"> <input type="text" value="' + $text + '" id="txt-new" maxlength="15" >' +
                       '  <span data-hover="tooltip"  class="event not-specified" title="Not Specified"></span>   ' +
                       ' <span data-hover="tooltip"  class="event low" title="Low"></span>   ' +
                       ' <span data-hover="tooltip" class="event medium" title="Medium"></span>    ' +
                       '<span data-hover="tooltip"  class="event high" title="High"></span></div>';
                   $me.hide();
                   $($edit_event).insertAfter($me);
                   $('#txt-new').select();
                   $('span.event').removeClass('active').each(function () {
                       if ($(this).hasClass($option)) {
                           $(this).addClass('active');
                       }
                   });
                   $('.option-event').keyup(function (e) {
                       if (e.keyCode == 13) {
                           if ($('#txt-new').val().length !== 0) {
                               var $option;
                               if ($('.event.active').hasClass('not-specified')) {
                                   $option = 'btn-default';
                               } else if ($('.event.active').hasClass('low')) {
                                   $option = 'btn-success';
                               } else if ($('.event.active').hasClass('medium')) {
                                   $option = 'btn-warning';
                               } else if ($('.event.active').hasClass('high')) {
                                   $option = 'btn-danger';
                               }
                               var $new_list = '<div class="external-event fc-event ' + $option + '">' + $('#txt-new').val() +
                                   '<div class="pull-right tab-tools">' +
                                   '<i class="icon-note"></i>' +
                                   '<i class="icon-trash"></i>' +
                                   '</div> </div>';
                               $($new_list).insertAfter($me);
                               $me.remove();
                               $('#external-events div.external-event').each(function () {
                                   eventDrag($(this));
                               });
                               $(this).remove();

                           } else alert("Name not null!");
                       }
                   });
               });
           };
           edit_event();
           //END EDIT EVENT
       };

       return{
           init: function () {
               handleFullCalendar();
           }
       };

    }(jQuery);
    page_calendar.init();
});
App.controller('PageGalleryController', function ($scope, $routeParams){
    var page_gallery = function() {
	    var handleMixitup = function(){
	        $('.mix-grid').mixItUp({
	            animation: {
	                duration: 400,
	                effects: 'fade stagger(34ms) translateZ(-700px) scale(0.01)',
	                easing: 'cubic-bezier(0.175, 0.885, 0.32, 1.275)'
	            }
	        });
	    };
	    var handleHoverEffect = function(){
	        $("[rel='tooltip']").tooltip();    
	 
	        $('.thumbnail').hover(
	            function(){
	                $(this).find('.caption').slideDown(250); //.fadeIn(250)
	            },
	            function(){
	                $(this).find('.caption').slideUp(250); //.fadeOut(205)
	            }
	        );     
	    };

	    var handleLightbox = function() {
	    	$('.mix-zoom').click(function(){
	    		$('#lightbox-modal img').attr('src', $(this).attr('data-img'));
	    	});
	    };
	    
	    return{
	        init: function () {
	            handleMixitup();
	            handleHoverEffect();
	            handleLightbox();
	        }
	    };
	}(jQuery);
	page_gallery.init();
});
App.controller('PageMailController', function ($scope, $routeParams){
    var page_mail = function() {
	    //Init wysihtml5
	    var handlePageMail = function() {
	        $('.wysihtml5').wysihtml5();    
	    };

	    return{
	        init: function () {
	            handlePageMail();
	        }
	    };
	}(jQuery);
	
	page_mail.init();

});
App.controller('TableAdvancedController', function ($scope, $routeParams){
    var table_advanced = function() {

	    var handleDatatable = function(){
	        var spinner = $( ".spinner" ).spinner();
	        var table = $('#table_id').dataTable( {
	            "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
	            "order": [[ 1, "asc" ]],
	            "aoColumnDefs" : [ {
	                'bSortable' : false,
	                'aTargets' : [ 0 ]
	            } ]
	        } );

	        var tableTools = new $.fn.dataTable.TableTools( table, {
	            "sSwfPath": "../assets/vendors/DataTables/extensions/TableTools/swf/copy_csv_xls_pdf.swf",
	            "buttons": [
	                "copy",
	                "csv",
	                "xls",
	                "pdf",
	                { "type": "print", "buttonText": "Print me!" }
	            ]
	        } );
	        $(".DTTT_container").css("float","right");
	    };
	    return{
	        init: function () {
	            handleDatatable();
	        }
	    };
	}(jQuery);
	
	setTimeout(function(){
        table_advanced.init();
    },500);
	

});
App.controller('TableTreegridController', function ($scope, $routeParams){
    var table_treegrid = function() {

	    //BEGIN JQUERY TREEGRID
	    var handleTreeGrid = function(){
	        $('.tree-projects').treegrid({
	            expanderExpandedClass: 'fa fa-caret-down',
	            expanderCollapsedClass: 'fa fa-caret-right'
	        });
	    };
	    //END JQUERY TREEGRID

	    return{
	        init: function () {
	            handleTreeGrid();
	        }
	    };
	}(jQuery);

	table_treegrid.init();


});
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
App.controller('UiModalsController', function ($scope, $routeParams){
    
});
App.controller('UiNestableListController', function ($scope, $routeParams){
    var ui_nestable_list = function() {

	    var handleNestablelist = function(){
	        var updateOutput = function(e)
	        {
	            var list   = e.length ? e : $(e.target),
	                output = list.data('output');
	            if (window.JSON) {
	                output.val(window.JSON.stringify(list.nestable('serialize')));//, null, 2));
	            } else {
	                output.val('JSON browser support required for this demo.');
	            }
	        };

	        // activate Nestable for list 1
	        $('#nestable').nestable({
	            group: 1
	        }).on('change', updateOutput);

	        // activate Nestable for list 2
	        $('#nestable2').nestable({
	            group: 1
	        }).on('change', updateOutput);

	        // output initial serialised data
	        updateOutput($('#nestable').data('output', $('#nestable-output')));
	        updateOutput($('#nestable2').data('output', $('#nestable2-output')));

	        $('#nestable-menu').on('click', function(e)
	        {
	            var target = $(e.target),
	                action = target.data('action');
	            if (action === 'expand-all') {
	                $('.dd').nestable('expandAll');
	            }
	            if (action === 'collapse-all') {
	                $('.dd').nestable('collapseAll');
	            }
	        });

	        $('#nestable3').nestable();
	    };
	    return{
	        init: function () {
	            handleNestablelist();
	        }
	    };
	}(jQuery);

	ui_nestable_list.init();
});
App.controller('UiPanelsController', function ($scope, $routeParams){
    var ui_panels = function() {

	    var handlePanelScroll = function() {
	        $('.panel-scroll').slimScroll({
	            "width": '100%',
	            "height": '140px',
	            "wheelStep": 5
	        });
	    };

	    return{
	        init: function () {
	            handlePanelScroll();
	        }
	    };

	}(jQuery);

	ui_panels.init();
});
App.controller('UiTabsAccordionsController', function ($scope, $routeParams){
	$(function () {

	    //BEGIN ACCORDION WITH ICONS
	    function toggleChevron(e) {
	        $(e.target)
	            .prev('.panel-heading')
	            .find("i.indicator")
	            .toggleClass('glyphicon-chevron-left glyphicon-chevron-down');
	    }
	    $('#accordion1').on('hidden.bs.collapse', toggleChevron);
	    $('#accordion1').on('shown.bs.collapse', toggleChevron);
	    //END ACCORDION WITH ICONS


	        $(".closeTab").click(function () {
	            //there are multiple elements which has .closeTab icon so close the tab whose close icon is clicked
	            var tabContentId = $(this).parent().attr("href");
	            $(this).parent().parent().remove(); //remove li of tab
	            $('#myCloseableTab a:first').tab('show'); // Select first tab
	            
	            var tabId = $('#myTabCloseable a:first').attr('href'); // Select id to active first tab
	            $(tabid).show();   // Show tabcontent first

	            $(tabContentId).remove(); //remove respective tab content
	        });
	});

	ui_tabs_accordions.init();
});
App.controller('UiToastrListController', function ($scope, $routeParams){
    var ui_toastr = function() {
	    var i = -1;
	    var toastCount = 0;
	    var $toastlast;

	    var getMessage = function () {
	        var msgs = ["Hello! We are awesome admin template, we hope it's helpful for you.",
	            'Is it not perfect? Yes, we will improve',
	            'Happy coding!',
	            'Send us your amazing ideas ',
	            "Let's make awesome thing together!"
	        ];
	        i++;
	        if (i === msgs.length) {
	            i = 0;
	        }

	        return msgs[i];
	    };
	    var handleShowToasts=function() {
	        $('#showtoast').click(function () {
	            var shortCutFunction = $("#toastTypeGroup input:radio:checked").val();
	            var msg = $('#message').val();
	            var title = $('#title').val() || '';
	            var $showDuration = $('#showDuration');
	            var $hideDuration = $('#hideDuration');
	            var $timeOut = $('#timeOut');
	            var $extendedTimeOut = $('#extendedTimeOut');
	            var $showEasing = $('#showEasing');
	            var $hideEasing = $('#hideEasing');
	            var $showMethod = $('#showMethod');
	            var $hideMethod = $('#hideMethod');
	            var toastIndex = toastCount++;

	            toastr.options = {
	                closeButton: $('#closeButton').prop('checked'),
	                debug: $('#debugInfo').prop('checked'),
	                positionClass: $('#positionGroup input:radio:checked').val() || 'toast-top-right',
	                onclick: null
	            };

	            if ($('#addBehaviorOnToastClick').prop('checked')) {
	                toastr.options.onclick = function () {
	                    alert('You can perform some custom action after a toast goes away');
	                };
	            }

	            if ($showDuration.val().length) {
	                toastr.options.showDuration = $showDuration.val();
	            }

	            if ($hideDuration.val().length) {
	                toastr.options.hideDuration = $hideDuration.val();
	            }

	            if ($timeOut.val().length) {
	                toastr.options.timeOut = $timeOut.val();
	            }

	            if ($extendedTimeOut.val().length) {
	                toastr.options.extendedTimeOut = $extendedTimeOut.val();
	            }

	            if ($showEasing.val().length) {
	                toastr.options.showEasing = $showEasing.val();
	            }

	            if ($hideEasing.val().length) {
	                toastr.options.hideEasing = $hideEasing.val();
	            }

	            if ($showMethod.val().length) {
	                toastr.options.showMethod = $showMethod.val();
	            }

	            if ($hideMethod.val().length) {
	                toastr.options.hideMethod = $hideMethod.val();
	            }

	            if (!msg) {
	                msg = getMessage();
	            }

	            $("#toastrOptions").text("Command: toastr["
	                + shortCutFunction
	                + "](\""
	                + msg
	                + (title ? "\", \"" + title : '')
	                + "\")\n\ntoastr.options = "
	                + JSON.stringify(toastr.options, null, 2)
	            );

	            var $toast = toastr[shortCutFunction](msg, title); // Wire up an event handler to a button in the toast, if it exists
	            $toastlast = $toast;
	            if ($toast.find('#okBtn').length) {
	                $toast.delegate('#okBtn', 'click', function () {
	                    alert('you clicked me. i was toast #' + toastIndex + '. goodbye!');
	                    $toast.remove();
	                });
	            }
	            if ($toast.find('#surpriseBtn').length) {
	                $toast.delegate('#surpriseBtn', 'click', function () {
	                    alert('Surprise! you clicked me. i was toast #' + toastIndex + '. You could perform an action here.');
	                });
	            }
	            $(".pulsate").each(function () {
	                $(this).pulsate();
	            });

	        });
	    };
	    function getLastToast(){
	        return $toastlast;
	    }
	    var handleClearLastToasts = function() {
	        $('#clearlasttoast').click(function () {
	            toastr.clear(getLastToast());
	        });
	    };
	    var handleClearToasts = function() {
	        $('#cleartoasts').click(function () {
	            toastr.clear();
	        });
	    };
	    return{
	        init: function () {
	            handleShowToasts();
	            handleClearLastToasts();
	            handleClearToasts();
	        }
	    };
	}(jQuery);
	$.fn.Button.core();
	ui_toastr.init();
});
App.controller('UiTreeviewController', function ($scope, $routeParams){
    var ui_treeview = function() {
	    var setting = {
	        check: {
	            enable: true
	        },
	        data: {
	            simpleData: {
	                enable: true
	            }
	        }
	    };

	    var zNodes = [
	        { id: 1, pId: 0, name: "can check 1", open: true},
	        { id: 11, pId: 1, name: "can check 1-1", open: true},
	        { id: 111, pId: 11, name: "can check 1-1-1"},
	        { id: 112, pId: 11, name: "can check 1-1-2"},
	        { id: 12, pId: 1, name: "can check 1-2", open: true},
	        { id: 121, pId: 12, name: "can check 1-2-1"},
	        { id: 122, pId: 12, name: "can check 1-2-2"},
	        { id: 2, pId: 0, name: "can check 2", checked: true, open: true},
	        { id: 21, pId: 2, name: "can check 2-1"},
	        { id: 22, pId: 2, name: "can check 2-2", open: true},
	        { id: 221, pId: 22, name: "can check 2-2-1", checked: true},
	        { id: 222, pId: 22, name: "can check 2-2-2"},
	        { id: 23, pId: 2, name: "can check 2-3"}
	    ];


	//BEGIN BASIC
	    var settingBasic = {
	        data: {
	            key: {
	                title: "title"
	            },
	            simpleData: {
	                enable: true
	            }
	        }
	    };

	    var zNodesBasic = [
	        { id: 1, pId: 0, name: "pNode 1", title: "", open: true},
	        { id: 11, pId: 1, name: "pNode 11", title: ""},
	        { id: 111, pId: 11, name: "leaf node  111", title: "", isHidden: true},
	        { id: 112, pId: 11, name: "leaf node  112", title: ""},
	        { id: 113, pId: 11, name: "leaf node  113", title: ""},
	        { id: 12, pId: 1, name: "pNode 12", title: "", isHidden: true},
	        { id: 121, pId: 12, name: "leaf node  121", title: ""},
	        { id: 122, pId: 12, name: "leaf node  122", title: "", isHidden: true},
	        { id: 123, pId: 12, name: "leaf node  123", title: ""},
	        { id: 2, pId: 0, name: "pNode 2", title: "", open: true},
	        { id: 21, pId: 2, name: "pNode 21", title: "", isHidden: true},
	        { id: 211, pId: 21, name: "leaf node  211", title: ""},
	        { id: 212, pId: 21, name: "leaf node  212", title: ""},
	        { id: 213, pId: 21, name: "leaf node  213", title: ""},
	        { id: 22, pId: 2, name: "pNode 22", title: ""},
	        { id: 221, pId: 22, name: "leaf node  221", title: ""},
	        { id: 222, pId: 22, name: "leaf node  222", title: ""},
	        { id: 223, pId: 22, name: "leaf node  223", title: ""},
	        { id: 3, pId: 0, name: "pNode 3", title: "", open: true},
	        { id: 31, pId: 3, name: "pNode 31", title: ""},
	        { id: 311, pId: 31, name: "leaf node 311", title: "", isHidden: true},
	        { id: 312, pId: 31, name: "leaf node  312", title: ""},
	        { id: 313, pId: 31, name: "leaf node  313", title: ""},
	        { id: 32, pId: 4, name: "pNode 32", title: "", isHidden: true},
	        { id: 321, pId: 32, name: "leaf node  321", title: ""},
	        { id: 322, pId: 32, name: "leaf node  322", title: "", isHidden: true},
	        { id: 323, pId: 32, name: "leaf node  323", title: ""},
	        { id: 4, pId: 0, name: "pNode 4", title: "", open: true},
	        { id: 41, pId: 4, name: "pNode 41", title: "", isHidden: true},
	        { id: 411, pId: 41, name: "leaf node  411", title: ""},
	        { id: 412, pId: 41, name: "leaf node  412", title: ""},
	        { id: 413, pId: 41, name: "leaf node  413", title: ""},
	        { id: 42, pId: 4, name: "pNode 42", title: ""},
	        { id: 421, pId: 42, name: "leaf node  421", title: ""},
	        { id: 422, pId: 42, name: "leaf node 422", title: ""},
	        { id: 423, pId: 42, name: "leaf node 423", title: ""}
	    ];
	//END BASIC

	//BEGIN DRANG TREE
	    var settingDrag = {
	        edit: {
	            enable: true,
	            showRemoveBtn: false,
	            showRenameBtn: false
	        },
	        data: {
	            simpleData: {
	                enable: true
	            }
	        },
	        callback: {
	            beforeDrag: beforeDrag,
	            beforeDrop: beforeDrop
	        }
	    };

	    var zNodesDrag = [
	        { id: 1, pId: 0, name: "can drag 1", open: true},
	        { id: 11, pId: 1, name: "can drag 1-1"},
	        { id: 12, pId: 1, name: "can drag 1-2", open: true},
	        { id: 121, pId: 12, name: "can drag 1-2-1"},
	        { id: 122, pId: 12, name: "can drag 1-2-2"},
	        { id: 123, pId: 12, name: "can drag 1-2-3"},
	        { id: 13, pId: 1, name: "can't drag 1-3", open: true, drag: false},
	        { id: 131, pId: 13, name: "can't drag 1-3-1", drag: false},
	        { id: 132, pId: 13, name: "can't drag 1-3-2", drag: false},
	        { id: 133, pId: 13, name: "can drag 1-3-3"},
	        { id: 2, pId: 0, name: "can drag 2", open: true},
	        { id: 21, pId: 2, name: "can drag 2-1"},
	        { id: 22, pId: 2, name: "can't drop 2-2", open: true, drop: false},
	        { id: 221, pId: 22, name: "can drag 2-2-1"},
	        { id: 222, pId: 22, name: "can drag 2-2-2"},
	        { id: 223, pId: 22, name: "can drag 2-2-3"},
	        { id: 23, pId: 2, name: "can drag 2-3"}
	    ];
	//END DRANG TREE
	//BEGIN RADIO
	    var settingRadio = {
	        check: {
	            enable: true,
	            chkStyle: "radio",
	            radioType: "level"
	        },
	        data: {
	            simpleData: {
	                enable: true
	            }
	        }
	    };

	    var zNodesRadio = [
	        { id: 1, pId: 0, name: "can check 1", open: true},
	        { id: 11, pId: 1, name: "can check 1-1", open: true},
	        { id: 111, pId: 11, name: "can check 1-1-1"},
	        { id: 112, pId: 11, name: "can check 1-1-2"},
	        { id: 12, pId: 1, name: "can check 1-2", open: true},
	        { id: 121, pId: 12, name: "can check 1-2-1"},
	        { id: 122, pId: 12, name: "can check 1-2-2"},
	        { id: 2, pId: 0, name: "can check 2", checked: true, open: true},
	        { id: 21, pId: 2, name: "can check 2-1"},
	        { id: 22, pId: 2, name: "can check 2-2", open: true},
	        { id: 221, pId: 22, name: "can check 2-2-1", checked: true},
	        { id: 222, pId: 22, name: "can check 2-2-2"},
	        { id: 23, pId: 2, name: "can check 2-3"}
	    ];

	//END RADIO

	    function beforeDrag(treeId, treeNodes) {
	        for (var i = 0, l = treeNodes.length; i < l; i++) {
	            if (treeNodes[i].drag === false) {
	                return false;
	            }
	        }
	        return true;
	    }

	    function beforeDrop(treeId, treeNodes, targetNode, moveType) {
	        return targetNode ? targetNode.drop !== false : true;
	    }


	//BEGIN EDIT
	    var settingEdit = {
	        edit: {
	            enable: true
	        },
	        data: {
	            simpleData: {
	                enable: true
	            }
	        },
	        callback: {
	            beforeDrag: beforeDrag
	        }
	    };

	    var zNodesEdit = [
	        { id: 1, pId: 0, name: "parent node 1", open: true},
	        { id: 11, pId: 1, name: "leaf node 1-1"},
	        { id: 12, pId: 1, name: "leaf node 1-2"},
	        { id: 13, pId: 1, name: "leaf node 1-3"},
	        { id: 2, pId: 0, name: "parent node 2", open: true},
	        { id: 21, pId: 2, name: "leaf node 2-1"},
	        { id: 22, pId: 2, name: "leaf node 2-2"},
	        { id: 23, pId: 2, name: "leaf node 2-3"},
	        { id: 3, pId: 0, name: "parent node 3", open: true },
	        { id: 31, pId: 3, name: "leaf node 3-1"},
	        { id: 32, pId: 3, name: "leaf node 3-2"},
	        { id: 33, pId: 3, name: "leaf node 3-3"}
	    ];

	//BEGIN EDIT


	//BEGIN SEARCH DATA
	    var settingSearch = {
	        data: {
	            key: {
	                title: "t"
	            },
	            simpleData: {
	                enable: true
	            }
	        },
	        view: {
	            fontCss: getFontCss
	        }
	    };

	    var zNodesSearch = [
	        { id: 1, pId: 0, name: "search node demo 1", t: "id=1", open: true},
	        { id: 11, pId: 1, name: "can search 'name'", t: "id=11"},
	        { id: 12, pId: 1, name: "can search 'level'", t: "id=12"},
	        { id: 13, pId: 1, name: "can search 'id'", t: "id=13"},
	        { id: 14, pId: 1, name: "can search other attr", t: "id=14"},
	        { id: 2, pId: 0, name: "search node demo 2", t: "id=2", open: true},
	        { id: 21, pId: 2, name: "can search single node", t: "id=21"},
	        { id: 22, pId: 2, name: "can search nodes array", t: "id=22"},
	        { id: 23, pId: 2, name: "search me", t: "id=23"},
	        { id: 3, pId: 0, name: "search node demo 3", t: "id=3", open: true },
	        { id: 31, pId: 3, name: "My id is : 31", t: "id=31"},
	        { id: 32, pId: 31, name: "My id is : 32", t: "id=32"},
	        { id: 33, pId: 32, name: "My id is : 33", t: "id=33"}
	    ];

	    function focusKey(e) {
	        if (key.hasClass("empty")) {
	            key.removeClass("empty");
	        }
	    }

	    function blurKey(e) {
	        if (key.get(0).value === "") {
	            key.addClass("empty");
	        }
	    }

	    var lastValue = "", nodeList = [], fontCss = {};

	    function clickRadio(e) {
	        lastValue = "";
	        searchNode(e);
	    }

	    function searchNode(e) {
	        var zTree = $.fn.zTree.getZTreeObj("treeDemo");

	        var value = $.trim(key.get(0).value);
	        var keyType = "name";

	        if (key.hasClass("empty")) {
	            value = "";
	        }
	        if (lastValue === value) return;
	        lastValue = value;
	        if (value === "") return;
	        updateNodes(false);


	        nodeList = zTree.getNodesByParamFuzzy(keyType, value);
	        updateNodes(true);

	    }

	    function updateNodes(highlight) {
	        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	        for (var i = 0, l = nodeList.length; i < l; i++) {
	            nodeList[i].highlight = highlight;
	            zTree.updateNode(nodeList[i]);
	        }
	    }

	    function getFontCss(treeId, treeNode) {
	        return (!!treeNode.highlight) ? {color: "#A60000", "font-weight": "bold"} : {color: "#333", "font-weight": "normal"};
	    }

	    function filter(node) {
	        return !node.isParent && node.isFirstNode;
	    }

	//END SEARCH DATA


	    var handleZTree = function () {

	        $.fn.zTree.init($("#demoBasic"), settingBasic, zNodesBasic);
	        $.fn.zTree.init($("#demoCheck"), setting, zNodes);

	        $.fn.zTree.init($("#demoRadio"), settingRadio, zNodesRadio);

	        $.fn.zTree.init($("#demoDrag"), settingDrag, zNodesDrag);

	        $.fn.zTree.init($("#demoEdit"), settingEdit, zNodesEdit);
	        $.fn.zTree.init($("#treeDemo"), settingSearch, zNodesSearch);
	        key = $("#key");
	        key.bind("focus", focusKey)
	            .bind("blur", blurKey)
	            .bind("propertychange", searchNode)
	            .bind("input", searchNode);


	    };
	    return{
	        init: function () {
	            handleZTree();
	        }
	    };
	}(jQuery);
	setTimeout(function(){
		ui_treeview.init();	
	},500);
	
});
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
App.directive("ngAccordion", function($parse, $compile){
    return {
        link: function($scope, element, attributes){
            $scope._accordion = {status:[], collapse:{}};

            $scope._accordion.collapse = function(i){
                for(var j=0; j<$scope._accordion.status.length; j++){
                    if(i==j)
                        continue;
                    $scope._accordion.status[j] = true;
                }
                $scope._accordion.status[i] = !$scope._accordion.status[i];
            };

            $(">div", attributes.$$element).each(function(index, item){
                $scope._accordion.status[index] = true;
                $(">.panel-heading>a", item).attr({'ng-click': '_accordion.collapse('+index+')', 'index':index});
                $(">.panel-collapse", item).attr({'collapse': '_accordion.status['+index+']', 'index':index});
            });

            element.html($compile(element.html())($scope));
        }
    };
});
App.directive("ngAnimation", function($parse, $compile){
    return {
        link: function($scope, element, attributes){
            $scope._animation_change = function(v){
                $scope.header.effect = v;
            };

            attributes.$$element.find('button').each(function(index, value){
                $(this).attr({'ng-click': "_animation_change('"+$(this).attr('data-value')+"')"});
            });

            element.html($compile(element.html())($scope));
        }
    };
});
App.directive("ngAreachartspline", function(){
    return {
        link: function($scope, element, attributes){
            //BEGIN AREA CHART SPLINE
            var d6_1 = [["Jan", 67],["Feb", 91],["Mar", 36],["Apr", 150],["May", 28],["Jun", 123],["Jul", 38]];
            var d6_2 = [["Jan", 59],["Feb", 49],["Mar", 45],["Apr", 94],["May", 76],["Jun", 22],["Jul", 31]];
            $.plot("#area-chart-spline", [{
                data: d6_1,
                label: "Upload",
                color: "#ffce54"
            },{
                data: d6_2,
                label: "Download",
                color: "#01b6ad"
            }], {
                series: {
                    lines: {
                        show: !1
                    },
                    splines: {
                        show: !0,
                        tension: 0.4,
                        lineWidth: 2,
                        fill: 0.8
                    },
                    points: {
                        show: !0,
                        radius: 4
                    }
                },
                grid: {
                    borderColor: "#fafafa",
                    borderWidth: 1,
                    hoverable: !0
                },
                tooltip: !0,
                tooltipOpts: {
                    content: "%x : %y",
                    defaultTheme: true
                },
                xaxis: {
                    tickColor: "#fafafa",
                    mode: "categories"
                },
                yaxis: {
                    tickColor: "#fafafa"
                },
                shadowSize: 0
            });
            //END AREA CHART SPLINE
        }
    };
});
App.directive("ngDropzone", function($parse, $compile){
    return {
        link: function($scope, element, attributes){
            $(attributes.$$element).dropzone({
                url: "http://www.torrentplease.com/dropzone.php",
                maxFilesize: 100,
                paramName: "uploadfile",
                maxThumbnailFilesize: 5,
                init: function() {
                    //$scope.files.push({file: 'added'}); // here works
                    this.on('success', function(file, json) {
                    });

                    this.on('addedfile', function(file) {
                        $scope.$apply(function(){
                            //alert(file);
                            //$scope.files.push({file: 'added'});
                        });
                    });

                    this.on('drop', function(file) {
                        //alert('file');
                    });

                }

            });
        }
    };
});

App.directive("ngGeneraltab", function(){
    return {
        link: function (scope, element, attrs) {
            element.click(function(e) {
                e.preventDefault();
            });
        }
    };
});
App.directive("ngMenu", function($parse, $compile){
    return {
        link: function($scope, element, attributes){
            $scope._menu = {status:[], collapse:{}, hover:[]};
			
			$scope._menu.mouseleave = function(){
				for(var j=0; j<$scope._menu.hover.length; j++){
					$scope._menu.hover[j] = '';
				}
			};
			$scope._menu.mouseover = function(i){
				for(var j=0; j<$scope._menu.hover.length; j++){
					$scope._menu.hover[j] = '';
				}
				$scope._menu.hover[i] = 'nav-hover';
			};
            $scope._menu.collapse = function(i){
                $scope._menu.status[i] = !$scope._menu.status[i];

                var current = attributes.$$element.find('a[index='+i+']');

                current.parent('li').addClass('active').siblings().removeClass('active').children('ul').each(function(){
                    $scope._menu.status[$(this).attr('index')] = true;
                });

                if(current.hasClass('btn-fullscreen')){
                    if (!document.fullscreenElement &&
                        !document.mozFullScreenElement && !document.webkitFullscreenElement && !document.msFullscreenElement){
                        if (document.documentElement.requestFullscreen) {
                            document.documentElement.requestFullscreen();
                        } else if (document.documentElement.msRequestFullscreen) {
                            document.documentElement.msRequestFullscreen();
                        } else if (document.documentElement.mozRequestFullScreen) {
                            document.documentElement.mozRequestFullScreen();
                        } else if (document.documentElement.webkitRequestFullscreen) {
                            document.documentElement.webkitRequestFullscreen(Element.ALLOW_KEYBOARD_INPUT);
                        }
                    } else {
                        if (document.exitFullscreen) {
                            document.exitFullscreen();
                        } else if (document.msExitFullscreen) {
                            document.msExitFullscreen();
                        } else if (document.mozCancelFullScreen) {
                            document.mozCancelFullScreen();
                        } else if (document.webkitExitFullscreen) {
                            document.webkitExitFullscreen();
                        }
                    }
                }
            };

            attributes.$$element.find('li').children('a').each(function(index, value){
                $scope._menu.status[index] = true;
                $(this).attr({'ng-click': '_menu.collapse('+index+')', 'index':index});
                $('>ul', $(this).parent('li')).attr({'collapse': '_menu.status['+index+']', 'index':index});
            });
			
			$(">li", attributes.$$element).each(function(index, value){
				$scope._menu.hover[index] = '';
				$(this).attr({'ng-mouseleave':'_menu.mouseleave()', 'ng-mouseover': '_menu.mouseover('+index+')', 'ng-class':'_menu.hover['+index+']'});
			});
 
            element.html($compile(element.html())($scope));
        }
    };
});
App.directive("ngTab", function($parse, $compile){
    return {
        link: function($scope, element, attributes){
            $("a", element).click(function(e){
                e.preventDefault();
            });
        }
    };
});
App.directive("scrollSpy", function($window){
    return {
        restrict: 'A',
        controller: function ($scope) {
            $scope.spies = [];
            this.addSpy = function (spyObj) {
                $scope.spies.push(spyObj);
            };
        },
        link: function (scope, elem, attrs) {
            var spyElems;
            spyElems = [];

            scope.$watch('spies', function (spies) {
                var spy, _i, _len, _results;
                _results = [];

                for (_i = 0, _len = spies.length; _i < _len; _i++) {
                    spy = spies[_i];

                    if (spyElems[spy.id] === null) {
                        _results.push(spyElems[spy.id] = elem.find('#' + spy.id));
                    }
                }
                return _results;
            });

            $($window).scroll(function () {
                var highlightSpy, pos, spy, _i, _len, _ref;
                highlightSpy = null;
                _ref = scope.spies;

                // cycle through `spy` elements to find which to highlight
                for (_i = 0, _len = _ref.length; _i < _len; _i++) {
                    spy = _ref[_i];
                    spy.out();

                    // catch case where a `spy` does not have an associated `id` anchor
                    if (spyElems === null || spyElems[spy.id] === null || spyElems[spy.id].offset() === undefined) {
                        continue;
                    }

                    if ((pos = spyElems[spy.id].offset().top) - $window.scrollY <= 0) {
                        // the window has been scrolled past the top of a spy element
                        spy.pos = pos;

                        if (highlightSpy === null) {
                            highlightSpy = spy;
                        }
                        if (highlightSpy.pos < spy.pos) {
                            highlightSpy = spy;
                        }
                    }
                }

                // select the last `spy` if the scrollbar is at the bottom of the page
                if ($(window).scrollTop() + $(window).height() >= $(document).height()) {
                    spy.pos = pos;
                    highlightSpy = spy;
                }

                return highlightSpy !== null ? highlightSpy["in"]() : void 0;
            });
        }
    };
});

App.directive('spy', function ($location, $anchorScroll){
    return {
        restrict: "A",
        require: "^scrollSpy",
        link: function(scope, elem, attrs, affix) {
            elem.click(function () {
                $location.hash(attrs.spy);
                $anchorScroll();
            });

            affix.addSpy({
                id: attrs.spy,
                in: function() {
                    elem.addClass('active');
                },
                out: function() {
                    elem.removeClass('active');
                }
            });
        }
    };
});