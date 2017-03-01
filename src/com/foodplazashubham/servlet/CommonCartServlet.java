package com.foodplazashubham.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodplazashubham.dao.CartDaoImp;
import com.foodplazashubham.dao.FoodOrderDaoImp;
import com.foodplazashubham.pojo.Cart;


/**
 * Servlet implementation class CommonCartServlet
 */
@WebServlet("/CommonCartServlet")
public class CommonCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		
		HttpSession session=request.getSession();
		String action= request.getParameter("action");
		String customerusername = (String)session.getAttribute("customer");
		CartDaoImp cdimp=new CartDaoImp();
		Cart c=new Cart();
		
		if(action!=null && action.equalsIgnoreCase("addtocart"))
		{
			int fid=Integer.parseInt(request.getParameter("foodId"));
			int fqty=Integer.parseInt(request.getParameter("foodQuantity"));
			
			c.setFoodId(fid);
			c.setFoodQuantity(fqty);
			c.setCustomerUserName(customerusername);
			boolean b=cdimp.addToCart(c);
			
			if(b==true)
			{
				response.sendRedirect("CommonFoodServlet");
			}
			else
			{
				response.sendRedirect("Error.jsp");
			}
		}
		else if(action!=null && action.equalsIgnoreCase("delete"))
		{
			int cartid =Integer.parseInt(request.getParameter("cartid"));
		    	boolean b=cdimp.deleteCart(cartid,customerusername);
		    	if(b==true)
		    	{
		    		//response.sendRedirect("SuccessAdd.jsp");
		    		response.sendRedirect("CommonCartServlet");
		    	}		   
		       else
		       {
		    	response.sendRedirect("Error.jsp");
		       }
		}
		else
		{
			
			List<Cart> cartlist=cdimp.listCart(customerusername);
			System.out.println(cartlist);
			if(cartlist!=null)
			{
				session.setAttribute("cartlist",cartlist);
				response.sendRedirect("CartList.jsp");
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
		HttpSession session=request.getSession();
		String action= request.getParameter("action");
		String customerusername = (String)session.getAttribute("customer");
		FoodOrderDaoImp fdimp=new FoodOrderDaoImp();
		CartDaoImp cdimp=new CartDaoImp();
		if(action!=null && action.equalsIgnoreCase("placeorder"))
		{
			
			String foodprice[]=request.getParameterValues("foodprice");
			String quantity[]=request.getParameterValues("quantity");
			double totalbill=0;
			for(int i=0; i<foodprice.length; i++)
			{
				totalbill = totalbill+(Double.parseDouble(foodprice[i]))*(Integer.parseInt(quantity[i]));
			}
			int orderid=fdimp.placeOrder(customerusername,totalbill);
			
			if(orderid>0)
			{
				boolean b=cdimp.clearCart(customerusername);
				if(b==true)
				{
					request.setAttribute("placeordersuccess", "Order placed successfully. Your order id is "+orderid+" and your total bill is "+totalbill);
					RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
					rd.forward(request, response);
					
				}
				else
				{
					request.setAttribute("placeorder",false);
					RequestDispatcher rd= request.getRequestDispatcher("/Index.jsp");
					rd.forward(request, response);
					
				}
			}
			else
			{
				request.setAttribute("placeorder",false);
				RequestDispatcher rd= request.getRequestDispatcher("/Index.jsp");
				rd.forward(request, response);
				
			}
		}
	}

}
