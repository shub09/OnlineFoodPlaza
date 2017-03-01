package com.foodplazashubham.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodplazashubham.dao.AdminDaoImp;
import com.foodplazashubham.dao.CustomerDaoImp;
import com.foodplazashubham.dao.LoginDaoImp;
import com.foodplazashubham.pojo.Customer;

/**
 * Servlet implementation class CommonLoginServlet
 */
@WebServlet("/CommonLoginServlet")
public class CommonLoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonLoginServlet()
    {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{		
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		System.out.println(action);
		if(action!=null && action.equalsIgnoreCase("logout"))
		{
			session.invalidate();
			response.sendRedirect("Index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LoginDaoImp ldimp=new LoginDaoImp();
	
		AdminDaoImp adimp=new AdminDaoImp();
	
		String action=request.getParameter("action");
		
		
		if(action!=null && action.equalsIgnoreCase("login"))
		{
			String type=request.getParameter("type");
		    String username=request.getParameter("username");
		    String password=request.getParameter("password");
			HttpSession session=request.getSession();
		    Cookie c=new Cookie("username",username);
			response.addCookie(c);
			 if(action!=null && type.equalsIgnoreCase("customer"))
		    {
			  boolean b=ldimp.customerLogin(username,password);
			   if (b==true)
			  {
				session.setAttribute("customer",username);
				session.setAttribute("type",type);
				
				response.sendRedirect("Index.jsp");
			  }
			  else
			  {
				
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				request.setAttribute("CustomerLogin","false");
				rd.forward(request,response);
			  }
		   }
		   else if(action!=null && type.equalsIgnoreCase("admin"))
		   {
			   boolean b=ldimp.adminLogin(username,password);
			   if (b==true)
			   {
			    	session.setAttribute("admin",username);
				    session.setAttribute("type",type);
				    String ad=adimp.getAdmin(username);
				    session.setAttribute("ad",ad);
				    response.sendRedirect("Index.jsp");
			   }
			  else
			  {
				
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				request.setAttribute("AdminLogin","false");
				rd.forward(request,response);
			  }
		  }
	   }
		else if(action!=null && action.equalsIgnoreCase("changepassword"))
		{
			HttpSession session=request.getSession();
			String type=(String)session.getAttribute("type");
			
			String username=request.getParameter("username");
		    //String password=request.getParameter("password");
			String newpassword=request.getParameter("newpassword");
			if(type.equalsIgnoreCase("customer"))
			{
				username=(String) session.getAttribute("customer");
				boolean b=ldimp.customerChangePassword(username, newpassword);
				if(b==true)
				{
					response.sendRedirect("Index.jsp");
				}
				else
				{
					response.sendRedirect("Error.jsp");
				}
			}
		    if(type.equalsIgnoreCase("admin"))
		    {
			  username=(String) session.getAttribute("admin");
			  boolean b=ldimp.adminChangePassword(username, newpassword);
			  if(b==true)
			  {
				  response.sendRedirect("Index.jsp");
			  }
			  else
			  {
				response.sendRedirect("Error.jsp");
			  }
		    }
			
		}

	}
}
