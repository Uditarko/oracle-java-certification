/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.working.with.lambdas.examples;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import my.learning.java.working.with.lambdas.ExampleData;
import my.learning.java.working.with.lambdas.Product;

/**
 *
 * @author uditarko
 */
public class LambdasExample06 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        try (FileWriter writer = new FileWriter("products.txt")) {
//            for (Product product : products) {
//                writer.write(product.toString() + "\n");
//            }

            // According to forEach(), the lambda expression implements interface Consumer. The accept() method
            // of this interface does not declare any checked exceptions, so the lambda expression is not allowed
            // to throw any checked exceptions. We are forced to handle the IOException inside the lambda expression.
            products.forEach(product -> {
                try {
                    writer.write(product.toString() + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException | RuntimeException e) {
            System.err.println("An exception occurred: " + e.getMessage());
        }
    }

}
