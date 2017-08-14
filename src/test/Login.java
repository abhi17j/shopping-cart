package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hib.Raid;


public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String n=req.getParameter("em");
		String p=req.getParameter("ps");
		
		
		if(check.Validate(n,p))
		{
			Cart cart=Raid.Fetch(n,p);
			if(cart==null)
			{
				 cart=new Cart();
			}

			HttpSession session=req.getSession();
			session.setAttribute("name", n);
			session.setAttribute("pass", p);
		
			session.setAttribute("cart", cart);
			
			RequestDispatcher rd=req.getRequestDispatcher("Welcome.html");
			rd.forward(req, res);
			
		}
		else
		{
			out.println("sorry.. wrong Username or Password");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, res);
		}
		out.close();
		
		
	}

}

