<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录日志管理</title>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',spilt:true" title="查询条件" style="height:180px;">
		<form method="post" id="searchForm">
			<table class="myTable">
				<tr>
					<td>账户</td>
					<td>
						<input class="easyui-textbox" name="account">
					</td>
					<td>ip</td>
					<td>
						<input class="easyui-textbox" name="ip">
					</td>
				<tr>
					<td>结果</td>
					<td>
						<input class="easyui-combobox" name="result"
						data-options="
						valueField:'value',
						textField:'label',
						data:[{
							value:1,
							label:'成功'
						},{
							value:2,
							label:'失败'
						}],icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]"> 	
					</td>
					<td>登录时间</td>
					<td>
						<input class="easyui-datetimebox" name="startTime">&nbsp;-
						<input class="easyui-datetimebox" name="endTime">
					</td>
				</tr>
			</table>
			<div class="searchBtnDiv">
				<button class="btn btn-primary myBtn" onclick="search()" type="button">查询</button>
				<button class="btn btn-primary myBtn" onclick="resetForm()" type="button">重置</button>
			</div>
		</form>
	</div>
	<div data-options="region:'center',spilt:true" title="查询结果">
		<table id="logDg"></table>
	</div>
	<script>
	$(function(){
		$("#logDg").datagrid({
			url:"${basePath}/loginLog/searchgrid",
			rownumbers:true,
			pagination:true,
			singleSelect:true,
			queryParams:$("#searchForm").serializeObject(),
			columns:[[
			         {field:"id",hidden:true},
			         {field:"account",title:"账号",width:100},
			         {field:"ip",title:"登陆ip",width:200},
			         {field:"result",title:"登陆结果",width:80,formatter:function(value,row,index){
			        	 if(value == 1){
			        		 return "<font style='color:green;'>成功</font>";
			        	 }
			        	 else if(value == 2){
			        		 return "<font style='color:red;'>失败</font>";
			        	 }
			        	 else{
			        		 return value;
			        	 }
			         }},
			         {field:"loginTime",title:"登陆时间",width:200,formatter:function(value,row,index){
			        	 return (new Date(value)).format("yyyy-MM-dd hh:mm:ss");
			         }}
			          ]]
		});
	});
	
	
	function search(){
		$("#logDg").datagrid("reload",$("#searchForm").serializeObject());
	}
	
	function resetForm(){
		$("#searchForm").form("reset");
	}
	
	</script>
</body>
</html>