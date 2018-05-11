<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限列表</title>
</head>
<body>

	<h3>权限列表</h3>
	<a href="${pageContext.request.contextPath}/privilege/add">添加权限</a>
	<br>
	
	<table border="1px">
		<thead>
			<tr>
				<td>序号</td>
				<td>权限名称</td>
				<td>权限描述</td>
				<td>操作</td>
			</tr>
		</thead>
		<c:forEach var="a" items="${privilegelist}" varStatus="s">

		<tr>
         
            <td>${s.index + 1}</td>
			<td>${a.name}</td>
			<td>${a.description}</td>
			<td>
				<a href="${pageContext.request.contextPath}/privilege/update?privilegeId=${a.id}">修改权限</a>&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/privilege/delete?privilegeId=${a.id}">删除权限</a>
			</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>