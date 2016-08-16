<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入境进区申请</title>
</head>
<body>
	<div class="easyui-layout" style="height:1400px;">
		<div data-options="region:'north',split:true" title="入境进区申报单" style="height:660px;">
			<form method="post" id="addForm">
				<div class="subTitle">基础信息</div>
				<hr/>
				<table class="myTable">
					<tr>
						<td>申报机构</td>
						<td>
							<input name="ciqbCode" class="easyui-combobox"
				            data-options="valueField:'code',textField:'name',url:'${basePath }/org/getAll',required:true">
						</td>
						<td>申报日期</td>
						<td>
							<input name="declarationDate" class="easyui-datebox"
							data-options="required:true">
						</td>
						<td>运输工具</td>
						<td>
							<select name="tblType" class="easyui-combobox"
				                    	 data-options="
				                    	 valueField:'value',
				                    	textField:'label',
				                    	data:[{
				                    		label:'飞机',
				                    		value:'1'
				                    	},{
				                    		label:'卡车',
				                    		value:'2'
				                    	},{
				                    		label:'火车',
				                    		value:'3'
				                    	},{
				                    		label:'其他',
				                    		value:'4'
				                    	},{
				                    		label:'海运集装箱',
				                    		value:'5'
				                    	},{
				                    		label:'陆运集装箱',
				                    		value:'6'
				                    	},{
				                    		label:'空运集装箱',
				                    		value:'7'
				                    	}],
				                    	 icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
							</select>
						</td>
					</tr>
					<tr>
						<td>运输工具名称</td>
						<td>
							<input name="toolName" class="easyui-textbox">
						</td>
						<td>运输工具号</td>
						<td>
							<input name="toolNo" class="easyui-textbox">
						</td>
						<td>到货日期</td>
						<td>
							<input name="arrivalDate" class="easyui-datebox" data-options="required:true">
						</td>
					</tr>
					<tr>
						<td>卸毕日期</td>
						<td>
							<input name="uploadDate" class="easyui-datebox" 
							data-options="icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
						</td>
						<td>目的地</td>
						<td>
							<input name="destination" class="easyui-textbox">
						</td>
						<td>存货地点</td>
						<td>
							<input name="stockLocation" class="easyui-textbox">
						</td>
					</tr>
					<tr>
						<td>报检类别</td>
						<td>
							<select name="tblType" class="easyui-combobox"
				                    	 data-options="
				                    	 valueField:'value',
				                    	textField:'label',
				                    	data:[{
				                    		label:'入境检验检疫',
				                    		value:'13'
				                    	},{
				                    		label:'入境流向',
				                    		value:'14'
				                    	},{
				                    		label:'入境验证',
				                    		value:'15'
				                    	}],
				                    	 icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
							</select>
						</td>
						<td>报检申报类别</td>
						<td>
							<select name="tblReportType" class="easyui-combobox"
				                    	 data-options="
				                    	 valueField:'value',
				                    	textField:'label',
				                    	data:[{
				                    		label:'一般进口',
				                    		value:'01'
				                    	},{
				                    		label:'出去进口',
				                    		value:'03'
				                    	},{
				                    		label:'境外进口',
				                    		value:'05'
				                    	},
				                    	{
				                    		label:'进境集装箱重箱',
				                    		value:'07'
				                    	},{
				                    		label:'进境集装箱空箱',
				                    		value:'09'
				                    	}],
				                    	 icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
							</select>
						</td>
						<td>索赔期（天）</td>
						<td>
							<input name="claimDays" class="easyui-numberbox">
						</td>
					</tr>
					<tr>
						<td>特殊要求</td>
						<td>
							<input name="specRequire" class="easyui-textbox">
						</td>
						<td>报关单号</td>
						<td>
							<input name="customDeclareNo" class="easyui-textbox">
						</td>
					</tr>
				</table>
				<div class="subTitle">报检信息</div>
				<hr/>
				<table class="myTable">
					<tr>
						<td>外贸综合服务企业</td>
						<td>
							<input class="easyui-combobox"
								 name="editId"
								 data-options="valueField: 'id',textField: 'ename',url:'${basePath }/ent/getAll',required:true">
						</td>
						<td>合同号</td>
						<td>
							<input name="bargainNo" class="easyui-textbox"
							data-options="required:true">
						</td>
						<td>提单号</td>
						<td>
							<input name="blNo" class="easyui-textbox"
							data-options="required:true">
						</td>
					</tr>
					<tr>
						<td>发货人中文名</td>
						<td colspan="2">
							<input name="shipperName" style="width:100%;" class="easyui-textbox"
							data-options="required:true">
						</td>
						<td>收货人中文名</td>
						<td colspan="2">
							<input name="consigneeName" style="width:100%;" class="easyui-textbox"
							data-options="required:true">
						</td>
					</tr>
					<tr>
						<td>发货人英文名</td>
						<td colspan="2">
							<input name="shipperNameEn" style="width:100%;" class="easyui-textbox">
						</td>
						<td>收货人英文名</td>
						<td colspan="2">
							<input name="consigneeNameEn" style="width:100%;" class="easyui-textbox">
						</td>
					</tr>
					<tr>
						<td>发货人地址</td>
						<td colspan="2">
							<input name="shipperAddr" style="width:100%;" class="easyui-textbox">
						</td>
						<td>收货人地址</td>
						<td colspan="2">
							<input name="consigneeAddr" style="width:100%;" class="easyui-textbox">
						</td>
					</tr>
					<tr>
						<td>贸易方式</td>
						<td>
							<input name="tradeType" class="easyui-combobox"
							data-options="valueField:'code',textField:'name',url:'${basePath }/tradeType/getAll',
							icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
						</td>
						<td>监管方式</td>
						<td>
							<input name="chargeType" class="easyui-combobox"
							data-options="valueField:'code',textField:'name',url:'${basePath }/chargeType/getAll',
							icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
						</td>
						<td>贸易国别</td>
						<td>
							<input name="tradeCode" class="easyui-combobox"
							data-options="valueField:'code',textField:'name',url:'${basePath }/region/getAll',required:true">
						</td>
					</tr>
					<tr>
						<td>起运港</td>
						<td>
							<input name="portLoad" class="easyui-combobox"
							data-options="valueField:'code',textField:'name',url:'${basePath }/port/getAll',
							required:true">
						</td>
						<td>起运国/地区</td>
						<td>
							<input name="countryLoad" class="easyui-textbox" disabled>
						</td>
						<td>经停港</td>
						<td>
							<input name="portStop" class="easyui-combobox"
							data-options="valueField:'code',textField:'name',url:'${basePath }/port/getAll',
							icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
						</td>
					</tr>
					<tr>
						<td>目的港</td>
						<td>
							<input name="portDis" class="easyui-combobox"
							data-options="valueField:'code',textField:'name',url:'${basePath }/port/getAll',
							required:true">
						</td>
						<td>唛头</td>
						<td>
							<input name="markNo" class="easyui-textbox">
						</td>
						<td>币种</td>
						<td>
							<input name="fCode" class="easyui-combobox"
							data-options="valueField:'code',textField:'name',url:'${basePath }/currency/getAll',
							required:true">
						</td>
					</tr>
					<tr>
						<td>申报类型</td>
						<td>
							<input name="reportType" class="easyui-combobox"
							data-options="valueField:'value',textField:'label',
							data:[{
								label:'预申报',
								value:10
								},{
								label:'入仓申报',
								value:20
								}
							],icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
						</td>
						<td>预申报编码</td>
						<td>
							<input name="declCode" class="easyui-textbox">
						</td> 
					</tr>
				</table>
				<div style="width:100%;text-align:center;margin-top:20px;">
					<button type="button" onclick="submitForm();" class="btn btn-primary myBtn">提交</button>
					<button type="button" onclick="resetForm();" class="btn btn-primary myBtn">重置</button>
				</div>
			</form>
		</div>
		<div data-options="region:'center',split:true" title="货柜信息" style="height:200px;">
			<table id="conDg" class="easyui-datagrid"
            url="${basePath }/entry/getCon"
            toolbar="#toolbar" pagination="true"
            idField="id"
            rownumbers="true">
		        <thead>
		            <tr>
		            	<th field="id" width="50" hidden="true">id</th>
		                <th field="conNo" width="50">箱号</th>
		                <th field="conSize" width="50">尺寸</th>
		                <th field="conType" width="50">柜型</th>
		                <th field="sealNo" width="50">封条号码</th>
		            </tr>
		        </thead>
		    </table>
		    <div id="toolbar">
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newCon()">添加</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editCon()">修改</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyCon()">删除</a>
		    </div>
		    
		    <div id="dlg" class="easyui-dialog" style="width:400px"
		            closed="true" buttons="#dlg-buttons">
		        <form id="conForm" method="post" style="margin:0;padding:20px 50px">
		            <div style="margin-bottom:10px">
		                <input name="conNo" class="easyui-textbox" required="true" label="箱号:" style="width:100%">
		            </div>
		            <div style="margin-bottom:10px">
		                <input name="conSize" class="easyui-combobox" required="true" label="尺寸:" style="width:100%"
		                data-options="valueField:'value',textField:'label',
							data:[{
								label:'10:10',
								value:'10:10'
								},{
								label:'20:20',
								value:'20:20'
								},{
								label:'25:25',
								value:'25:25'
								},{
								label:'40:40',
								value:'40:40'
								},{
								label:'45:45',
								value:'45:45'
								}
							]">
		            </div>
		            <div style="margin-bottom:10px">
		                <input name="conType" class="easyui-combobox" required="true" label="柜型:" style="width:100%"
		                data-options="valueField:'value',textField:'label',
							data:[{
								label:'普通箱',
								value:'A'
								},{
								label:'超高柜',
								value:'B'
								},{
								label:'冷藏',
								value:'C'
								},{
								label:'罐式',
								value:'D'
								}
							]">
		            </div>
		            <div style="margin-bottom:10px">
		                <input name="sealNo" class="easyui-textbox" label="封条号码:" style="width:100%">
		            </div>
		            <input type="text" name="eid" id="eid">
		        </form>
		    </div>
		    <div id="dlg-buttons">
		        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveCon()" style="width:90px">保存</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
		    </div>
		</div>
		<div data-options="region:'south',split:true" title="货物清单" style="height:200px;">
		</div>
	</div>
	<script>
	$(function(){
		$("#eid").val("2");
	})
	function resetForm(){
		$("#addForm").form("reset");
	}
	var url;
    function newCon(){
        $('#dlg').dialog('open').dialog('center').dialog('setTitle','新增');
        $('#conForm').form('clear');
        url = '${basePath}/entry/saveCon';
    }
    function editCon(){
        var row = $('#conDg').datagrid('getSelected');
        if (row){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','修改');
            $('#fm').form('load',row);
            url = '${basePath}/entry/updateCon?id='+row.id;
        }
    }
    function saveCon(){
        $('#conForm').form('submit',{
            url: url,
            onSubmit: function(){
                return $(this).form('validate');
            },
            success: function(result){
                var result = eval('('+result+')');
                layer.msg(result.msg);
                if (result.success){
                    $('#dlg').dialog('close');       
                    $('#conDg').datagrid('reload');    
                }
            }
        });
    }
    function destroyUser(){
        var row = $('#conDg').datagrid('getSelected');
        if (row){
            $.messager.confirm('删除','确认删除?',function(r){
                if (r){
                    $.post('${basePath}/entry/deleteCon',{id:row.id},function(result){
                    	var result = eval('('+result+')');
                    	layer.msg(result.msg);
                        if (result.success){
                            $('#conDg').datagrid('reload');    
                        }
                    },'json');
                }
            });
        }
    }
	</script>
</body>
</html>