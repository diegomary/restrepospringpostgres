/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ml.repository;

import java.util.ArrayList;

import ml.checkout.Product;


/**
 *
 * @author Diego
 */
public class ProductRepository {
    
    public static ArrayList<Product> ProducsAvailable(){
        
        // Since the offer can change often it is handy to to flag the product to revive or disabled them.
        Product prA = new Product("A","Laptop", 0.5 ,true, 3, 1.30);		
	    Product prB = new Product("B","Phone",0.30,true,2,0.45);
	    Product prC = new Product("C","Kitchen",2.0,false,1,2.0);
	    Product prD = new Product("D","Book",0.75,false,1,0.75);
        ArrayList<Product> prc = new ArrayList<Product>();
        
        prc.add(prA);
        prc.add(prB);
        prc.add(prC);
        prc.add(prD);
        return prc;
    }
    
}
