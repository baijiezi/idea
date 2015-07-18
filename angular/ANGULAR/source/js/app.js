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
