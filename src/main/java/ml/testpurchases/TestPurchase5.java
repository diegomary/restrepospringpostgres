/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ml.testpurchases;

import java.util.ArrayList;

import ml.checkout.Product;
import ml.repository.ProductRepository;

/**
 *
 * @author Diego
 */
public class TestPurchase5 {
    
    public TestPurchase5(){}    
    public static ArrayList<Product> Purchase() {
        
        ArrayList<Product> FlowOfProductsInSession = new ArrayList<Product>();        
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(0)); // SKU A First purchase  SCANNED (8 purchases OF A ) (odd)
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(0)); // SKU A   
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(0)); // SKU A 
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(0)); // SKU A 
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(0)); // SKU A 
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(0)); // SKU A  
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(0)); // SKU A  
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(0)); // SKU A 
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(1)); // SKU B (7 purchases OF B ) (even)
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(1)); // SKU B 
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(1)); // SKU B   
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(1)); // SKU B 
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(1)); // SKU B 
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(1)); // SKU B  
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(1)); // SKU B 
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(2)); // SKU C   
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(3)); // SKU D    
        
        
        
        return FlowOfProductsInSession;
    }    
}
