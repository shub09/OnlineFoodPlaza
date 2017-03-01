<%@ page import="com.foodplazashubham.pojo.Customer" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ADD FOOD</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script>
function validate()
{
var fid=document.getElementById("fid").value;	
var fname=document.getElementById("fname").value;
var fprice=document.getElementById("fprice").value;
if(fid=="")
{
document.getElementById("fidError").innerHTML="*Please Enter Id";
return false;
}
if(fname=="")
{
document.getElementById("fnameError").innerHTML="*Please Enter Name";
return false;
}
if(fprice=="")
{
document.getElementById("fpriceError").innerHTML="*Please Enter Price of the Food";
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
 <form action="CommonFoodServlet" method="post" onsubmit="return validate()">
  <input type="hidden" name="action"  value="addfood">
  <table bgcolor="gray" border="1" bordercolor="green" align="center" cellpadding="15" >
        <tr>
            <td>FoodId</td>
            <td>
                  <input type="text" name="foodid" id="fid">
                  <br>             
                  <span id="fidError" style="color:red"></span>
            </td>
         </tr> 
         <tr>
            <td>FoodName</td>
            <td>
                  <textarea rows="1" cols="20" name="foodname" id="fname">
                 </textarea>
                 <br>             
                  <span id="fnameError" style="color:red"></span>
            </td>
         </tr> 
         <tr>
            <td>FoodPrice</td>
            <td>
                  <input type="text" name="foodprice" id="fprice">
                  <br>             
                  <span id="fpriceError" style="color:red"></span>
            </td>
         </tr> 
         <tr>
            <td>FoodType</td>
            <td>
                  <select name="type">
                    <option value="veg">VEG</option>
                    <option value="non veg">NON VEG</option>    
                  </select>  
                      
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