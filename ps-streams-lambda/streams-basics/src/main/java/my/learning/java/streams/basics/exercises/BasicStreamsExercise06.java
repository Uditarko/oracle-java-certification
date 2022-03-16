/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.streams.basics.exercises;

import java.util.List;
import java.util.stream.Collectors;
import my.learning.java.streams.basics.Product;

/**
 *
 * @author uditarko
 */
public class BasicStreamsExercise06 {
    
    /**
     * Exercise 6: Format a list of products into a string, with one product per line.
     *
     * @param products A list of products.
     * @return A string containing the products as strings, separated by newlines ('\n').
     */
    public String formatProductList(List<Product> products) {
        // TODO: Convert each of the products to a string (using Product.toString()) and collect the results in a string.
        // Separate the products strings by a newline character '\n'.
        //
        // Hint: Use the appropriate collector in the last step to convert the product strings into a single string.

          return products.stream().map(Product::toString).collect(Collectors.joining("\n"));
    }

}
