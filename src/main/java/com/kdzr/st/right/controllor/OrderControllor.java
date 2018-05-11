package com.kdzr.st.right.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kdzr.common.pojo.PageAjax;
import com.kdzr.st.right.model.Order;
import com.kdzr.st.right.service.OrderService;
import com.kdzr.st.right.vo.OrderPageVo;

@Controller
@RequestMapping("order")
public class OrderControllor {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/queryPage",method=RequestMethod.GET)
	public String queryPage(){
		return "order/order_list";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/queryPage",method=RequestMethod.POST)
	public PageAjax<Order> queryPage(@RequestBody OrderPageVo opv){
		//设置下startRow
		opv.getPa().setStartRow((opv.getPa().getPageNum()-1)*(opv.getPa().getPageSize()));
		
		if(opv.getOrder().getOrder_name()=="") {
			opv.getOrder().setOrder_name(null);
		}
		if(opv.getOrder().getOrder_name()!=null) {
			//去除搜索关键字 两端的空格
			opv.getOrder().setOrder_name(opv.getOrder().getOrder_name().trim());
		}
		int total = orderService.count(opv.getOrder());//总记录数
		PageAjax<Order> pa = orderService.selectPage(opv.getOrder(),opv.getPa());
		int pageSize = opv.getPa().getPageSize();
		//总页数
		int pages = -1;
		if(total<pageSize) {
			pages = 1;
		}else {
			pages = (total/pageSize == 0)?(total/pageSize):(total/pageSize+1);
		}
		
		pa.setTotal(total);
		pa.setPages(pages);
		return pa;
	}
	
	
	
	
	
	

}
