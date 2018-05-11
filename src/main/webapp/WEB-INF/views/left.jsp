<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
	<!-- frameset和frame来实现前台的分帧，target指定在哪里显示具体的数据 -->
	<a href="<%=request.getContextPath() %>/user/list" target="body">用户管理</a><br>
	<a href="<%=request.getContextPath() %>/role/list" target="body">角色管理</a><br>
	<a href="<%=request.getContextPath() %>/privilege/list" target="body">权限管理</a><br>
	<a href="<%=request.getContextPath() %>/order/queryPage" target="body">订单管理</a>

</body>
