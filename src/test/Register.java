package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String a=req.getParameter("userName");
		String c=req.getParameter("userPass");
		String b=req.getParameter("userEmail");
		String d=req.getParameter("userCountry");
		
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abhishek");
				
			PreparedStatement ps=con.prepareStatement("insert into Record15 values(?,?,?,?)");
			
			ps.setString(1, a);
			ps.setString(2, b);
			ps.setString(3, c);
			ps.setString(4, d);
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.println("you are successfully registered...you can login");
				RequestDispatcher rd=req.getRequestDispatcher("Front.html");
				rd.include(req, res);
				
			}
			else {
				out.println("Registration failed ");
			}
			
		}
		catch(Exception e7)
		{
			System.out.println(e7);
		}
		
		out.close();
	}

}
