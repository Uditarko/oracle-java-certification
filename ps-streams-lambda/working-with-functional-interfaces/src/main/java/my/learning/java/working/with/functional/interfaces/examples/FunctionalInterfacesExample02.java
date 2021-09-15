/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.working.with.functional.interfaces.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import my.learning.java.working.with.functional.interfaces.Category;
import my.learning.java.working.with.functional.interfaces.ExampleData;
import my.learning.java.working.with.functional.interfaces.Product;

/**
 *
 * @author uditarko
 */
public class FunctionalInterfacesExample02 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        Map<Category, List<Product>> productsByCategory = new HashMap<>();

        // Without functional interfaces and lambda expressions.
        for (Product product : products) {
            Category category = product.getCategory();

            // Check if the map already has a List for this category; if not, add one.
            if (!productsByCategory.containsKey(category)) {
                productsByCategory.put(category, new ArrayList<>());
            }

            // Add the product to the appropriate list in the map.
            productsByCategory.get(category).add(product);
        }

        // With Map.computeIfAbsent()
        for (Product product : products) {
            Category category = product.getCategory();

            // computeIfAbsent() gets the existing List for the category, or calls the given
            // Function<Category, List<Product>> to create the List if there is no entry in the Map for the category.
            productsByCategory.computeIfAbsent(category, c -> new ArrayList<>()).add(product);
        }

        // Map.forEach() takes a BiConsumer (a Consumer which takes two parameters); the key and value of each entry.
        productsByCategory.forEach((category, ps) -> {
            System.out.println("Category: " + category);
            ps.forEach(product -> System.out.println("- " + product.getName()));
        });
    }
}
