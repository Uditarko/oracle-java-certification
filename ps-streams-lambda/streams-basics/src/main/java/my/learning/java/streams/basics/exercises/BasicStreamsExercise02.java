/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.streams.basics.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import my.learning.java.streams.basics.Category;
import my.learning.java.streams.basics.Product;

/**
 *
 * @author uditarko
 */
public class BasicStreamsExercise02 {
    

    /**
     * Exercise 2a: In a list of products, find the products that are in a given category and return their names.
     *
     * @param products A list of products.
     * @param category A product category.
     * @return A List containing the names of the products in the given category.
     */
    public List<String> getProductNamesForCategory(List<Product> products, Category category) {
        Predicate<Product> filterProductByCategory=product -> product.getCategory()==category;
        Function<Product,String> tarnsformProductToName=product -> product.getName();
        // TODO: Add three stream operation methods:
        //
        // 1) Find the products that are in the given category
        // 2) Transform each product to its name
        // 3) Collect the result into a List
        //
        // Hint: Use the API documentation of interface java.util.stream.Stream.

          return products.stream().filter(filterProductByCategory).map(tarnsformProductToName).collect(Collectors.toList());

    }

    /**
     * Exercise 2b: Given a map that contains products grouped by category and a stream of categories, get the names of the products
     * for each category in that stream and return all the products in a list.
     *
     * @param productsByCategory A map containing products grouped by category.
     * @param categories         A stream of product categories.
     * @return A list containing the names of products in each of the categories in the given stream.
     */
    public List<String> categoriesToProductNames(Map<Category, List<Product>> productsByCategory, Stream<Category> categories) {
        // TODO: Start with the stream of categories.
        // For each category in that stream, get the products.
        // Then transform them to product names.
        // Finally, collect the results in a list.
        //
        // Hint: You'll need to use different mapping methods.

         List<String> names=categories.flatMap(c -> productsByCategory.get(c).stream().map(p -> p.getName())).collect(Collectors.toList());
         return names;
    }

}
