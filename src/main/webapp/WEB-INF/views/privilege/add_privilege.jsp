<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加权限</title>
</head>
<body>

	<h3>添加权限</h3>
	
	<form action="${pageContext.request.contextPath}/privilege/add" method="post">
		<table border="1px">
			<tr>
				<td>权限名称：</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>权限描述：</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="保存" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>