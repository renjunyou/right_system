<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
	<script type="text/javascript">
		function logout(){
			//alert("你确定要注销身份吗？");
			window.parent.location.href="${pageContext.request.contextPath}/login/loginout";
		}
	</script>
</head>
<body>
	<h1>XXX管理系统</h1>
	
	<div id="wel">欢迎您，${userinfo.user.username }</div>
	<a href="javascript:onClick=logout()">注销</a>
</body>