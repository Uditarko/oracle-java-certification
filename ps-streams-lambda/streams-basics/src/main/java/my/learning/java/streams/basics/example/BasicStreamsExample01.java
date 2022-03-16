/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.streams.basics.example;

import java.util.List;
import java.util.stream.Stream;
import my.learning.java.streams.basics.ExampleData;
import my.learning.java.streams.basics.Product;

/**
 *
 * @author uditarko
 */
public class BasicStreamsExample01 {
        

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // Streams are lazy - without a terminal operation, no work is done
        // When you call intermediate operations on a stream, you're only building the pipeline;
        // no elements are flowing through it yet
        Stream<Product> stream = products.stream().map(product -> {
            System.out.println(product);
            return product;
        });

        // When you call a terminal operation, the stream will do the work
        stream.forEach(product -> {});
    }

    
}
