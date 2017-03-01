<%@page import="com.foodplazashubham.pojo.Feedback"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String custUserName = (String) session.getAttribute("Customer"); %>
	<% String adminName = (String) session.getAttribute("AdminName"); %>

	<!--  Free CSS Template by TemplateMo.com  -->
	<div id="templatemo_container">
		<div id="templatemo_header">
			<div id="site_title"></div>
		</div>
		<!-- end of header -->

		<div id="templatemo_menu">
			<ul>
				<li class="current"><a href="index.jsp"><b>Home</b></a></li>
				<li><a href="CommonFoodServlet"><b>Food Menu</b></a></li>
				<li><a href="ContactUs.jsp"><b>Contact Us</b></a></li>
				<%if(custUserName== null && adminName==null){ %>
				<li><a href="CustomerRegistration.jsp"><b>Register</b></a></li>
				<%} %>
				<%if(adminName!=null){ %>
				<li><a href="CommonCustomerServlet"><b>Show Customer</b></a></li>
				<li><a href="AddFood.jsp"><b>Add Food</b></a></li>
				<li><a href="CommonFeedbackServlet"><b>Feedback</b></a></li>
				<%} %>
				<%if(custUserName!=null){ %>
				<li><a
					href="CommonCustomerServlet?action=edit&cust=<%=custUserName%>"><b>Edit
							Profile</b></a></li>
				<li><a href="CommonCartServlet"><b>Show Cart</b></a></li>
				<%} %>
				<%if(custUserName!= null || adminName!=null){ %>
				<li><a href="ChangePassword.jsp"><b>Change Password</b></a></li>
				<%} %>
				<%if(custUserName== null && adminName==null){ %>
				<li><a href="Login.jsp"><b>Login</b></a></li>
				<%} %>
				<% if(custUserName!= null || adminName!=null){%>
				<li><a href="CommonLoginServlet?action=logout"><b>Logout</b></a></li>
				<%} %>
			</ul>

		</div>

	<% List<Feedback> fblist = (List<Feedback>) session.getAttribute("feedbacklist");%>

	<h2 align="center">Feedback List</h2>
	<table border="2" align="center">
		<tr>
			<th>Feedback Id</th>
			<th>Name</th>
			<th>Email id</th>
			<th>Contact no</th>
			<th>Message</th>
		</tr>

		<% for (int i = 0; i < fblist.size(); i++) {
				Feedback fb = fblist.get(i);
			%>

		<tr>
			<td><%=fb.getFbid() %></td>
			<td><%=fb.getFbname() %></td>
			<td><%=fb.getFbemailid() %></td>
			<td><%=fb.getFbcontactno() %></td>
			<td><%=fb.getMessage() %></td>
		</tr>

		<%} %>
	</table>
	
	<div id="templatemo_footer">

			<a href="index.jsp">Home</a> | <a href="#">Top Dishes</a> | <a
				href="#">Company</a> | <a href="#">FAQs</a> | <a href="#">Contact
				Us</a><br /> Copyright © 2015 <a href="#"><strong>Developed
					by Sharlee Punyarthi</strong></a>
			<!-- Credit: www.templatemo.com -->
		</div>
		<!-- end of footer -->
		<!--  Free CSS Templates by TemplateMo.com  -->
	</div>
</body>
</html>