Date.prototype.format = function(fmt) { 
    var o = { 
       "M+" : this.getMonth()+1,                 //月份 
       "d+" : this.getDate(),                    //日 
       "h+" : this.getHours(),                   //小时 
       "m+" : this.getMinutes(),                 //分 
       "s+" : this.getSeconds(),                 //秒 
       "q+" : Math.floor((this.getMonth()+3)/3), //季度 
       "S"  : this.getMilliseconds()             //毫秒 
   }; 
   if(/(y+)/.test(fmt)) {
           fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
   }
    for(var k in o) {
       if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
   return fmt; 
}        

$(document).ready(function(){
  //点击订单管理菜单，首次请求数据
  var order_n = $("input[name='order_name']").val();
  //parseInt()  jQuery方法，字符串转数字
  var page_size = parseInt($("#page_size").find("option:selected").val()); 
  getOrderByPage(1,page_size,order_n);

  $("#proname").click(function(){
    $("#error_msg1").show();
  });
  
  $("#count").click(function(){
    $("#error_msg2").show();
  });
  
  $("form").submit(function(){
    if($("input[name='proname']").val() == ""){
    	alert("请输入商品名称！");
    	$("input[name='proname']").focus();
    	return false;
    }
    if($("input[name='count']").val() == ""){
    	alert("请输入商品数量！");
    	$("input[name='count']").focus();
    	return false;
    }
  });
  
  //go 翻页
  $(".page-btn").click(function(){
	  //得到页数
	  var page__= parseInt($(".page-go input").val());
	  
	  //得到pagesize
	  var pa_ze = parseInt($("#page_size").find("option:selected").val());
	  
	  getOrderByPage(page__,pa_ze,order_n);
	   
  });
  
  //搜索 查询
  
  
});

//检索数据
function search(){
	
	var or_name = $("#yc").val($("input[name='proname']").val());
	
	getOrderByPage(1,5,or_name);
	
}

function getOrderByPage(pageNum,pageSize,order_name){
	//pageNum 请求页   pageSize 页面记录数    
	var json = {
			'pa':{
				'pageNum':pageNum,
				'pageSize':pageSize
			},
			'order':{'order_name':order_name}
	}
	
	//json字符串 {"username":"admin","password":"123456"}  
    var postdata = JSON.stringify(json);//json对象转换json字符串
	
	$.ajax({
		type:"post",
		url: js_path + "/order/queryPage",
		dataType:"json",
		contentType:"application/json;charset=utf-8",
		data:postdata,
		success:function(result){
			var total = result.total;
			$("#tab").empty();
			if(total == 0){
				$("#tab").append(
					'<tr>'+
						'<th>订单日期</td>'+
						'<th>商品数量</td>'+
						'<th>商品名称</td>'+
						'<th>操作</td>'+
					'</tr>'+
					'<tr align="center">'+
						'<td colspan="4">没有数据</td>'+
					'</tr>'
				);
				//隐藏分页数据
				$("#pages").hide();
			}else{
				var rowsItem = result.rows;
				//添加表头
				$("#tab").append(
						'<tr>'+
							'<th>订单日期</td>'+
							'<th>商品数量</td>'+
							'<th>商品名称</td>'+
							'<th>操作</td>'+
						'</tr>'
					);
				//添加数据
				$.each(rowsItem,function(index, item){
					$("#tab").append(
						'<tr align="center">'+
						'<td>' + new Date(item.order_date).format("yyyy-MM-dd") + '</td>'+
						'<td>' + item.num + '</td>'+
						'<td>' + item.order_name + '</td>'+
						'<td><a href="'+ js_path + '/order/updateOrder?order_id=' + item.id +'">修改</a>&nbsp;&nbsp;<a href="'+ js_path + '/order/deleteOrder?order_id=' + item.id +'" onclick="del()">删除</a>'+
						'</tr>'
					);
				});
				
				//设置分页数据
				$(".allPage").text(result.pages);
				$(".allItem").text(result.total);
				
				
				
			}
			
		}
	})
	
}




function IsNum(e) {
    var k = window.event ? e.keyCode : e.which;
    if (((k >= 48) && (k <= 57)) || k == 8 || k == 0) {
    } else {
        if (window.event) {
            window.event.returnValue = false;
        }
        else {
            e.preventDefault();
        }
    }
}

function del(){
	if(!confirm("确认要删除？")) {
		window.event.returnValue = false;
	}
}

