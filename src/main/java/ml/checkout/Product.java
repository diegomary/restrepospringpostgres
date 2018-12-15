package ml.checkout;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "Products")
public class Product {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private  String  sku;
	@Size(min = 3, max = 20)
	private String name;
    private  double unitPrice;   
    private  boolean  isOnOffer;
    private  int quantityOnOffer;
    private  double offerPrice;
    
    @ManyToOne 
    private Category category;   
    
    public Product() {};
   
    
    public Product(String sku,String name, double  unitPrice , boolean isOnOffer, int  quantityOnOffer , double offerPrice){
        this.sku = sku;
        this.name = name;
        this.unitPrice = unitPrice;       
        this.isOnOffer = isOnOffer;
        this.quantityOnOffer = quantityOnOffer;
        this.offerPrice = offerPrice;
    }         
     
    public String getSku() {
        return this.sku;
    } 
    public void setSku(String sku) {
        this.sku=sku;
    } 
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name=name;
    }
    
    public double getUnitPrice() {
        return this.unitPrice;
    }
    
    public void setUnitPrice( double unitprice) {
         this.unitPrice= unitprice;
    }
    
    public boolean getIsOnOffer() {
        return this.isOnOffer;
    }
    
    public void setIsOnOffer(boolean isonoffer) {
        this.isOnOffer = isonoffer;
    }    
    
    public int getQuantityOnOffer() {
        return this.quantityOnOffer;
    }
    
    public void setQuantityOnOffer(int qonoffer) {
        this.quantityOnOffer = qonoffer;
    }    
    
     public double getOfferPrice() {
        return this.offerPrice;
    }     
     
    public void setOfferPrice(double  offerprice) {
         this.offerPrice = offerprice;
    }
    
    
}

