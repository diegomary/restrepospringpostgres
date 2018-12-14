package ml;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import ml.checkout.ProductScanner;
import ml.checkout.ProductScanner1;
import ml.interfaces.IShoppingCart;
import ml.shoppingcart.CartItem;
import ml.shoppingcart.ShoppingCart;
import ml.testpurchases.TestPurchase1;
import ml.testpurchases.TestPurchase2;
import ml.testpurchases.TestPurchase3;
import ml.testpurchases.TestPurchase4;
import ml.testpurchases.TestPurchase5;

@SpringBootApplication
public class MlApplication {


	public static void main(String[] args) {
		SpringApplication.run(MlApplication.class, args);
				
	/*	  System.out.println("Solution 1: TEST CASES");
	        
	        //Should return a Grand Total of 5.0 USing Solution 1
	        ProductScanner scanner = new ProductScanner(TestPurchase1.Purchase());
	        System.out.println("Solution 1: Test 1 Grand Total : " + scanner.GrandTotal()); 
	        
	        //Should return a Grand Total of 2.5
	        scanner = new ProductScanner(TestPurchase2.Purchase());
	        System.out.println("Solution 1: Test 2 Grand Total : "+ scanner.GrandTotal());  
	        
	        //Should return a Grand Total of 6.0
	        scanner = new ProductScanner(TestPurchase3.Purchase());
	        System.out.println("Solution 1: Test 2 Grand Total : "+ scanner.GrandTotal());        
	        
	        //Should return a Grand Total of 5.3
	        scanner = new ProductScanner(TestPurchase4.Purchase());
	        System.out.println("Solution 1: Test 2 Grand Total : "+ scanner.GrandTotal());
	        
	         //Should return a Grand Total of 8.0
	        scanner = new ProductScanner(TestPurchase5.Purchase());
	        System.out.println("Solution 1: Test 5 Grand Total : "+ scanner.GrandTotal());       
	        
	        System.out.println("Solution 2: TEST CASES");
	        
	        //Should return a Grand Total of 5.0 USing Solution 1
	        ProductScanner1 scanner1 = new ProductScanner1(TestPurchase1.Purchase());
	        System.out.println("Solution 1: Test 1 Grand Total : " + scanner1.GrandTotal()); 
	        
	        //Should return a Grand Total of 2.5
	        scanner1 = new ProductScanner1(TestPurchase2.Purchase());
	        System.out.println("Solution 1: Test 2 Grand Total : "+ scanner1.GrandTotal());  
	        
	        //Should return a Grand Total of 6.0
	        scanner1 = new ProductScanner1(TestPurchase3.Purchase());
	        System.out.println("Solution 1: Test 3 Grand Total : "+ scanner1.GrandTotal());        
	        
	        //Should return a Grand Total of 5.3
	        scanner1 = new ProductScanner1(TestPurchase4.Purchase());
	        System.out.println("Solution 1: Test 4 Grand Total : "+ scanner1.GrandTotal());
	        
	        //Should return a Grand Total of 8.0
	        scanner1 = new ProductScanner1(TestPurchase5.Purchase());
	        System.out.println("Solution 1: Test 5 Grand Total : "+ scanner1.GrandTotal());
		
		System.out.println(IShoppingCart.PrintSignature());*/
		
		

		Helper hp = new Helper(new ShoppingCart());
		
		
		
		
	}

}

