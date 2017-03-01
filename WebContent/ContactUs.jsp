<%@ page import="com.foodplazashubham.pojo.Customer" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Tea and Meal - Free CSS Template</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
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
        	<li class="current"><a href="Index.jsp"><b>Home</b></a></li>
            <li><a href="CommonFoodServlet"><b>Food Menu</b></a></li>
            
             <%if(custUserName== null && adminName==null){ %>
    		 <li><a href="AddCustomer.jsp"><b>Register</b></a></li>
    		 <%} %>
            <li><a href="ContactUs.jsp"><b>Contact us</b></a></li>
            
            <%if(adminName!=null){ %>
            <li><a href="CommonCustomerServlet"><b>Show Customer</b></a></li>
            <li ><a href="AddFood.jsp"><b>Add Food</b></a></li>
            <li><a href="CommonFeedbackServlet" ><b>Feedback</b></a></li>
            <%} %>
            
            <%if(custUserName!=null){ %>
    		 <li ><a href="CommonCustomerServlet?action=Edit&cust=<%=custUserName%>">
    		 <b>Edit Customer Profile</b></a></li>
    		  <li ><a href="CommonCartServlet"><b>Show Cart</b></a></li>
    		 <%} %>
    		  
    		 <%if(custUserName== null && adminName==null){ %>
            <li ><a href="Login.jsp"><b>LOGIN</b></a></li><%} %>
            
    		<%if(custUserName!= null || adminName!=null){ %>
            <li ><a href="UpdatePassword.jsp"><b>Change Password</b></a></li><%} %>
            
           <%if(custUserName!= null || adminName!=null){ %>
            <li ><a href="CommonLoginServlet?action=logout"><b>LOGOUT</b></a></li><%} %>
        </ul>
    </div> <!-- end of menu -->
    
		
		
		
			<div style="margin-left: 25px; margin-top: 25px; font-size: medium;">
			<h3>Snack Time</h3>
			<p>Shop no. 1, SB Road,</p>
			<p>Powai,</p>
			<p>Mumbai-400076</p>
		</div>
	
	<br />
		<div style="margin-left: 25px; margin-top: 25px;">
				<h2 align="left">Give your Feedback here..</h2>
				
			<form action="CommonFeedbackServlet" method="post">
			<input type="hidden" value="addFeedback" name="action">
				<table align="left">
					<tr>
						<th>Name : </th>
						<td><input type="text" name="fbname"></td>
					</tr>

					<tr>
						<th>Email id : </th>
						<td><input type="email" name="fbemailid"></td>
					</tr>

					<tr>
						<th>Contact no : </th>
						<td><input type="text" name="fbcontactno"></td>
					</tr>

					<tr>
						<th>Message : </th>
						<td><textarea cols="20" rows="5" name="message"></textarea></td>
					</tr>

					<tr>
						<td><input type="submit" value="Submit"></td>
						<td align="center"><input type="reset" value="Reset"></td>
					</tr>

				</table>

			</form>
		</div>
			


				

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
	<!-- end of container -->
	<!-- templatemo 082 tea and meal -->
	<!-- 
Tea And Meal Template 
http://www.templatemo.com/preview/templatemo_082_tea_and_meal 
-->
</body>
</html>
