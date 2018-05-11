package com.kdzr.st.right.vo;

import com.kdzr.common.pojo.PageAjax;
import com.kdzr.st.right.model.Order;

public class OrderPageVo {
	
	private Order order;
	private PageAjax<Order> pa;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public PageAjax<Order> getPa() {
		return pa;
	}
	public void setPa(PageAjax<Order> pa) {
		this.pa = pa;
	}
	

}
