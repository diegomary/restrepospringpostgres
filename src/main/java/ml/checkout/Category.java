package ml.checkout;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	public Category() {};
	private String categoryName;
	private String categoryDescription;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
	@JoinColumn(name = "category_id")
	List<Product> products;

	 public String getCategoryName() {
	        return this.categoryName;
	    } 
	    public void setCategoryName(String categoryName) {
	        this.categoryName = categoryName;
	    } 
	    public String getCategoryDescription() {
	        return this.categoryDescription;
	    }
	    
	    public void setCategoryDescription(String categoryDescription) {
	        this.categoryDescription = categoryDescription;
	    }
	    
	    public List<Product>  getProducts() {
	        return this.products;
	    }
	    
	    public void setProducts(List<Product>  products) {
	        this.products = products;
	    }	
	

}
