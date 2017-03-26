<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台管理系统</title>
</head>
<body>
<div align="center">
<br><br>
	<h1>图书后台管理系统</h1><br>
	<h1>欢迎您</h1>
	
	<a href="${pageContext.request.contextPath}/ManagerControl?op=listClassify">查询分类</a>
	<a href="manager/addClassify.jsp">添加分类</a>
	<a href="${pageContext.request.contextPath}/ManagerControl?op=listbooks">查询图书</a>
	<a href="${pageContext.request.contextPath}/ManagerControl?op=findclassifyonbook">添加图书</a>
	<a id="" href="">查询分类</a>
	<a id="" href="">查询分类</a>
</div>
<br>
<br>
</body>
</html>