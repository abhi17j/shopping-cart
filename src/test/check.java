package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class check {
	
	public static boolean Validate(String name,String pass)
	{
		boolean status=false;
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abhishek");
		    
			PreparedStatement ps=con.prepareStatement("select * from Record15 where name=? and pass=?");
			ps.setString(1, name);
			ps.setString(2, pass);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
		}
		catch(Exception e2)
		{
			System.out.println("error in check");
		}
		return status;
	}
	
	/*public static void main(String[] args) {
		
		boolean a=check.Validate("rinkee.m","mishra");
		System.out.println(a);
	}*/

}
