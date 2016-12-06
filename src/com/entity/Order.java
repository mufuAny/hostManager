package com.entity;

public class Order {
	private int order_id;
	private String order_time;
	private String  order_money;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int orderId) {
		order_id = orderId;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String orderTime) {
		order_time = orderTime;
	}
	public String getOrder_money() {
		return order_money;
	}
	public void setOrder_money(String money) {
		order_money = money;
	}
	public float getOrder_discount() {
		return order_discount;
	}
	public void setOrder_discount(float orderDiscount) {
		order_discount = orderDiscount;
	}
	public String  getOrder_end_price() {
		return order_end_price;
	}
	public void setOrder_end_price(String money) {
		order_end_price = money;
	}
	public int getFood_count() {
		return food_count;
	}
	public void setFood_count(int foodCount) {
		food_count = foodCount;
	}
	public int getClient_desk_id() {
		return client_desk_id;
	}
	public void setClient_desk_id(int clientDeskId) {
		client_desk_id = clientDeskId;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String clientName) {
		client_name = clientName;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int orderStatus) {
		order_status = orderStatus;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employeeId) {
		employee_id = employeeId;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employeeName) {
		employee_name = employeeName;
	}
	//订单折扣
	private float order_discount;
	private String  order_end_price;
	private int food_count;
	private int client_desk_id;
	private String client_name;
	private int order_status;
	private int employee_id;
	private String employee_name;
}
