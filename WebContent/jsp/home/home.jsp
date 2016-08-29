<%@page import="com.gpl.authorization.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>

<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
 	
 	<title>主页</title>
    <style>
        body {
            padding-top: 50px;
        }

        /*
         * Top navigation
         * Hide default border to remove 1px line.
         */
        .navbar-fixed-top {
            border: 0;
        }

        /* Sidebar navigation */
        .nav-sidebar {
            /* margin-right: -21px; 
            margin-bottom: 20px;
            margin-left: -20px; */
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

    </style>
</head>
<body class="easyui-layout" style="min-width:500px;">
	<div data-options="region:'north'" style="height:55px;">
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
		        		<li><a href="#" onclick="logout();">注销账户</a></li>
		        	</ul>
		        </div>
	        </div>
	    </nav> 
	</div>
	<div data-options="region:'west',split:true" title="  " style="width:300px;">
		<div id="menu" class="easyui-accordion" data-options="border:false,multiple:true">
	    </div>
	</div>
	<div data-options="region:'center'">
	    <div id="tabs" class="easyui-tabs" data-options="fit:true,border:false,plain:true,closable:true">
			<div title="DataGrid" style="padding:5px">
				<table id="dg">
				</table>
			</div>
		</div>
	</div>
	<form action="${basePath }/login/logout" method="get" id="logoutForm"></form>
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
			var res = $.parseJSON(result);
			if(result && res.success){
				var data = res.data;
				//生成左侧菜单栏 
				organizeMenu(data);
			}else{
			}
		}
	);
	
	function organizeMenu(data){
		var result = new Array();
		//主节点排序
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
				//组织主节点下的子节点
				for(var j = 0;j < data.length ;j++){
					if(data[j].pid == data[i].id){
						subItem[count++] = data[j];
					}
				}
				//子节点排序
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
		
		//创建html
		for(var i = result.length - 1;i>=0;i--){
			var content = $("<ul></ul>");
			content.attr("class","nav nav-sidebar");
			for(var j = 0;j<result[i][1].length;j++){
				var li = $("<li></li>");
				li.attr("id",result[i][1][j].url);
				li.attr("title",result[i][1][j].mname);
				li.click(function(){
					openTab(this);
				}); 
				var a = $("<a href='#'></a>");
				a.text(result[i][1][j].mname);
				li.append(a);
				content.append(li);
			} 
			$("#menu").accordion('add',{
				title:result[i][0].mname,
				content:content,
				selected:false,
				iconCls:'icon-more'
				
				
			});
		}
	}
	
});

	function openTab(data){
		if($("#tabs").tabs("exists",data.title)){
			$("#tabs").tabs("select",data.title);
			return;
		}
		var url = data.id;
		var mname = data.title;
		var href = "${basePath}/"+url;
		//直接使用href会导致同时打开的标签页共用id，导致id冲突，所以要使用iframed的方式来避免
		var content = "<iframe frameborder='0' src='" + href +"' style='width:100%;height:100%;'></iframe>";
		$("#tabs").tabs("add",{
			id:mname,
			content:content,
			title:mname,
			closable:true
		});
		
	}
	
	function logout(){
		$.messager.confirm("退出登录","确认退出",function(r){
			if(r){
				$("#logoutForm").submit();
			}
		});
	}

</script>
</body>
</html>