<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色绑定权限</title>
</head>
<body>

	<h3>绑定权限</h3>
	
	<table border="1px">
		<tr>
			<td>当前角色名称</td>
			<td>${role.name}</td>
		</tr>
		
		<tr>
			<td>当前角色所拥有的权限</td>
			<td>
				<c:forEach items="${rolePrivilege}" var="rp">
					${rp.privilegename }
				</c:forEach>
			</td>
		</tr>
		
		<tr>
			<td>当前系统所拥有的角色</td>
			<td>
				<form method="post" action="${pageContext.request.contextPath}/role/addRolePrivilege">
					<%--要为用户添加角色，需要知道是哪一个用户，通过hidden传递过去用户的id--%>
					<input type="hidden" name="roleId" value="${role.id}" />
					<c:forEach items="${allPrivilege}" var="pl"> 
						<input type="checkbox" name="privilegeList" value="${pl.id}">${pl.name} 
					</c:forEach> 
					<input type="submit" value="添加权限！">
				</form>
			</td>
		</tr>
		
		
	</table>

</body>
</html>