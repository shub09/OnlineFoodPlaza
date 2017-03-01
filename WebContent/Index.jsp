<%@ page import="com.foodplazashubham.pojo.Customer" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--  Free CSS Template by TemplateMo.com  --> 
<% String custUserName = (String) session.getAttribute("customer"); %>
<% String adminName = (String) session.getAttribute("admin"); %>
<%String placeordersuc=(String)request.getAttribute("placeordersuccess"); %>
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
    <div id="message" align="center" style="color:red" >

<%if(adminName!=null){
out.println("Welcome "+adminName);
}
if(custUserName!= null){
out.println("Welcome "+custUserName);
}%>

    
   <%  if(placeordersuc!=null)
	{
		out.println(placeordersuc);
	}%>
	</div>
    <div id="templatemo_top_dishes">

    	<h1>Recommended Dishes</h1>
        <div class="top_dishes_box">
       	  <img src="images/wrap.jpeg" alt="image" width="205" height="150"/>
          <h2>WRAPS</h2>
            <p>These tasty wraps are great for a relaxed meal.Available with chicken or panner fillings in a crunchy roll..this is one of the best appetizer. <a href="#">Read more...</a></p>
      </div>
        
        <div class="top_dishes_box">
       	  <img src="images/aloo tikki.jpeg" alt="image" width="205" height="150"/>
            <h2>ALOO TIKKI</h2>
          <p>The traditional tikki turned into a big cheesy burger bundled with green saunce giving it a twist. <a href="#">Read more...</a></p>
        </div>
        
        <div class="top_dishes_box">
       	  <img src="images/pizza.jpeg" alt="image" width="205" height="150"/>
            <h2>DOUBLE CHEESE PIZZA</h2>
          <p>These personal-sized pizzas are loaded with fresh tomato slices and topped up with two kinds of cheese, black olives and fresh herbs. 
             A delicious way to welcome your guests. <a href="#">Read more...</a></p>
      </div>
        
        <div class="top_dishes_box">
       	  <img src="images/nuggets.jpeg" alt="image" width="205" height="150"/>
            <h2>Chicken Nuggets</h2>
          <p>Bite sized pieces of chicken battered and cooked to golden perfection <a href="#">Read more...</a></p>
        </div>
        
        <div class="cleaner">&nbsp;</div>
    
    </div> <!-- end of top dishes -->
    
   <div id="templatemo_content">
    	<span class="top"></span>
        <div id="templatemo_innter_content">
            
                <div id="templatemo_content_left">
                    <h1>Welcome to our website</h1>
                <img src="images/templatemo_image_05.jpg" alt="image" />
                    
                    <p>Snack Time is designed and maintained by Shubham Wankhede </p>
                    <a href="#">Read more...</a>
                    
                    <div style="clear: botemplatemo_headerth; padding: 30px 0 20px 0;">                
                <a href="http://validator.w3.org/check?uri=referer"><img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
<a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="Valid CSS!" vspace="8" border="0" /></a>
					</div>
                    
                    <div class="cleaner_with_height">&nbsp;</div>
                
                </div> <!-- end of content left -->
                <div id="templatemo_content_right">
                    <h1>Special meal for you</h1>
                    <div class="right_column_section">
	             
                        <img src="images/meal.jpeg" alt="image" width="205" height="150"/>
                        <p></p>
                        <a href="#">Read more...</a>
                     </div>
                
                </div> <!-- end of content right -->
        		<div class="cleaner">&nbsp;</div>
        </div>   
        <div class="cleaner" style="background: #fff;">&nbsp;</div> 	
    </div>


<div id="templatemo_footer">
    
    	<a href="#">Home</a> | <a href="#">Tea</a> | <a href="#">Top Dishes</a> | <a href="#">Company</a> | <a href="#">FAQs</a> | <a href="#">Contact Us</a><br />
        Copyright © 2024 <a href="#"><strong>Your Company Name</strong></a> 
        <!-- Credit: www.templatemo.com --></div> <!-- end of footer -->
<!--  Free CSS Templates by TemplateMo.com  --> 
</div><!-- end of container -->
<!-- templatemo 082 tea and meal -->
<!-- 
Tea And Meal Template 
http://www.templatemo.com/preview/templatemo_082_tea_and_meal 
-->
<script>
	
	$(function ()
       {
	   var $element = $('#templatemo_header');
	    function fadeInOut () 
           {
	        $element.fadeIn                               /*$(#templatemo_header).fadeIn */
                (1000, function () 
                {
	            $element.fadeOut
                    (1500, function () 
                    {
	                $element.fadeIn(1500, function () {
	                    setTimeout(fadeInOut, 500);
	                });
	            });
	        });
	    }

	    fadeInOut();
	});

</script>
</body>
</html>
