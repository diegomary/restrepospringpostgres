package ml.shoppingcart;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import ml.interfaces.IShoppingCart;

public class ShoppingCart implements IShoppingCart {	
	
	public List<CartItem> items;	
	public Date creationDate;	
	
	public ShoppingCart(){
		
		 this.items = new ArrayList<CartItem>();
	     this.creationDate = new Date(); 
	     IShoppingCart.super.PrintSignature();
		
	}
	
	public Date getDate() { return this.creationDate; }

	@Override
	public String AddItem(CartItem item) {	 
		 
		 for(CartItem cp: items){
			  if(cp.getProduct().getSku() == item.getProduct().getSku()){				 
				 cp.setQuantity(cp.getQuantity()+1);
				 return item.getProduct().getSku();				  
			  }
		 }			  
			
		this.items.add(item);
	    return item.getProduct().getSku();
	
	}

	@Override
	public String RemoveItem(CartItem item) {

		if ( this.items.size() == 0 ) return "Empty";
		this.items = this.items.stream()                
		           .filter(i -> !item.getProduct().getSku().equals(i.getProduct().getSku()))     
		           .collect(Collectors.toCollection(ArrayList::new));  
		   
		return item.getProduct().getSku();
	}
	

	@Override
	public boolean SetItemQuantity(String sku, int newQuantity) {
		
		for(CartItem cp: items){
			  if(cp.getProduct().getSku() == sku){				 
				 cp.setQuantity(newQuantity);
				 return true;				  
			  }
		 }		
					
	    return false;		
	}
	

	@Override
	public boolean IncreaseQuantityByOne(String sku) {
		for(CartItem cp: items){
			  if(cp.getProduct().getSku() == sku){				 
				 cp.setQuantity(cp.getQuantity()+1);
				 return true;				  
			  }
		 }			  
		return false;
	}

	@Override
	public boolean DecreaseQuantityByOne(String sku) {
		
		
		for(CartItem cp: items){
			  if(cp.getProduct().getSku() == sku){				 
				 cp.setQuantity(cp.getQuantity()-1);
			  }
		 }			  
		
		this.items.removeIf(ci -> (ci.getQuantity()==0));
		return true;        
	}

	@Override
	public double GetSubTotal() {
		double subTotal = 0;
	    for (CartItem cp: items) { subTotal += cp.getTotalPrice(); }
	    return subTotal;
	}

	@Override
	public void EmptyCart() {
		
		items = new ArrayList<CartItem>();		
		
	}

}
