<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/datagrid-detailview.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入境进区查询</title>
</head>
<body>
	<fieldset>
		<legend>查询条件</legend>
		<form id="searchForm" method="post">
			<div class="subTitle">基础信息</div>
			<hr/>
			<table class="myTable">
				<tr>
					<td>申报机构</td>
					<td>
						<input name="ciqbCode" class="easyui-combobox"
				        data-options="valueField:'code',textField:'name',url:'${basePath }/org/getAll',
				        icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
					</td>
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
					<td>状态</td>
					<td>
						<input name="status" class="easyui-combobox"
						data-options="valueField:'value',textField:'label',
						data:[{
			                   label:'待发送',
			                   value:1
			                  },{
				               label:'已发送',
				               value:2
				              },{
				               label:'待审核',
				               value:3
				              },{
				               label:'接收失败',
				               value:4
				              },{
				               label:'审核成功',
				               value:5
				              },{
				               label:'审核查验',
				               value:6
				              },{
				               label:'审核失败',
				               value:7
				              }],
				             icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
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
						<input name="destination" class="easyui-textbox">
					</td>
					
				</tr>
				<tr>
					<td>申报日期</td>
					<td colspan="3">
						<input name="startDeclarationDate" class="easyui-datebox"
						data-options="icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">&nbsp;-
						<input name="endDeclarationDate" class="easyui-datebox"
						data-options="icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear');}}]">
					</td>
					<td>存货地点</td>
					<td>
						<input name="stockLocation" class="easyui-textbox">
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
			<div style="width:100%;text-align:center;">
				<button type="button" class="btn btn-primary myBtn" onclick="search();">查询</button>
				<button type="button" class="btn btn-primary myBtn" onclick="resetForm();">重置</button>
			</div>
		</form>
	</fieldset>
	<fieldset>
		<legend>查询结果</legend>
		<table id="entryDg" style="width:100%;"></table>
		<div id="toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="commit()">提交备案</a>
		</div>
	</fieldset>
	<script>
	$(function(){
		$("#entryDg").datagrid({
			url:"${basePath}/entry/getEntry",
			pagination:true,
			rownumbers:true,
			toolbar:"#toolbar",
			queryParams:$("#searchForm").serializeObject(),
			columns:[[
			          {field:"id",hidden:true},
			          {field:"entInBoundNo",title:"企业自编号",width:100},
			          {field:"status",title:"状态",width:50,formatter:function(value,row,index){
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
			        		  return "<font color='green'>审核成功</font>";
			        	  }else if(value == 6){
			        		  return "<font color='yellow'>审核查验</font>";
			        	  }else if(value == 7){
			        		  return "<font color='red'>审核失败</font>";
			        	  }else{
			        		  return value;
			        	  }
			          }},
			          {field:"operType",title:"操作类型",width:50,formatter:function(value,row,index){
			        	  if(value == "A"){
			        		  return "<font color='blue'>新增</font>";
			        	  }else if(value == "M"){
			        		  return "<font color='purple'>变更</font>";
			        	  }else{
			        		  return value;
			        	  }
			          }},
			          {field:"declarationDate",title:"申报日期",width:100,formatter:function(value,row,index){
			        	  return (new Date(value)).format("yyyy-MM-dd");
			          }},
			          {field:"ciqbName",title:"审核机构名称",width:150},
			          {field:"bargainNo",title:"合同号",width:100},
			          {field:"shipperName",title:"发货人姓名",width:100},
			          {field:"shipperNameEn",title:"发货人英文名",width:100},
			          {field:"shipperAddr",title:"发货人地址",width:200},
			          {field:"consigneeName",title:"收货人姓名",width:100},
			          {field:"consigneeNameEn",title:"收货人英文名",width:100},
			          {field:"consigneeAddr",title:"收货人地址",width:200},
			          {field:"portLoadName",title:"起运港",width:100},
			          {field:"portDisName",title:"目的港",width:100},
			          {field:"fName",title:"币种",width:50},
			          {field:"tool",title:"运输工具",width:100,formatter:function(value,row,index){
			        	  if(value == 1){
			        		  return "<font color='blue'>飞机</font>";
			        	  }else if(value == 2){
			        		  return "<font color='purple'>卡车</font>";
			        	  }else if(value == 3){
			        		  return "<font color='orange'>火车</font>";
			        	  }else if(value == 4){
			        		  return "<font color='pink'>船</font>";
			        	  }else if(value == 5){
			        		  return "<font color='brown'>其他</font>";
			        	  }else if(value == 6){
			        		  return "<font color='green'>海运集装箱</font>";
			        	  }else if(value == 7){
			        		  return "<font color='red'>陆运集装箱</font>";
			        	  }else if(value == 8){
			        		  return "<font color='yellow'>空运集装箱</font>";
			        	  }else{
			        		  return value;
			        	  }
			        	  
			          }},
			          {field:"toolName",title:"运输工具名称",width:100},
			          {field:"toolNo",title:"运输工具号",width:100},
			          {field:"blNo",title:"提单号",width:100},
			          {field:"arrivalDate",title:"到货日期",width:100,formatter:function(value,row,index){
			        	  return (new Date(value)).format("yyyy-MM-dd");
			          }},
			          {field:"uploadDate",title:"卸毕日期",width:100,formatter:function(value,row,index){
			        	  return (new Date(value)).format("yyyy-MM-dd");
			          }},
			          {field:"destination",title:"目的地",width:150},
			          {field:"stockLocation",title:"存货地点",width:150},
			          {field:"tradeName",title:"贸易国别",width:100},
			          {field:"countryLoad",title:"起运国",width:100},
			          {field:"portStopName",title:"经停港",width:100},
			          {field:"tradeTypeName",title:"贸易方式",width:100},
			          {field:"chargeTypeName",title:"监管方式",width:100},
			          {field:"tblType",title:"报检类别",width:100,formatter:function(value,row,index){
			        	  if(value == "13"){
			        		  return "<font color='blue'>入境检验检疫</font>";
			        	  }else if(value == "14"){
			        		  return "<font color='purple'>入境流向</font>";
			        	  }else if(value == "15"){
			        		  return "<font color='orange'>入境验证</font>";
			        	  }else{
			        		  return value;
			        	  }
			          }},
			          {field:"tblReportType",title:"报检申报类别",width:100,formatter:function(value,row,index){
			        	  if(value == "01"){
			        		  return "<font color='blue'>一般进口</font>";
			        	  }else if(value == "03"){
			        		  return "<font color='purple'>出区进口</font>";
			        	  }else if(value == "05"){
			        		  return "<font color='orange'>境外进口</font>";
			        	  }else if(value == "07"){
			        		  return "<font color='pink'>进境集装箱重箱</font>";
			        	  }else if(value == "09"){
			        		  return "<font color='brown'>进境集装箱空箱</font>";
			        	  }else{
			        		  return value;
			        	  }
			          }},
			          {field:"markNo",title:"唛头",width:100},
			          {field:"claimDays",title:"索赔期（天）",width:50},
			          {field:"specRequire",title:"特殊要求",width:150},
			          {field:"customDeclareNo",title:"报关单号",width:100},
			          {field:"reportType",title:"申报类型",width:50,formatter:function(value,row,index){
			        	  if(value == "10"){
			        		  return "<font color='blue'>预申报</font>";
			        	  }else if(value == "20"){
			        		  return "<font color='purple'>入仓申报</font>";
			        	  }else{
			        		  return value;
			        	  }
			          }},
			          {field:"declCode",title:"预申报编码",width:100},
			          {field:"editName",title:"跨境电商企业",width:200},
			          {field:"eportInboundNo",title:"ICIP平台标识",width:100},
			          {field:"regStatusDesc",title:"审核备注",width:100},
			          {field:"createTime",title:"创建时间",width:150,formatter:function(value,row,index){
			        	  return (new Date(value)).format("yyyy-MM-dd hh:mm:ss");
			          }}
			     ]],
			     view:detailview,
			     detailFormatter:function(index , row){
			    	 return "<table id='goodDg'></table>"+
				     "<table id='conDg' style='width:auto;'></table>";
			     },
			     onExpandRow:function(index,row){
			    	 var goodDg = $(this).datagrid("getRowDetail",index).find("#goodDg");
			    	 goodDg.datagrid({
			    		 url:"${basePath}/entry/getGood?eid=" + row.id,
			    		 cache:true,
			    		 singleSelect:true,
			    		 rownumebrs:true,
			    		 height:"auto",
			    		 pagination:true,
			    		 columns:[[
			 	                  {field:"id",hidden:true,title:"id"},
			 	                  {field:"cbeComName",title:"跨境电商企业",width:300},
			 	                  {field:"hsCode",title:"hs码",width:80},
			 	                  {field:"ciqGoodsNo",title:"商品备案号",width:100},
			 	                  {field:"gCode",title:"商品货号",width:100},
			 	                  {field:"goodsMaterial",title:"商品材质",width:200},
			 	                  {field:"packTypeName",title:"包装类型",width:200},
			 	                  {field:"fName",title:"货币",width:100},
			 	                  {field:"uPric",title:"单价",width:100},
			 	                  {field:"buyFromCity",title:"采购城市",width:100},
			 	                  {field:"qty",title:"数量",width:100},
			 	                  {field:"qtyDesc",title:"单位描述",width:100},
			 	                  {field:"qtp",title:"第二数量",width:100},
			 	                  {field:"qtpUnitName",title:"第二数量单位",width:100},
			 	                  {field:"kgs",title:"毛重",width:100},
			 	                  {field:"fcy",title:"净重",width:100},
			 	                  {field:"conNo",title:"箱号",width:100},
			 	                  {field:"kgsUnit",title:"重量单位",width:100},
			 	                  {field:"packNum",title:"包装数量",width:100},
			 	                  {field:"goodsBatchNo",title:"商品批次号",width:100},
			 	                  {field:"packPieceNum",title:"包装件数",width:100},
			 	                  {field:"createTime",title:"创建时间",width:200,formatter:function(value,row,index){
			 	                	  return (new Date(value)).format("yyyy-MM-dd hh:mm:ss");
			 	                  }},
			 	                  ]],
			 	     	 onResize:function(){
			 	     		 $("#entryDg").datagrid("fixDetailRowHeight",index);
			 	     	 },
			 	     	 onLoadSuccess:function(){
			 	     		 setTimeout(function(){
			 	     			 $("#entryDg").datagrid("fixDetailRowHeight",index);
			 	     		 },0);
			 	     	 }
			    	 });
			    	 var goodDg = $(this).datagrid("getRowDetail",index).find("#conDg");
			    	 goodDg.datagrid({
			    		 url:"${basePath}/entry/getCon?eid=" + row.id,
			    		 cache:true,
			    		 singleSelect:true,
			    		 rownumebrs:true,
			    		 height:"auto",
			    		 pagination:true,
			    		 columns:[[
							{field:"id",hidden:true,title:"id"},
							{field:"conNo",title:"箱号",width:150},
							{field:"conSize",title:"尺寸",width:150},
							{field:"conType",title:"柜型",width:150,formatter:function conTypeFormatter(value,row,index){
								if(value == "A"){
									return "<font color='blue'>普通箱</font>";
								}
								else if(value == "B"){
									return "<font color='pink'>超高柜</font>";
								}
								else if(value == "C"){
									return "<font color='green'>冷藏</font>";
								}
								else if(value == "D"){
									return "<font color='red'>罐式</font>";
								}
							}},
							{field:"sealNo",title:"封条号码",width:200}
			 	         ]],
			 	     	 onResize:function(){
			 	     		 $("#entryDg").datagrid("fixDetailRowHeight",index);
			 	     	 },
			 	     	 onLoadSuccess:function(){
			 	     		 setTimeout(function(){
			 	     			 $("#entryDg").datagrid("fixDetailRowHeight",index);
			 	     		 },0);
			 	     	 }
			    	 });
			    	 $("#entryDg").datagrid("fixDetailRowHeight",index);
			   	}
			});
		}
	);
	
	function resetForm(){
		$("#searchForm").form("reset");
	}
	
	function search(){
		$("#entryDg").datagrid("reload",$("#searchForm").serializeObject());
	}
	
	function commit(){
		var row = $("#entryDg").datagrid("getSelected");
		if(row && row.status == 0){
			$.messager.confirm("提交备案","确认提交？",function(r){
				if(r){
					$.post("${basePath}/entry/commit",{id:row.id},function(result){
						var result = $.parseJSON(result);
						layer.msg(result.msg);
						if(result.success){
							$("#entryDg").datagrid("reload",$("#searchForm").serializeObject());
						}
					});
				}
			});
		}else{
			layer.msg("请选择一条状态为新增的数据");
		}
	}
	</script>
</body>
</html>