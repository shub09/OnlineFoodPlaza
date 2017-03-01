package com.foodplazashubham.utility;

import java.sql.*;

public class DBUtility
{
  static Connection con=null;
  public static Connection getConnection()
  {
	  
    try
    {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodplazashubham","root","squ@d123");
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
      return con;
  }
}
