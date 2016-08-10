<%@page import="com.gpl.authorization.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>

<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
 	<link rel="stylesheet" type="text/css" href="${basePath }/asserts/easyui/themes/default/easyui.css">
 	<link rel="stylesheet" type="text/css" href="${basePath }/asserts/easyui/themes/icon.css">
 	<link rel="stylesheet" type="text/css" href="${basePath }/asserts/easyui/demo/demo.css">
 	<script type="text/javascript" src="${basePath }/asserts/easyui/jquery.easyui.min.js"></script>
 	<title>主页</title>
    <style>
        body {
            padding-top: 50px;
        }


        /*
         * Global add-ons
         */

        .sub-header {
            padding-bottom: 10px;
            border-bottom: 1px solid #eee;
        }

        /*
         * Top navigation
         * Hide default border to remove 1px line.
         */
        .navbar-fixed-top {
            border: 0;
        }

        /*
         * Sidebar
         */

        /* Hide for mobile, show later */
        .sidebar {
            display: none;
        }
        @media (min-width: 768px) {
            .sidebar {
                position: fixed;
                top: 51px;
                bottom: 0;
                left: 0;
                z-index: 1000;
                display: block;
                padding: 20px;
                overflow-x: hidden;
                overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
                background-color: #f5f5f5;
                border-right: 1px solid #eee;
            }
        }

        /* Sidebar navigation */
        .nav-sidebar {
            margin-right: -21px; /* 20px padding + 1px border */
            margin-bottom: 20px;
            margin-left: -20px;
        }
        .nav-sidebar > li > a {
            padding-right: 20px;
            padding-left: 20px;
        }
        .nav-sidebar > .active > a,
        .nav-sidebar > .active > a:hover,
        .nav-sidebar > .active > a:focus {
            color: #fff;
            background-color: #428bca;
        }


        /*
         * Main content
         */

        .main {
            padding: 20px;
        }
        @media (min-width: 768px) {
            .main {
                padding-right: 40px;
                padding-left: 40px;
            }
        }
        .main .page-header {
            margin-top: 0;
        }


        /*
         * Placeholder dashboard ideas
         */

        .placeholders {
            margin-bottom: 30px;
            text-align: center;
        }
        .placeholders h4 {
            margin-bottom: 0;
        }
        .placeholder {
            margin-bottom: 20px;
        }
        .placeholder img {
            display: inline-block;
            border-radius: 50%;
        }
        form input,
        form textarea,
        form button,
        form label{
            margin:5px 0px;
        }
        .myBtn{
            background:#428bca;
        }
        .a{
        	cursor:pointer;
        }
    </style>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:true" title="West" style="heigth:150px;margin-bottom:10px;">
	    <nav class="navbar navbar-inverse navbar-fixed-top">
	        <div class="container-fluid">
	            <div class="navbar-header">
		            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			            <span class="sr-only">Toggle navigation</span>
			            <span class="icon-bar"></span>
			            <span class="icon-bar"></span>
			            <span class="icon-bar"></span>
			        </button>
	                <a class="navbar-brand" href="#">报关系统</a>
	            </div>
		        <div id="navbar" class="navbar-collapse collapse">
		        	<ul class="nav navbar-nav navbar-right">
		        		<li><a href="#"><%=((User)session.getAttribute("user")).getAccount() %></a></li>
		        		<li><a href="#">注销账户</a></li>
		        	</ul>
		        </div>
	        </div>
	    </nav>
	</div>
	        <div data-options="region:'west',split:true" title="West" style="width:300px;">
	            <div id="menu" class="easyui-accordion" data-options="fit:true,border:false">
	                <!-- <div title="Title1" style="padding:10px;">
	                    content1
	                </div>
	                <div title="Title2" data-options="selected:true,iconCls:'icon-more'" style="padding:10px;">
	                    content2
	                </div>
	                <div title="Title3" style="padding:10px">
	                    content3
	                </div> -->
	            </div>
	        </div>
	        <div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
	            <div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
	                <div title="DataGrid" style="padding:5px">
	                    <table id="dg">
	                    </table>
	                </div>
	            </div>
	        </div>
<script>

$(function(){
	<%-- $("#dg").datagrid({
		url:"${basePath }/user/getModules",
		queryParams:{
			account:'<%=((User)session.getAttribute("user")).getAccount() %>'
		},
		columns:[[
		          {field:'id',title:'id',width:80},
		          {field:'mname',title:'mname',width:180},
		          {field:'pid',title:'pid',width:80},
		          {field:'sort',title:'sort',width:80},
		          {field:'url',title:'url',width:380},
		          ]]
	}); --%>
	$.post("${basePath }/user/getModules",
			{account:"<%=((User)session.getAttribute("user")).getAccount() %>"},
			function(result){
			console.log(result);
			var res = $.parseJSON(result);
			if(result && res.success){
				var menu = $("#menu");
				var data = res.data;
				//生成左侧菜单栏
				organizeMenu(data);
			}else{
			}
		}
	);
	
	function organizeMenu(data){
		var result = new Array();
		for(var i = 0 ;i <data.length ;i++){
			for(var j = 0;j<data.length && j!=i;j++){
				if(data[i].pid == null && data[j].pid == null){
					if(data[i].sort < data[j].sort){
						var temp = data[i];
						data[i] = data[j];
						data[j] = temp;
					}
				}
			}
		}
		
		for(var i = 0;i<data.length;i++){
			if(data[i].pid == null){
				var item = new Array();
				item[0] = data[i];
				var subItem = new Array();
				var count = 0;
				for(var j = 0;j < data.length ;j++){
					if(data[j].pid == data[i].id){
						subItem[count++] = data[j];
					}
				}
				for(var j = 0 ;j< subItem.length;j++){
					for(var k = 0;k < subItem.length && j != k;k++){
						if(subItem[j].sort < subItem[k].sort){
							var temp = subItem[j];
							subItem[j] = subItem[k];
							subItem[k] = temp;
						}
					}
				}
				item[1] = subItem;
				result.push(item);
			}
		}
		
		
		for(var i = result.length - 1;i>=0;i--){
			var content = "";
			for(var j = 0;j<result[i][1].length;j++){
				content += '<a href="#">' + result[i][1][j].mname +'</a><br/>';
			}
				/* $("#menu").accordion('add',{
					title:result[i].mname,
					content:content,
					selected:false,
					iconCls:'icon-more'
				}); */
				
			var menu = $("#menu");
				var icon = "icon-more";
			menu.html('<div title="'+result[i].mname+'" data-options="iconCls:'+icon+'"></div>');
		}
	}
});


</script>
</body>
</html>