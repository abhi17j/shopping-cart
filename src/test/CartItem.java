package test;

public class CartItem {
	
	private String cartItemId;
	private Item item;
	private int quantity;
	
	public CartItem()
	{}
	
	public CartItem(final String cartItemId, final Item item,final int quantity)
	{
		this.cartItemId=cartItemId;
		this.item=item;
		this.quantity=quantity;
	}

	public String getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public boolean equals(Object o)
	{
		return ((CartItem)o).cartItemId.equals(cartItemId);
	}

}
