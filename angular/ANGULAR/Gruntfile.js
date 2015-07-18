"use strict";

module.exports = function(grunt) {
  // Project configuration.
  grunt.initConfig({
    // Config stuff
    project: {
      javascript: {
        ours: ['source/js/app.js', 'source/js/**/*.js']
      },
      secret: grunt.file.readJSON('./secret.json'),
      pkg: grunt.file.readJSON('./package.json')
    },
    less: {
      build: {
        files: {
            "app/assets/css/system.css" : "source/assets/css/system.less",
            "app/assets/css/system-responsive.css" : "source/assets/css/system-responsive.less",
            "app/global/css/core.css" : "source/global/css/core.less"
        }
      }
    },
    jade: {
      compile: {
        options: {
          data: {
            debug: false
          },
          pretty:true
        },
        files: {
            "app/index.html": ["source/jade/index.jade"],
            "app/templates/states/charts_chartjs.html": ["source/jade/templates/states/charts_chartjs.jade"],
            "app/templates/states/charts_flot.html": ["source/jade/templates/states/charts_flot.jade"],
            "app/templates/states/charts_sparklines.html": ["source/jade/templates/states/charts_sparklines.jade"],
            "app/templates/states/form_components.html": ["source/jade/templates/states/form_components.jade"],
            "app/templates/states/form_dropzone.html": ["source/jade/templates/states/form_dropzone.jade"],
            "app/templates/states/form_multiple_file_upload.html": ["source/jade/templates/states/form_multiple_file_upload.jade"],
            "app/templates/states/form_picker.html": ["source/jade/templates/states/form_picker.jade"],
            "app/templates/states/form_select.html": ["source/jade/templates/states/form_select.jade"],
            "app/templates/states/form_wizard.html": ["source/jade/templates/states/form_wizard.jade"],
            "app/templates/states/layout_boxed.html": ["source/jade/templates/states/layout_boxed.jade"],
            "app/templates/states/layout_full_width.html": ["source/jade/templates/states/layout_full_width.jade"],
            "app/templates/states/layout_header_fixed.html": ["source/jade/templates/states/layout_header_fixed.jade"],
            "app/templates/states/layout_horizontal_menu.html": ["source/jade/templates/states/layout_horizontal_menu.jade"],
            "app/templates/states/layout_sidebar_collapsed.html": ["source/jade/templates/states/layout_sidebar_collapsed.jade"],
            "app/templates/states/layout_sidebar_collapsed_fixed.html": ["source/jade/templates/states/layout_sidebar_collapsed_fixed.jade"],
            "app/templates/states/layout_sidebar_fixed.html": ["source/jade/templates/states/layout_sidebar_fixed.jade"],
            "app/templates/states/main.html": ["source/jade/templates/states/main.jade"],
            "app/templates/states/page_404.html": ["source/jade/templates/states/page_404.jade"],
            "app/templates/states/page_500.html": ["source/jade/templates/states/page_500.jade"],
            "app/templates/states/page_calendar.html": ["source/jade/templates/states/page_calendar.jade"],
            "app/templates/states/page_gallery.html": ["source/jade/templates/states/page_gallery.jade"],
            "app/templates/states/page_invoice.html": ["source/jade/templates/states/page_invoice.jade"],
            "app/templates/states/page_lock_screen.html": ["source/jade/templates/states/page_lock_screen.jade"],
            "app/templates/states/page_mail.html": ["source/jade/templates/states/page_mail.jade"],
            "app/templates/states/page_pricing_table.html": ["source/jade/templates/states/page_pricing_table.jade"],
            "app/templates/states/page_profile.html": ["source/jade/templates/states/page_profile.jade"],
            "app/templates/states/page_timeline.html": ["source/jade/templates/states/page_timeline.jade"],
            "app/templates/states/page_search.html": ["source/jade/templates/states/page_search.jade"],
            "app/templates/states/page_signin.html": ["source/jade/templates/states/page_signin.jade"],
            "app/templates/states/page_signup.html": ["source/jade/templates/states/page_signup.jade"],
            "app/templates/states/table_advanced.html": ["source/jade/templates/states/table_advanced.jade"],
            "app/templates/states/table_basic.html": ["source/jade/templates/states/table_basic.jade"],
            "app/templates/states/table_responsive.html": ["source/jade/templates/states/table_responsive.jade"],
            "app/templates/states/table_treegrid.html": ["source/jade/templates/states/table_treegrid.jade"],
            "app/templates/states/ui_buttons.html": ["source/jade/templates/states/ui_buttons.jade"],
            "app/templates/states/ui_datepaginator.html": ["source/jade/templates/states/ui_datepaginator.jade"],
            "app/templates/states/ui_general.html": ["source/jade/templates/states/ui_general.jade"],
            "app/templates/states/ui_icons.html": ["source/jade/templates/states/ui_icons.jade"],
            "app/templates/states/ui_nestable_list.html": ["source/jade/templates/states/ui_nestable_list.jade"],
            "app/templates/states/ui_panels.html": ["source/jade/templates/states/ui_panels.jade"],
            "app/templates/states/ui_sortable_list.html": ["source/jade/templates/states/ui_sortable_list.jade"],
            "app/templates/states/ui_tabs_accordions.html": ["source/jade/templates/states/ui_tabs_accordions.jade"],
            "app/templates/states/ui_typography.html": ["source/jade/templates/states/ui_typography.jade"],
            "app/templates/states/_includes/chat-form.html": ["source/jade/templates/states/_includes/chat-form.jade"],
            "app/templates/states/_includes/horizontal-menu.html": ["source/jade/templates/states/_includes/horizontal-menu.jade"],
            "app/templates/states/_includes/sidebar-main.html": ["source/jade/templates/states/_includes/sidebar-main.jade"],
            "app/templates/states/_includes/template-setting.html": ["source/jade/templates/states/_includes/template-setting.jade"],
            "app/templates/states/_includes/title-breadcrumb.html": ["source/jade/templates/states/_includes/title-breadcrumb.jade"],
            "app/templates/states/_includes/topbar.html": ["source/jade/templates/states/_includes/topbar.jade"]
        }
      }
    },
    watch: {
      file: '**/*.html',
      options: {
        livereload: true
      },
      styles: {
        files: ['**/*.less'],
        tasks: ['less'],
        options: {
          nospawn: true
        }
      },
      jade: {
        files: ['**/*.jade'],
        tasks: ['jade'],
        options: {
          nospawn: true
        }
      },
      gruntfile: {
        files: 'Gruntfile.js',
        tasks: ['default']
      }
      ,
      javascript: {
        files: '<%= project.javascript.ours %>',
        tasks: ['jshint', 'concat']
      }
    },
    concat: {
      javascript_ours: {
        options: {
          banner: '"use strict";\n' 
        },
        src: '<%= project.javascript.ours %>',
        dest: 'app/js/main.js'
      }
    },
    jshint: {
      options: {
        strict: false,
        laxbreak: true,
        debug: true,
        globals: {
          angular: true,
          $: true,
          _: true
        }
      },
      all: '<%= project.javascript.ours %>' 
    },
    concurrent: {
      target: {
        tasks: ['watch'],
        options: {
          logConcurrentOutput: true
        }
      }
    },
    copy: {
      main: {
        nonull: true,
        files: [
            // copy main angularjs components
            {dest: 'app/js/libs/jquery.min.js', src:'source/bower_components/jquery/jquery.min.js'},
            {dest: 'app/js/libs/angular.js', src:'source/bower_components/angular/angular.js'},
            {dest: 'app/js/libs/angular-route.js', src:'source/bower_components/angular-route/angular-route.js'},
            {dest: 'app/js/libs/angular-ui-router.js', src:'source/bower_components/angular-ui-router.js'},
            {dest: 'app/js/libs/ocLazyLoad.js', src:'source/bower_components/ocLazyLoad.js'},
            {dest: 'app/js/libs/ui-bootstrap.js', src:'source/bower_components/angular-bootstrap/ui-bootstrap.js'},
            // copy global components
            {expand: true, cwd: 'source/global/images/', dest: 'app/global/images/', src:'**'},
            {expand: true, cwd: 'source/global/js/', dest: 'app/global/js/', src:'**'},
            {expand: true, cwd: 'source/global/vendors/', dest: 'app/global/vendors/', src:'**'}
        ],
      },
    }
  });

  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-less');
  grunt.loadNpmTasks('grunt-contrib-jade');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-concurrent');
  grunt.loadNpmTasks('grunt-serve');
  
  // Default task(s).
  grunt.registerTask('default', ['copy', 'jade','less', 'jshint', 'concat', 'concurrent' ]);
  // Other special task(s)
  // In command screeen, type ">grunt js" or ">grunt ja" or ">grunt le"
  grunt.registerTask('js', ['jshint', 'concat','concurrent' ]);
  grunt.registerTask('ja', ['jade', 'concurrent']);
  grunt.registerTask('le', ['less', 'concurrent']);
};