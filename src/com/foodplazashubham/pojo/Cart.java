package com.foodplazashubham.pojo;

public class Cart
{
	  private String customerUserName;
	  private int foodId;
	  private int foodQuantity;
	  private String foodName;	  
	  private int foodPrice;
	  private int cartId;
	  
	  
	  
	  public int getCartId() 
	  {
		return cartId;
	  }
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getFoodName() {
			return foodName;
		}
		public void setFoodName(String foodName) {
			this.foodName = foodName;
		}
		public int getFoodPrice() {
			return foodPrice;
		}
		public void setFoodPrice(int foodPrice) {
			this.foodPrice = foodPrice;
		}
	  public String getCustomerUserName() {
		return customerUserName;
	}
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getFoodQuantity() {
		return foodQuantity;
	}
	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}
	@Override
	public String toString() {
		return "Cart [customerUserName=" + customerUserName + ", foodId="
				+ foodId + ", foodQuantity=" + foodQuantity + ", foodName="
				+ foodName + ", foodPrice=" + foodPrice + ", cartId=" + cartId
				+ "]";
	}
	  

	  
	  
}
