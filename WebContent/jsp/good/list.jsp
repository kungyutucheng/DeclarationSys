<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品备案</title>
<style>
</style>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north',split:true" title="查询条件" style="height:300px;">
			<div style="text-align:center;">
				<form id="searchForm" enctype="multipart/form-data">
		            <table class="myTable">
		                <tr>
		                	<td>商品备案号</td>
		                	<td><input name="ciqGoodsNo" class="easyui-textbox"></td>
		                	<td>审核状态</td>
		                    <td>
		                    	<input name="status" class="easyui-combobox" data-options="
		                    	valueField:'value',
		                    	textField:'label',
		                    	data:[{
		                    		label:'待发送',
		                    		value:1
		                    	},{
		                    		label:'待审核',
		                    		value:2
		                    	},{
		                    		label:'接收失败',
		                    		value:3
		                    	},{
		                    		label:'通过',
		                    		value:4
		                    	},{
		                    		label:'不通过',
		                    		value:5
		                    	}],
		                    	icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
							</td>
		                    <td>商品货号</td>
		                    <td><input name="gCode" class="easyui-textbox"></input></td>
		               	</tr>
		               	<tr>
		                    <td>库存</td>
		                    <td>
		                    	<input name="startNum" class="easyui-textbox" style="width:80px;">&nbsp;-
		                    	<input name="endNum" class="easyui-textbox" style="width:80px;">
		                    </td>
		                    <td>商品名称</td>
		                    <td><input name="gname" class="easyui-textbox"></input></td>
		                    <td>hs码</td>
		                    <td><input name="hsCode" class="easyui-textbox"></input></td>
		                </tr>
		               	<tr>
		                    <td>商品描述</td>
		                    <td><input name="goodsDesc" class="easyui-textbox"></input></td>
		                    <td>生产厂家</td>
		                    <td><input name="comName" class="easyui-textbox"></input></td>
		                    <td>品牌</td>
		                    <td><input name="brand" class="easyui-textbox"></input></td>
		                </tr>
		               	<tr>
		                    <td>原产国/地区</td>
		                    <td><input name="assemCountry" class="easyui-textbox"></input></td>
		                    <td>商品申请编号</td>
		                    <td><input name="cargobCode" class="easyui-textbox"></input></td>
		                    <td>国检组织机构</td>
		                    <td>
		                    	<input id="ciqbCode" name="ciqbCode" class="easyui-combobox"
		                    	data-options="valueField:'code',textField:'name',url:'${basePath }/org/getAll',
		                    	icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
		                    </td>
		                </tr>
		                <tr>
		                    <td>跨境电商企业</td>
		                    <td>
								<input id="cbeComId" class="easyui-combobox"
								 name="cbeComId" data-options="valueField: 'id',textField: 'ename',url:'${basePath }/ent/getAll',
								 icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
							</td>
		                    <td>制单企业</td>
		                    <td>
		                    	<input id="editId" class="easyui-combobox"
								 name="editId" data-options="valueField: 'id',textField: 'ename',url:'${basePath }/ent/getAll',
								 icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
		                    </td>
		                    <td>操作类型</td>
		                    <td>
		                    	<input name="operType" class="easyui-combobox"
		                    	 data-options="
		                    	 valueField:'value',
		                    	textField:'label',
		                    	data:[{
		                    		label:'新增',
		                    		value:'A'
		                    	},{
		                    		label:'修改',
		                    		value:'M'
		                    	},{
		                    		label:'自动引用',
		                    		value:'I'
		                    	}],
		                    	 icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
							</td>
		                </tr>
		                <tr>
		                    <td>申请时间</td>
		                    <td  colspan="3">
		                    	<input name="startTime" class="easyui-datetimebox" data-options="icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).datetimebox('clear');}}]">&nbsp;-
		                    	<input name="endTime" class="easyui-datetimebox" data-options="icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).datetimebox('clear');}}]">
		                    </td>
		                </tr>
		                <tr>
		                    <td></td>
		                    <td>
		                    	<input type="button" class="btn btn-primary myBtn" value="查询" onclick="searchgrid();" style="display:inline-block;width:auto;">
		                    	<input type="button" class="btn btn-primary myBtn" value="重置" onclick="resetForm();" style="display:inline-block;width:auto;">
		                    </td>
		                </tr>
		            </table>
		        </form>
			</div> 
		</div>
		<div data-options="region:'center',split:true" title="查询结果" style="height:auto;">
			<table id="goodDg"></table>
		</div>
	</div>
    <script type="text/javascript">
		$(function(){
			var queryParams = $("#searchForm").serializeObject();
			$("#goodDg").datagrid({
				url:"${basePath}/good/searchgrid",
				method:"post",
				pagination:true,
				rownumbers:true,
				loadMsg:"加载中，请稍后...",
				ctrlSelect:true,
				queryParams:queryParams,
				columns:[[
				          {field:"ciqGoodsNo",title:"商品备案号",width:100},
				          {field:"status",title:"审核状态",width:100,formatter:function(value,row,index){
				        	  if(value == 0){
				        		  return "<font color='blue'>新增</font>";
				        	  }else if(value == 1){
				        		  return "<font color='purple'>待发送</font>";
				        	  }else if(value == 2){
				        		  return "<font color='orange'>已发送</font>";
				        	  }else if(value == 3){
				        		  return "<font color='pink'>待审核</font>";
				        	  }else if(value == 4){
				        		  return "<font color='brown'>接收失败</font>";
				        	  }else if(value == 5){
				        		  return "<font color='green'>通过</font>";
				        	  }else if(value == 6){
				        		  return "<font color='red'>不通过</font>";
				        	  }else{
				        		  return value;
				        	  }
				          }},
				          {field:"num",title:"库存",width:100,sortable:true},
				          {field:"gCode",title:"商品货号",width:100},
				          {field:"gname",title:"商品名称",width:300},
				          {field:"spec",title:"规格描述",width:100},
				          {field:"hsCode",title:"hs码",width:100},
				          {field:"unit",title:"计量单位",width:100},
				          {field:"goodsDesc",title:"商品描述",width:300},
				          {field:"gRemark",title:"商品备注",width:100},
				          {field:"comName",title:"生产厂家",width:300},
				          {field:"manufactureAddr",title:"生产厂家地址",width:300},
				          {field:"brand",title:"品牌",width:100},
				          {field:"assemCountry",title:"原产国/地区",width:100},
				          {field:"ingredient",title:"成分",width:200},
				          {field:"addtiveFlag",title:"超范围使用添加剂",width:300},
				          {field:"poisonFlag",title:"含有毒害物质",width:300},
				          {field:"regNotes",title:"审核备注",width:100},
				          {field:"cargobCode",title:"商品申请编码",width:100},
				          {field:"ciqbName",title:"审核组织机构",width:100},
				          {field:"cbeComName",title:"跨境电商企业",width:200},
				          {field:"editName",title:"制单企业",width:200},
				          {field:"remark",title:"申请备注",width:100},
				          {field:"operType",title:"操作类型",width:60,formatter:function(value,row,index){
				        	  if(value == "A"){
				        		  return "<font color='green'>新增</font>"
				        	  }
				        	  else if(value == "M"){
				        		  return "<font color='green'>修改</font>"
				        	  }
				        	  else if(value == "I"){
				        		  return "<font color='green'>自动引用</font>"
				        	  }
				          }},
				          {field:"createTime",title:"申请时间",width:200,formatter:function(value,row,index){
				        	  return (new Date(value)).format("yyyy-MM-dd hh:mm:ss");
				          }},
				          ]]
			});
			
			
			var pager = $("#goodDg").datagrid("getPager");
			pager.pagination({
				loading:true,
				displayMsg:"从第{from}条数据到第{to}条数据，共{total}条数据"
				
			});
			
		});
		
		
		function searchgrid(){
			$("#goodDg").datagrid("reload",$("#searchForm").serializeObject());
		}
		
		function resetForm(){
			$("#searchForm").form("reset");
		}
		
		</script>
	
</body>
</html>