package ml;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import ml.checkout.Product;
import ml.repository.ProductRestRepository;


// these 2 annotations below allow to use instantiated beans as defined in the Spring context 
// and use prperly the destined configuration files.
@RunWith(SpringRunner.class)
@SpringBootTest

public class RepositoryTests {
	
	private List<Product> lp;
	
	@Autowired
    private ProductRestRepository productRepo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {	
		
		lp = new ArrayList<Product>();
		lp.add(new Product("skuabc","Super Laptop",1300.40 , false, 5 , 4000));
		lp.add(new Product("skucde","Iphone 10 x",2000.40 , false, 3 , 3000));
		lp.add(new Product("skuefg","Micro Usb device",123.40 , false, 9 , 1200));
		lp.add(new Product("skuhij","Microsoft surface",1235.40 , false, 93 , 12400));
	}

	@After
	public void tearDown() throws Exception {	
		
	}

	@Test
	// Given 4 different product saved in the db the count of products should be 4.
	public void A() {
		
		productRepo.deleteAll();		
		Product prA = new Product("A","Laptop", 0.5 ,true, 3, 1.30);		
		productRepo.save(prA);		
	    Product prB = new Product("B","Phone",0.30,true,2,0.45);
	    productRepo.save(prB);	    
	    Product prC = new Product("C","Kitchen",2.0,false,1,2.0);
	    productRepo.save(prC);	    
	    Product prD = new Product("D","Book",0.75,false,1,0.75);
	    productRepo.save(prD);		
		assertEquals(productRepo.count(), 4);		
		
	}
	
	
	@Test
	// Given a list of 4 product saving it using saveAll must give a total number of products present in the db = to 4
		public void B() {
		productRepo.deleteAll();
		productRepo.saveAll(lp);
		assertEquals(productRepo.count(), 4);		
		
	}
	
	
	
	

}
