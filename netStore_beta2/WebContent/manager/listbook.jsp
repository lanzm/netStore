<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="index.jsp" %>

<div align="center">

<table border="1">
  <tr>
  	<th>序号</th>
    <th>书籍名称</th>
    <th>书籍作者</th>
    <th>书籍图片</th>
    <th>书籍分类</th>
    <th>书籍价格</th>
    <th>书籍描述</th>
  </tr>
  <c:forEach items="${requestScope.page.books}" var="l" varStatus="vs">
  
  
  <tr>
  	<td>${vs.count}</td>
    <td>${l.name}</td>
    <td>${l.author}</td>
    <td>
    	<img alt="${pageContext.request.contextPath}/images/${l.path}/${l.filename}" src="${l.filename}">
    </td>
    <td>${l.classify_id.name}</td> 
    <td>${l.price}</td>
    <td>${l.description}</td>
  </tr>
  
  </c:forEach>
</table>

<br>
<br>
第${page.thisPage}页/共${page.totalPage}页&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}${page.url}&num=${page.previousPage}" >上一页 </a>
&nbsp;
<a href="${pageContext.request.contextPath}${page.url}&num=${page.nextPage}"> 下一页</a>
</div>


</body>
</html>