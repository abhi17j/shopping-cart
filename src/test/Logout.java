package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import hib.Store;


public class Logout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession ht=request.getSession();
		Cart cart=(Cart) ht.getAttribute("cart");
		
		String name=(String) ht.getAttribute("name");
		String p=(String) ht.getAttribute("pass");
		
		
		
		int i=Store.Insert(cart,name,p);
		if(i!=5)
		{
			ht.invalidate();
			out.println("you are logged out");
			out.println("<br></br>");
			out.println("<a href='Front.html'>go to Home Page");
			
			
			
		}
	}

}
