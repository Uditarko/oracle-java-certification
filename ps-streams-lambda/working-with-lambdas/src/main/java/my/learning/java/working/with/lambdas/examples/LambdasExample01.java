/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.working.with.lambdas.examples;

import java.util.Comparator;
import java.util.List;
import my.learning.java.working.with.lambdas.ExampleData;
import my.learning.java.working.with.lambdas.Product;

/**
 *
 * @author uditarko
 */
public class LambdasExample01 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // Interface Comparator implemented with an anonymous class.
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getPrice().compareTo(p2.getPrice());
            }
        });

        // Interface Comparator implemented with a lambda expression.
        products.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));

        // The same with a more verbose syntax:
        // - You can optionally specify the type of the parameters
        // - The body can be a block between { and } or a single expression
        products.sort((Product p1, Product p2) -> {
            return p1.getPrice().compareTo(p2.getPrice());
        });

        for (Product product : products) {
            System.out.println(product);
        }
    }

}
