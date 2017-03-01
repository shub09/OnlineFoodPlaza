<%@ page import="java.util.List,com.foodplazashubham.pojo.Food" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>DISPLAY FOOD</title>

<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

</head>
<body>
<!--  Free CSS Template by TemplateMo.com  --> 
<% String custUserName = (String) session.getAttribute("customer"); %>
<% String adminName = (String) session.getAttribute("admin"); %>
<%-- <% Customer cust=(Customer)session.getAttribute("cust"); %> --%>

<div id="templatemo_container">
	<div id="templatemo_header">
    	<div id="site_title"></div>
    </div> <!-- end of header -->
    
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
    
    
<%-- <%
   String cus=(String)request.getAttribute("CustomerLogin");
   String adm=(String)request.getAttribute("AdminLogin");
   if(cus.equals("false")||adm.equals("false"))
   {
	   out.println("invalid name and password");
   } 
%> --%>
    <% List<Food> foodlist=(List<Food>)session.getAttribute("foodlist"); %> 
      <table style="width:50%" bgcolor="gray" border="1" bordercolor="green" align="center" cellpadding="15">
           <caption>FOOD LIST</caption>
             <tr>
                <th>Food Id</th>
                <th>Food Name</th>
                <th>Food Price</th>
                <th>Food Type</th>
                <th>Food Quantity</th>
             </tr>
              <% 
          for (int i=0;i<foodlist.size();i++)
         {
        	Food food=foodlist.get(i);%>
        	<tr>
        	 <td><%=food.getFoodId()  %></td>
        	 <td><%=food.getFoodName() %></td>
        	 <td><%=food.getFoodPrice() %></td>
        	 <td><%=food.getFoodType() %></td>
        	 <td><%=food.getFoodQuantity() %></td>
        	 <%if(adminName!=null){ %>
        	 <td><a href="CommonFoodServlet?action=edit&foodId=<%=food.getFoodId() %>">EDIT</a></td>
        	 <td><a href="CommonFoodServlet?action=delete&foodId=<%=food.getFoodId()%>">DELETE</a></td>
        	 <%} %>
              <%if(custUserName!=null){ %>
              <td><a href="CommonCartServlet?action=addtocart&foodId=<%=food.getFoodId()%>&foodQuantity=<%=food.getFoodQuantity()%>">ADD TO CART
              </a></td>
               <%} %>
            </tr>
           <%} %>
      </table>     
       <div id="templatemo_footer">
    
    	<a href="#">Home</a> | <a href="#">Tea</a> | <a href="#">Top Dishes</a> | <a href="#">Company</a> | <a href="#">FAQs</a> | <a href="#">Contact Us</a><br />
        Copyright © 2024 <a href="#"><strong>Your Company Name</strong></a> 
        <!-- Credit: www.templatemo.com --></div> <!-- end of footer -->
<!--  Free CSS Templates by TemplateMo.com  --> 
</div><!-- end of container -->    
</body>
</html>