<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户登录</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/login/login" method="post">
			用户名：<input type="text" name="username" /><span>${loginMessage }</span><br>
			密    码：<input type="password" name="password" /><br><span style="color:#F00">${loginMessage }</span><br>
			<input type="submit" value="登录" />&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/login/register"><input type="button" value="注册" /></a>
		</form>
	</body>
</html>