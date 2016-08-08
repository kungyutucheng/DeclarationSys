<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<% String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName() + ":" + request.getServerPort() + path + "/"; %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<%=basePath %>asserts/bootstrap/bootstrap.min.css" type="text/css">
    <script type="text/javascript" src="<%=basePath %>asserts/bootstrap/bootstrap.min.js"></script>
    <title>用户登录</title>
    <style>
	    * {
			margin: 0;
			padding: 0;
		}
		
		html, body {
			height: 100%;
			width: 100%;
		}
        body {
            /* padding-top: 40px;
            padding-bottom: 40px;
            background-color: #eee; */
            background: url(${basePath}images/login/login_bg.jpg) center no-repeat;
            background-size: 100% auto;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
            border:1px solid #eee;
            border-radius:10px;
            background:rgba(255,255,255,0.3);
            text-align:center;
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox,
        .form-signin .errorMsg {
            margin-bottom: 10px;
        }
        .form-signin .form-signin-heading{
        	font-weight:bold;
        }
        .form-signin .checkbox {
            font-weight: normal;
            text-align:left;
        }
        .form-signin .errorMsg{
        	text-align:left;
        	font-weight:normal;
        	color:red;
        }
        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }
        .form-signin .form-control:focus {
            z-index: 2;
        }
        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }
        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>
</head>
<body>
    <div class="container" style="padding:200px;">
        <form class="form-signin" method="post" action="<%=basePath %>login/login">
        <h2 class="form-signin-heading">报关系统</h2>
        <label for="inputEmail" class="sr-only">Account</label>
        <input type="text" id="inputEmail" name="account" class="form-control" placeholder="请输入用户名" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="请输入密码" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
        </div>
        <div class="errorMsg">${message}</div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        </form>

    </div>
</body>
</html>