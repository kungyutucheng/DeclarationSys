<%@page import="com.gpl.authorization.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<% String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName() + ":" + request.getServerPort() + path + "/"; %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<%=basePath %>asserts/bootstrap/bootstrap.min.css" type="text/css">
    <script type="text/javascript" src="<%=basePath %>asserts/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>asserts/jquery/jquery.form.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/common.js"></script>
    <script type="text/javascript" src="<%=basePath %>asserts/bootstrap/bootstrap.min.js"></script>
    <title>主页</title>
    <style>
        body {
            padding-top: 50px;
        }


        /*
         * Global add-ons
         */

        .sub-header {
            padding-bottom: 10px;
            border-bottom: 1px solid #eee;
        }

        /*
         * Top navigation
         * Hide default border to remove 1px line.
         */
        .navbar-fixed-top {
            border: 0;
        }

        /*
         * Sidebar
         */

        /* Hide for mobile, show later */
        .sidebar {
            display: none;
        }
        @media (min-width: 768px) {
            .sidebar {
                position: fixed;
                top: 51px;
                bottom: 0;
                left: 0;
                z-index: 1000;
                display: block;
                padding: 20px;
                overflow-x: hidden;
                overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
                background-color: #f5f5f5;
                border-right: 1px solid #eee;
            }
        }

        /* Sidebar navigation */
        .nav-sidebar {
            margin-right: -21px; /* 20px padding + 1px border */
            margin-bottom: 20px;
            margin-left: -20px;
        }
        .nav-sidebar > li > a {
            padding-right: 20px;
            padding-left: 20px;
        }
        .nav-sidebar > .active > a,
        .nav-sidebar > .active > a:hover,
        .nav-sidebar > .active > a:focus {
            color: #fff;
            background-color: #428bca;
        }


        /*
         * Main content
         */

        .main {
            padding: 20px;
        }
        @media (min-width: 768px) {
            .main {
                padding-right: 40px;
                padding-left: 40px;
            }
        }
        .main .page-header {
            margin-top: 0;
        }


        /*
         * Placeholder dashboard ideas
         */

        .placeholders {
            margin-bottom: 30px;
            text-align: center;
        }
        .placeholders h4 {
            margin-bottom: 0;
        }
        .placeholder {
            margin-bottom: 20px;
        }
        .placeholder img {
            display: inline-block;
            border-radius: 50%;
        }
        form input,
        form textarea,
        form button,
        form label{
            margin:5px 0px;
        }
        .myBtn{
            background:#428bca;
        }
        .a{
        	cursor:pointer;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
	            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		            <span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		        </button>
                <a class="navbar-brand" href="#">报关系统</a>
            </div>
	        <div id="navbar" class="navbar-collapse collapse">
	        	<ul class="nav navbar-nav navbar-right">
	        		<li><a href="#"><%=((User)session.getAttribute("user")).getAccount() %></a></li>
	        		<li><a href="#">注销账户</a></li>
	        	</ul>
	        </div>
        </div>
    </nav>

    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-3 col-md-2 sidebar">
                <ul class="nav nav-sidebar">
                    <li class="active" name="navItem" value="1"><a href="#">查看全部</a> </li>
                    <li name="navItem" value="2"><a href="#">添加</a> </li>
                </ul>
            </div>
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <div id="listPage">
                    <h2 class="sub-header">商品列表</h2>
                    <div class="table-responsive">
                        <table class="table table-striped" id="goodTable">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>名称</th>
                                <th>单价</th>
                                <th>描述</th>
                                <th>创建时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                        <div style="text-align: center;">
                            <nav>
                                <ul class="pagination">
                                    <li>
                                        <a href="#" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                    <li><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li>
                                        <a href="#" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <div id="addPage" style="display:none;">
                    <h2 class="sub-header">添加商品</h2>
                    <form class="form-group" id="addGoodForm"  action="<%=basePath %>good/add"  method="post" onsubmit="return addGood();">
                        <label for="goodName" class="sr-only">商品名称</label>
                        <input name="name" id="goodName" class="form-control" type="text" placeholder="名称" required autofocus>
                        <label for="goodPrice" class="sr-only">商品价格</label>
                        <input name="price" id="goodPrice" class="form-control" type="number" placeholder="价格" required>
                        <label for="goodDesc" class="sr-only">商品描述</label>
                        <textarea class="form-control" name="desc" id="goodDesc" cols="20" rows="10" placeholder="描述" required></textarea>
                        <div class="btn-group">
                            <button type="reset" class="btn btn-primary myBtn">重置</button>
                            <button type="submit" class="btn btn-primary myBtn">提交</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
    <div class="modal fade" role="dialog" id="updateModal" aria-labelledby="updateModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span> </button>
                    <h4 class="modal-title" id="modalTitle">修改商品信息</h4>
                </div>
                <form class="form-group" id="updateForm" action="<%=basePath%>good/update" method="post" onsubmit="return updateGood();">
               		<div class="modal-body">
                        <label for="updateGoodId">商品ID</label>
                        <input id="updateGoodId" name="id" type="text" readonly class="form-control">
                        <label for="updateGoodName">商品名称</label>
                        <input id="updateGoodName" name="name" type="text" class="form-control" required autofocus>
                        <label for="updateGoodPrice">商品价格</label>
                        <input id="updateGoodPrice" name="price" type="number" class="form-control" required>
                        <label for="updateGoodDesc">商品描述</label>
                        <textarea id="updateGoodDesc" name="desc" type="text" class="form-control" required></textarea>
                 	</div>
                 	<div class="modal-footer">
                    	<button type="button" class="btn btn-primary myBtn" data-dismiss="modal">取消</button>
                    	<button type="submit" class="btn btn-primary myBtn">提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>


    <div class="modal fade" role="dialog" id="deleteModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span> </button>
                    <h4 class="modal-title">删除商品</h4>
                </div>
                <div class="modal-body">
                    	确认删除？
                </div>
                <div class="modal-footer">
                	<form style="dispaly:none;"id="deleteForm" action="<%=basePath %>good/delete" method="get" onsubmit="return deleteGood();">
                		<input id="deleteGoodId" name="id" type="hidden">
                		<button type="button" class="btn btn-primary myBtn" data-dismiss="modal">取消</button>
                    	<button type="submit" class="btn btn-primary myBtn">确定</button>
                	</form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" role="dialog" id="messageModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span> </button>
                    <h4 class="modal-title">添加商品</h4>
                </div>
                <div class="modal-body" id="modalBody">
                    添加成功
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary myBtn" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>

<script>

    //记录上一页的最后一条记录的id
    var lastId = 0;
    window.onload=function () {
        $("#listPage").show();
        $("#addpage").hide();
        loadGoods(lastId);
        var lis = $("li[name='navItem']");
        for (var i = 0; i < lis.length; i++) {
            lis[i].onclick = function () {
                for (var j = 0; j < lis.length; j++) {
                    lis[j].className = "";
                }
                this.className = "active";
                if(this.value == 1 || this.value == "1"){
                    $("#listPage").show();
                    $("#addPage").hide();
                    loadGoods();
                }else if(this.value == 2 || this.value == "2"){
                    $("#listPage").hide();
                    $("#addPage").show();
                }
            }
        }
    }

    function loadGoods(lastId){
    	$.post("<%=basePath%>good/search",
    			{
    				"pageNo":1,
    				"pageSize":10,
    				"fdhsj":" fdshu    "
    				},
    	function(result){
    		console.log(result);
    		var data = JSON.parse(result);
    		var table = $("#goodTable");
    		for(var i = 0;i < data.length;i++){
    			var params = data[i].id+',"'+data[i].name+'",'+data[i].price+',"'+data[i].desc+'"';
	    		table.html(table.html()+"<tr>"+
	                    "<td>"+data[i].id+"</td>"+
	                    "<td>"+data[i].name+"</td>"+
	                    "<td>"+data[i].price+"</td>"+
	                    "<td>"+data[i].desc+"</td>"+
	                    "<td>"+new Date(data[i].createTime).format("yyyy-MM-dd hh:mm:ss")+"</td>"+
	                    "<td>"+
	                        "<a class='a' style='margin-right:5px;' onclick='javascript:setUpdateMsg("+params+");'>修改</a>"+
	                        "<a class='a' onclick='javascript:setDeleteGoodId("+data[i].id+");'>删除</a>"+
	                    "</td>"+
	                "</tr>");
    		}
    	});
    }

    function setUpdateMsg(id,name,price,desc) {
        var idInput = $("#updateGoodId");
        var nameInput = $("#updateGoodName");
        var priceInput = $("#updateGoodPrice");
        var descInput = $("#updateGoodDesc");
        idInput.val(id);
        nameInput.val(name);
        priceInput.val(price);
        descInput.val(desc);
        $("#updateModal").modal("show");
    }
    
    function setDeleteGoodId(id){
    	$("#deleteGoodId").val(id);
        $("#deleteModal").modal("show");
    }
    
    function addGood(){
    	var options = {
    			success:function(result){
    				if(result == "0" || result == 0){
    					$("#modalBody").text("添加失败");
    					$("#messageModal").modal("show");
    					
    				}else{
    					$("#modalBody").text("添加成功");
    					$("#messageModal").modal("show");
    				}
    				
    			},beforeSubmit:function(){
    				var text;
    				if($("#goodName").val().length > 20){
    					text = "商品名称过长";
    					$("#modalBody").text(text);
        				$("#messageModal").modal("show");
        				return false;
    				}
    				if($("#goodDesc").val().length > 100){
    					text = "商品描述过长";
    					$("#modalBody").text(text);
        				$("#messageModal").modal("show");
        				return false;
    				}
    				return true;
    			}
    	};
    	$("#addGoodForm").ajaxSubmit(options);
    	return false;
    	
    }
    
    function updateGood(){
    	console.log(1);
    	var options = {
    			success : function(result){
    				console.log(result);
    				if(result == "true" || result){
    					window.location.reload();
    				}else{
    					$("#modalBody").text("更新失败");
    					$("#updateModal").modal("hide");
    					$("#messageModal").modal("show");
    				}
    			},
    			beforeSubmit : function(){
    				if($("#updateGoodName").val().length > 20){
    					$("#modalBody").text("商品名称过长");
    					$("#messageModal").modal("show");
    					return false;
    				}
    				if($("#updateGoodDesc").val().length > 100){
    					$("#modalBody").text("商品描述过长");
    					$("#messageModal").modal("show");
    					return false;
    				}
    				return true;
    			}
    			
    	};
    	$("#updateForm").ajaxSubmit(options);
    	return false;
    }
    
    function deleteGood(){
    	var options = {
    			success : function(result){
    				if(result == "true" || result){
    					window.location.reload();
    				}else{
	    				$("#modalBody").text("删除失败");
	    				$("#deleteModal").modal("hide");
	    				$("#messageModal").modal("show");
    				}
    			}
    	};
    	
    	$("#deleteForm").ajaxSubmit(options);
    	return false;
    }
</script>
</body>
</html>