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
public class TestPurchase1 {
    
    public TestPurchase1(){}
    
    public static ArrayList<Product> Purchase() {
        
        ArrayList<Product> FlowOfProductsInSession = new ArrayList<Product>();        
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(0)); // SKU A First purchase  SCANNED
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(3)); // SKU D Second purchase    "  
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(2)); // SKU C Third purchase     "  
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(1)); // SKU B Fourth purchase    "  
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(0)); // SKU A Fifth purchase     "  
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(0)); // SKU A Sixth purchase     "  
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(0)); // SKU A Seventh purchase   "  
        FlowOfProductsInSession.add(ProductRepository.ProducsAvailable().get(1)); // SKU B Heighth purchase   "
        
        return FlowOfProductsInSession;
    }    
}