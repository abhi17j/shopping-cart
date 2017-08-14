package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDao {
	
	
	public ItemDao()
	{}
	public ArrayList<Item> getAllItems()
	{
		
		ArrayList<Item> a1=new ArrayList<Item>();
		

		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abhishek");
		 Statement stmt=con.createStatement();
		 ResultSet rs=stmt.executeQuery("select * from Entry");
		 while(rs.next())
		 {
			 Item item=new Item();
			 item.setId(rs.getInt(1));
			 item.setName(rs.getString(2));
			 item.setImagePath(rs.getString(3));
			 item.setDescription(rs.getString(4));
			 item.setPrice(rs.getInt(5));
			 a1.add(item);
			 }
		}
		catch(Exception e)
		{
			System.out.println("error in connection1");
		}
	
			return a1;
	}
	
	public Item getItem(final int itemId) throws ClassNotFoundException,SQLException
	{
		Item item=new Item();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abhishek");
		
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from Entry where id="+itemId);
		if(rs.next())
		{
			item.setId(rs.getInt(1));
			item.setName(rs.getString(2));
			item.setImagePath(rs.getString(3));
			item.setDescription(rs.getString(4));
			item.setPrice(rs.getInt(5));
		}
		rs.close();
		stmt.close();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println("error in connection 2");
		}
		return item;
	}
	
	public int getItemCount()throws ClassNotFoundException,SQLException
	{
		int itemCount=0;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abhishek");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select count(*) from Entry");
		rs.next();
		 itemCount=rs.getInt(1);
		rs.close();
		stmt.close();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println("Error in connection 3");
		}
		
		return itemCount;
	}
}
