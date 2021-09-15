/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.working.with.functional.interfaces.examples;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import my.learning.java.working.with.functional.interfaces.Category;
import my.learning.java.working.with.functional.interfaces.ExampleData;
import my.learning.java.working.with.functional.interfaces.Product;

/**
 *
 * @author uditarko
 */
public class FunctionalInterfacesExample04 {

    // Go through a list of products, and return the first product for which the predicate returns true.
    static Optional<Product> findProduct(List<Product> products, Predicate<Product> predicate) {
        for (Product product : products) {
            if (predicate.test(product)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("2.00");

        // Two simple predicates that can be combined using the functional composition methods in interface Predicate.
        Predicate<Product> isFood = product -> product.getCategory() == Category.FOOD;
        Predicate<Product> isCheap = product -> product.getPrice().compareTo(priceLimit) < 0;

        findProduct(products, isFood.and(isCheap)) // Combining the predicates with and(...)
                .map(product -> String.format("%s for $ %.2f", product.getName(), product.getPrice()))
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("There are no cheap food products"));
    }
}
