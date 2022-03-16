/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.streams.basics.example;

import java.util.List;
import java.util.regex.Pattern;
import my.learning.java.streams.basics.Category;
import my.learning.java.streams.basics.ExampleData;
import my.learning.java.streams.basics.Product;

/**
 *
 * @author uditarko
 */
public class BasicStreamsExample03 {
    

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // The filter() intermediate operation filters elements from the stream
        products.stream()
                .filter(product -> product.getCategory() == Category.FOOD)
                .forEach(System.out::println);

        // The map() intermediate operation does a one-to-one transformation on each element
        products.stream()
                .map(product -> String.format("The price of %s is $ %.2f", product.getName(), product.getPrice()))
                .forEach(System.out::println);

        // The flatMap() intermediate operation does a one-to-N transformation on each element
        // The function passed to flatMap() must return a Stream that contains the output elements
        // The streams returned by the calls to the function are "flatted" into a single output stream
        Pattern spaces = Pattern.compile("\\s+");
        products.stream()
                .flatMap(product -> spaces.splitAsStream(product.getName()))
                .forEach(System.out::println);
    }

}
