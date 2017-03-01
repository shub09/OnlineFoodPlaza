package com.foodplazashubham.pojo;

public class Admin
{
	  private String adminName;
	  private String adminUserName;
	  private String Password;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminUserName="
				+ adminUserName + ", Password=" + Password + "]";
	}
	  
}
