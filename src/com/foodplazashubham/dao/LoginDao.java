package com.foodplazashubham.dao;

public interface LoginDao 
{
  boolean adminLogin(String adminUserName,String addPassword);
  boolean adminChangePassword(String adminUserName,String newPassword);
  boolean customerLogin(String customerUserName,String addPassword);
  boolean customerChangePassword(String customerUserName,String newPassword);
}
