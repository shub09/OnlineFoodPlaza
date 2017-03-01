package com.foodplazashubham.dao;

import java.sql.*;

//import com.foodplazashubham.pojo.Admin;
import com.foodplazashubham.utility.DBUtility;

public class LoginDaoImp implements LoginDao
{
	Connection con=null;
	ResultSet rs=null;
	String sql=null;

	public boolean adminLogin(String adminUserName, String addPassword)
    {
			try
			{
				//Admin ad=new Admin();
				con=DBUtility.getConnection();
				sql="select adminpassword from Admin where adminusername=?";
				PreparedStatement pts=con.prepareStatement(sql);
				pts.setString(1,adminUserName);
				rs=pts.executeQuery();
				while(rs.next())
				{
					String adpass=rs.getString("adminpassword");
					//ad.setContact(rs.getLong("contact"));
					if(adpass.equals(addPassword))
					{
						return true;
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return false;
	}

	@Override
	public boolean adminChangePassword(String adminUserName, String newPassword) 
	{

		try
		{
			con=DBUtility.getConnection();
			sql="update Admin set adminpassword=? where adminusername=?";
			PreparedStatement pts=con.prepareStatement(sql);
			pts.setString(1,newPassword);
			pts.setString(2,adminUserName);
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
	public boolean customerLogin(String customerUserName, String addPassword)
	{
		try
		{
			//Admin ad=new Admin();
			con=DBUtility.getConnection();
			sql="select customerpassword from Customer where customerusername=?";
			PreparedStatement pts=con.prepareStatement(sql);
			pts.setString(1,customerUserName);
		
			rs=pts.executeQuery();
			while(rs.next())
			{
				String adpass=rs.getString("customerpassword");
				//ad.setContact(rs.getLong("contact"));
				System.out.println(adpass);
				if(adpass.equals(addPassword))
				{
					return true;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean customerChangePassword(String customerUserName,String newPassword) 
	{

		try
		{
			con=DBUtility.getConnection();
			sql="update Customer set customerpassword=? where customerusername=?";
			PreparedStatement pts=con.prepareStatement(sql);
			pts.setString(2,customerUserName);
			pts.setString(1,newPassword);

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

}
