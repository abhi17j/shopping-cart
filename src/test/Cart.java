package test;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Cart {
	
	private ArrayList cartItems;
	
	public Cart()
	{
		cartItems=new ArrayList<>(); 
	}
	public void addCartItems(final CartItem cartItem)
	{
		if(cartItems.contains(cartItem))
		{
			int index=cartItems.indexOf(cartItem);
			CartItem thisItem=(CartItem) cartItems.get(index);
			thisItem.setQuantity(thisItem.getQuantity()+1);
		}
		else
		{
			cartItems.add(cartItem);
		}
	}
	public void removeCartItem(final CartItem cartItem)
	{
		cartItems.remove(cartItem);
	}
	public void setCartItems(final ArrayList cartItems)
	{
		this.cartItems=cartItems;
	}
	public ArrayList getCartItems()
	{
		return cartItems;
	}
	
	public double getCartvaValue()
	{
		double value=0;
		java.util.Iterator itr=cartItems.iterator();
		
		while(itr.hasNext())
		{
			CartItem cartitem=(CartItem) itr.next();
			value=value+(cartitem.getItem().getPrice()*cartitem.getQuantity());
			
		}
			return value;	
	}

}









