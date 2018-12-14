package ml.restcontrollers;
import java.util.ArrayList;
import java.util.List;

import java.util.Collections;
import java.util.Comparator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.mongodb.DBObject;

import ml.checkout.Category;
import ml.checkout.Product;
import ml.repository.CategoryRestRepository;
import ml.repository.ProductRepository;
import ml.repository.ProductRestRepository;
@RestController
public class ApiAi {	
@Autowired
private HttpServletRequest contextRequest;
@Autowired private MongoTemplate mongoTemplate;
@Autowired private ProductRestRepository prodRepo;
@Autowired private CategoryRestRepository catRepo;
	
	@RequestMapping(value="/first", method=RequestMethod.GET)
	@CrossOrigin(origins = {"*"},methods = { RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.OPTIONS},allowedHeaders= {"content-type","custom-header"})
	public @ResponseBody ArrayList<Product> getjson() 	
	{
		ArrayList<Product> ar = ProductRepository.ProducsAvailable();
		ArrayList<Product> filtered = new ArrayList<Product>();
		for(Product  p: ar){
			  if(p.getUnitPrice() > 0.5){
				  filtered.add(p);
			  }
			}	
		// Sorting
		Collections.sort(filtered, new Comparator<Product>() {
		        @Override
		        public int compare(Product p2, Product p1)
		        {
		          //return  p1.getSku().compareTo(p2.getSku());
		          return Double.compare(p2.getUnitPrice(),p1.getUnitPrice());
		        }
		    });	
		return filtered;	
	} 
	
	@GetMapping("/get")
	@CrossOrigin(origins = {"*"},methods = { RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.OPTIONS},allowedHeaders= {"content-type","custom-header"})
	public String test() 
	{
		 //http://localhost:8080/get?page=20&year=2018
		 String page = contextRequest.getParameter("page");
		 String year = contextRequest.getParameter("year"); 
		 return page + "  " + year;	
			
	}	
		
	@RequestMapping("/api/getsc")
	public @ResponseBody Product Palla(@RequestBody Product product) {	
	
	// The following raw request will serialize to a Product  (Try in postman)
	// {"sku":"dshgfwyewrq","unitPrice":670.0,"isOnOffer":true,"quantityOnOffer":23,"offerPrice":29.0}	
	 return product;		
	}
	
	
	@RequestMapping(value="/getallflower", method=RequestMethod.GET)
	public @ResponseBody List<DBObject>  GetAllFlowers() {	
			
	    return mongoTemplate.findAll(DBObject.class, "BachFlowers");			
	}
	
	
	@RequestMapping(value="/getdata", method=RequestMethod.GET)
	public @ResponseBody Iterable<Product>  testData() {		
		Product p = new Product("sku123", 0.5 ,true, 3, 1.30);
		p.setName("The best product in the world");
		prodRepo.save(p);
		return prodRepo.findAll();
	    	
	}	
	
	@RequestMapping(value="/getdatapaged", method=RequestMethod.GET)
	public @ResponseBody Page<Product>  testData1(Pageable page) {		
		
		return prodRepo.findAll(page);		
		// this is the query
		//http://localhost:8080/getdatapaged?page=1&size=2&sort=sku
	    	
	}
	
	
	@RequestMapping(value="/getdatafull", method=RequestMethod.GET)
	public @ResponseBody Iterable<Product>  testData11() {		
		
		return prodRepo.findAll();		
		
	}
	
	
	
	@RequestMapping(value="/getdatafullcat", method=RequestMethod.GET)
	public @ResponseBody Iterable<Category>  testData112() {		
		
		return catRepo.findAll();		
		
	}
	
	
	
 

}
