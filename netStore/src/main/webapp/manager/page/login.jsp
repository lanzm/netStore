<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<meta name="keywords" content="scclui框架">
	<meta name="description" content="scclui为轻量级的网站后台管理系统模版。">
    <title>首页</title>
	<script type="text/javascript" src="common/lib/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="common/js/manager_plugin.js"></script>
	<script type="text/javascript" src="common/js/manager.js"></script>
	<link rel="stylesheet" href="common/layui/css/layui.css">
	<link rel="stylesheet" href="common/css/sccl.css">
    
  </head>
  
  <body class="login-bg">
    <div class="login-box">
        <header>
            <h1>后台管理系统</h1>
        </header>
        <div id="login-main" class="login-main">
			<form action="managerlogin.action" class="layui-form" method="post">
				<input name="__RequestVerificationToken" type="hidden" value="">                
				<div class="layui-form-item">
					<label class="login-icon">
						<i class="layui-icon"></i>
					</label>
					<input type="text" id="managername" name="managername" lay-verify="managername" autocomplete="off" placeholder="这里输入登录名" class="layui-input">
				</div>
				<div class="layui-form-item">
					<label class="login-icon">
						<i class="layui-icon"></i>
					</label>
					<input type="password" id="password" name="password" lay-verify="password" autocomplete="off" placeholder="这里输入密码" class="layui-input">
				</div>
				<div class="layui-form-item">
					<div class="pull-left"> 
						<span><font color="red">${msg}</font></span>
					</div>
					<div class="pull-right">
						<button id="submit" class="layui-btn layui-btn-primary" lay-submit="" lay-filter="login">
							<i class="layui-icon"></i> 登录
						</button>
					</div>
					<div class="clear"></div>
				</div>
			</form>        
		</div>
        <footer>
            <p>Lan zm</p>
        </footer>
    </div>
 
  </body>
</html>
