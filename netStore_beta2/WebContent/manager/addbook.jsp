<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="index.jsp" %>

<div align="center">
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/ManagerControl?op=addbooks" method="post">
		<table border="1">
			<tr>
				<th>书本名称</th>
				<td><input name="name"/></td>
			</tr>
			<tr>
				<th>书本分类</th>
				<td>
				<select name="classify">
					<option>---请选择---</option>
					<c:forEach items="${requestScope.list}" var="l">
						<option>${l.name}</option>
					</c:forEach>				
				</select>
				</td>
			</tr>
			<tr>
				<th>书本作者</th>
				<td><input name="author"/></td>
			</tr>
			<tr>
				<th>书本价格</th>
				<td><input name="price"/></td>
			</tr>
			<tr>
				<th>书本图片</th>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<th>书本描述</th>
				<td><textarea rows="5" cols="48" name="description"></textarea></td>
			</tr>
			<tr>
				
				<td><input type="submit" value="保存"/></td>
			</tr>
		</table>
	</form>

</div>



</body>
</html>