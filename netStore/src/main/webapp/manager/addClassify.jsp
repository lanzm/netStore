<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="index.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加分类</title>


	<div id="addclassify" align="center">
		<br>
		<br>
		<hr>
		<form action="addClassify.action" method="post">
			分类名称：<input class="classifyname" id="classifyname" name="classifyname"/><font class="message" ></font><br><br>
			分类描述：<input id="description" name="description"/><br><br>
			<input id="add" name="add" type="submit" value="添加">
		</form>
	</div>

</body>
</html>