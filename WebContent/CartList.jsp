<%@ page import="java.util.List,com.foodplazashubham.pojo.Cart" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> CART LIST</title>
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

<% List<Cart> cartlist=(List<Cart>)session.getAttribute("cartlist"); %> 
     <form action="CommonCartServlet" method="post">
     <input type="hidden" name="action" value="placeorder"></input>
      <table style="width:50%" bgcolor="gray" border="1" bordercolor="green" align="center" cellpadding="15">
           <caption>CART LIST</caption>
             <tr>
                <th>Food Name</th>
                <th>Food Price</th>
                <th>Quantity</th>
             </tr>
              <% 
          for (int i=0;i<cartlist.size();i++)
         {
        	Cart c=cartlist.get(i);%>
        	<tr>
        	 <td><%=c.getFoodName() %></td>
        	 <td><%=c.getFoodPrice()%>
        	  <input type="hidden" name="foodprice" value="<%=c.getFoodPrice()%>"></input>
        	 </td>
        	 <td><select name="quantity">
        	   <% 
                   for (int j=0;j<50;j++)
                  {%>
                  <option value="<%=j %>"><%=j %></option>
                  <%}%>
                  </select>
        	 </td>        	
        	 <td><a href="CommonCartServlet?action=delete&cartid=<%=c.getCartId() %>">DELETE</a></td>
        	</tr>
         <%}%>
         <tr>
            <td colspan="4" align="center">
              <input type="submit" value="Place Order"/>
            </td>
         </tr>
      </table>    
      <div id="templatemo_footer">
<a href="#">Home</a> | <a href="#">Tea</a> | <a href="#">Top Dishes</a> | <a href="#">Company</a> | <a href="#">FAQs</a> | <a href="#">Contact Us</a><br />
Copyright © 2024 <a href="#"><strong>Your Company Name</strong></a> 
<!-- Credit: www.templatemo.com --></div> <!-- end of footer -->
<!--  Free CSS Templates by TemplateMo.com  --> 
</div><!-- end of container -->    
</body>
</html>