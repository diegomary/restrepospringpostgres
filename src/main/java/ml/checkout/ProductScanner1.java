package ml.checkout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductScanner1 {
    
    public double totalPrice;
    private final List<Product> flowOfProductsInSession; 
    // Here for semplicity I am dependency injecting a simple list but in a real environment
    // we can inject an object that implements a specific interface/contract to render pure the concept of DI.
    public ProductScanner1( List<Product> FlowOfProductsInSession ){ flowOfProductsInSession = FlowOfProductsInSession; };
    
    public double GrandTotal(){        
        List<String> productOccurrences = new ArrayList<String>();             
        flowOfProductsInSession.forEach( pr -> { productOccurrences.add(pr.getSku());});        
        Set<String> uniqueSkus = new HashSet<>(productOccurrences); 
       
        uniqueSkus.forEach((usku) -> {
            
            int singleProductOccurrency = Collections.frequency(productOccurrences, usku);     
            Product candidateProduct = flowOfProductsInSession.stream().filter(pr -> usku.equals(pr.getSku())).findAny().orElse(null);
            if(candidateProduct.getIsOnOffer()) {
                
                int offerQuantity = candidateProduct.getQuantityOnOffer();                
                int totalOfferQuantities = Math.round(singleProductOccurrency/offerQuantity);                
                int rem = singleProductOccurrency % offerQuantity;                
                this.totalPrice += ((candidateProduct.getOfferPrice() * totalOfferQuantities) + (candidateProduct.getUnitPrice() * rem));
                return;
            }          
                double productPrice = candidateProduct.getUnitPrice(); 
                double totalPriceForProduct = productPrice * singleProductOccurrency;
                this.totalPrice += totalPriceForProduct;
           
        });
        
       return this.totalPrice;  
    }
    
}

