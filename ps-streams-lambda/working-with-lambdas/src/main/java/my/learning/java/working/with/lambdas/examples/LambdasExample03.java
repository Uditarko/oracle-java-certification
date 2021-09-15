/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.working.with.lambdas.examples;

import java.math.BigDecimal;
import java.util.List;
import my.learning.java.working.with.lambdas.ExampleData;
import my.learning.java.working.with.lambdas.Product;

/**
 *
 * @author uditarko
 */
public class LambdasExample03 {

    interface ProductFilter {

        boolean accept(Product product);
    }

    // Print the products that are accepted by the filter.
    static void printProducts(List<Product> products, ProductFilter filter) {
        for (Product product : products) {
            if (filter.accept(product)) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("5.00");

        // This lambda expression captures the local variable priceLimit.
        // The variable must be effectively final; if it is not, an error will appear in the lambda expression.
        ProductFilter filter = product -> product.getPrice().compareTo(priceLimit) < 0;

        // Reassigning the variable, even after the lambda expression, makes it not effectively final.
        // priceLimit = new BigDecimal("6.00");
        printProducts(products, filter);
    }

}
