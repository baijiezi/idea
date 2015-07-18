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