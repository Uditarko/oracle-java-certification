/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.streams.basics.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import my.learning.java.streams.basics.Category;
import my.learning.java.streams.basics.ExampleData;
import my.learning.java.streams.basics.Product;

/**
 *
 * @author uditarko
 */
public class BasicStreamsExample05 {


    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // This is not a good way to get the elements of a stream into a list
//        List<String> foodProductNames = new ArrayList<>();
//        products.stream()
//                .filter(product -> product.getCategory() == Category.FOOD)
//                .map(Product::getName)
//                .forEach(foodProductNames::add);

        // Using collect() you can collect the elements of a stream into a collection
        // Class Collectors contains factory methods for collectors that create different kinds of collections
        List<String> foodProductNames = products.stream()
                .filter(product -> product.getCategory() == Category.FOOD)
                .map(Product::getName)
                .collect(Collectors.toList());

        System.out.println(foodProductNames);

        // Collectors.joining(...) returns a collector to reduce stream elements into a string
        String categories = products.stream()
                .map(Product::getCategory)
                .distinct()
                .map(Category::name)
                .collect(Collectors.joining("; "));

        System.out.println(categories);
    }

}
