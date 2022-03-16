/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.streams.basics.exercises;

import java.util.List;
import java.util.stream.Collectors;
import my.learning.java.streams.basics.Category;
import my.learning.java.streams.basics.Product;

/**
 *
 * @author uditarko
 */
public class BasicStreamsExercise01 {
    

    /**
     * Exercise 1: In a list of products, find the products that are in the category UTENSILS and sort them by name.
     *
     * @param products A list of products.
     * @return A list of products that are utensils, sorted by name.
     */
    public List<Product> findUtensilsSortedByName(List<Product> products) {
        // TODO: Add three stream operation methods:
        //
        // 1) Find the products that are in the category UTENSILS
        // 2) Sort them by name
        // 3) Collect the result into a List
        //
        // Hint: Use the API documentation of interface java.util.stream.Stream.

          return products.stream().filter(prdct -> prdct.getCategory()==Category.UTENSILS)
                  .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                  .collect(Collectors.toList());

    }
}
