var baseURL = "/ahmjxdsh000/";

function recursive_menu(menu_obj, array_data, html_string){
    var menu_childs = new Array();
    html_string += '<ul style="display: none;">';
    $.each(array_data, function(key, value){
        if(value.parent == menu_obj.menuId){
            var menu_child_obj = new Object();
            menu_child_obj.menuId = value.idMenu;
            menu_child_obj.menuName = value.title;
            if(value.vapplicationId == "null"){
                html_string += '<li class="menu treeview transition">'+
                                    '<a href="#">'+
                                        '<i class="glyphicon glyphicon-eye-open"></i> <span>'+value.title+'</span>'+
                                        '<i class="glyphicon glyphicon-chevron-down icon-menu-expand" style="float:right"></i>'+
                                    '</a>';
                html_string = recursive_menu(menu_child_obj, array_data, html_string);
                html_string += '</li>';
            } else {
                html_string += '<li class="menu transition">'+
                                    '<a data-formid="'+value.url+'" href="#">'+
                                        '<i class="glyphicon glyphicon-circle-o">'+
                                        '</i>'+value.title+
                                    '</a>'+
                                '</li>';                
            }
                     
           menu_childs.push(menu_child_obj);
            
        }
    });
    if(menu_childs.length > 0){
        menu_obj.menuChilds = menu_childs;
    }
    html_string += '</ul>';
    return html_string;
}

function _fw_login(user, pass){
    var userData = new Object();
    
    userData.userName = "admin";
    userData.password = "admin";
    
    $.ajax
    ({
        type: "POST",
        url: baseURL + "/api/uamusers/search/findOneByUserName?name=" + user,
        contentType: "application/json",
        dataType: 'json',
        async: false,
        headers: {
          "Authorization": "Basic " + btoa(user + ":" + pass)
        },
        data: JSON.stringify(userData)
    })
    .done(function(data){
    	window.location = "dashboard.htm";
        //if(data.stat=="200"){
    	if(true) {
            window.location = "dashboard.htm";

            var menu_root = new Array();
            var htmlMenu = '';
            
            //find root parent (vparent null)
            $.each(data.menus, function(key, value){
            	
               if(value.parent == "null"){
                   var rootObj = new Object();
                   rootObj.menuId = value.idMenu;
                   rootObj.menuName = value.title;
                   htmlMenu += '<li class="treeview transition">'+
                                    '<a href="#">'+
                                        '<i class="glyphicon glyphicon-eye-open"></i> <span>'+value.title+'</span>'+
                                        '<i class="glyphicon glyphicon-chevron-down icon-menu-expand" style="float:right"></i>'+
                                    '</a>';
                   htmlMenu = recursive_menu(rootObj, data.rows, htmlMenu);
                   htmlMenu += '</li>';
                   menu_root.push(rootObj);
               } 
            });           
           
        } else {
            $('#error-login').slideDown();
        }       
    })
    .fail(function(){console.log('login failed')});
}

function _fw_resetUserorPwd(user, pwd){
    var username;
    var fullname;
    var userData = new Object();
    if(pwd==false){
        fullname = user;
        userData.fullname = fullname;
    }else{
        username = user;
        userData.username = username;
        userData.password = pwd;
    }

    if(!user || !(pwd.toString())){
        console.log('kosooooong');
        $('#error-login').slideDown();
    }else{
        $.ajax
        ({
            type: "POST",
            url: baseURL+"/dashboard/login",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            data: JSON.stringify(userData)
        })
        .done(function(data){
            console.log('bcbcbcbcbcbcbcbbcbcc');
            $('div.global_message')
                .html('<div class="alert alert-success alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>ppppppppppppppppppppppppppp</div>');
            /*if(data.stat=="200"){           
                $('div.global_message')
                .html('<div class="alert alert-success alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>llllllllllllllllllllllllllllllllllllllllll'+msg+'</div>');
            } else {
                $('div.global_message')
                .html('<div class="alert alert-danger alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>ppppppppppppppppppppppppppp'+msg+'</div>');
                
            } */
        })
        .fail(function(){console.log('reset failed')});
    }
}