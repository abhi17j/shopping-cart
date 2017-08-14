package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

public class FetchItemServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		
		
		ItemDao dao=new ItemDao();
		
			ArrayList<Item> a1=dao.getAllItems();
			HttpSession ht=req.getSession();
			ht.setAttribute("a1", a1);
			
		    req.getRequestDispatcher("Cataloq.jsp").forward(req, res);
		
		
		
		
	}

}
