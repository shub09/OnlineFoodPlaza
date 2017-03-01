package com.foodplazashubham.dao;

import java.sql.*;

import java.util.Date;
import com.foodplazashubham.pojo.FoodOrder;
import com.foodplazashubham.utility.DBUtility;

public class FoodOrderDaoImp implements FoodOrderDao
{
	Connection con=null;
	String sql=null;
	String sql1=null;
	
	ResultSet rs=null;
	ResultSet rs1=null;
	FoodOrder fd=new FoodOrder();
/*	@Override
	public boolean placeOrder(int custId)
	{
		double T_Bill = 0;
		try
		{
			con=DBUtility.getConnection();
			sql="select sum( F.foodprice * C.foodquantity ) as Total from Food as F,Cart as C where F.foodname=C.foodname and C.customerid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, custId);
			rs=ps.executeQuery();
			if(rs.next())
			{
				T_Bill=rs.getDouble("Total");
			}
			sql="insert into Foodorder(customerid,totalbill,orderstatus,orderdate) values(?,?,?,NOW())";
			ps=con.prepareStatement(sql);
			ps.setInt(1, custId);
			ps.setDouble(2, T_Bill);
			ps.setString(3, "Processing");
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
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<FoodOrder> getAllOrder() 
	{
		List<FoodOrder> l=new ArrayList<FoodOrder>();
		try
		{
			
			con=DBUtility.getConnection();
			sql="select * from Foodorder";
			PreparedStatement ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				FoodOrder fd=new FoodOrder();
				fd.setOrderId(rs.getInt("orderid"));
				fd.setCustomerId(rs.getInt("customerid"));
				fd.setTotalbill(rs.getDouble("totalbill"));
				fd.setOrderStatus(rs.getString("orderstatus"));
				fd.setOrderDate(rs.getString("orderdate"));
				l.add(fd);
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
	public String checkStatus(int orderId)
	{
		String s;
		try
		{
			con=DBUtility.getConnection();
			sql="select orderstatus from Foodorder where orderid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, orderId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				s=rs.getString("orderstatus");
				return s;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean changeStatus(int orderId, String orderStatus)
	{
		try
		{
			con=DBUtility.getConnection();
			sql="update Foodorder set orderstatus=? where orderid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, orderStatus);
			ps.setInt(2, orderId);
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
	}*/
	public int placeOrder(String customerusername,double totalbill)
	{
		// TODO Auto-generated method stub
		int orderid=0;
		try 
		{
			con=DBUtility.getConnection();
			if(totalbill>0)
			{
				
				
				String orderdate=new Date().toString();
				System.out.println(orderdate);
			    sql="insert into Foodorder(customerusername,totalbill,status,orderdate)values(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
			
				ps.setString(1,customerusername);				
				ps.setDouble(2,totalbill);
				ps.setString(3,"Processing");
                ps.setString(4,orderdate);
				
				int a = ps.executeUpdate();
				
				if(a>0)
				{
					String sql1="select orderid from Foodorder where customerusername=? and orderdate=?";
					PreparedStatement ps1=con.prepareStatement(sql1);
				
					ps1.setString(1,customerusername);					
					ps1.setString(2,orderdate);
					System.out.println(ps1);
					 rs1 = ps1.executeQuery();
				   /* while(rs.next())
				    {
				    	System.out.println("hii");
						orderid=rs.getInt("orderid");		
					    return orderid;
				    }*/
					if(rs1.next())
					{
						System.out.println("hii");
						orderid=rs1.getInt("orderid");
						System.out.println(orderid);
					    return orderid;
					}					
				
				    else
				   {
					 return 0;
				   }
			}
			else
			{
				return 0;
			}

			}
		}
	catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}
