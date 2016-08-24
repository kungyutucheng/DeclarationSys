<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入境进区申请</title>
</head>
<body class="easyui-layout">
		<div data-options="region:'north',split:true" title="入境进区申报单" style="height:32%;">
			<form method="post" id="entryForm" style="margin:0 auto;">
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
				                    		label:'出区进口',
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
						<td colspan="3">
							<input class="easyui-combobox"
								style="width:100%;"
								 name="editId"
								 data-options="valueField: 'id',textField: 'ename',url:'${basePath }/ent/getAll',required:true">
						</td>
						<td>合同号</td>
						<td>
							<input name="bargainNo" class="easyui-textbox"
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
						<td>提单号</td>
						<td>
							<input name="blNo" class="easyui-textbox"
							data-options="required:true">
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
							data-options="valueField:'code',textField:'name',url:'${basePath }/region/getAll',required:true">
						</td>
						<td>起运港</td>
						<td>
							<input name="portLoad" class="easyui-combobox"
							data-options="valueField:'code',textField:'name',url:'${basePath }/port/getAll',
							required:true">
						</td>
						<td>起运国/地区</td>
						<td>
							<input name="countryLoad" class="easyui-textbox" value="中国" readonly>
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
							required:true">
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
							required:true">
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
				<div style="width:100%;text-align:center;margin-top:20px;">
					<button type="button" onclick="saveEntry();" class="btn btn-primary myBtn">提交</button>
					<button type="button" onclick="resetForm();" class="btn btn-primary myBtn">重置</button>
					<button type="button" onclick="commit();" class="btn btn-primary myBtn">提交备案</button>
				</div>
			</form>
		</div>
		<div data-options="region:'center',split:true" title="货柜信息" style="height:32%;">
			<table id="conDg">
		    </table>
		    <div id="conToolbar">
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newCon()">添加</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editCon()">修改</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyCon()">删除</a>
		    </div>
		    
		    <div id="dlg" class="easyui-dialog" style="width:400px"
		            closed="true" buttons="#dlg-buttons">
		        <form id="conForm" method="post" style="margin:0;padding:20px 50px">
		            <div style="margin-bottom:10px">
		                <input name="conNo" class="easyui-textbox" required="true" label="箱号" style="width:100%"
		                validType="match[/^[a-zA-Z]{3}[Uu][0-9]{7}$/,'请输入11位字符，且前三位为字母，第四位为U，后七位为数字']">
		            </div>
		            <div style="margin-bottom:10px">
		                <input name="conSize" class="easyui-combobox" required="true" label="尺寸" style="width:100%"
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
		                <input name="conType" class="easyui-combobox" required="true" label="柜型" style="width:100%"
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
		                <input name="sealNo" class="easyui-textbox" label="封条号码" style="width:100%">
		            </div>
		            <input type="hidden" name="eid" id="eid1" value="0">
		        </form>
		    </div>
		    <div id="dlg-buttons">
		        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveCon()" style="width:90px">保存</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
		    </div>
		</div>
		<div data-options="region:'south',split:true" title="货物清单" style="height:32%;">
			<table id="entryGoodDg">
		    </table>
		    <div id="goodToolbar">
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newGood()">添加</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editGood()">修改</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyGood()">删除</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="showGoods()">选择备案商品</a>
		    </div>
		    <div id="goodDlg" class="easyui-dialog" style="width:700px"
		            closed="true" buttons="#goodDlg-buttons">
		        <form id="goodForm" method="post" style="margin:0;padding:20px 50px">
		            <div style="margin-bottom:10px">
		            	<table class="myTable">
		            		<tr>
		            			<td>跨境电商企业</td>
		            			<td>
		            				<input class="easyui-combobox" name="cbeComId" id="cbeComId"  
		            				data-options="required:true,url:'${basePath }/ent/getAll',valueField:'id',textField:'ename'">
		            			</td>
		            			<td>hs码</td>
		            			<td>
		            				<input class="easyui-textbox" name="hsCode" id="hsCode"
		            				data-options="required:true">
		            			</td>
		            		</tr>
		            		<tr>
		            			<td>商品备案号</td>
		            			<td>
		            				<input class="easyui-textbox" name="ciqGoodsNo" id="ciqGoodsNo"
		            				data-options="required:true">
		            			</td>
		            			<td>商品货号</td>
		            			<td>
		            				<input class="easyui-textbox" name="gCode" id="gCode"
		            				data-options="required:true">
		            			</td>
		            		</tr>
		            		<tr>
		            			<td>包装方式</td>
		            			<td>
		            				<input class="easyui-combobox" name="packType"
		            				data-options="required:true,url:'${basePath }/package/getAll',valueField:'code',textField:'name'">
		            			</td>
		            			<td>币种</td>
		            			<td>
		            				<input class="easyui-combobox" name="fCode" id="fCode"
		            				data-options="required:true,url:'${basePath }/currency/getAll',valueField:'code',textField:'name'">
		            			</td>
		            		</tr>
		            		<tr>
		            			<td>单价</td>
		            			<td>
		            				<input class="easyui-numberbox" name="uPric"
		            				data-options="required:true">
		            			</td>
		            			<td>采购城市</td>
		            			<td>
		            				<input class="easyui-textbox" name="buyFromCity"
		            				data-options="required:true">
		            			</td>
		            		</tr>
		            		<tr>
		            			<td>数量</td>
		            			<td>
		            				<input class="easyui-numberbox" name="qty"
		            				data-options="required:true">
		            			</td>
		            			<td>商品批次号</td>
		            			<td>
		            				<input class="easyui-textbox" name="goodsBatchNo"
		            				data-options="required:true">
		            			</td>
		            		</tr>
		            		<tr>
		            			<td>第二数量</td>
		            			<td>
		            				<input class="easyui-numberbox" name="qtp"
		            				data-options="required:true">
		            			</td>
		            			<td>第二数量单位</td>
		            			<td>
		            				<input class="easyui-combobox" name="qtpUnit"
		            				data-options="required:true,url:'${basePath }/unit/getAll',valueField:'code',textField:'name'">
		            			</td>
		            		</tr>
		            		<tr>
		            			<td>毛重</td>
		            			<td>
		            				<input class="easyui-numberbox" name="kgs"
		            				data-options="required:true">
		            			</td>
		            			<td>净重</td>
		            			<td>
		            				<input class="easyui-numberbox" name="net"
		            				data-options="required:true">
		            			</td>
		            		</tr>
		            		<tr>
		            			<td>包装件数</td>
		            			<td>
		            				<input class="easyui-textbox" name="packPieceNum"> 
		            			</td>
		            			<td>箱号</td>
		            			<td>
		            				<input name="contId" id="contId">
		            			</td>
		            		</tr>
		            		<tr>
		            			<td>商品材质</td>
		            			<td>
		            				<input class="easyui-textbox" name="goodsMaterial">
		            			</td>
		            			<td>单位描述</td>
		            			<td>
		            				<input class="easyui-textbox" name="qtyDesc">
		            			</td>
		            		</tr>
		            		<tr>
		            			<td>重量单位</td>
		            			<td>
		            				<input class="easyui-textbox" name="kgsUnit">
		            			</td>
		            			<td>包装数量</td>
								<td>
									<input class="easyui-numberbox" name="packNum">
								</td>		            			
		            		</tr>
		            		<tr>
		            			<td><input type="hidden" name="eid" id="eid2" value="0"></td>
		            		</tr>
		            	</table>
		            </div>
		        </form>
		    </div>
		    <div id="goodDlg-buttons">
		        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveGood()" style="width:90px">保存</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#goodDlg').dialog('close')" style="width:90px">取消</a>
		    </div>
		    <div id="addGoodDlg" class="easyui-dialog" style="width:700px"
		            closed="true" buttons="#addGoodDlg-buttons">
		            <div style="margin-bottom:10px;text-align:center;width:100%;">
		            	<form method="post" id="searchGoodForm" style="text-align:center;width:100%;">
		            		<div style="margin:10px 0;">
		            			<input class="easyui-textbox" name="ciqGoodsNo" label="商品备案号" style="display:inline-block;">
		            			<input class="easyui-textbox" name="gCode" label="商品货号" style="display:inline-block;">
		            			<input class="easyui-textbox" name="gname" label="商品名称" style="display:inline-block;">
		            			<input type="hidden" name="noNotNull" value="1" id="noNotNull">
		            		</div>
		            		<div style="margin:10px 0;">
		            			<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="loadGoodData()" style="width:90px">查询</a>
		        				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="resetGoodForm()" style="width:90px">重置</a>
		            		</div>
		            	</form>
		            	<table id="addGoodDg">
		            	</table>
		            </div>
		    </div>
		    <div id="addGoodDlg-buttons">
		        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="addGood()" style="width:90px">添加</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#addGoodDlg').dialog('close')" style="width:90px">取消</a>
		    </div>
		</div>
	<script>
	
	//记录入境进区提交后的id
	var eid = 0;
	$(function(){
		$("#conDg").datagrid({
			url:"${basePath }/entry/getCon",
			queryParams:{
				eid:$("#eid1").val()
			},
	        toolbar:"#conToolbar", 
	        pagination:true,
	        idField:"id",
	        rownumbers:true,
	        columns:[[
	                  {field:"ck",checkbox:true},
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
	        
		});
		
		$("#entryGoodDg").datagrid({
			url:"${basePath }/entry/getGood",
			queryParams:{
				eid:$("#eid2").val()
			},
	        toolbar:"#goodToolbar", 
	        pagination:true,
	        idField:"id",
	        rownumbers:true,
	        columns:[[
	                  {field:"ck",checkbox:true},
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
	        
		});
	})
	function resetForm(){
		$("#entryForm").form("reset");
	}
	function saveEntry(){
		$("#entryForm").form("submit",{
			url:"${basePath}/entry/saveEntry",
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				var result = eval('('+result+')');
                layer.msg(result.msg);
                if (result.success){
                	//$("#eid1").val(Number(result.data));
                	//$("#eid2").val(Number(result.data));
                	eid = Number(result.data);
                }
			}
		});
	}
	
	var url;
    function newCon(){
    	if(eid == 0){
    		layer.msg("请先提交入境进区申报单");
    		return;
    	}
        $('#dlg').dialog('open').dialog('center').dialog('setTitle','新增');
        $('#conForm').form('reset');
        $("#eid1").val(eid);
        url = '${basePath}/entry/saveCon';
    }
    function editCon(){
        var row = $('#conDg').datagrid('getSelected');
        if (row){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','修改');
            $('#conForm').form('load',row);
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
                    $('#conDg').datagrid('reload',{
        				eid:$("#eid1").val()
        			});  
                }
            }
        });
    }
    function destroyCon(){
        var rows = $('#conDg').datagrid('getChecked');
        if(rows.length == 0){
        	layer.msg("请先选择一条数据");
        	return;
        }
        if (rows){
        	var ids = "";
        	for(var i = 0 ;i < rows.length;i++){
        		ids += rows[i].id + ",";
        	}
        	ids = ids.substr(0,ids.length-1);
            $.messager.confirm('删除','确认删除?',function(r){
                if (r){
                    $.post('${basePath}/entry/deleteCon',{ids:ids},function(result){
                    	var result = $.parseJSON(result);
                    	layer.msg(result.msg);
                        if (result.success){
                            $('#conDg').datagrid('reload',{
                				eid:$("#eid1").val()
                			});    
                            $("#conDg").datagrid("uncheckAll");
                        }
                    });
                }
            });
        }
    }
    function newGood(){
    	if(eid == 0){
    		layer.msg("请先提交入境进区申报单");
    		return;
    	}
        $('#goodDlg').dialog('open').dialog('center').dialog('setTitle','新增');
        $('#goodForm').form('reset');
        $("#eid2").val(eid);
        $("#gCode").textbox("readonly",false);
    	$("#hsCode").textbox("readonly",false);
    	$("#ciqGoodsNo").textbox("readonly",false);
        url = '${basePath}/entry/saveGood';
        loadCon();
    }
    function editGood(){
        var row = $('#entryGoodDg').datagrid('getSelected');
        if (row){
            $('#goodDlg').dialog('open').dialog('center').dialog('setTitle','修改');
            $("#gCode").textbox("readonly",false);
        	$("#hsCode").textbox("readonly",false);
        	$("#ciqGoodsNo").textbox("readonly",false);
            $('#goodForm').form('load',row);
            url = '${basePath}/entry/updateGood?id='+row.id;
            loadCon();
        }
    }
    function saveGood(){
        $('#goodForm').form('submit',{
            url: url,
            onSubmit: function(){
                return $(this).form('validate');
            },
            success: function(result){
                var result = eval('('+result+')');
                layer.msg(result.msg);
                if (result.success){
                    $('#goodDlg').dialog('close');       
                    $('#entryGoodDg').datagrid('reload',{
        				eid:$("#eid2").val()
        			});    
                }
            }
        });
    }
    function destroyGood(){
        var rows = $('#entryGoodDg').datagrid('getSelections');
        if(rows.length == 0){
        	layer.msg("请先选择一条数据");
        	return;
        }
        if (rows){
        	var ids = "";
        	for(var i = 0 ;i < rows.length;i++){
        		ids += rows[i].id + ",";
        	}
        	ids = ids.substr(0,ids.length-1);
            $.messager.confirm('删除','确认删除?',function(r){
                if (r){
                    $.post('${basePath}/entry/deleteGood',{ids:ids},function(result){
                    	var result = $.parseJSON(result);
                    	layer.msg(result.msg);
                        if (result.success){
                            $('#entryGoodDg').datagrid('reload',{
                				eid:$("#eid2").val()
                			});    
                            $("#entryGoodDg").datagrid("uncheckAll");
                        }
                    });
                }
            });
        }
    }
    
    function loadCon(){
    	$("#contId").combobox({
    		url:"${basePath}/entry/getConByEid",
    		queryParams:{
    			eid:$("#eid2").val()
    		},
    		valueField:"id",
    		textField:"conNo"
    	});
    }
    
    function showGoods(){
    	if(eid == 0){
    		layer.msg("请先提交入境进区申报单");
    		return;
    	}
    	$('#searchGoodForm').form('reset');
    	$("#eid2").val(eid);
    	$('#addGoodDlg').dialog('open').dialog('center').dialog('setTitle','选择备案商品');
    	loadGoodData();
    }
    
    function loadGoodData(){
    	$("#addGoodDg").datagrid({
    		url:"${basePath}/good/searchgrid",
    		queryParams:$("#searchGoodForm").serializeObject(),
    		rownumbers:true,
    		singleSelect:true,
    		pagination:true,
    		columns:[[
    			{field:"id",hidden:true},
    			{field:"ciqGoodsNo",width:100,title:"商品备案号"},
    			{field:"gCode",width:100,title:"商品货号"},
    			{field:"gname",width:100,title:"商品名称"}
    		]]
    	});
    }
    function resetGoodForm(){
    	$("#searchGoodForm").form("reset");
    }
    function addGood(){
    	var row = $("#addGoodDg").datagrid("getSelected");
    	if(row){
	    	$('#goodForm').form('reset');
	    	$('#goodForm').form('load',row);
	    	$("#gCode").textbox("readonly",true);
	    	$("#hsCode").textbox("readonly",true);
	    	$("#ciqGoodsNo").textbox("readonly",true);
	    	$('#goodDlg').dialog('open').dialog('center').dialog('setTitle','新增');
	    	url = '${basePath}/entry/saveGood';
	    	loadCon();
    	}else{
    		layer.msg("请先选择一条记录");
    	}
    }
    
    function commit(){
    	if(eid == 0){
    		layer.msg("请先提交入境进区申报单");
    		return;
    	}
    	var row = $("#entryGoodDg").datagrid("getRows"); 
    	if(!row || row.length == 0){
    		layer.msg("请添加货物");
    		return;
    	}
    	$.messager.confirm("提交备案","确认提交？",function(r){
			if(r){
				$.post("${basePath}/entry/commit",{id:eid},function(result){
					var result = $.parseJSON(result);
					layer.msg(result.msg);
				});
			}
		});
    }
	</script>
</body>
</html>