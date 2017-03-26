<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="index.jsp" %>   

 <div align="center"> 
 
 	<table border="1">
 		<tr>
 			<th>分类名称</th>
 			<th>分类描述</th>
 		</tr>
 		<c:forEach items="${requestScope.list}" var="l" >
			<tr align="center">
				<td>
					${l.name}
				</td>
				<td>
					${l.description}
				</td>
			</tr>
		</c:forEach>
 		
 	</table>
 
 </div>
</body>
</html>