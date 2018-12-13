package ml.checkout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductScanner {
    
    public double totalPrice;
    private final List<Product> flowOfProductsInSession; 
    // Here for semplicity I am dependency injecting a simple list but in a real environment
    //we can inject an object that implements a specific interface/contract to render pure the concept of DI.
    // This class adheres to SOLID 1st principle since the sole responsability is to produce the Grand Total given a flow of purchase.
    public ProductScanner( List<Product> FlowOfProductsInSession ){ flowOfProductsInSession = FlowOfProductsInSession; };    
    public double GrandTotal(){ 
        
        List<String> productOccurrences = new ArrayList<String>();              
        flowOfProductsInSession.forEach(pr ->  { productOccurrences.add(pr.getSku()); });
        Set<String> uniqueSkus = new HashSet<>(productOccurrences); 
       
        uniqueSkus.forEach((usku) -> {
            int singleProductOccurrency = Collections.frequency(productOccurrences, usku);     
            Product candidateProduct = flowOfProductsInSession.stream().filter(pr -> usku.equals(pr.getSku())).findAny().orElse(null);
            if(candidateProduct.getIsOnOffer()) {
                
                int offerQuantity = candidateProduct.getQuantityOnOffer();
                double offerPrice = candidateProduct.getOfferPrice();
                double productPrice = candidateProduct.getUnitPrice();
                int totalOfferQuantities = Math.round(singleProductOccurrency/offerQuantity);
                double discountForSingleOffer = ( productPrice * offerQuantity ) - offerPrice;
                double discountForTotal = discountForSingleOffer * totalOfferQuantities;
                this.totalPrice += (singleProductOccurrency * productPrice) - discountForTotal;
                return;                
            }           
                double productPrice = candidateProduct.getUnitPrice(); 
                double totalPriceForProduct = productPrice * singleProductOccurrency;
                this.totalPrice += totalPriceForProduct;
           
        });
        
       return this.totalPrice;  
    }
    
}