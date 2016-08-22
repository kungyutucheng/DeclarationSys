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
				<form id="goodMainForm" method="post">
		            <table class="myTable">
		                <tr>
		                    <td>国检组织机构</td>
		                    <td><input id="ciqbCode" name="ciqbCode" class="f1 easyui-combobox"
		                    	style="width:100%;" data-options="valueField:'code',textField:'name',url:'${basePath }/org/getAll',required:true">
		                    </td>
		                    <td>跨境电商企业</td>
		                    <td>
								<input id="cbeComId" class="easyui-combobox"
								 name="cbeComId" style="width:100%;" data-options="valueField: 'id',textField: 'ename',url:'${basePath }/ent/getAll',required:true">
							</td>
						</tr>
						<tr>
		                    <td>制单企业</td>
		                    <td>
		                    	<input id="editId" class="easyui-combobox"
								 name="editId" style="width:100%;" data-options="valueField: 'id',textField: 'ename',url:'${basePath }/ent/getAll',required:true">
		                    </td>
		                </tr>
		                <tr>
		                    <td>备注</td>
		                    <td colspan="3"><input id="remark" name="remark"class="f1 easyui-textbox" style="width:100%;"></input></td>
		                </tr>
		                <tr>
		                    <td></td>
		                    <td><input type="button" class="btn btn-primary myBtn" value="提交" style="width:auto;" onclick="saveGoodMain();"></td>
		                    <td><input type="button" class="btn btn-primary myBtn" value="修改" style="width:auto;" onclick="reviseGoodMain();"></td>
		                    <td><input type="button" class="btn btn-primary myBtn" value="重置" style="width:auto;" onclick="resetForm();"></td>
		                </tr>
		            </table>
		            <input type="hidden" name="id" id="id1" value="0">
		        </form>
			</div> 
		</div>
		<div data-options="region:'center',split:true" title="备案商品详细" style="height:auto;">
			<table id="goodDg"></table>
			<div id="conToolbar">
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newGood()">添加</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editGood()">修改</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyGood()">删除</a>
		    </div>
		    <div id="dlg" class="easyui-dialog" style="width:400px"
		            closed="true" buttons="#dlg-buttons">
		    	<form id="goodForm">
		    		<table class="myTable">
		    			<tr>
		    				<td>商品货号</td>
		    				<td>
		    					<input class="easyui-textbox" name="gCode"
		    					data-options="required:true">
		    				</td>
		    				<td>商品名称</td>
		    				<td>
		    					<input class="easyui-textbox" name="gname"
		    					data-options="required:true">
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>规格型号</td>
		    				<td>
		    					<input class="easyui-textbox" name="spec"
		    					data-options="required:true">
		    				</td>
		    				<td>hs码</td>
		    				<td>
		    					<input class="easyui-textbox" name="hsCode"
		    					data-options="required:true">
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>计量单位</td>
		    				<td>
		    					<input class="easyui-combobox" name="unit"
		    					data-options="required:true,valueField:'code',textField:'name',url:'${basePath }/unit/getAll'">
		    				</td>
		    				<td>品牌</td>
		    				<td>
		    					<input class="easyui-textbox" name="brand"
		    					data-options="required:true">
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>原产国/地区</td>
		    				<td>
		    					<input class="easyui-textbox" name="assemCountry"
		    					data-options="required:true">
		    				</td>
		    				<td>商品条形码</td>
		    				<td>
		    					<input class="easyui-textbox" name="goodsBarCode">
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>商品描述</td>
		    				<td>
		    					<input class="easyui-textbox" name="goodsDesc">
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>商品备注</td>
		    				<td>
		    					<input class="easyui-textbox" name="gRemark">
		    				</td>
		    				<td>生产厂家</td>
		    				<td>
		    					<input class="easyui-textbox" name="comName">
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>生产厂家地址</td>
		    				<td>
		    					<input class="easyui-textbox" name="manufactureAddr"> 
		    				</td>
		    				<td>成分</td>
		    				<td>
		    					<input class="easyui-textbox" name="ingredient">
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>超范围使用食品添加剂</td>
		    				<td>
		    					<input class="easyui-textbox" name="additiveFlag">
		    				</td>
		    				<td>含有毒害物质</td>
		    				<td>
		    					<input class="easyui-textbox" name="poisonFlag">
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>
		    					<input type="hidden" name="id" value="0" id="id2">
		    				</td>
		    			</tr>
		    		</table>
		    	</form>
		    </div>
		    <div id="dlg-buttons">
		        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveCon()" style="width:90px">保存</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
		    </div>
		</div>
    </div>
    <script type="text/javascript">
    	var id = 0;
    	function saveGoodMain(){
    		$("#goodMainForm").form("submit",{
    			url:"${basePath}/good/saveGoodMain",
    			onSubmit:function(){
    				return $(this).form("validate");
    			},
    			success:function(result){
    				var result = $.parseJSON(result);
    				layer.msg(result.msg);
    				if(result.success){
    					id = result.id;
    				}
    			}
    		});
    	}
    	
    	function reviseGoodMain(){
    		
    	}
    </script>
	</div>
</body>
</html>