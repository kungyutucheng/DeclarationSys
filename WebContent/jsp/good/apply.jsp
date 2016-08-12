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
		                    <td><input name="ciqbCode" class="f1 easyui-combobox"
		                    	style="width:100%;" data-options="valueField:'code',textField:'name',url:'${basePath }/org/getAll'"></td>
		                </tr>
		                <tr>
		                    <td>跨境电商企业</td>
		                    <td>
								<input id="cbeComId" class="easyui-combobox"
								 name="cbeComId" style="width:100%;" data-options="valueField: 'id',textField: 'ename',url:'${basePath }/ent/getAll'">
							</td>
		                    <td>制单企业</td>
		                    <td>
		                    	<input id="editId" class="easyui-combobox"
								 name="editId" style="width:100%;" data-options="valueField: 'id',textField: 'ename',url:'${basePath }/ent/getAll'">
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
			<table id="tt" style="width:auto;height:300px;"
					singleSelect="true",
					rownumbers="true",
					toolbar="tb">
				<thead>
					<tr>
						<th field="gCode" width="100" editor="{type:'validatebox',options:{required:true,missingMessage:'请输入商品货号',validType:'maxLength[30]'}}">商品货号</th>
						<th field="gname" width="100" editor="{type:'validatebox',options:{required:true,missingMessage:'请输入商品名称',validType:'maxLength[255]'}}">商品名称</th>
						<th field="spec" width="100" editor="{type:'validatebox',options:{required:true,missingMessage:'请输入规格型号',validType:'maxLength[255]'}}">规格型号</th>
						<th field="hsCode" width="100" editor="{type:'validatebox',options:{required:true,missingMessage:'请输入hs编码',validType:'maxLength[32]'}}">hs编码</th>
						<th field="unit" width="150" editor="{type:'validatebox',options:{required:true,missingMessage:'请输入计量单位'}}">计量单位</th>
						<th field="goodsBarCode" width="100" editor="{type:'validatebox',options:{required:false,validType:'maxLength[13]'}}">条形码</th>
						<th field="goodsDesc" width="100" editor="{type:'validatebox',options:{required:false,validType:'maxLength[255]'}}">商品描述</th>
						<th field="gRemark" width="100" editor="{type:'validatebox',options:{required:false,validType:'maxLength[255]'}}">商品备注</th>
						<th field="comName" width="100" editor="{type:'validatebox',options:{required:false,validType:'maxLength[256]'}}">生产厂家</th>
						<th field="manufactureAddr" width="100" editor="{type:'validatebox',options:{required:false,validType:'maxLength[256]'}}">生产厂家地址</th>
						<th field="brand" width="100" editor="{type:'validatebox',options:{required:true,missingMessage:'请输入规格型号',validType:'maxLength[255]'}}">品牌</th>
						<th field="assemCountry" width="100" editor="{type:'validatebox',options:{required:true,missingMessage:'请输入规格型号',validType:'maxLength[255]'}}">原产国/地区</th>
						<th field="ingredient" width="100" editor="{type:'validatebox',options:{required:false,validType:'maxLength[256]'}}">成分</th>
						<th field="additiveFlag" width="100" editor="{type:'validatebox',options:{required:false,validType:'maxLength[256]'}}">超范围使用食品添加剂</th>
						<th field="poisonFlag" width="100" editor="{type:'validatebox',options:{required:false,validType:'maxLength[256]'}}">含有毒害物质</th>
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
			
			$.extend($.fn.validatebox.defaults.rules, {
			    maxLength: {
			        validator: function(value, param){
			            return value.length <= param[0];
			        },
			        message: '该字段长度请勿超过{0}'
			    }
			});
		});
		
		
	</script>
</body>
</html>