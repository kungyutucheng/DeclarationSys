<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品备案</title>
</head>
<body>
	<div class="container">
		<!-- <form style="text-align:center;">
			<table class="searchTable">
				<tr>
					<td>商品申请编号</td>
					<td><input name="cargobCode" class="form-control" type="text" required></td>
					<td>国检组织机构代码</td>
					<td><input name="ciqbCode" class="form-control" type="text" required></td>
				</tr>
				<tr>
					<td>跨境电商企业</td>
					<td>
						<select name="cbeComId" class="form-control">
							<option value="1">企业1</option>
							<option value="2">企业2</option>
						</select>
					</td>
					<td>制单企业</td>
					<td>
						<select name="editId" class="form-control">
							<option value="1">企业1</option>
							<option value="2">企业2</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>备注</td>
					<td colspan="3"><input type="text" class="form-control" name="remark"></td>
				</tr>
			</table>
		</form> -->
		<form class="form-horizontal">
			<div class="form-group">
				<label for="addCargobCode" class="col-sm-3 control-label">商品申请编号</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="addCargobCode" name="cargobCode">
				</div>
				<label for="addCiqbCode" class="col-sm-3 control-label">国检组织</label>
				<div class="col-sm-3">
					<select name="ciqbCode" id="addCiqbCode"  class="form-control">
						<option value="1">组织1</option>
						<option value="2">组织2</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="addCbeComId" class="col-sm-3 control-label">跨境电商企业</label>
				<div class="col-sm-3">
					<select name="cbeComId" id="addCbeComId" class="form-control">
						<option value="1">组织1</option>
						<option value="2">组织2</option>
					</select>
				</div>
				<label for="addEditId" class="col-sm-3 control-label">制单企业</label>
				<div class="col-sm-3">
					<select name="editId" id="addEditId" class="form-control">
						<option value="1">组织1</option>
						<option value="2">组织2</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="addRemark" class="col-sm-3 control-label">备注</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="addRemark" name="remark">
				</div>
			</div>
		</form>
	</div>
</body>
</html>