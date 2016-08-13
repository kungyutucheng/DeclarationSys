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
			<div id="tb" style="height:auto">
		        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="javascript:$('#tt').edatagrid('addRow')">Append</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="javascript:$('#tt').edatagrid('destroyRow')">Remove</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="javascript:$('#tt').edatagrid('saveRow')">Accept</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="javascript:$('#tt').edatagrid('cancelRow')">Reject</a>
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
			});
			
			$('#tt').edatagrid({
				onSave:function(index,row){
					console.log("index:" + index + ",row:" + row.id);
				}
			});
		});
		
		
	</script>
      <%-- <table id="dg" class="easyui-datagrid" title="Row Editing in DataGrid" style="width:700px;height:auto"
            data-options="
                iconCls: 'icon-edit',
                singleSelect: true,
                toolbar: '#tb',
                url: '${basePath }/user/test',
                method: 'get',
                onClickCell: onClickCell,
                onEndEdit: onEndEdit,
                pagination:true,
                onLoadSuccess:function(data){
                	console.log(data)
                }
            ">
        <thead>
            <tr>
                <th data-options="field:'id',width:80">Item ID</th>
                <th data-options="field:'mname',width:100,editor:'textbox'">Product</th>
                <th data-options="field:'url',width:80,align:'right',editor:'textbox'">List Price</th>
                <th data-options="field:'pid',width:80,align:'right',editor:'textbox'">List Price</th>
                <th data-options="field:'sort',width:80,align:'right',editor:'textbox'">List Price</th>
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
    
    <script type="text/javascript">
        var editIndex = undefined;
        function endEditing(){
        	console.log("endEditing");
            if (editIndex == undefined){return true}
            console.log("endEditing:if");
            if ($('#dg').datagrid('validateRow', editIndex)){
            	console.log("endEditing:" + editIndex);
                $('#dg').datagrid('endEdit', editIndex);
                console.log("endEditing:true");
                editIndex = undefined;
                return true;
            } else {
            	console.log("endEditing:false");
                return false;
            }
        }
        function onClickCell(index, field){
        	console.log("onClickCell:"+index);
            if (editIndex != index){
            	console.log("onClickCell1:"+index);
                if (endEditing()){
                	try{
                    $('#dg').datagrid('selectRow', index)
                            .datagrid('beginEdit', index);
                	}catch(e){
                		console.log(e);
                	}
                	console.log("onClickCell22222:"+index);
                    var ed = $('#dg').datagrid('getEditor', {index:index,field:field});
                    if (ed){
                    	console.log("onClickCell3:"+index);
                        ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
                    }
                    editIndex = index;
                } else {
                	console.log("onClickCell4:"+index);
                    setTimeout(function(){
                        $('#dg').datagrid('selectRow', editIndex);
                    },0);
                }
            }
        }
        function onEndEdit(index, row){
        	console.log("onEndEdit:"+index);
            var ed = $(this).datagrid('getEditor', {
                index: index,
                field: 'url'
            });
            row.productname = $(ed.target).combobox('getText');
        }
        function append(){
        	console.log("append");
            if (endEditing()){
            	console.log("append1");
                $('#dg').datagrid('appendRow');
                console.log("append2");
                editIndex = $('#dg').datagrid('getRows').length-1;
                console.log("append3");
                $('#dg').datagrid('selectRow', editIndex)
                        .datagrid('beginEdit', editIndex);
                console.log("append4");
            }
        }
        function removeit(){
        	console.log("remove");
            if (editIndex == undefined){return}
            $('#dg').datagrid('cancelEdit', editIndex)
                    .datagrid('deleteRow', editIndex);
            editIndex = undefined;
        }
        function accept(){
        	console.log("accept");
            if (endEditing()){
                $('#dg').datagrid('acceptChanges');
            }
        }
        function reject(){
        	console.log("reject");
            $('#dg').datagrid('rejectChanges');
            editIndex = undefined;
        }
        function getChanges(){
        	console.log("getChange");
            var rows = $('#dg').datagrid('getChanges');
            alert(rows.length+' rows are changed!');
        }
    </script> --%>
</body>
</html>