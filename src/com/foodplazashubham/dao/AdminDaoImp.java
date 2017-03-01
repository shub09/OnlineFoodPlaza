package com.foodplazashubham.dao;


import java.sql.*;
import com.foodplazashubham.utility.DBUtility;

public class AdminDaoImp implements AdminDao
{
	Connection con=null;
	String sql=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	public String getAdmin(String adminUserName)
	{
		try
		{
			con=DBUtility.getConnection();
			sql="select adminname from Admin where adminusername=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,adminUserName);
			rs=ps.executeQuery();
			while(rs.next())
			{
				String adminname=rs.getString("adminname");
				return adminname;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
}

