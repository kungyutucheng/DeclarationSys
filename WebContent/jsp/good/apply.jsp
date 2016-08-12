<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		                    	<select id="cbeComId" name="cbeComId" class="easyui-combobox">
									<!-- <option value="0"></option> -->
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
		                    <td><input type="submit" class="btn btn-primary myBtn" value="提交" style="width:auto;"></input></td>
		                </tr>
		            </table>
		        </form>
			</div> 
		</div>
		<div data-options="region:'center',split:true" title="备案商品详细" style="height:auto;">
			<div id="tb" style="height:auto">
		        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="javascript:$('#tt').edatagrid('addRow')">新增</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="javascript:$('#tt').edatagrid('destroyRow')">删除</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="javascript:$('#tt').edatagrid('saveRow')">保存</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="javascript:$('#tt').edatagrid('cancelRow')">撤销</a>
		    </div>
			<table id="tt" style="width:600px;height:200px"
					method='get',
					singleSelect="true",
					toolbar="tb">
				<thead>
					<tr>
						<th field="id" width="100" editor="{type:'validatebox',options:{required:true}}">Item ID</th>
						<th field="mname" width="100" editor="text">Product ID</th>
						<th field="sort" width="100" align="right" editor="{type:'numberbox',options:{precision:1}}">List Price</th>
						<th field="pid" width="100" align="right" editor="numberbox">Unit Cost</th>
						<th field="url" width="150" editor="text">Attribute</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
    <script type="text/javascript">
		$(function(){
			$('#tt').edatagrid({
				onSave:function(index,row){
					console.log("index:" + index + ",row:" + row.id);
				}
			});
			
			$.post("${basePath }/ent/getAll",null,function(result){
				var result = $.parseJSON(result);
				console.log(result.success);
				if(result && result.success){
					var data = result.data;
					var selector = $("#cbeComId");
					for(var i = 0 ;i < data.length;i++){
						selector.append("<option value='" + data[i].id + "'>" + data[i].ename + "</option>");
					}
				}else{
					layer.msg(result.msg);
				}
			});
		});
		
		
	</script>
</body>
</html>