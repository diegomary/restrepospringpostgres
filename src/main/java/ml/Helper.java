package ml;

import ml.interfaces.IShoppingCart;


public class Helper {
	
	private IShoppingCart sc;
	
	public Helper(IShoppingCart _sc) {		
		
		 sc = _sc;
		 System.out.println(sc.getDate());
		
	}

}
