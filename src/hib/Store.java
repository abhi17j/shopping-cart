package hib;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import test.Cart;
import test.CartItem;
import test.Item;

public class Store {
	
	public static int Insert(Cart cart,String n,String p)
	{
		
		
		
		int i=0;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abhishek");
		    
	     PreparedStatement pp=con.prepareStatement("delete from Record17 where na=? and pa=?");
	       pp.setString(1,n );
	       pp.setString(2, p);
	       pp.executeUpdate();
	       pp.close();
		
			ArrayList al=cart.getCartItems();
			
			
			Iterator itr=al.iterator();
			while(itr.hasNext())
			{
				CartItem cartItem=(CartItem) itr.next();
				
				
				PreparedStatement pt=con.prepareStatement("insert"
						+ " into Record17 values(?,?,?,?,?,?,?,?,?)");
				pt.setString(1, n);
				
				pt.setString(2, p);
				pt.setString(3, cartItem.getCartItemId());
				pt.setInt(4, cartItem.getQuantity());
				
				Item it=cartItem.getItem();
				pt.setInt(5, it.getId());
				pt.setString(6,it.getName());
				pt.setString(7, it.getImagePath());
				pt.setString(8, it.getDescription());
				int pr=25;
				// pr=(int) it.getPrice();
				pt.setInt(9, pr);
				
				int t=pt.executeUpdate();
				if(t==0)
				{
					 i=5;
				}
		
			}
			
			con.close();
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("error in storing cart");
           
		}
		
		return i;
	}

}






