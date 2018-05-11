<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户绑定角色</title>
</head>
<body>

	<h3>绑定角色</h3>
	
	<table border="1px">
		<tr>
			<td>当前用户名称</td>
			<td>${user.username}</td>
		</tr>
		
		<tr>
			<td>当前用户所拥有的角色</td>
			<td>
				<c:forEach items="${userRoles}" var="userRole">
					${userRole.rolename }
				</c:forEach>
			</td>
		</tr>
		
		<tr>
			<td>当前系统所拥有的角色</td>
			<td>
				<form method="post" action="${pageContext.request.contextPath}/user/addUserRole">
					<%--要为用户添加角色，需要知道是哪一个用户，通过hidden传递过去用户的id--%>
					<input type="hidden" name="userId" value="${user.id}" />
					<c:forEach items="${allRoles}" var="roles"> 
						<input type="checkbox" name="roleIdList" value="${roles.id}">${roles.name} 
					</c:forEach> 
					<input type="submit" value="添加角色！">
				</form>
			</td>
		</tr>
		
		
	</table>

</body>
</html>