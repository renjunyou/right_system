package com.kdzr.st.right.model;

import java.util.Date;

public class Order {
	
	private Integer id;
	private String order_name;
	private Integer num;
	private Date order_date;
	
	public Order() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", order_name=" + order_name + ", num=" + num + ", order_date=" + order_date + "]";
	}
	
	

}
