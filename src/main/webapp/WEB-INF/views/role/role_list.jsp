<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色列表</title>
</head>
<body>

	<h3>角色信息</h3>
	<a href="${pageContext.request.contextPath}/role/add">添加角色</a>
	<br>
	
	<table border="1px">
		<thead>
			<tr>
				<td>序号</td>
				<td>角色名称</td>
				<td>角色描述</td>
				<td>操作</td>
			</tr>
		</thead>
		<c:forEach var="a" items="${rolelist}" varStatus="s">

		<tr>
         
            <td>${s.index + 1}</td>
			<td>${a.name}</td>
			<td>${a.description}</td>
			<td>
				<a href="${pageContext.request.contextPath}/role/addRolePrivilege?roleId=${a.id}">为角色授权</a>
				&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/role/update?roleId=${a.id}">修改角色</a>&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/role/delete?roleId=${a.id}">删除角色</a>
			</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>