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
		<div data-options="region:'north',split:true" title="备案信息" style="height:200px;">
			<div style="text-align:center;">
				<form id="ff" action="form1_proc.php" method="post" enctype="multipart/form-data">
		            <table class="myTable">
		                <tr>
		                    <td>商品申请编号</td>
		                    <td><input name="cargobCode" class="f1 easyui-textbox"></input></td>
		                    <td>国检组织机构代码</td>
		                    <td><input name="ciqbCode" class="f1 easyui-textbox"></input></td>
		                </tr>
		                <tr>
		                    <td>跨境电商企业</td>
		                    <td>
		                    	<select name="cbeComId" class="easyui-combobox">
									<option value="1">企业1</option>
									<option value="2">企业2</option>
								</select>
							</td>
		                    <td>制单企业</td>
		                    <td>
		                    	<select name="editId" class="easyui-combobox">
									<option value="1">企业1</option>
									<option value="2">企业2</option>
								</select>
		                    </td>
		                </tr>
		                <tr>
		                    <td>备注</td>
		                    <td  colspan="3"><input name="remark"class="f1 easyui-textbox" style="width:100%;"></input></td>
		                </tr>
		                <tr>
		                    <td></td>
		                    <td><input type="submit" value="Submit"></input></td>
		                </tr>
		            </table>
		        </form>
			</div> 
		</div>
		<div data-options="region:'center',split:true" title="备案商品详细" style="height:auto;">
			<table id="goodDg"></table>
		</div>
	</div>
    <script type="text/javascript">
		$(function(){
			$("#goodDg").datagrid({
				url:"${basePath}/good/searchgrid",
				method:"post",
				pagination:true,
				rownumbers:true,
				loadMsg:"加载中，请稍后...",
				ctrlSelect:true,
				columns:[[
				          {field:"ciqGoodsNo",title:"商品备案号",width:100},
				          {field:"status",title:"审核状态",width:100,formatter:function(value,row,index){
				        	  if(value == 0){
				        		  return "<font color='pink'>新增</font>";
				        	  }
				          	  else if(value == 1){
				        		  return "<font color='orange'>待发送</font>";
				        	  }
				        	  else if(value == 2){
				        		  return "<font color='blue'>待审核</font>";
				        	  }
				        	  else if(value == 3){
				        		  return "<font color='purple'>接收失败</font>";
				        	  }
				        	  else if(value == 4){
				        		  return "<font color='green'>通过</font>";
				        	  }
				        	  else if(value == 5){
				        		  return "<font color='red'>不通过</font>";
				        	  }
				          }},
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
				          {field:"num",title:"库存",width:100,sortable:true},
				          {field:"regNotes",title:"审核备注",width:100},
				          {field:"cargobCode",title:"商品申请编码",width:100},
				          {field:"ciqbName",title:"审核组织机构",width:100},
				          {field:"cbeComName",title:"跨境电商企业",width:200},
				          {field:"editName",title:"制单企业",width:200},
				          {field:"remark",title:"申请备注",width:100},
				          {field:"operType",title:"操作类型",width:40,styler:function(value,row,index){
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
		
		
	
</body>
</html>