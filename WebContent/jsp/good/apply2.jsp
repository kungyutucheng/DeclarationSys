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
				<form id="applyForm" method="post">
		            <table class="myTable">
		                <tr>
		                    <td>国检组织机构</td>
		                    <td><input id="ciqbCode" name="ciqbCode" class="f1 easyui-combobox"
		                    	style="width:100%;" data-options="valueField:'code',textField:'name',url:'${basePath }/org/getAll',required:true,missingMessage:'请选择组织机构'">
		                    </td>
		                    <td>跨境电商企业</td>
		                    <td>
								<input id="cbeComId" class="easyui-combobox"
								 name="cbeComId" style="width:100%;" data-options="valueField: 'id',textField: 'ename',url:'${basePath }/ent/getAll',required:true,missingMessage:'请选择跨境电商企业'">
							</td>
						</tr>
						<tr>
		                    <td>制单企业</td>
		                    <td>
		                    	<input id="editId" class="easyui-combobox"
								 name="editId" style="width:100%;" data-options="valueField: 'id',textField: 'ename',url:'${basePath }/ent/getAll',required:true,missingMessage:'请选择制单企业'">
		                    </td>
		                </tr>
		                <tr>
		                    <td>备注</td>
		                    <td colspan="3"><input id="remark" name="remark"class="f1 easyui-textbox" style="width:100%;"></input></td>
		                </tr>
		                <tr>
		                    <td></td>
		                    <td><input type="submit" class="btn btn-primary myBtn" value="提交" style="width:auto;"></td>
		                </tr>
		            </table>
		            <input type="text" name="goods" id="goods">
		        </form>
			</div> 
		</div>
		<div data-options="region:'center',split:true" title="备案商品详细" style="height:auto;">
			<table id="dg" class="easyui-datagrid" title="Row Editing in DataGrid" style="width:700px;height:auto"
	            data-options="
	                iconCls: 'icon-edit',
	                singleSelect: true,
	                toolbar: '#tb',
	                onClickCell: onClickCell,
	                onEndEdit: onEndEdit,
	                url:'${basePath }/good/getAll',
	                method:'post'
	            ">
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
	 
	    <div id="tb" style="height:auto">
	        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">Append</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">Remove</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">Accept</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="reject()">Reject</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="getChanges()">GetChanges</a>
	    </div>
    </div>
    <script type="text/javascript">
    
    	$(function(){
    		$("#applyForm").form({
				url:"${basePath}/good/save",
				onSubmit:function(){
					$("#goods").val(JSON.stringify(goods));
					if($("#ciqbCode").combobox('getValue') == ""){
						layer.msg("请选择国检组织");
						return false;
					}
					if($("#cbeComId").combobox('getValue') == ""){
						layer.msg("请选择跨境电商企业");
						return false;
					}
					if($("#editId").combobox('getValue') == ""){
						layer.msg("请选择制单企业");
						return false;
					}
					if($("#goods").val() == null || $("#goods").val() == "[]"){
						layer.msg("请在下方表格录入商品信息");
						return false;
					}
				},
				onProcess:function(percent){
					console.log("percent:"+percent);
				},
				success:function(result){
					var result = $.parseJSON(result);
					layer.msg(result.msg);
				}
			});
			
			$('#remark').textbox({
				icons: [{
					iconCls:'icon-clear',
					handler: function(e){
						$(e.data.target).textbox('clear');
					}
				},
				{
					iconCls:'combo-arrow',
					handler: function(e){
						layer.prompt({
							  formType: 2,//0-文本(默认),1-密码,2-多行文本
							  maxLength:256,//可输入的文本最大长度
							  value: $(e.data.target).textbox('getValue'),//默认值
							}, function(value, index, elem){
								$(e.data.target).textbox('setValue',value);
							  	layer.close(index);
							});
					}
				}]
			})
		});
    	var editIndex = undefined;
        function endEditing(){
            if (editIndex == undefined){return true}
            if ($('#dg').datagrid('validateRow', editIndex)){
                $('#dg').datagrid('endEdit', editIndex);
                editIndex = undefined;
                return true;
            } else {
                return false;
            }
        }
        function onClickCell(index, field){
            if (editIndex != index){
                if (endEditing()){
                    $('#dg').datagrid('selectRow', index)
                            .datagrid('beginEdit', index);
                    var ed = $('#dg').datagrid('getEditor', {index:index,field:field});
                    if (ed){
                        ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
                    }
                    editIndex = index;
                } else {
                    setTimeout(function(){
                        $('#dg').datagrid('selectRow', editIndex);
                    },0);
                }
            }
        }
        function onEndEdit(index, row){
            var ed = $(this).datagrid('getEditor', {
                index: index,
                field: 'productid'
            });
            row.productname = $(ed.target).combobox('getText');
        }
        function append(){
            if (endEditing()){
                $('#dg').datagrid('appendRow',{status:'P'});
                editIndex = $('#dg').datagrid('getRows').length-1;
                $('#dg').datagrid('selectRow', editIndex)
                        .datagrid('beginEdit', editIndex);
            }
        }
        function removeit(){
            if (editIndex == undefined){return}
            $('#dg').datagrid('cancelEdit', editIndex)
                    .datagrid('deleteRow', editIndex);
            editIndex = undefined;
        }
        function accept(){
            if (endEditing()){
                $('#dg').datagrid('acceptChanges');
            }
        }
        function reject(){
            $('#dg').datagrid('rejectChanges');
            editIndex = undefined;
        }
        function getChanges(){
            var rows = $('#dg').datagrid('getChanges');
            alert(rows.length+' rows are changed!');
        }
    </script>
	</div>
</body>
</html>