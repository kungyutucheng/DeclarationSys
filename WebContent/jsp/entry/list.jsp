<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入境进区查询</title>
</head>
<body class="easyui-layout">
	<div class="easyui-layout" data-options="region:'north',split:true" title="查询条件">
		<form id="searchForm" method="post">
			<div class="subTitle"></div>
			<hr/>
			<table class="myTable">
				<tr>
					<td>申报机构</td>
					<td>
						<input name="ciqbCode" class="easyui-combobox"
				        data-options="valueField:'code',textField:'name',url:'${basePath }/org/getAll',
				        icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
					</td>
					<td>申报日期</td>
					<td colspan="3">
						<input name="startDeclarationDate" class="easyui-datebox"
						data-options="icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">&nbsp;-
						<input name="endDeclarationDate" class="easyui-datebox"
						data-options="icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
					</td>
				</tr>
				<tr>
					<td>运输工具</td>
					<td>
					<input name="tool" class="easyui-combobox"
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
					</td>
					<td>运输工具名称</td>
					<td>
						<input name="toolName" class="easyui-textbox">
					</td>
					<td>运输工具号</td>
					<td>
						<input name="toolNo" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>到货日期</td>
					<td colspan="3">
						<input name="startArrivalDate" class="easyui-datebox"
						 data-options="icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">&nbsp;-
						<input name="endArrivalDate" class="easyui-datebox"
						data-options="icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
					</td>
					<td>目的地</td>
					<td>
						<input name="destination" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>卸毕日期</td>
					<td colspan="3">
						<input name="startUploadDate" class="easyui-datebox"
						 data-options="icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">&nbsp;-
						<input name="endUploadDate" class="easyui-datebox"
						data-options="icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
					</td>
					<td>目的地</td>
					<td>
						<input name="stockLocation" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>报检类别</td>
					<td>
						<input name="tblType" class="easyui-combobox"
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
					</td>
					<td>报检申报类别</td>
					<td>
						<input name="tblReportType" class="easyui-combobox"
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
					</td>
					<td>特殊要求</td>
					<td>
						<input name="specRequire" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>索赔期</td>
					<td colspan="3">
						<input name="startClaimDays" class="easyui-numberbox">&nbsp;-
						<input name="endClaimDays" class="easyui-numberbox">
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
					<td colspan="3">
						<input class="easyui-combobox"
							style="width:100%;"
							 name="editId"
							 data-options="valueField: 'id',textField: 'ename',url:'${basePath }/ent/getAll'">
					</td>
					<td>合同号</td>
					<td>
						<input name="bargainNo" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>发货人中文名</td>
					<td colspan="2">
						<input name="shipperName" style="width:100%;" class="easyui-textbox">
					</td>
					<td>收货人中文名</td>
					<td colspan="2">
						<input name="consigneeName" style="width:100%;" class="easyui-textbox">
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
					<td>提单号</td>
					<td>
						<input name="blNo" class="easyui-textbox">
					</td>
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
				</tr>
				<tr>
					<td>贸易国别</td>
					<td>
						<input name="tradeCode" class="easyui-combobox"
						data-options="valueField:'code',textField:'name',url:'${basePath }/region/getAll',
						icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
					</td>
					<td>起运港</td>
					<td>
						<input name="portLoad" class="easyui-combobox"
						data-options="valueField:'code',textField:'name',url:'${basePath }/port/getAll',
						icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
					</td>
					<td>起运国/地区</td>
					<td>
						<input name="countryLoad" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>经停港</td>
					<td>
						<input name="portStop" class="easyui-combobox"
						data-options="valueField:'code',textField:'name',url:'${basePath }/port/getAll',
						icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
					</td>
					<td>目的港</td>
					<td>
						<input name="portDis" class="easyui-combobox"
						data-options="valueField:'code',textField:'name',url:'${basePath }/port/getAll',
						icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
					</td>
					<td>唛头</td>
					<td>
						<input name="markNo" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>币种</td>
					<td>
						<input name="fCode" class="easyui-combobox"
						data-options="valueField:'code',textField:'name',url:'${basePath }/currency/getAll',
						icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
					</td>
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
		</form>		
	</div>
	<div class="easyui-layout" data-options="region:'center',split:true" title="查询结果">
	</div>

</body>
</html>