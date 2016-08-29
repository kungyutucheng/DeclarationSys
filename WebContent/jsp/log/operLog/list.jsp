<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异常日志管理</title>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:true,title:'查询条件'" style="height:160px;">
		<form id="searchForm" method="POST">
			<table class="myTable">
				<tr>
					<td>用户账号</td>
					<td>
						<input class="easyui-textbox" name="account">
					</td>
					<td>方法名</td>
					<td>
						<input class="easyui-textbox" name="method">
					</td>
					<td>描述</td>
					<td>
						<input class="easyui-textbox" name="description">
					</td>
				</tr>
				<tr>
					<td>创建时间</td>
					<td colspan="3">
						<input class="easyui-datetimebox" name="startTime"
						data-options="icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
						&nbsp;-&nbsp;
						<input class="easyui-datetimebox" name="endTime"
						data-options="icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
					</td>
				</tr>
			</table>
			<div class="searchBtnDiv">
				<button class="btn btn-primary myBtn" type="button" onclick="search();">查询</button>
				<button class="btn btn-primary myBtn" type="button" onclick="reset();">重置</button>
			</div>
		</form>
	</div>
	<div data-options="region:'center',title:'查询结果',spilt:true">
		<table id="dg"></table>
	</div>
	<script>
	$(function(){
		$("#dg").datagrid({
			url:"${basePath}/operLog/searchgrid",
			queryParams:$("#searchForm").serializeObject(),
			rowsnumbers:true,
			pagination:true,
			columns:[[
			          {field:"id",hidden:true},
			          {field:"account",title:"用户账户",width:100},
			          {field:"method",title:"方法名",width:300},
			          {field:"description",title:"描述",width:500},
			          {field:"createTime",title:"创建时间",width:200,formatter:function(value,row,index){
			        	  return (new Date(value)).format("yyyy-MM-dd hh:mm:ss");
			          }}
			          ]]
		});
	});
	
	function search(){
		$("#dg").datagrid("reload",$("#searchForm").serializeObject());
	}
	
	function reset(){
		$("#searchForm").form("reset");
	}
	</script>
</body>
</html>