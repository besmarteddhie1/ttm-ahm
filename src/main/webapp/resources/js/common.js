var form_path = "forms/";
var form_ext = ".htm";
var form_change_password = "AHMDSUAM007";
var timeout;
var username;
var token;
var baseURL = "/ahmjxdsh000/api";
var baseURLRedirect = "/ahmjxdsh000";
var updateData = [];
var lastRequest;

var baseColorBookmark = new Array('#176CCC', '#11BDB8', '#0EB263', '#c79b10', '#c13d11');
var bookmarkSameBaseColor = 4;
var bookmarkedApps = [];

$(document).ajaxSend(function(event, request, settings) {
  $('#loading-indicator').show();
});
$(document).ajaxComplete(
  function(event,request,settings){
    $('#loading-indicator').hide();
    var responseText = request.responseJSON;
    if(responseText != undefined){
        if(responseText.stat == '401'){
             $('.ahm .login-outer').slideDown();
            lastRequest = settings;
        }
    }
  }
);

$(document).mouseup(
    function(e){
        var slideUp = true;
        var lookupVisible = $('.lookup-form:visible');
        var lookupWrapperVisible = $('.lookup-wrapper:has(.lookup-form:visible)');
        
        if($(e.target).closest('.lookup-form').hasClass('lookup-form')){
            if(lookupVisible.length > 0){
                if($(e.target).closest('.lookup-form').is(lookupVisible)){
                    slideUp = false;
                }
                
            }
        }
        
        if($(e.target).hasClass('input-lookup')){
            if(lookupWrapperVisible.length > 0){
                 if($(e.target).is($('.input-lookup', lookupWrapperVisible))){
                     slideUp = false;
                 }
            }
            
        }
        
        if(slideUp){
            $('.lookup-form').slideUp();
        }
    }
);

$(function() {
    /*
    $.fn.editable.defaults.mode = 'inline';
    $.fn.editable.defaults.showbuttons = false;
    $.fn.editable.defaults.type = 'text';
      */  
    
    /*
    var userData = new Object();
    userData.userName = "admin";
    userData.password = "admin";*/
	$.ajax
    ({
        type: "GET",
        url: baseURL+"/udm/whoami"
    })
    .done(function(user){
//    	console.log("user",user);
    	$('#username_login').html(user);
    	$('#username').val(user);
    })
    .fail(function(){
        console.log('failed user')
    });
	
    $.ajax
    ({
        type: "GET",
        url: baseURL+"/udm/menus"
    })
    .done(function(data){
        if(data){                 
            var menu_root = new Array();
            var htmlMenu = '';

            $.each(data, function(key, value){
                if(value.parent == null){
                    var rootObj = new Object();
                    rootObj.menuId = value.id;
                    rootObj.menuName = value.title;
                    htmlMenu += '<li class="treeview transition">'+
                    '<a href="#">'+
                    '<i class="'+value.icon+'"></i> <span>'+value.title+'</span>'+
                    '<i class="glyphicon glyphicon-chevron-down icon-menu-expand" style="float:right"></i>'+
                    '</a>';
                    htmlMenu = recursive_menu(rootObj, data, htmlMenu);
                    htmlMenu += '</li>';
                    menu_root.push(rootObj);
                } 
            });
                
            $('#ahmdsh1_menu_ul').html(htmlMenu);
                
            $('.treeview > a').click(function() {
                    
                //toggle selected menu active
                var curTreeview = $(this).parent().toggleClass('active');
                //change selected meno icon to up/down arrow
                $(this).children('.icon-menu-expand').toggleClass('glyphicon-chevron-up glyphicon-chevron-down');
                //slide selected menu
                var curMenu = $(this).next().slideToggle();

                //slideup all children            
                $.each($('ul', curTreeview),function(){
                    $('ul', $(this)).slideUp();
                });             
                //mark all children as inactive
                $('ul .treeview', curTreeview).removeClass('active');
                //change all children icon to down arrow
                $('ul .treeview a', curTreeview).children('.icon-menu-expand').removeClass('glyphicon-chevron-up');
                $('ul .treeview a', curTreeview).children('.icon-menu-expand').addClass('glyphicon-chevron-down');

                //slideup another menu in same level and its childs
                var curTreeviewSiblings = curTreeview.siblings('li').removeClass('active');
                $('a .icon-menu-expand', curTreeviewSiblings).removeClass('glyphicon-chevron-up');
                $('a .icon-menu-expand', curTreeviewSiblings).addClass('glyphicon-chevron-down');
                $('ul', curTreeviewSiblings).slideUp();



            });

            $('li.menu:not(.treeview) > a').click(function(e) {
                e.preventDefault();
                var formid = $(this).data('formid');
                var form_obj = $('#tablink_'+formid);
                if(form_obj.html() == undefined){
                    get_form(this);
                            
                } else{
                    form_obj.tab('show');
                    $('[role="tabpanel"].tab-pane').removeClass('active');
                    $('#tabpanel_'+formid).addClass('active');
                }
                return false;
            });


            listener_tabNav();
            $(window).resize(listener_tabNav);

            search_prepare();
            
            addBookmarkMenu();
        } else {
            //console.log(data.msg);
        }       
    })
    .fail(function(){
        //console.log('login failed')
    });
	
});

function getFormChangePassword(){
    var id = form_change_password;
    var menuid = form_change_password;
    var ctab = $('#tabpanel_'+id);
    var title = 'Change Password';
    if (ctab.length<=0) {
        // create tab
        ctab = $('<div role="tabpanel" class="tab-pane" data-formid="'+id+'" id="tabpanel_'+id+'">Loading...</div>').appendTo($('.maincontent_containers.tab-content'));
        $('<li role="presentation" data-formid="'+id+'" id="tablink_'+id+'" ><a href="#tabpanel_'+id+'" class="tablink" aria-controls="'+title+'" role="tab" data-toggle="tab">'+title+' </a><a href="#" class="closetabLink" onclick="removeTab(this);"><span class="glyphicon glyphicon glyphicon-remove" aria-hidden="true"></span></a></li>').appendTo($('.nav-tabs-container .nav-tabs'));
    } 
    $('#tablink_'+id+' a.tablink').click();
    listener_tabNav();
    
    $.get( id + form_ext,{
        'cb':(new Date).getTime()
    }, function( data ) {
        
        var tabPanel = $('#tabpanel_'+id);
        $('#tabpanel_'+id).html( '<div class="main-app">'+data+'</div>' );

        $('.btn-lookup', tabPanel).addClass('btn-primary').html('<span class="glyphicon glyphicon-search"></span>');

        $('#tabpanel_'+id).prepend('<div class="app-info"><div class="app-button"></div><ol class="breadcrumb"><li class="active"><span>'+title+'</span></li></ol></div>');

       // 
        var appVer = $('#'+id).data('version');
        $('#tabpanel_'+id).append('<div class="page-footer">'+id+' - Ver. '+appVer+'</div>');
    });
}

function search_prepare(){
    $('.mainmenu > ul li').each(function(){
        $(this).data('keys',$(this).text().toLowerCase().replace(/[\s\r\n]+/g,'|'));
    });
    $('.mainmenu-search input.form-control').keyup(search_crawl);
}

function search_crawl(){
    var key = $('.mainmenu-search input.form-control').val().toLowerCase();
    if (key=='') {
        $('.mainmenu li.treeview').removeClass('active');
        $('.mainmenu li.treeview a').children('.icon-menu-expand').addClass('glyphicon-chevron-down').removeClass('glyphicon-chevron-up');
        $('.mainmenu li.treeview').show();
        $('.mainmenu ul.treeview-menu').hide();
        $('.mainmenu > ul li').show();
    } else {
        $('.mainmenu li.treeview').addClass('active');
        $('.mainmenu li.treeview a').children('.icon-menu-expand').addClass('glyphicon-chevron-up').removeClass('glyphicon-chevron-down');
        $('.mainmenu > ul li').hide();
        $('.mainmenu > ul li:contains("'+key+'"), .mainmenu ul.treeview-menu').children('.icon-menu-expand').addClass('glyphicon-chevron-up').removeClass('glyphicon-chevron-down');
        $('.mainmenu > ul li:contains("'+key+'"), .mainmenu ul.treeview-menu').show();
    }
}

$.expr[":"].contains = $.expr.createPseudo(function(arg) {
    return function( elem ) {
        return $(elem).text().toUpperCase().indexOf(arg.toUpperCase()) >= 0;
    };
});

function listener_tabNav(){
    if($('.nav-tabs-container .nav-tabs')[0] != undefined){
        var ww = $('.nav-tabs-container .nav-tabs')[0].scrollWidth;
        if (ww > $('.nav-tabs-container .nav-tabs').width()) {
            $('.nav-tabs-container .nav-tabs').css('margin-right','65px');
            $('.nav-tabs-scroller').show();
        } else {
            $('.nav-tabs-container .nav-tabs').css('margin-right','0');
            $('.nav-tabs-scroller').hide();
        }/*
        if (ww > ($('.nav-tabs-container .nav-tabs').width() - $('#username_login').width()) ) {
            $('.nav-tabs-container .nav-tabs').addClass('with-username');
            $('.nav-tabs-scroller').show().addClass('with-username');
        } else {
            $('.nav-tabs-container .nav-tabs').removeClass('with-username');
            $('.nav-tabs-scroller').hide().removeClass('with-username');
        }*/
    }
}

function scrollTabNav(dir){
    var obj = $('.nav-tabs-container .nav-tabs');
    obj.animate({
        scrollLeft:(dir=='left'? '-=100':'+=100')
    });
}

function removeTab(obj){
    var li = $(obj).closest('li');
    var prevli = li.prev();
    var siblingli = li.siblings();
    var hasActive = false;
    $.each(siblingli, function(){
        if($(this).hasClass('active')){
            hasActive = true;
        }
    })
    if(!hasActive){
        prevli.addClass('active');
        var prevFormId = prevli.data('formid');
        $('#tabpanel_'+prevFormId).addClass('active');
    }
    var id = li.data('formid');
    $('#tabpanel_'+id+', #tablink_'+id).remove();
}
function menu_collapse(obj) {
    $('body').toggleClass('collapsed');
    $('.icon-toolbar', obj).toggleClass('flipX');
    return false;
}



function edit_custom_action(obj){
    var hasEdit = false;
    
    
    var editAction;
    
    var editAfterDisable;
    var fieldEditAfterDisable;
    var datafield = "action";
    if($(obj).data("custom-action") != undefined){
        var cusAction = $(obj).data("custom-action").split(",");
        for(i=0;i<cusAction.length; i++){
            if(cusAction[i].trim() == 'edit'){
                editAction = $(obj).data("edit-func");
                editAfterDisable = $(obj).data("edit-after-disable");
                fieldEditAfterDisable = $(obj).data("field-edit-after-disable");
                if(editAction != undefined){
                    hasEdit = true;
                    if(editAfterDisable != undefined){
                        if(fieldEditAfterDisable != undefined){
                            datafield=fieldEditAfterDisable;
                        }else{
                            datafield = "vstat";
                        }
                    }
                }
            }
        }
    }
    if(hasEdit){
        $('thead tr', obj).append('<th data-field="'+datafield+'" data-formatter="actionEditFormatter" data-events="actionEvents">Action</th>');
    } 
}

function add_custom_action(obj){
    var tableObj = $(obj).closest('.bootstrap-table');
    var hasAdd = false;
    var hasDel = false;
    
    var addAction;
    var delAction;
    if($(obj).data("custom-action") != undefined){
        var cusAction = $(obj).data("custom-action").split(",");
        for(i=0;i<cusAction.length; i++){
            if(cusAction[i].trim() == 'add'){
                addAction = $(obj).data("add-func");
                if(addAction != undefined){
                    hasAdd = true;
                }
            }
            if(cusAction[i].trim() == 'delete'){
                delAction = $(obj).data("delete-func");
                if(delAction != undefined){
                    hasDel = true;
                }
            }
            
        }
    }
    if(hasDel){
        $('.fixed-table-toolbar', tableObj).append('<div class="columns columns-right btn-group pull-right"><button class="btn btn-default small-button" onclick="'+delAction+'">Delete Selected Items</button></div>');
    }
    if(hasAdd){
        $('.fixed-table-toolbar', tableObj).append('<div class="columns columns-right btn-group pull-right"><button class="btn btn-default small-button" onclick="'+addAction+'">Add</button></div>');
    }
    
    
}
function actionEditFormatter(value, row, index) {
    // console.log('ppppppppppp',value);
    if(value){
        if(value=="AKTIF"){
            return [
            '<a class="edit ml10" href="javascript:;" title="Edit">',
            '<i class="glyphicon glyphicon-edit"></i>',
            '</a>'
            ].join('');
        }
    }else{
        return [
        '<a class="edit ml10" href="javascript:;" title="Edit">',
        '<i class="glyphicon glyphicon-edit"></i>',
        '</a>'
        ].join('');
    }
}
function actionRemoveFormatter(value, row, index) {
    return [
    '<a class="remove ml10" href="javascript:;" title="Remove">',
    '<i class="glyphicon glyphicon-remove" style="color:red"></i>',
    '</a>'
    ].join('');
}

window.actionEvents = {
    'click .edit': function (e, value, row, index) {
        var editAction = $(e.target).closest('table').data('edit-func');
        var args = new Array();
        args.push(e.target);
        args.push(row);
        args.push(index);
        
        window[editAction](e.target, row, index);
        
    },
    'click .remove': function (e, value, row, index) {
        
        var sourceId = $(e.target).closest('table').data('source-id');
        var obj = $(e.target).closest('table');
        var sourceObj = $('#'+sourceId);
        
        var objUniqueId = sourceObj.data('unique-id');
        var tblTempUniqueId = obj.data('unique-id');
        
        sourceObj.bootstrapTable('uncheckBy', {
            field:objUniqueId, 
            values:[row[objUniqueId]]
        });
        obj.bootstrapTable('remove', {
            field:tblTempUniqueId, 
            values:[row[tblTempUniqueId]]
        });
    }
};

function get_form(obj) {
    var id = $(obj).data("formid");
    var menuid = $(obj).data("menuid");
    var menuicon = $(obj).data("form-icon");
    var ctab = $('#tabpanel_'+id);
    var title = $(obj).text();
    if (ctab.length<=0) {
        // create tab
        ctab = $('<div role="tabpanel" class="tab-pane" data-formid="'+id+'" id="tabpanel_'+id+'">Loading...</div>').appendTo($('.maincontent_containers.tab-content'));
        $('<li role="presentation" data-formid="'+id+'" id="tablink_'+id+'" ><a href="#tabpanel_'+id+'" class="tablink" aria-controls="'+title+'" role="tab" data-toggle="tab"><span class="'+menuicon+'"></span>'+title+' </a><a href="#" class="closetabLink" onclick="removeTab(this);"><span class="glyphicon glyphicon glyphicon-remove" aria-hidden="true"></span></a></li>').appendTo($('.nav-tabs-container .nav-tabs'));
    } 
    $('#tablink_'+id+' a.tablink').click();
    listener_tabNav();
    var postData = new Object();
    postData.menuId = ''+menuid;
    postData.appId = id;
    _fw_post('/dashboard/appinfo', postData, function(data){
        if(data.stat == '200'){
            $.get( form_path + id + form_ext,{
                'cb':(new Date).getTime()
            }, function( data ) {
                var tabPanel = $('#tabpanel_'+id);
                $('#tabpanel_'+id).html( '<div class="main-app">'+data+'</div>' );
                
                $('.btn-lookup', tabPanel).addClass('btn-primary').html('<span class="glyphicon glyphicon-search"></span>');
                console.log(bookmarkedApps);
                console.log(id);
                if($.inArray(id, bookmarkedApps) == -1) {
                    $('#tabpanel_'+id).prepend('<div class="app-info"><div class="app-button"><button class="btn btn-default" onclick="refreshForm(this)"><span class="glyphicon glyphicon-refresh"></span></button><button class="btn btn-default" name="buttonBookmark" onclick="bookmarkApps(this)"><span class="glyphicon glyphicon-thumbs-up"></span></button></div><ol class="breadcrumb"><li class="active"><span>'+title+'</span></li></ol></div>');
                } else {
                    $('#tabpanel_'+id).prepend('<div class="app-info"><div class="app-button"><button class="btn btn-default" onclick="refreshForm(this)"><span class="glyphicon glyphicon-refresh"></span></button><button class="btn btn-default dislike" name="buttonBookmark" onclick="bookmarkApps(this)"><span class="glyphicon glyphicon-thumbs-up"></span></button></div><ol class="breadcrumb"><li class="active"><span>'+title+'</span></li></ol></div>');
                }
                
                
               // 
                var appVer = $('#'+id).data('version');
                $('#tabpanel_'+id).append('<div class="page-footer">'+id+' - Ver. '+appVer+'</div>');
                $('#datetimepicker1').datetimepicker({
                    locale:'id'
                });
                $('.panel-control .panel-button',tabPanel).prepend('<a class="panel-control-button" href="#" onclick="toggleMonitoring(this)"><span class="glyphicon glyphicon-chevron-left trasition"></span></a>');
     
                $('table', tabPanel).each(function(){
                    edit_custom_action(this);
                });
                $('table', tabPanel).bootstrapTable();
                $('table', tabPanel).each(function(){
                    add_custom_action(this);
                });


                //onkey enter
                $(':input:not([type="button"],[type="submit"],button)', tabPanel).keydown(function (e) {
                    if (e.keyCode == 13) {
                        $('.btn.default:first', tabPanel).click();
                    }
                });
                 
               


                $.each($('table', tabPanel), function(){

                    //checkbox table event oncheck all
                    $(this).on('check-all.bs.table', function (e, rows) {
                        var tblTempId = $(e.target).data('checkbox-table');

                        var objTblTemp = $('#'+tblTempId);

                        var tblTempUniqueId = objTblTemp.data('unique-id');
                        var objUniqueId = $(e.target).data('unique-id');

                        if(objTblTemp != undefined && tblTempId != undefined && objUniqueId != undefined){
                            $.each(rows, function(i, v){
                                var duplicate = false;
                                $.each(objTblTemp.bootstrapTable('getData'), function(index, val){
                                    if(v != undefined && val != undefined){
                                        if(v[objUniqueId] == val[tblTempUniqueId]){
                                            duplicate = true;
                                        }
                                    }
                                });
                                if(!duplicate){
                                    var dataDel = objTblTemp.bootstrapTable('getData');

                                    objTblTemp.bootstrapTable('insertRow', {
                                        index: dataDel.length, 
                                        row: v
                                    });

                                }
                            });
                        }

                    });

                    //checkbox table event oncheck
                    $(this).on('check.bs.table ', function (e, row) {
                        var tblTempId = $(e.target).data('checkbox-table');
                        var objTblTemp = $('#'+tblTempId);

                        var tblTempUniqueId = objTblTemp.data('unique-id');
                        var objUniqueId = $(e.target).data('unique-id');

                        if(objTblTemp != undefined){
                            var duplicate = false;
                            $.each(objTblTemp.bootstrapTable('getData'), function(i, v){
                                if(v != undefined && row != undefined){
                                    if(v[objUniqueId] == row[tblTempUniqueId]){
                                        duplicate = true;
                                    }
                                }

                            });

                            if(!duplicate){
                                var dataDel = objTblTemp.bootstrapTable('getData');

                                objTblTemp.bootstrapTable('insertRow', {
                                    index: dataDel.length, 
                                    row: row
                                });
                            }
                        }
                    });

                    //checkbox table event uncheck
                    $(this).on('uncheck.bs.table', function(e, row){
                        var tblTempId = $(e.target).data('checkbox-table');
                        var objTblTemp = $('#'+tblTempId);

                        var tblTempUniqueId = objTblTemp.data('unique-id');
                        var objUniqueId = $(e.target).data('unique-id');

                        $.each(objTblTemp.bootstrapTable('getData'), function(i, v){
                            if(v != undefined && row != undefined){
                                if(v[objUniqueId] == row[tblTempUniqueId]){
                                    objTblTemp.bootstrapTable('remove', {
                                        field: tblTempUniqueId, 
                                        values: [v[tblTempUniqueId]]
                                    });
                                } 
                            }
                        });

                    });

                    //checkbox table event uncheck all
                    $(this).on('uncheck-all.bs.table', function (e, rows) {
                        var tblTempId = $(e.target).data('checkbox-table');
                        var objTblTemp = $('#'+tblTempId);

                        var tblTempUniqueId = objTblTemp.data('unique-id');
                        var objUniqueId = $(e.target).data('unique-id');

                        $.each(rows, function(i, v){
                            var delFound = false;
                            $.each(objTblTemp.bootstrapTable('getData'), function(index, val){
                                if(v != undefined && val != undefined){
                                    if(v[objUniqueId] == val[tblTempUniqueId]){
                                        delFound = true;
                                    } 
                                }
                            });
                            if(delFound){
                                objTblTemp.bootstrapTable('remove', {
                                    field: tblTempUniqueId, 
                                    values: [v[tblTempUniqueId]]
                                });
                            } 
                        })

                    });

                    //checkbox table event preserve checkbox
                    $(this).on('post-body.bs.table', function(e){
                        var tblTempId = $(e.target).data('checkbox-table');
                        var objTblTemp = $('#'+tblTempId);

                        var tblTempUniqueId = objTblTemp.data('unique-id');
                        var objUniqueId = $(e.target).data('unique-id');

                        var data = $(e.target).bootstrapTable('getData');
                        $.each(data, function(index, val){
                            $.each(objTblTemp.bootstrapTable('getData'), function(i, v){
                                if(v != undefined){
                                    if(v[objUniqueId] == val[tblTempUniqueId]){
                                        $(e.target).bootstrapTable('check', index);
                                    }
                                }
                            }); 
                        });
                    });
                });



                //lookup
                $('.lookup', tabPanel).each(function() {
                    var isBindFunc = false;
                    var thisLookup = $(this);
                    var obj = $(this).parent();
                    var url = $(this).data("url");
                    var data_func = $(this).data("lookup-pre-func");
                    var data_func_change = $(this).data("lookup-change-func");
                    var data_bind_func = $(this).data('lookup-bind-func');
                    if(data_bind_func != undefined){
                        if(data_bind_func != ''){
                            var data_bind_func_f = window[data_bind_func];
                            if(typeof(data_bind_func_f) == 'function'){
                                isBindFunc = true;
                            }
                        }
                    }
                    var tableId = generateUUID();
                    var htmlVal = "<div class='lookup-form'><table id="+tableId+" data-method='post' data-url="+url+" data-content-type='application/json' data-data-type='json' data-query-params-type='limit' data-query-params='"+data_func+"' data-response-handler='loadData' data-side-pagination='server' data-pagination='true'>	<thead>	<tr>";
                    var data_callback = $(this).data("callback");
                    var columns = $(this).data("columns");

                    $.each(columns, function(index, element) {
                        htmlVal += "<th data-field='"+element.id+"' data-sortable='"+element.sortable+"' data-visible='"+element.visible+"'>"+element.name+"</th>";
                    });
                    obj.append(htmlVal);

                    if($(this).find('.input-lookup').attr('id') == undefined){
                        $(this).find('.input-lookup').attr('id', generateUUID());
                    }


                    $('#'+tableId).bootstrapTable();
                    var firstTime = true;
                    var fromButton = false;
                    $('#'+tableId).on('post-body.bs.table', function(e){
                        if(!isBindFunc){
                            var value_changed = false;
                            if(!firstTime && !fromButton){
                                var data = $('#'+tableId).bootstrapTable('getData', 'useCurrentPage');
                                //console.log(data);
                                if(data.length == 1){
                                    $.each(data_callback, function(key, val){
                                        if($(':input[name="'+key+'"]').length > 1) {
                                            
                                            $.each($(':input[name="'+key+'"]'), function(i,v){
                                                if($(this).val() == data[0][val]) {
                                                   $(this).attr('checked',true);
                                                }
                                            });
                                        } else {
                                            if($('#'+key).val() != data[0][val]){
                                                value_changed = true;
                                            }

                                            $('#'+key).val(data[0][val]);
                                        }
                                        
                                        
                                    });
                                    $(obj).find('.lookup-form').slideUp();

                                } else if(data.length == 0){
                                    $(obj).find('.lookup-form').slideDown();
                                    $.each(data_callback, function(key, val){
                                        value_changed = true;
                                        $('#'+key).val('');
                                    });

                                } else {
                                    $(obj).find('.lookup-form').slideDown();
                                }
                            }
                            if(value_changed){
                                var data_func_change_f = window[data_func_change];
                                if(typeof(data_func_change_f) == 'function'){
                                    data_func_change_f();
                                }
                            }
                        } else {
                            if(!firstTime && !fromButton){
                                $(obj).find('.lookup-form').slideDown();
                            }
                        }
                    });

                    $(this).find('.input-lookup').keyup(function(){
                        clearTimeout(timeout);
                        timeout = setTimeout(function(){
                            firstTime = false;
                            fromButton = false;
                            $('#'+tableId).bootstrapTable('refresh');

                        }, 500);

                    })

                    /*
                    $(this).find('.input-lookup').focusout(function() {
                        if($( document.activeElement ).attr('id') != $(obj).find('.lookup-form').attr('id')){
                            $(obj).find('.lookup-form').slideUp();
                        }

                    });*/

                    $(this).find('.btn-lookup').click(function(){
                        clearTimeout(timeout);
                        firstTime = false;
                        fromButton = true;
                        if($(obj).find('.lookup-form').is(":visible")){
                            $(obj).find('.lookup-form').slideUp();
                        }else{
                            $('#'+tableId).bootstrapTable('refresh');
                            $(obj).find('.lookup-form').slideDown();
                        }

                        
                    })


                    $('#'+tableId).on('click-row.bs.table', function (e, row, $element) {
                        if(!isBindFunc){
                            $(obj).find('.lookup-form').slideUp(); 
                            var value_changed = false;
                            $.each(data_callback, function(key, val){
                                if($('input[name="'+key+'"]').length > 1) {
                                    $.each($('input[name="'+key+'"]'), function(i,v){
                                        if($(this).val() == row[val]) {
                                           $(this).attr('checked',true);
                                        }
                                    });
                                } else {
                                    if($('#'+key).val() != row[val]){
                                        value_changed = true;
                                    }

                                    $('#'+key).val(row[val]);
                                }
                                /*
                                if($('#'+key).val() != row[val]){
                                    value_changed = true;
                                }
                                $('#'+key).val(row[val]);*/
                            });
                            if(value_changed){
                                var data_func_change_f = window[data_func_change];
                                if(typeof(data_func_change_f) == 'function'){
                                    data_func_change_f();
                                }
                            }
                        } else {
                            data_bind_func_f(row);
                            var inputLookup = thisLookup.find('.input-lookup');
                            //console.log(inputLookup.val());
                            var valLength = inputLookup.val().length *2;
                            inputLookup[0].setSelectionRange(valLength , valLength );
                        }

                    })
                });
            });
        }
    });
	
}

function _fw_subpage(obj, id, row){
    _fw_setMessage(obj);
    var parent = $(obj).closest('.div-app');
    if(parent.html() == undefined) {
        parent = $(obj).closest('.tab-pane');
    }
    $('.subpage.subpage-default', parent).removeClass('subpage-default');
    var targetSubpage = $('#'+id);
    _fw_validation_clear(targetSubpage);
    $(targetSubpage).addClass('subpage-default');
    
    //----------------control breadcrumb-----------------------
    var tpath = targetSubpage.data('path').split('/');
    
    var tabObj = $(obj).closest('.main-app').prev();
    var breadcrumb = $('ol.breadcrumb', tabObj);
    var listLI = $('li', breadcrumb);
    
    var lengthListLI = listLI.length;
    
    while(lengthListLI < tpath.length) {
        breadcrumb.append('<li><a href="#"></a></li>');
        lengthListLI++;
    }
    
    lengthListLI = $('li', breadcrumb).length;
    while (lengthListLI > tpath.length) {
        listLI[listLI.length-1].remove();
        lengthListLI--;
    }

    var path = '';
    listLI = $('li', breadcrumb);
    $.each(listLI, function(i,v){
        $(this).removeClass('active')
        if(i==0) {
            path +=tpath[i];
        } else {
            path += '/'+tpath[i];
        }
        console.log(path);
        
        if(i < listLI.length-1) {
            $(this).html('<a href="#" onclick="_fw_breadcrumb(this, \''+$.trim(path)+'\');return false">'+$.trim(tpath[i])+'</a>');         
        }
        else if(i == listLI.length-1) {
            $(this).addClass('active');
            $(this).html('<span>'+$.trim(tpath[i])+'</span>');
        } 
    });
    //-----------end breadcrumb-------------
    automaticFill(row, targetSubpage);
    
    
}

function automaticFill(row, targetSubpage){
    if(row != undefined || row != null){       
        $.each($(':input', targetSubpage).not('input[type="radio"]', targetSubpage), function(){
            var inputObj = $(this);
            var datafield = $(this).data("field");
            $.each(row, function(key, value){
                if(datafield == key){
                    inputObj.val(value);
                } 
            });
        });
        
        $.each($('input[type="radio"]', targetSubpage), function(){
            var inputObj = $(this);
            var datafield = $(this).data("field");
            $.each(row, function(key, value){
                if(datafield == key){
                    if(inputObj.val() != undefined && value != undefined) {
                        if(inputObj.val().toLowerCase() == value.toLowerCase()){
                            inputObj.prop('checked', true);
                        }
                    }
                }
            });
        });
    }
}

function generateUUID(){
    var d = new Date().getTime();
    var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = (d + Math.random()*16)%16 | 0;
        d = Math.floor(d/16);
        return (c=='x' ? r : (r&0x3|0x8)).toString(16);
    });
    return uuid;
}
/*
function _fw_search(tableId, postUrl, searchkey, callback){
    // $('#'+tableId).bootstrapTable('destroy');
    $('#'+tableId).bootstrapTable({
        method : 'post',
        url : baseURL+postUrl,
        contentType : 'application/json',
        dataType : 'json',
        queryParamsType : 'limit',
        queryParams : function(params){
            params.search = {
                "any": searchkey
            };
            if(params.sort == undefined){
                return{
                    limit : params.limit,
                    offset : params.offset,
                    search : params.search
                }
            }
                
            return params;
        }
            
        ,
        responseHandler: function(resp){
            if(resp.stat != '401'){
                return {
                    rows : resp.rows,
                    total : resp.total
                };
            
            } 
        }
            
    });
    $('#'+tableId).bootstrapTable('refresh');
    if(typeof(callback) == 'function'){
        callback();
    }
    

}*/
/*
function generateTable(tableId, data, callback) {
    $('#'+tableId).bootstrapTable('destroy');
    $('#'+tableId).bootstrapTable({
        ajax : function(){
            $.ajax
            ({
                type: "POST",
                url: baseURL+postUrl,
                contentType: "application/json",
                dataType: 'json',
                async: false,
                headers: {
                    "Authorization": "Basic " + btoa(username + ":" + token)
                },
                data: JSON.stringify(searchData)
            })
            .done(function(data){
                generateTable(tableId, data, callback);
            })
            .fail(function(){
                alert('failed')
            });
        }
    });
    callback();
}
*/
function recursive_menu(menu_obj, array_data, html_string){
//	console.log("menu_obj", menu_obj);
//	console.log("array_data", array_data);
    var menu_childs = new Array();
    html_string += '<ul class="treeview-menu" style="display: none;">';
    var menuGroup = [];
    var appGroup = [];
    
    $.each(array_data, function(key, value){
        if(value.idApplication == null){
            menuGroup.push(this);
        } else {
            appGroup.push(this);
        }
    });
    
    $.each(menuGroup, function(key, value){
//    	console.log("value ==>", value);
        if(value.parent == menu_obj.menuId){
            var menu_child_obj = new Object();
            menu_child_obj.menuId = value.id;
            menu_child_obj.menuName = value.title;
            
            html_string += '<li class="menu treeview transition">'+
            '<a href="#">'+
            '<i class="'+value.icon+'"></i> <span>'+value.title+'</span>'+
            '<i class="glyphicon glyphicon-chevron-down icon-menu-expand" style="float:right"></i>'+
            '</a>';
            html_string = recursive_menu(menu_child_obj, array_data, html_string);
            html_string += '</li>';
                    
            menu_childs.push(menu_child_obj);
            
        }
    });
    
    $.each(appGroup, function(key, value){
        if(value.parent.id == menu_obj.menuId){
            var menu_child_obj = new Object();
            menu_child_obj.menuId = value.id;
            menu_child_obj.menuName = value.title;
            html_string += '<li class="menu transition">'+
            '<a data-menuid="'+value.id+'" data-formid="'+value.url+'" href="#" data-form-icon="'+value.icon+'">'+
            '<i class="glyphicon glyphicon-circle-o">'+
            '</i>'+value.title+
            '</a>'+
            '</li>';                
                     
            menu_childs.push(menu_child_obj);
            
        }
    });
    
    /*
    $.each(array_data, function(key, value){
        if(value.vparent == menu_obj.menuId){
            var menu_child_obj = new Object();
            menu_child_obj.menuId = value.vid;
            menu_child_obj.menuName = value.vtitle;
            if(value.vapplicationId == "null"){
                html_string += '<li class="menu treeview transition">'+
                '<a href="#">'+
                '<i class="'+value.vicon+'"></i> <span>'+value.vtitle+'</span>'+
                '<i class="glyphicon glyphicon-chevron-down icon-menu-expand" style="float:right"></i>'+
                '</a>';
                html_string = recursive_menu(menu_child_obj, array_data, html_string);
                html_string += '</li>';
            } else {
                html_string += '<li class="menu transition">'+
                '<a data-menuid="'+value.vid+'" data-formid="'+value.vurl+'" href="#" data-form-icon="'+value.vicon+'">'+
                '<i class="glyphicon glyphicon-circle-o">'+
                '</i>'+value.vtitle+
                '</a>'+
                '</li>';                
            }
                     
            menu_childs.push(menu_child_obj);
            
        }
    });
    */
    if(menu_childs.length > 0){
        menu_obj.menuChilds = menu_childs;
    }
    html_string += '</ul>';
    return html_string;
}

function _fw_post(postUrl, postData, callback){
    $.ajax
    ({
        type: "POST",
        url: baseURL+postUrl,
        contentType: "application/json",
        dataType: 'json',
        async: false,
        headers: {
            "Authorization": "Basic " + btoa(username + ":" + token)
        },
        data: JSON.stringify(postData),
        success:function(data){
            if(data.stat != '401'){
                //console.log('done not error');
                if(typeof(callback) == 'function'){
                    callback(data);
                }
            } else {
               //console.log('done error');
            }
        }
    })
    /*.done(function(data){
        if(data.stat != '401'){
            console.log('done not error');
            if(typeof(callback) == 'function'){
                callback(data);
            }
        } else {
            console.log('done error');
        }
    })
    .fail(function(){
        console.log('failed')
    });*/
}

function _fw_reset_subpage(obj){
    _fw_validation_clear(obj);
    var subpage;
    if($(obj).hasClass('subpage')){
        subpage = $(obj);
    } else {
        subpage = $(obj).closest('.subpage');
    }
    $(subpage).find('input').not('input[type="radio"],.unresetable').val('');
    $(subpage).find('select').each(function(){
        $(this).val($(this).find('option:first').val());
    });
    $(subpage).find('textarea').val('');
}

function _fw_setMessage(obj, status, msg, errorCallback) {
    console.log("Umar",msg);
    var subpageId = $(obj).closest('.subpage').attr('id');
    //console.log(typeof(msg));
    var appObj = $(obj).closest('.div-app');
    if(typeof(msg) == 'string'){
        if($('.global_message', appObj).html() != ''){
            $('.global_message', appObj).slideUp(200);
        }
        
        if(status == 1 && msg== ''){
            $('.global_message', appObj).html('');
        } else if(status == 1 && msg != '') {
            $('.global_message', appObj)
            .html('<div class="alert alert-success alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>'+msg+'</div>');
        } else if(status == 0){
            $('.global_message', appObj)
            .html('<div class="alert alert-danger alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>'+msg+'</div>');
        } else {
            $('.global_message', appObj).html('');
        }
        
        if($('.global_message', appObj).html() != ''){
            $('.global_message', appObj).slideDown(200);
        }
        
    } else if(typeof(msg) == 'object'){
        if(msg.stat == '409') {
            if(status == '0'){
                if($('.global_message', appObj).html() != ''){
                    $('.global_message', appObj).slideUp(200);
                }
                
                var generateDataId = generateUUID();
                
                var msgArray = '';
                if(typeof(msg.dtlMsg) == 'object'){
                    if(msg.dtlMsg.length > 1){
                        msgArray = '<ul class="errorList">';
                        $.each(msg.dtlMsg, function(i, val){
                            msgArray += '<li>' + val + '</li>';
                        });
                        msgArray += '</ul>';
                    } else if(msg.dtlMsg.length == 1) {
                        msgArray = msg.dtlMsg[0];
                    }
                }
                
                $('.global_message', appObj)
                    .html('<div class="alert alert-danger alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>'+msgArray+'<ul><li style="list-style-type: none;"><a href="#" style="text-decoration: none;" onclick="reloadForUpdate(this,\''+subpageId+'\', \''+generateDataId+'\', \''+errorCallback+'\')" >Reload</a></li></ul></div>');
                
                if($('.global_message', appObj).html() != ''){
                    $('.global_message', appObj).slideDown(200);
                }
                updateData[generateDataId] = msg;
            }
        } else {
            msgArray = msg.dtlMsg;
            if(typeof(msg.dtlMsg) == 'object'){
                console.log("dtlMsg "+msg.dtlMsg);
                if(msg.dtlMsg.length > 1){
                    console.log("dtlMsg > 1 "+msg.dtlMsg);
                    msgArray = '<ul class="errorList">';
                    $.each(msg.dtlMsg, function(i, val){
                        msgArray += '<li>' + val + '</li>';
                    });
                    msgArray += '</ul>';
                } else if(msg.dtlMsg.length == 1) {
                    msgArray = msg.dtlMsg[0];
                    console.log("dtlMsg == 1 "+msg.dtlMsg);
                }
                _fw_setMessage(obj, status, msgArray)
            } else {
                _fw_setMessage(obj, status, msgArray);
            }
            
        }
    }
}

function reloadForUpdate(obj, pageId, id, errorCallback){
    _fw_setMessage(obj, -1, '');
    if(errorCallback == undefined){
        automaticFill(updateData[id].rows[0], $('#'+pageId));
    } else {
        var errorCallbackf = window[errorCallback];
        if(typeof(errorCallbackf) == 'function'){
            errorCallbackf(updateData[id].rows[0]);
        } else {
            automaticFill(updateData[id].rows[0], $('#'+pageId));
        }
    }
    
}

/* Validation */
var _vvalObjs = [];
function _fw_validation_clear(obj) {
    _vvalObjs = [];
    var ofrm;
    if($(obj).hasClass('subpage')){
        ofrm = $(obj);
    } else {
        ofrm = $(obj).closest('.subpage');
    }
    _fw_setMessage(obj, -1, '');
    ofrm.find('.form-group').removeClass('has-error has-feedback');
    ofrm.find('.form-group').find('.form-control-feedback').remove();
}
function _fw_validation_add(obj, fieldName, validation) {
    var ofrm = $(obj).closest('.subpage').length > 0 ? $(obj).closest('.subpage') : $(obj).closest('.div-app');
    var fieldLabel = $('label[for="' + fieldName+'"]', ofrm) != undefined ? $('label[for="' + fieldName+'"]', ofrm).text() : '';
    _vvalObjs[_vvalObjs.length] = {
        obj: $('#' + fieldName, ofrm), 
        name:fieldLabel, 
        val: validation , 
        msg:''
    };
    
}
function _fw_validation_validate(obj) {
    var ofrm = $(obj).closest('.subpage');
    var msg = '<ul class="errorList">';
    for (var i = 0; i < _vvalObjs.length; i++) {
        switch (_vvalObjs[i].val.toLowerCase()) {
            case 'required':
                if ((_vvalObjs[i].msg=='') && (_vvalObjs[i].obj.val() == null || _vvalObjs[i].obj.val().replace(/\s+/,'')=='')) _vvalObjs[i].msg = 'Field '+_vvalObjs[i].name+' is required.';
                break;
            case 'number':
                if ((_vvalObjs[i].msg=='') && isNaN(_vvalObjs[i].obj.val())) _vvalObjs[i].msg = 'Field ' + _vvalObjs[i].name + ' must be numeric.';
                break;
        }
    }
    var dmsg = '';
    for (var i = 0; i < _vvalObjs.length; i++) {
        //_vvalObjs[i].obj.closest('.form-group').removeClass('has-success has-error has-feedback');
        //_vvalObjs[i].obj.next().remove();
        if (_vvalObjs[i].msg != '') {
            dmsg += '<li>' + _vvalObjs[i].msg + '</li>';
            _vvalObjs[i].obj.closest('.form-group').addClass('has-error has-feedback');
        } else {
        // _vvalObjs[i].obj.closest('.form-group').addClass('has-success  has-feedback');
        }
    }
    if (dmsg != '') {
        msg += dmsg + '</ul>';
        _fw_setMessage(obj, 0, msg);
        return false;
    }
    return true;
}


function loadData(resps){
    if(resps.stat != '401'){
        return {
            rows : resps.rows,
            total : resps.total
        };
    } else {
        return {
            rows : [],
            total : 0
        };
    }
    
}

function _fw_relogin(user, pass){
    /*var userData = new Object();
    userData.userName = "admin";
    userData.password = "admin";*/
    $.ajax
    ({
        type: "POST",
        url: baseURL+"/dashboard/login",
        contentType: "application/json",
        dataType: 'json',
        async: false,
        headers: {
          "Authorization": "Basic " + btoa(user + ":" + pass)
        }//,
        //data: JSON.stringify(userData)
    })
    .done(function(data){
        if(data.stat=="200"){
            $('.ahm .login-outer').slideUp();
            $.ajax(lastRequest);
            
        } else {
            $('#error-login').slideDown();
        }       
    })
    .fail(function(){console.log('login failed')});
    
}

function _rt_initTable(tblSelector,limiter) {

        var tbl = $(tblSelector).addClass('responsiveTable');

        $('.hiddenCell',tbl).removeClass('hiddenCell');

        $('.detailBlock',tbl).remove();

        var rlimit = !limiter ? tbl.closest('.div-app')  : limiter;

        var maxw = rlimit.width();

        console.log(tbl.outerWidth()+' -- '+maxw);

        if (tbl.outerWidth()>maxw) {

               var rw = 0, rc=0;

               $('th',tbl).each(function(){

                       rw += $(this).outerWidth();

                       if (rw<maxw){

                               rc++;

                       } else return false;

               });

               rc = rc-2;

               tbl.data('hiddenIdx',rc);

               console.log(rc);

               $('th:gt('+rc+')',tbl).addClass('hiddenCell');

               $(' > tbody > tr',tbl).each(function(){

                       if ($('table',this).length<=0) {
                               var firstTd;
                               if($('td:first', this).hasClass('bs-checkbox')){
                                   firstTd = $('td:nth-child(2)', this);
                               } else {
                                   firstTd = $('td:first',this);
                               }
                               firstTd.addClass('mainCell');
                               console.log(firstTd.html());
                               if ($('a.moreLink',firstTd).length<=0) firstTd.prepend('<a href="#" class="moreLink" onclick="_rt_populate(this);return false;"></a>');

                               $('td:gt('+rc+')',this).addClass('hiddenCell');

                       }

               });

               

        }

}

 

function _rt_populate(obj) {

        var obj = $(obj);

        var tbl = obj.closest('table');

        var row = obj.closest('tr');

        var td = obj.parent();

        var tgt = $('.detailBlock',td);

        if (tgt.length<=0) {

               tgt = $('<div class="detailBlock"></div>').appendTo(td);

               var headers = Array(); 

               var celldata = Array(); 

               $('th.hiddenCell',tbl).each(function(){

                       headers[headers.length] = $(this).text();

               });

               $('td.hiddenCell',row).each(function(){

                       celldata[celldata.length] = $(this).html();

               });

               for(var x=0; x<headers.length; x++) {

                       $('<div class="itemLbl">'+headers[x]+'</div><div class="itemVal">'+celldata[x]+'</div>').appendTo(tgt);

               }

        }

        tgt.slideToggle();

}

function numberFormatter(value, row, index) {
    console.log(value);
    return addCommas(value);
}

function addCommas(nStr) {
    if(nStr != undefined && nStr != "") {
        nStr = parseFloat(nStr).toFixed(2)
    nStr += '';
        var x = nStr.split('.');
        var x1 = x[0];
        var x2 = x.length > 1 ? '.' + x[1] : '';
        var rgx = /(\d+)(\d{3})/;
        while (rgx.test(x1)) {
            x1 = x1.replace(rgx, '$1' + ',' + '$2');
        }
        return (x1 +''+ x2);


    } else {
        return nStr;
    }
}
    
 function removeCommas(nStr) {
     if(nStr != undefined && nStr != "") {
        return nStr.replace(/,/g, '');
     } else {
         return nStr;
     }
 }
 
 function toggleMonitoring(obj) {
     $(obj).closest('.panel-control').toggleClass('collapsed');
     $('.glyphicon', $(obj)).toggleClass('flipX');
     return false;
 }
 
 function _fw_breadcrumb(obj, path) {
     var parent = $(obj).closest('.tab-pane');
     var pageId = $('.subpage[data-path="'+path+'"]', parent).attr('id');
     _fw_subpage(obj, pageId);
     
     var parent_li = $(obj).closest('li').addClass('active');
     $(parent_li).nextAll().remove();
     
 }
 
 var indexBaseColor = -1;
 function addBookmarkMenu() {
     _fw_post('/dashboard/getuserbookmark', '', function(data){
         $('#bookmarkList').html('');
         indexBaseColor = -1;
         var bookmarkBySystem = [];
         var bookmarkByUser = [];
         bookmarkedApps = [];
         $.each(data.rows, function(i, v){
             if(v.flag == 'S') {
                 bookmarkBySystem.push(v);
             } else {
                 bookmarkByUser.push(v);
             }
             bookmarkedApps.push(v.vapplicationId);
         });
         
         var i = 0;
         $.each(bookmarkBySystem, function(index,val){
             createBookmarkToHome(i, val);
             i++;
         });     
         
         $.each(bookmarkByUser, function(index,val){
             createBookmarkToHome(i, val);
             i++;
         });
         
     });
 }
 
 function createBookmarkToHome(i, v) {
     var moduloMenu = i % bookmarkSameBaseColor;
             
    if(moduloMenu == 0) {
        indexBaseColor++;
        if(indexBaseColor >= baseColorBookmark.length){
            indexBaseColor = 0;
        }
    }



    var colorCss = shadeColor2(baseColorBookmark[indexBaseColor], moduloMenu * 0.1);

    if(colorCss.length > 7) {
        colorCss = colorCss.substr(0, 7);
    }

    $('#bookmarkList').append(generateBookmark(v, colorCss));
 }
 
 
 function removeBookmarkHomeMenu(obj) {
     event.preventDefault();
     var formId = $(obj).data('formid');
     
     var data = new Object();
     data.appId = formId;
     
     _fw_post('/dashboard/unbookmarkmenu', data, function(data){
         if(data.stat == '200') {
             //$(obj).closest('.tile').remove();
             addBookmarkMenu();
             $('button[name="buttonBookmark"]',$('#tabpanel_'+formId)).removeClass('dislike');
         }
     });
     
     event.cancelBubble = true;
     event.stopPropagation();
     
     return false;
     
 }
 
 function openAppsFromHome(obj) {
     //event.preventDefault();
     
     var formId = $(obj).data('formid');
     
     
     var form_obj = $('#tablink_'+formId);
     if(form_obj.html() == undefined){
        var form = $('a[data-formid="'+formId+'"]', $('#ahmdsh1_menu_ul'));
        get_form(form);

     } else{
        form_obj.tab('show');
        $('[role="tabpanel"].tab-pane').removeClass('active');
        $('#tabpanel_'+formId).addClass('active');
     }
     
     return false;
     
 }
 
 function refreshForm(obj){
     event.preventDefault();
     var tabPanel = $(obj).closest('.tab-pane');
     var formId = tabPanel.data('formid');
         
    var form = $('a[data-formid="'+formId+'"]', $('#ahmdsh1_menu_ul'));
    get_form(form);

     return false;
 }
 
 function bookmarkApps(obj) {
     event.preventDefault();
     var tabPanel = $(obj).closest('.tab-pane');
     var formId = tabPanel.data('formid');
     
     var data = new Object();
     data.appId = formId;
     
     _fw_post('/dashboard/bookmarkmenu', data, function(data){
         if(data.stat == '200') {
             $(obj).toggleClass('dislike');
             $(this).attr("onclick", "unbookmarkApps(this)");
             addBookmarkMenu();
         }
     });
     return false;
 }
 
 function unbookmarkApps(obj) {
     event.preventDefault();
     var tabPanel = $(obj).closest('.tab-pane');
     var formId = tabPanel.data('formid');
     
     var data = new Object();
     data.appId = formId;
     
     _fw_post('/dashboard/unbookmarkmenu', data, function(data){
         if(data.stat == '200') {
             $(obj).toggleClass('dislike');
             $(this).attr("onclick", "bookmarkApps(this)");
             addBookmarkMenu();
         }
     });
     return false;
 }
 
 function generateBookmark(val, color) {
     var bookmarkIcon = '<div class="tile" style="background-color:'+ color+';" data-formid="'+val.vapplicationId+'" onclick="openAppsFromHome(this)">'
        +'<div class="tile-content">'
        +'<i class="'+val.vicon+'"></i>'
        +'</div>'
        +'<div class="tile-status">'
        +'<span class="name">'+val.vtitle+'</span>'
        +'</div>';
    if(val.flag != 'S') {
        bookmarkIcon += '<a href="#" class="link-unbookmark-tile" title="Unbookmark Apps" data-formid="'+val.vapplicationId+'" onclick="removeBookmarkHomeMenu(this)">'
            +'<span class="glyphicon glyphicon-thumbs-down">'
            +'</span>'
            +'</a>'
    }
    bookmarkIcon += '</div>';
    return bookmarkIcon;
 }
 
 function shadeColor2(color, percent) {   
    var f=parseInt(color.slice(1),16),t=percent<0?0:255,p=percent<0?percent*-1:percent,R=f>>16,G=f>>8&0x00FF,B=f&0x0000FF;
    return "#"+(0x1000000+(Math.round((t-R)*p)+R)*0x10000+(Math.round((t-G)*p)+G)*0x100+(Math.round((t-B)*p)+B)).toString(16).slice(1);
}