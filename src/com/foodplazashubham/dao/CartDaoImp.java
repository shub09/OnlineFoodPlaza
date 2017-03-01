package com.foodplazashubham.dao;

import java.util.*;
import java.sql.*;
import java.util.ArrayList;

import com.foodplazashubham.pojo.Cart;
import com.foodplazashubham.utility.DBUtility;

public class CartDaoImp implements CartDao 
{

	Connection con=null;
	String sql=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	@Override
	public boolean addToCart(Cart c)
	{
		try
		{ 
			con=DBUtility.getConnection();
			sql="insert into Cart(customerusername,foodid,foodquantity)values(?,?,?)";
			PreparedStatement ps1=con.prepareStatement(sql);
			ps1.setString(1, c.getCustomerUserName());
			ps1.setInt(2,c.getFoodId());
			ps1.setInt(3, c.getFoodQuantity());
			
			int a=ps1.executeUpdate();
			if(a>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

	@Override
	public List<Cart> listCart(String customerusername)
	{
		List<Cart> l=new ArrayList<Cart>();
		try
		{
			con=DBUtility.getConnection();
			sql="select c.cartid,c.customerusername,c.foodid,f.foodname,f.foodprice,f.foodquantity from Cart c,Food f where f.foodid=c.foodid and c.customerusername=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,customerusername);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Cart c=new Cart();
				c.setCartId(rs.getInt("cartid"));
				c.setCustomerUserName(rs.getString("customerusername"));
				c.setFoodId(rs.getInt("foodid"));
				c.setFoodQuantity(rs.getInt("foodquantity"));
				c.setFoodName(rs.getString("foodname"));
				c.setFoodPrice(rs.getInt("foodprice"));
				l.add(c);
			}
			return l;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	

	@Override
	public boolean deleteCart(int  cartid,String customerusername)
	{
		try
		{
			con=DBUtility.getConnection();
			sql="delete from Cart where cartid=? and customerusername=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, cartid);
			ps.setString(2,customerusername);
			int a=ps.executeUpdate();
			if(a>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	public boolean clearCart(String customerusername)
	{
		try
		{
			con=DBUtility.getConnection();
			sql="delete from Cart where customerusername=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,customerusername);
			int a=ps.executeUpdate();
			if(a>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

}
