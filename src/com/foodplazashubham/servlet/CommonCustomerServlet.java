package com.foodplazashubham.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodplazashubham.dao.*;
import com.foodplazashubham.pojo.*;
/**
 * Servlet implementation class CommonCustomerServlet
 */
@WebServlet("/CommonCustomerServlet")
public class CommonCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CommonCustomerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
	    Customer cust=new Customer();
		CustomerDaoImp cdimp=new CustomerDaoImp();
		String customerusername = (String)session.getAttribute("customer");
		String action=request.getParameter("action");
				if(action!=null && action.equalsIgnoreCase("edit"))
				{
					//int customerid =Integer.parseInt(request.getParameter("customerid"));
				    cust=cdimp.getCustomerByUserName(customerusername);
				    if(cust!=null)
				    {
				    	session.setAttribute("cust",cust);
				    	response.sendRedirect("EditCustomer.jsp");
				    }
				    else
				    {
				    	response.sendRedirect("Error.jsp");
				    }
				}
		
				else if(action!=null && action.equalsIgnoreCase("delete"))
				{
					int customerid =Integer.parseInt(request.getParameter("customerid"));
				    cust=cdimp.getCustomerById(customerid);
				    if(cust!=null)
				    {
				    	boolean b=cdimp.deleteCustomer(customerid);
				    	if(b==true)
				    	{
				    		//response.sendRedirect("SuccessAdd.jsp");
				    		response.sendRedirect("CommonCustomerServlet");
				    	}
				    }
				    else
				    {
				    	response.sendRedirect("Error.jsp");
				    }
				}
				else
				{
					List<Customer> customerlist=cdimp.getAllCustomer();
					
					if(customerlist!=null)
					{
						session.setAttribute("customerlist",customerlist);
						response.sendRedirect("CustomerList.jsp");
					}
					
					else
					{
						response.sendRedirect("Error.jsp");
					}
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Customer f=new Customer();
		CustomerDaoImp cdimp=new CustomerDaoImp();
		String action=request.getParameter("action");
		if(action!=null && action.equalsIgnoreCase("AddCustomer"))
		{
		  
		   String customername=request.getParameter("customername");
		   String customeraddress=request.getParameter("customeraddress");
		   Long contact=Long.parseLong(request.getParameter("contact"));
		   String customerusername=request.getParameter("uname");
		   String customerpassword=request.getParameter("password");
		   f.setCustomerName(customername);
		   f.setCustomerAddress(customeraddress);
		   f.setContact(contact);
		   f.setCustomerUserName(customerusername);
		   f.setCustomerPassword(customerpassword);
		   boolean b=cdimp.addCustomer(f);
		   if(b==true)
		   {
			   response.sendRedirect("SuccessAdd.jsp");
		   }
		   else
		   {
			   response.sendRedirect("Error.jsp");
		   }  
		}
		   else if(action!=null && action.equalsIgnoreCase("UpdateCustomer"))
			{
			   int customerid =Integer.parseInt(request.getParameter("customerid"));
			   String customername=request.getParameter("customername");
			   String customeraddress=request.getParameter("customeraddress");
			   Long contact=Long.parseLong(request.getParameter("contact"));
			   String customerusername=request.getParameter("uname");
			   String customerpassword=request.getParameter("password");
			   f.setCustomerId(customerid);
			   f.setCustomerName(customername);
			   f.setCustomerAddress(customeraddress);
			   f.setContact(contact);
			   f.setCustomerUserName(customerusername);
			   f.setCustomerPassword(customerpassword);
			   boolean b=cdimp.updateCustomer(f);
			   if(b==true)
			   {
				   response.sendRedirect("CommonCustomerServlet");
			   }
			   else
			   {
				   response.sendRedirect("Error.jsp");
			   }  
			}
		  
		
	}

}
