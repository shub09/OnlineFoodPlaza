package com.foodplazashubham.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import com.foodplazashubham.dao.*;
import com.foodplazashubham.pojo.*;
/**
 * Servlet implementation class CommonFeedbackServlet
 */
@WebServlet("/CommonFeedbackServlet")
public class CommonFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonFeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		List<Feedback> feedbacklist = new ArrayList<Feedback>();
		CustomerDaoImp cdao= new CustomerDaoImp();
			feedbacklist=cdao.showFeedback();
			session.setAttribute("feedbacklist", feedbacklist);
			response.sendRedirect("FeedbackList.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		CustomerDaoImp cdao= new CustomerDaoImp();
		String action= request.getParameter("action");
		List<Feedback> feedbacklist = new ArrayList<Feedback>();
		
		if(action!=null && action.equalsIgnoreCase("addFeedback"))
		{
			Feedback fb = new Feedback();
			String fbname = request.getParameter("fbname");
			String fbemailid=request.getParameter("fbemailid");
			String fbcontactno=request.getParameter("fbcontactno");
			String message=request.getParameter("message");
			
			fb.setFbname(fbname);
			fb.setFbemailid(fbemailid);
			fb.setFbcontactno(fbcontactno);
			fb.setMessage(message);
			
			boolean flag=cdao.addFeedback(fb);
			if(flag==true)
			{
				/*request.setAttribute("FeedBackSuccess", "true");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);*/
				response.sendRedirect("SuccessAdd.jsp");
			}
			else
			{
				/*request.setAttribute("FeedBackError", false);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);*/
				response.sendRedirect("Error.jsp");
			}
		}
		
	}

}
