package ml;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.Date;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ml.checkout.Product;
import ml.shoppingcart.CartItem;
import ml.shoppingcart.ShoppingCart;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartTests {

	@Test
	public void contextLoads() {}
	
	@Test
	// When the shopping cart is empty adding 2 items of the same product should result in a shopping cart with only 1 item
	// and a quantity equals to 2
	public void Sc2i (){
		// Given
		ShoppingCart sc = new ShoppingCart();
		CartItem ci = new CartItem();		
		ci.setQuantity(1);		
		ci.setProduct(new Product("skuabc",1300.40 , false, 5 , 4000));
		// When
		sc.AddItem(ci);
		sc.AddItem(ci);	
		assertEquals(sc.items.size(),1);		
		assertEquals(sc.items.get(0).getQuantity(),2);
	}
	
	@Test
	// When the shopping cart is not empty adding 2 items of the same product should result in a shopping cart with only 1 item
	// added and a quantity for that item equals to 2
	public void Sc2iN (){
		// Given
		ShoppingCart sc = new ShoppingCart();
		CartItem ci = new CartItem();		
		ci.setQuantity(1);		
		ci.setProduct(new Product("skuabc",1300.40 , false, 5 , 4000));
		CartItem ci1 = new CartItem();		
		ci1.setQuantity(1);		
		ci1.setProduct(new Product("skucde",2000.40 , false, 3 , 3000));
		sc.AddItem(ci);
		sc.AddItem(ci1);		
		CartItem cinew = new CartItem();		
		cinew.setQuantity(1);		
		cinew.setProduct(new Product("skuefg",123.40 , false, 9 , 1200));		
		// When
		sc.AddItem(cinew);
		sc.AddItem(cinew);	
		assertEquals(sc.items.size(),3);		
		assertEquals(sc.items.get(2).getQuantity(),2);
	}
	
	
	
	@Test
	// When the shopping cart is not empty removing one item should result in a shopping cart with a size reduced of 1
	public void Sc2iR (){
		// Given
		ShoppingCart sc = new ShoppingCart();
		CartItem ci = new CartItem();		
		ci.setQuantity(1);		
		ci.setProduct(new Product("skuabc",1300.40 , false, 5 , 4000));
		CartItem ci1 = new CartItem();		
		ci1.setQuantity(1);		
		ci1.setProduct(new Product("skucde",2000.40 , false, 3 , 3000));
		sc.AddItem(ci);
		sc.AddItem(ci1);
		int sizeBefore = sc.items.size();
		// When
		sc.RemoveItem(ci1);
		int sizeAfter = sc.items.size();
		assertThat(sizeAfter, is(sizeBefore-1)); 		
	
	}
	
	@Test
	//When the shopping cart has an item whose quantity is modified the quantity should be equal to the new value	
	public void ScSQ (){
		// Given
		ShoppingCart sc = new ShoppingCart();
		CartItem ci = new CartItem();		
		ci.setQuantity(1);		
		ci.setProduct(new Product("skuabc",1300.40 , false, 5 , 4000));
		// When
		sc.AddItem(ci);
		sc.SetItemQuantity("skuabc", 10);			
		assertEquals(sc.items.get(0).getQuantity(),10);
	}
	
	
	@Test
	//When the shopping cart is not empty there must be a method called GrandTotal that gives the total amount of purchase.	
	public void Sc_GT (){
		
		// Given a shopping cart with 3 items
		ShoppingCart sc = new ShoppingCart();
		CartItem ci = new CartItem();		
		ci.setQuantity(1);		
		ci.setProduct(new Product("skuabc",1300.40 , false, 5 , 4000));		
		CartItem ci1 = new CartItem();		
		ci1.setQuantity(1);		
		ci1.setProduct(new Product("skucde",2000.40 , false, 3 , 3000));		
		CartItem cinew = new CartItem();		
		cinew.setQuantity(1);		
		cinew.setProduct(new Product("skuefg",123.40 , false, 9 , 1200));
		sc.AddItem(ci);
		sc.AddItem(ci1);
		sc.AddItem(cinew);		
		// We modify the quantity of one of the Items
		sc.SetItemQuantity("skuabc", 10);		
		// When
		double subTotal = sc.GetSubTotal();
		assertEquals(null,subTotal,15127.8,0);		
		
	}	
	
	@Test
	//When the shopping cart is not empty calling the method Empty Cart will result in a shopping cart whose creation date is preserved,
	//but the number of items is equal to 0.	
	public void Sc_Ept (){
		
		// Given a shopping cart with 3 items
		ShoppingCart sc = new ShoppingCart();
		CartItem ci = new CartItem();		
		ci.setQuantity(1);		
		ci.setProduct(new Product("skuabc",1300.40 , false, 5 , 4000));		
		CartItem ci1 = new CartItem();		
		ci1.setQuantity(1);		
		ci1.setProduct(new Product("skucde",2000.40 , false, 3 , 3000));		
		CartItem cinew = new CartItem();		
		cinew.setQuantity(1);		
		cinew.setProduct(new Product("skuefg",123.40 , false, 9 , 1200));
		sc.AddItem(ci);
		sc.AddItem(ci1);
		sc.AddItem(cinew);		
		Date creationDate = sc.getDate();
		//When
		sc.EmptyCart();
		assertEquals(sc.items.size(),0);
		assertEquals(sc.getDate(), creationDate);
		
		
	}	
	
	@Test
	//When the shopping cart is not empty calling the method IncreaseQuantityByOne on an item will increment its quantity of one.	
	public void Sc_inc1 (){			
		ShoppingCart sc = new ShoppingCart();
		CartItem ci = new CartItem();		
		ci.setQuantity(1);		
		ci.setProduct(new Product("skuabc",1300.40 , false, 5 , 4000));		
		sc.AddItem(ci);
		int beforeQuantity = sc.items.get(0).getQuantity();
		//When
		sc.IncreaseQuantityByOne("skuabc");
		assertEquals(sc.items.get(0).getQuantity(), beforeQuantity+1);			
	}	
	
	@Test
	//When the shopping cart has an item with quantity equal to one and the method DecreaseQuantityByOne is called
	// the shopping cart should result empty.	
	public void Sc_dec1 (){			
		ShoppingCart sc = new ShoppingCart();
		CartItem ci = new CartItem();		
		ci.setQuantity(1);		
		ci.setProduct(new Product("skuabc",1300.40 , false, 5 , 4000));		
		sc.AddItem(ci);
		
		//When
		sc.DecreaseQuantityByOne("skuabc");
		assertEquals(sc.items.size(), 0);			
	}	
	
	@Test
	//When the shopping cart has two items and one has a quantity equal to one, applying the method DecreaseQuantityByOne to the latter
	//will result in a shopping cart with only one item.
	public void Sc_dec12 (){			
		ShoppingCart sc = new ShoppingCart();
		CartItem ci = new CartItem();		
		ci.setQuantity(1);		
		ci.setProduct(new Product("skuabc",1300.40 , false, 5 , 4000));		
		CartItem ci1 = new CartItem();		
		ci1.setQuantity(1);		
		ci1.setProduct(new Product("skucde",2000.40 , false, 3 , 3000));		
		sc.AddItem(ci);
		sc.AddItem(ci1);		
		//When
		sc.DecreaseQuantityByOne("skuabc");
		assertEquals(sc.items.size(), 1);			
	}	


}

