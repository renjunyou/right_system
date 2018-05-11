<%@ page language="java" import="java.util.*" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单列表</title>
<%@include file="../include/TopUntil.jsp"%>
<link rel="stylesheet" type="text/css" href="${path}/static/css/common.css" /><!--公共样式-->
<script type="text/javascript">
	var js_path = "${pageContext.request.contextPath}";
</script>

</head>
<body>
	<span style="color:#F00" class="proname">${userinfo.user.username}</span>&nbsp;的订单
	<input type="hidden" id="yc" value=""/>
	<form action="${path}/Order/OrdersSearch.do" method="post">
		商品名称：<input type="text" name="order_name" value="">
		<button type="button" onclick="search()" >检索</button>
		<font color="red">
			${OrdersSearchMessage}
		</font>
	</form>
	
	<a href ="${path}/Order/addOrder">新增</a>

	<table id="tab">
		<!-- 表头数据 -->
		<!-- 表格数据 -->
		
	</table>
	
	<!--翻页-->
    <div class="pages" id="pages">
         <div class="Pagination" id="Pagination"></div>
         <div class="searchPage">
            <span class="page-sum">共<strong class="allPage"></strong>页/<strong class="allItem"></strong>条</span>
            <span class="page-sum">每页显示
            	<select id="page_size">
            		<option selected="selected" value="5">5</option>
            		<option value="20">20</option>
            		<option value="50">50</option>
            	</select>
                                条</span>
            <span class="page-go">跳转<input type="text">页</span>
            <a href="javascript:;" class="page-btn">GO</a>
         </div>
    </div>
    <!--翻页end-->
	
	

</body>
<script type="text/javascript" src="${path}/static/js/input.js"></script>
</html>