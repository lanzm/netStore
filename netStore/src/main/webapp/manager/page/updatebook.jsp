<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>  <!-- 要加这句话，不然EL表达式无法使用!!! -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../common/css/form.css">
<script type="text/javascript" src="../common/lib/jquery-1.4.2.js"></script>
<script type="text/javascript" src="../common/js/manager_plugin.js"></script>
<script type="text/javascript" src="../common/js/manager.js"></script>  
</head>
<body>
		<div align="center">
		<br>
		<br>
		<form action="../updateBook.action" method="post" id="addbook" class="basic-grey" enctype="multipart/form-data">
			<label>
				<span>图书名称*：</span>
				<input id="bookname" name="bookname" type="text" value="${book.bookname}"/>
			</label>
			
			<label>
				<span>图书作者*：</span>
				<input id="author" name="author" type="text" value="${book.author}"/>
			</label>
			
			<label>
				<span>图书分类*：</span>
				<select id="classifyn" name="classifyn">
					<option>--请选择书籍分类--</option>
					<c:forEach items="${classifys}" var="classify">
						<option  <c:if test="${book.classify.classifyname == classify.classifyname}">selected="selected"</c:if>>${classify.classifyname}</option>
					</c:forEach>
				</select>
			</label>
			
			<label>
				<span>图书图片*：</span>
				<input id="photo" name="image" type="file"><br><br>
			</label>
			
			<label>
				<span>图书价格*：</span>
				<input id="price" name="price" type="text" value="${book.price}"><br><br>
			</label>
			
			<label>
				<span>图书描述：</span>
				<textarea id="description" name="description">${book.description}</textarea><br><br>
			</label>
			
			<label>
				<a id="back" class="back" href="../listBook.action">返回</a>
				<input id="add" class="submit" type="submit" value="修改">
			</label>
		</form>
	</div>
	
</body>
</html>