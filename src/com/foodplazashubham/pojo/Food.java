package com.foodplazashubham.pojo;

public class Food
{
  private int foodId;
  private String foodName;
  private double foodPrice;
  private String foodType;
  private int foodQuantity;
  
public int getFoodQuantity() {
	return foodQuantity;
}
public void setFoodQuantity(int foodQuantity) {
	this.foodQuantity = foodQuantity;
}
public int getFoodId() 
{
	return foodId;
}
public void setFoodId(int foodId)
{
	this.foodId = foodId;
}

public String getFoodName()
{
	return foodName;
}
public void setFoodName(String foodName)
{
	this.foodName = foodName;
}

public double getFoodPrice()
{
	return foodPrice;
}
public void setFoodPrice(double foodPrice)
{
	this.foodPrice = foodPrice;
}
public String getFoodType() {
	return foodType;
}
public void setFoodType(String foodType) {
	this.foodType = foodType;
}
@Override
public String toString() {
	return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodPrice="
			+ foodPrice + ", foodType=" + foodType + ", foodQuantity="
			+ foodQuantity + "]";
}
  
}
