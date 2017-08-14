package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Final extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String a=request.getParameter("action");
		
		if(a.equals("Update Cart"))
		{
			HttpSession ht=request.getSession();
			String n=(String) ht.getAttribute("name");
			
			if (n==null) 
			{
				out.println("invalid access");
				out.println("<br></br>");
				out.println("<a href='Front.html'>go to homepage");
			}	
			
			else {
				
				Cart cart=(Cart) ht.getAttribute("cart");
				ArrayList a1=cart.getCartItems();
				
				
				try{
				int p=a1.size();
				out.println(p);
		
				for(int o=0;o<a1.size();o++)
				{
					CartItem cp=(CartItem) a1.get(o);
					String cr=request.getParameter("p"+cp.getItem().getId());
					if(cr!=null)
					{
						a1.remove(cp);
						o--;
					
				    }
				
				 }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				if(a1.isEmpty())
				{
					cart.setCartItems(a1);
					out.println("no item in cart");
					out.println("<br></br>");
					out.println("<a href='Cataloq.jsp'>go to shopping");
				}
				else {
					 cart.setCartItems(a1);
					RequestDispatcher rq=request.getRequestDispatcher("DisplayCart.jsp");
					   rq.forward(request, response);
					
				     }
				   
				
			}

			
			
		}
		else if (a.equals("shop more"))
		{
			HttpSession ht=request.getSession();
			String n=(String) ht.getAttribute("name");
			
			if (n==null) 
			{
				out.println("invalid access");
				out.println("<br></br>");
				out.println("<a href='Front.html'>go to homepage");
			}	
			else {
				
				RequestDispatcher rq=request.getRequestDispatcher("Cataloq.jsp");
			   rq.forward(request, response);
				
			}
		   
		}
		else if (a.equals("freeze cart"))
		{
			HttpSession ht=request.getSession();
			String n=(String) ht.getAttribute("name");
			
			if (n==null) 
			{
				out.println("invalid access");
				out.println("<br></br>");
				out.println("<a href='Front.html'>go to homepage");
			}
			else {
				out.println("your cart has been freezed");
				out.println("<br></br>");
				out.println("<a href='log'>Logout");
			}
			 
			
		}
	}

	}
