<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="index.jsp" %>

<div align="center">
	<form action="${pageContext.request.contextPath}/ManagerControl?op=addClassify" method="post">
		<table border="1">
			<tr align="center">
				<th>分类名称</th>
				<td><input name="name" type="text"/></td>
			</tr>
			<tr align="center">
				<th>分类描述</th>
				<td><textarea rows="5" cols="48" name="description"></textarea></td>
			</tr>
			
			<tr align="right">
				<td><input type="submit" value="保存"/></td>
			</tr>
			
		</table>
	</form>
	
	
</div>	


</body>
</html>