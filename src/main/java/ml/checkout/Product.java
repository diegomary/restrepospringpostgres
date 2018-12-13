package ml.checkout;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "Products")
public class Product {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private  String  sku;
	private String name;
    private  double unitPrice;   
    private  boolean  isOnOffer;
    private  int quantityOnOffer;
    private  double offerPrice;  
    
    public Product() {};
   
    
    public Product(String _sku, double  _unitPrice , boolean _isOnOffer, int  _quantityOnOffer , double _offerPrice){
        this.sku = _sku;
        this.unitPrice = _unitPrice;       
        this.isOnOffer = _isOnOffer;
        this.quantityOnOffer = _quantityOnOffer;
        this.offerPrice = _offerPrice;
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

