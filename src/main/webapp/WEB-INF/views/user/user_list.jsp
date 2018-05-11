<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表信息</title>
</head>
<body>

	<h3>用户信息</h3>
	
	<a href="${pageContext.request.contextPath}/user/add">添加用户</a>
	<br>
	<table border="1px">
		<thead>
			<tr>
				<td>序号</td>
				<td>姓名</td>
				<td>密码</td>
				<td>操作</td>
			</tr>
		</thead>
		<c:forEach var="a" items="${userlist}" varStatus="s">

		<tr>
         
            <td>${s.index + 1}</td>
			<td>${a.username}</td>
			<td>${a.password}</td>
			<td>
				<a href="${pageContext.request.contextPath}/user/addUserRole?userId=${a.id}">为用户授权角色</a>
				&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/user/update?userId=${a.id}">修改用户</a>&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/user/delete?userId=${a.id}">删除用户</a>
			</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>