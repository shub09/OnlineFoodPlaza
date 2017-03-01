<%@ page import="com.foodplazashubham.pojo.Customer" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ADD CUSTOMER</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script>
function validate()
{
	
var cname=document.getElementById("cname").value;
var caddress=document.getElementById("caddress").value;
var ccontact=document.getElementById("ccontact").value;
if(cname=="")
{
document.getElementById("cnameError").innerHTML="*Please Enter Name";
return false;
}
if(caddress=="")
{
document.getElementById("caddressError").innerHTML="*Please Enter Address";
return false;
}
if(ccontact=="")
{
document.getElementById("ccontactError").innerHTML="*Please Enter Contact Number";
return false;
}
if(isNaN(ccontact))
{
document.getElementById("ccontactError").innerHTML="Please Enter Contact Number in number";
return false;
}
if(ccontact.length<10)
{
document.getElementById("ccontactError").innerHTML="Please Enter Contact Number greater than 10 digit";
return false;
}
return true;
}
</script>
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
  <form action="CommonCustomerServlet" method="post" onsubmit="return validate()">
  <input type="hidden" name="action"  value="addcustomer">
  <table bgcolor="gray" border="1" bordercolor="green" align="center" cellpadding="15" >
           <tr>
            <td>Customer Name</td>
            <td>
                  <textarea rows="1" cols="20" name="customername" id="cname">
                  </textarea>
                  <br>
                  <span id="cnameError" style="color:red"></span>
            </td>
         </tr> 
         <tr>
            <td>Customer Address</td>
            <td>
                 <textarea rows="5" cols="20" name="customeraddress" id="caddress">
                 </textarea>
                 <br>
                 <span id="caddressError" style="color:red"></span>
            </td>
         </tr> 
         <tr>
            <td>Contact Number</td>
            <td>
                  <input type="text" name="contact" id="ccontact">
                  <br>
                  <span id="ccontactError" style="color:red"></span>
            </td>
        </tr> 
        <tr>
            <td>Set UserName</td>
            <td>
                  <input type="text" name="uname" id="cuname">
                 
            </td>
        </tr> 
        <tr>
            <td>Set Password</td>
            <td>
                  <input type="password" name="password" id="cpass">
                  
            </td>
        </tr> 
        
          <tr>
               <td colspan="2">
                            <input type="submit" name="submit" value="ADD"/>
                            <input type="reset" value="CLEAR">
               </td>
           </tr>
      </table>
    </form> 
<div id="templatemo_footer">
<a href="#">Home</a> | <a href="#">Tea</a> | <a href="#">Top Dishes</a> | <a href="#">Company</a> | <a href="#">FAQs</a> | <a href="#">Contact Us</a><br />
Copyright © 2024 <a href="#"><strong>Your Company Name</strong></a> 
<!-- Credit: www.templatemo.com --></div> <!-- end of footer -->
<!--  Free CSS Templates by TemplateMo.com  --> 
</div><!-- end of container --> 
</body>
</html>