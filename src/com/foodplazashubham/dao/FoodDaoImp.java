package com.foodplazashubham.dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import com.foodplazashubham.pojo.Food;
import com.foodplazashubham.utility.DBUtility;

public class FoodDaoImp implements FoodDao
{
 
  Connection con=null;
  String sql=null;
  ResultSet rs=null;
  public boolean addFood(Food food)
  {
	  con=DBUtility.getConnection();
	  sql="Insert into Food values(?,?,?,?,?)";
	  PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
	
	  ps.setInt(1,food.getFoodId());
	  ps.setString(2,food.getFoodName());
	  ps.setDouble(3,food.getFoodPrice());
	  ps.setString(4,food.getFoodType());
	  ps.setInt(5,food.getFoodQuantity());
	  System.out.println(ps);
	  int i=ps.executeUpdate();
	  System.out.println(i);
	  if(i>0)
	  {
		return true;  
	  }
	  else
	  {
		  return false;
	  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
  }


@Override
public boolean updateFood(Food food)
{
	  con=DBUtility.getConnection();
	  sql="Update Food set foodname=?,foodprice=?,foodtype=? where foodid=?";
	  PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
	
	  ps.setInt(4,food.getFoodId());
	  ps.setString(1,food.getFoodName());
	  ps.setDouble(2,food.getFoodPrice());
	  ps.setString(3,food.getFoodType());
	  System.out.println(ps);
	  int i=ps.executeUpdate();
	  System.out.println(i);
	  if(i>0)
	  {
		return true;  
	  }
	  else
	  {
		  return false;
	  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}
@Override
public boolean deleteFood(int id) 
{
	con=DBUtility.getConnection();
	  sql="delete from Food where foodid=?";
	  PreparedStatement ps;
	try 
	{
		ps = con.prepareStatement(sql);
	    ps.setInt(1,id);
	    System.out.println(ps);
	    int i=ps.executeUpdate();
	    System.out.println(i);
	    if(i>0)
	    {
		  return true;  
	    }
	   else
	   {
		  return false;
	   }
	}
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	return false;
}
@Override
public Food getFoodById(int id)
{
	Food fo=new Food();
	con=DBUtility.getConnection();
	  sql="select * from Food where foodid=?";
	  PreparedStatement ps;
	try 
	{
		ps = con.prepareStatement(sql);
	    ps.setInt(1,id);
	    System.out.println(ps);
	     rs=ps.executeQuery();
	     while(rs.next())
	     {
	    	 fo.setFoodId(rs.getInt("foodid"));
	    	 fo.setFoodName(rs.getString("foodname"));
			 fo.setFoodPrice(rs.getInt("foodprice"));
			 fo.setFoodType(rs.getString("foodtype"));  
			 fo.setFoodQuantity(rs.getInt("foodquantity"));
	    	 return fo;
	     }
	    
	}
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	
	return null;
}
@Override
public List<Food> displayAllFood()
{
	List<Food> f=new LinkedList<Food>();

	con=DBUtility.getConnection();
	sql="select * from Food";
	PreparedStatement ps;
	try
	{
		ps=con.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			Food food=new Food();
			food.setFoodId(rs.getInt("foodid"));
			food.setFoodName(rs.getString("foodname"));
			food.setFoodPrice(rs.getInt("foodprice"));
			food.setFoodType(rs.getString("foodtype"));
			food.setFoodQuantity(rs.getInt("foodquantity"));
			f.add(food);
			
		}
		return f;
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	return null;
}
}
