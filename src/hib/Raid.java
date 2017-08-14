package hib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import test.Cart;
import test.CartItem;
import test.Item;

public class Raid {
	
	public static Cart Fetch(String n,String p)
	{
		Cart cart=new Cart();
		ArrayList al=new ArrayList<>();
		
     
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abhishek");
		    
			PreparedStatement tm=con.prepareStatement("select * from Record17 where na=? and pa=?");
			tm.setString(1, n);
			tm.setString(2, p);
			ResultSet rt=tm.executeQuery();
			while(rt.next())
			{
				Item item=new Item();
				item.setId(rt.getInt(5));
				item.setName(rt.getString(6));
				item.setImagePath(rt.getString(7));
				item.setDescription(rt.getString(8));
				item.setPrice(rt.getInt(9));
				
				CartItem ci=new CartItem();
				ci.setCartItemId(rt.getString(3));
				ci.setQuantity(rt.getInt(4));
				ci.setItem(item);
				
				al.add(ci);
				
			}
			rt.close();
			tm.close();
			con.close();
			cart.setCartItems(al);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error in fetching ");
		
		}
		return cart;
		
		
	}

}
