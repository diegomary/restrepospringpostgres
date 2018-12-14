package ml.interfaces;


import java.util.Date;

import ml.shoppingcart.CartItem;

public interface IShoppingCart {
	
	public final String title = "Dm Shopping Cart";
	public String AddItem(CartItem product);
	public String RemoveItem(CartItem product);
	public Date getDate();
	public boolean SetItemQuantity(String sku, int newQuantity);
	public boolean IncreaseQuantityByOne(String sku);
	public boolean DecreaseQuantityByOne(String sku);
	public double GetSubTotal();
	public void EmptyCart();
	public default void PrintSignature() { System.out.println("This is "  + title); }

}
