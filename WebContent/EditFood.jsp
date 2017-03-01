<%@ page import="java.util.List,com.foodplazashubham.pojo.Food" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<title>UPDATE FOOD</title>
<script>
function validate()
{	
var fname=document.getElementById("fname").value;
var fprice=document.getElementById("fprice").value;
var ftype=document.getElementById("ftype").value;
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
if(ftype=="")
{
document.getElementById("ftype").innerHTML="*Please mention type of Food";
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
 <%  Food food=(Food)session.getAttribute("food"); %>
 
 <form action="CommonFoodServlet" method="post" onsubmit="return validate()">
  <input type="hidden" name="action"  value="updatefood">
  <table bgcolor="gray" border="1" bordercolor="green" align="center" cellpadding="15" >
      
        <tr>
            <td>FoodId</td>
            <td>
                  <input type="text" name="foodid" value=<%=food.getFoodId()%> readonly>
            </td>
         </tr> 
         
         <tr>
            <td>FoodName</td>
            <td>
                  <textarea rows="1" cols="20" name="foodname" id="fname"><%=food.getFoodName() %>
                  </textarea>
                   <br>             
                  <span id="fnameError" style="color:red"></span>
            </td>
         </tr> 
         <tr>
            <td>FoodPrice</td>
            <td>
                  <input type="text" name="foodprice" value=<%=food.getFoodPrice() %> id="fprice">
                  <br>             
                  <span id="fpriceError" style="color:red"></span>
            </td>
         </tr> 
         <tr>
            <td>FoodType</td>
            <td>
                 <textarea rows="1" cols="20" name="type"  id="ftype"><%=food.getFoodType()%>
                 </textarea>
                 <span id="ftypeError" style="color:red"></span>
            </td>
         </tr> 
          <tr>
               <td colspan="2">
                           <input type="submit" name="submit" value="UPDATE"/>
                           <input type="reset" value="RESET">
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