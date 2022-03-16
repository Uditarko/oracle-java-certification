/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.streams.basics.example;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import my.learning.java.streams.basics.Category;
import my.learning.java.streams.basics.ExampleData;
import my.learning.java.streams.basics.Product;

/**
 *
 * @author uditarko
 */
public class BasicStreamsExample04 {
    

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // findFirst() will return an Optional with the first element in the stream, or an empty Optional
        // This is often used together with filter() to search for an element on arbitrary criteria
        Optional<Product> opt = products.stream()
                .filter(product -> product.getCategory() == Category.OFFICE)
                .findFirst();
        opt.ifPresent(System.out::println);

        // If you only want to check if the stream contains an element that matches your search criteria,
        // then you can use anyMatch(), which will return a boolean result
        // Unlike findFirst() and findAny(), you don't have to filter first - anyMatch() takes a Predicate
        boolean foundOfficeProduct = products.stream()
                .anyMatch(product -> product.getCategory() == Category.OFFICE);
        System.out.println("Does the list contain at least one office product? " + foundOfficeProduct);

        // To check if all elements of the stream match specific criteria, use allMatch()
        BigDecimal priceLimit = new BigDecimal("10.00");
        boolean allProductsAreCheap = products.stream()
                .allMatch(product -> product.getPrice().compareTo(priceLimit) < 0);
        System.out.println("Are all products cheap? " + allProductsAreCheap);

        // noneMatch() returns the opposite of anyMatch()
        boolean allProductsAreExpensive = products.stream()
                .noneMatch(product -> product.getPrice().compareTo(priceLimit) < 0);
        System.out.println("Are all products expensive? " + allProductsAreExpensive);
    }

}
