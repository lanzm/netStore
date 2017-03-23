<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>  <!-- 要加这句话，不然EL表达式无法使用!!! -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="common/css/table2.css">
<script type="text/javascript" src="common/lib/jquery-1.4.2.js"></script>
<script type="text/javascript" src="common/js/manager_plugin.js"></script>
<script type="text/javascript" src="common/js/manager.js"></script>  
<title>书籍管理</title>
</head> 
<body>
	<div align="center">
		<form action="vagueBook.action">
		<input id="vague" name="vague" class="vague"  placeholder="请输入关键字" >
		<input class="seach" type="submit" value="搜索">
		</form>
	</div>
	<div align="center">
		<table id="table-2">
			<tr>
				<th><input id="allbook" type="checkbox"></th>
				<th>编号</th>
				<th>书籍图片</th>
				<th>书籍分类</th>
				<th>书籍名称</th>
				<th>书籍作者</th>
				<th>书籍价格</th>
				<th>书籍简介</th>
			</tr>
			
			<c:forEach items="${lists}" var="list" varStatus="status">
				
				<tr>
					<!-- 隐藏id -->
					<td><input type="checkbox"/><input type="hidden" value="${list.bid}"/></td>
					<!-- 自动生成编号 ！！！ -->
					<td>${status.index + 1}</td>
					<td><img alt="" src="/image/${list.filename}"></td>
					<td>${list.classify.classifyname}</td>
					<td>${list.bookname}</td>
					<td>${list.author}</td>
					<td>${list.price}</td>
					<td id="${status.index + 1}" width="400">${list.description}</td>
				</tr>
			</c:forEach>
			
		</table>
		<br>
		<br>
		<input id="del_book" class="del" type="button" value="删除所选">
		<a id="update" class="update" href = "" ><font color="white">修改所选书籍</font></a>
		<a class="add" href="addBook_bf.action"><font color="white">添加书籍</font></a>
		<br>
		<br>
		第${page.thisPage}页/共${page.totalPage}页&nbsp;&nbsp;
		<a class="pre" href="pageBook/${page.previousPage}.action"><font color="white">上一页</font></a>
		<c:forEach begin="1" end="${page.totalPage}" var="i">
			<a class="num" href="pageBook/${i}.action"><font color="white">${i}</font></a>
		</c:forEach>
		<a class="nex" href="pageBook/${page.nextPage}.action"><font color="white">下一页</font></a>
	</div>

</body>
</html>