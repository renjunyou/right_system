<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/TopUntil.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script type="text/javascript">
	function checkUserName(){
		$.ajax({
			type:"get",
			url:"${pageContext.request.contextPath}/user/checkUserName",
			dataType:"json",
			contentType:"application/json;charset=utf-8",
			data:{username:$("#username").val()},
			success:function(result){
				if(result.msg == "true"){
					$("#span1").html("<font color='green'>用户名可以使用</font>");
				}else if(result.msg == "false"){
					$("#span1").html("<font color='red'>用户名已经存在</font>");
				}
				//else{
				//	$("#span1").html("<font color='red'>用户名不能为空</font>");
				//}
			}
		})
	}
</script>
</head>
<body>

	<h3>注册用户</h3>
	
	<form action="${pageContext.request.contextPath}/login/register" method="post">
		<span>姓名：</span>
		<input type="text" id="username" name="username" placeholder="请输入用户名" onblur="checkUserName()" />
		<span id="span1"></span>
		<br>
		<span>密码：</span>
		<input type="password" name="password" placeholder="请输入密码" />
		<br><span id="regis" style="color:#F00">${reg_meg}</span>
		<input type="submit" value="注册" />
	</form>
</body>
</html>