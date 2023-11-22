package org.example;

import repositories.ProductRepo;

public class Main {
    public static void main(String[] args) {
        ProductRepo repository = new ProductRepo();
        var products = repository.allProducts();


        for(var product : products){
            System.out.println(product.getName() + " : " + product.getProductID());
        }
    }
}