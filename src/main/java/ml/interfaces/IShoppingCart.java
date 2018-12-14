package ml.interfaces;


import ml.shoppingcart.CartItem;

public interface IShoppingCart {
	
	public final String title = "Dm Shopping Cart";
	public String AddItem(CartItem product);
	public String RemoveItem(CartItem product);
	public boolean SetItemQuantity(String sku, int newQuantity);
	public boolean IncreaseQuantityByOne(String sku);
	public boolean DecreaseQuantityByOne(String sku);
	public double GetSubTotal();
	public void EmptyCart();
	public static String PrintSignature() { return "This is "  + title;	}

}
