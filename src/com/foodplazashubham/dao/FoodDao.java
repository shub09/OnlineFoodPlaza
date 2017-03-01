package com.foodplazashubham.dao;

import com.foodplazashubham.pojo.Food;
import java.util.*;

public interface FoodDao 
{
   boolean addFood(Food food);
   boolean updateFood(Food food);
   boolean deleteFood(int id);
   Food getFoodById(int id);
   List<Food> displayAllFood();
}
