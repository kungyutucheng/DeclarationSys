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
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #eee;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin .checkbox {
            font-weight: normal;
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
    <div class="container">
        <form class="form-signin" method="post" action="<%=basePath %>login/login">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Account</label>
        <input type="text" id="inputEmail" name="account" class="form-control" placeholder="Account" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        <div>${message}</div>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>

    </div>
</body>
</html>