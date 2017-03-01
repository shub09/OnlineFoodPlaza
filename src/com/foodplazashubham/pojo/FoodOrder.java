package com.foodplazashubham.pojo;

public class FoodOrder
{
	  private int orderId;
	  private int customerId;
	  private double totalbill;
	  private String orderStatus;
	  private String orderDate;
	  
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public double getTotalbill() {
		return totalbill;
	}
	public void setTotalbill(double totalbill) {
		this.totalbill = totalbill;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Foodorder [orderId=" + orderId + ", customerId=" + customerId
				+ ", totalbill=" + totalbill + ", orderStatus=" + orderStatus
				+ ", orderDate=" + orderDate + "]";
	}
	  
	  
}
