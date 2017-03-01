package com.foodplazashubham.pojo;

public class Customer
{
	  private int customerId;
	  private String customerName;
	  private String customerAddress;
	  private long contact;
	  private String customerPassword;
	  private String customerUserName;
	  
	public int getCustomerId() 
	 {
		return customerId;
	 }
	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}
	public String getCustomerName()
	{
		return customerName;
	}
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
	
	public String getCustomerAddress()
	{
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) 
	{
		this.customerAddress = customerAddress;
	}

	public long getContact() 
	{
		return contact;
	}
	public void setContact(long contact)
	{
		this.contact = contact;
	}
	public String getCustomerPassword() 
	{
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) 
	{
		this.customerPassword = customerPassword;
	}
	public String getCustomerUserName() 
	{
		return customerUserName;
	}
	public void setCustomerUserName(String customerUserName)
	{
		this.customerUserName = customerUserName;
	}
	@Override
	public String toString()
	{
		return "Customer [customerId=" + customerId + ", customerName="
				+ customerName + ", customerAddress=" + customerAddress
				+ ", contact=" + contact + ", customerPassword="
				+ customerPassword + ", customerUserName=" + customerUserName
				+ "]";
	}

	
	
	  
}
