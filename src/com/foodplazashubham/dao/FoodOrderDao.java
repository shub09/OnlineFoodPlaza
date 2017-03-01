package com.foodplazashubham.dao;


public interface FoodOrderDao 
{
	int placeOrder(String customerusername,double totalbill);
	//List<FoodOrder> getAllOrder();
	//String checkStatus(int orderId);
	//boolean changeStatus(int orderId,String orderStatus);
}

