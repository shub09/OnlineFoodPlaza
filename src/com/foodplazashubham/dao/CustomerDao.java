package com.foodplazashubham.dao;

import java.util.List;

import com.foodplazashubham.pojo.Customer;
import com.foodplazashubham.pojo.Feedback;

public interface CustomerDao 
{
	boolean addCustomer(Customer cust);
    boolean updateCustomer(Customer cust);
    boolean deleteCustomer(int custId);
    Customer getCustomerById(int custId);
    List<Customer> getAllCustomer();
    Customer getCustomerByUserName(String customerusername);

	boolean addFeedback(Feedback feed);
	List<Feedback> showFeedback();
}
