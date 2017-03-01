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
//import com.foodplazashubham.utility.*;

/**
 * Servlet implementation class CommonFoodServlet
 */
@WebServlet("/CommonFoodServlet")
public class CommonFoodServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CommonFoodServlet()
    {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		HttpSession session=request.getSession();
	    Food food=new Food();
		FoodDaoImp fdimp=new FoodDaoImp();
		String action=request.getParameter("action");
				if(action!=null && action.equalsIgnoreCase("edit"))
				{
					int foodid =Integer.parseInt(request.getParameter("foodId"));
				    food=fdimp.getFoodById(foodid);
				    if(food!=null)
				    {
				    	session.setAttribute("food",food);
				    	response.sendRedirect("EditFood.jsp");
				    }
				    else
				    {
				    	response.sendRedirect("Error.jsp");
				    }
				}
		            
				else if(action!=null && action.equalsIgnoreCase("delete"))
				{
					int foodid =Integer.parseInt(request.getParameter("foodId"));
				    food=fdimp.getFoodById(foodid);
				    if(food!=null)
				    {
				    	boolean b=fdimp.deleteFood(foodid);
				    	if(b==true)
				    	{
				    		//response.sendRedirect("SuccessAdd.jsp");
				    		response.sendRedirect("CommonFoodServlet");
				    	}
				    }
				    else
				    {
				    	response.sendRedirect("Error.jsp");
				    }
				}
		
		
				else
				{
					List<Food> foodlist=fdimp.displayAllFood();
					
					if(foodlist!=null)
					{
						session.setAttribute("foodlist",foodlist);
						response.sendRedirect("FoodList.jsp");
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
		Food f=new Food();
		FoodDaoImp fdimp=new FoodDaoImp();
		String action=request.getParameter("action");
		if(action!=null && action.equalsIgnoreCase("AddFood"))
		{
		   int foodid =Integer.parseInt(request.getParameter("foodid"));
		   String foodname=request.getParameter("foodname");
		   double foodprice=Double.parseDouble(request.getParameter("foodprice"));
		   String foodtype=request.getParameter("type");
		   f.setFoodId(foodid);
		   f.setFoodName(foodname);
		   f.setFoodPrice(foodprice);
		   f.setFoodType(foodtype);
		   boolean b=fdimp.addFood(f);
		   if(b==true)
		   {
			   response.sendRedirect("SuccessAdd.jsp");
		   }
		   else
		   {
			   response.sendRedirect("Error.jsp");
		   }  
		}
		
		   else if(action!=null && action.equalsIgnoreCase("UpdateFood"))
			{
			   int foodid =Integer.parseInt(request.getParameter("foodid"));
			   String foodname=request.getParameter("foodname");
			   double foodprice=Double.parseDouble(request.getParameter("foodprice"));
			   String foodtype=request.getParameter("type");
			   f.setFoodId(foodid);
			   f.setFoodName(foodname);
			   f.setFoodPrice(foodprice);
			   f.setFoodType(foodtype);
			   boolean b=fdimp.updateFood(f);
			   if(b==true)
			   {
				   response.sendRedirect("CommonFoodServlet");
			   }
			   else
			   {
				   response.sendRedirect("Error.jsp");
			   }   
			   		   
			}
		   
	}
}
