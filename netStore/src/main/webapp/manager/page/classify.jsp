<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>  <!-- 要加这句话，不然EL表达式无法使用!!! -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="common/css/table.css">
<script type="text/javascript" src="common/lib/jquery-1.4.2.js"></script>
<script type="text/javascript" src="common/js/manager_plugin.js"></script>
<script type="text/javascript" src="common/js/manager.js"></script>  
<title>分类管理</title>
</head>
<body>

<div id="div-1" align="center">
	<table id="table-1" align="center">
		<tr align="center">
			<th><input id="all" type="checkbox"></th>
			<th>编号</th>
			<th width="150">分类名称</th>
			<th width="200">分类描述</th>
			<th width="100">操作</th>
		</tr>
	<c:forEach items="${lists}" var="list">
		<tr align="center">
			<td><input type="checkbox"/></td>
			<td>${list.cid}</td>
			<td>${list.classifyname}</td>
			<td>${list.description}</td>
			<td><a href="removeClassify/${list.cid}.action">删除</a></td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<input id = "del_checked" class="del" type="button" value="删除所选">
	<input id="addclassify" class="add" type="button" value="添加分类">
</div>
</body>
</html>