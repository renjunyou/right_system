<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/TopUntil.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册成功</title>

</head>
<body>

	<h5>用户注册成功</h5>
	<strong id="stro">5</strong><span>秒后回到登录页</span>
</body>
<script type="text/javascript">
	var num = $("#stro").text();
	
	function count(){
		//alert(num);
		num--;
		$("#stro").text(num);
		if(num==0){
		　　window.location.href="${path}";
		}
	}
	setInterval("count()",1000);
</script>
</html>