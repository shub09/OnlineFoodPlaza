package com.foodplazashubham.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.foodplazashubham.pojo.Customer;
import com.foodplazashubham.pojo.Feedback;
import com.foodplazashubham.utility.DBUtility;


public class CustomerDaoImp implements CustomerDao
{
	Connection con=null;
	ResultSet rs=null;
	String sql=null;
	@Override
	public boolean addCustomer(Customer cust)
	{

		  con=DBUtility.getConnection();
		  sql="Insert into Customer(customername,customeraddress,contact,customerusername,customerpassword) values(?,?,?,?,?)";
		  PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
		    ps.setString(1,cust.getCustomerName());
		    ps.setString(2,cust.getCustomerAddress());
		    ps.setLong(3,cust.getContact());
		    ps.setString(4,cust.getCustomerUserName());
		    ps.setString(5,cust.getCustomerPassword());
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
	public boolean updateCustomer(Customer cust)
	{
		try
		{
			con=DBUtility.getConnection();
			sql="update Customer set customername=?,customeraddress=?,contact=?,customerusername=?,customerpassword=? where customerid=?";
			PreparedStatement pts=con.prepareStatement(sql);
			pts.setString(1, cust.getCustomerName());
			pts.setString(2, cust.getCustomerAddress());
			pts.setLong(3, cust.getContact());			
			pts.setString(4,cust.getCustomerUserName());
			pts.setString(5,cust.getCustomerPassword());
			pts.setInt(6, cust.getCustomerId());
			int a=pts.executeUpdate();
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
	public boolean deleteCustomer(int custid) 
	{
		try
		{
			con=DBUtility.getConnection();
			sql="delete from Customer where customerid=?";
			PreparedStatement pts=con.prepareStatement(sql);
			pts.setInt(1,custid);
			int a=pts.executeUpdate();
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
	public Customer getCustomerById(int custid)
	{
		try
		{
			Customer cust=new Customer();
			con=DBUtility.getConnection();
			sql="select * from Customer where customerid=?";
			PreparedStatement pts=con.prepareStatement(sql);
			pts.setInt(1, custid);
			rs=pts.executeQuery();
			while(rs.next())
			{
				cust.setCustomerId(rs.getInt("customerid"));
				cust.setCustomerName(rs.getString("customername"));
				cust.setCustomerAddress(rs.getString("customeraddress"));
				cust.setContact(rs.getLong("contact"));
				//cust.setCustomerUserName(rs.getString("cutsomerusername"));
				//cust.setCustomerPassword(rs.getString("cutsomerpassword"));
				return cust;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	@Override
	public List<Customer> getAllCustomer()
	{
		List<Customer> l=new LinkedList<Customer>();
		try
		{
			con=DBUtility.getConnection();
			sql="select * from Customer";
			PreparedStatement pts=con.prepareStatement(sql);
			rs=pts.executeQuery();
			while(rs.next())
			{
				Customer cust=new Customer();
				cust.setCustomerId(rs.getInt("customerid"));
				cust.setCustomerName(rs.getString("customername"));
				cust.setCustomerAddress(rs.getString("customeraddress"));
				cust.setContact(rs.getLong("contact"));
				l.add(cust);
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
	public Customer getCustomerByUserName(String customerUserName)
	{
		try
		{
			Customer cust=new Customer();
			con=DBUtility.getConnection();
			sql="select * from Customer where customerusername=?";
			PreparedStatement pts=con.prepareStatement(sql);
			pts.setString(1,customerUserName);
			rs=pts.executeQuery();
			while(rs.next())
			{
				cust.setCustomerId(rs.getInt("customerid"));
				cust.setCustomerName(rs.getString("customername"));
				cust.setCustomerAddress(rs.getString("customeraddress"));
				cust.setContact(rs.getLong("contact"));
				cust.setCustomerUserName(rs.getString("customerusername"));
				cust.setCustomerPassword(rs.getString("customerpassword"));
				return cust;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	@Override
	public boolean addFeedback(Feedback feed) 	
	{
		try
		{
			con=DBUtility.getConnection();
			String sql = "insert into Feedback(fbname,fbemailid,fbcontact,message)values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			//ps.setInt(1, feed.getFbid());
			ps.setString(1, feed.getFbname());
			ps.setString(2, feed.getFbemailid());
			ps.setString(3, feed.getFbcontactno());
			ps.setString(4, feed.getMessage());
			
			
			int x=ps.executeUpdate();
			if(x>0)
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Feedback> showFeedback()
	{
		List<Feedback> feedbacklist = new ArrayList<Feedback>();
		try
		{
			con=DBUtility.getConnection();
			String sql="select * from Feedback";
			PreparedStatement ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Feedback feed = new Feedback();
				feed.setFbid(rs.getInt("fbid"));
				feed.setFbname(rs.getString("fbname"));
				feed.setFbemailid(rs.getString("fbemailid"));
				feed.setFbcontactno(rs.getString("fbcontact"));
				feed.setMessage(rs.getString("message"));
				feedbacklist.add(feed);
			}
			
			return feedbacklist;
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
