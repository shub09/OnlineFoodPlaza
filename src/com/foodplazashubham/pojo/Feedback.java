package com.foodplazashubham.pojo;

public class Feedback
{
	private int fbid;
	private String fbname;
	private String fbemailid;
	private String fbcontactno;
	private String message;
	public int getFbid() {
		return fbid;
	}
	public void setFbid(int fbid) {
		this.fbid = fbid;
	}
	public String getFbname() {
		return fbname;
	}
	public void setFbname(String fbname) {
		this.fbname = fbname;
	}
	public String getFbemailid() {
		return fbemailid;
	}
	public void setFbemailid(String fbemailid) {
		this.fbemailid = fbemailid;
	}
	public String getFbcontactno() {
		return fbcontactno;
	}
	public void setFbcontactno(String fbcontactno) {
		this.fbcontactno = fbcontactno;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Feedback [fbid=" + fbid + ", fbname=" + fbname + ", fbemailid="
				+ fbemailid + ", fbcontactno=" + fbcontactno + ", message="
				+ message + "]";
	}
	
}
