/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.working.with.functional.interfaces.examples;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import my.learning.java.working.with.functional.interfaces.ExampleData;
import my.learning.java.working.with.functional.interfaces.Product;

/**
 *
 * @author uditarko
 */
public class FunctionalInterfacesExample01 {

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

        String name = "Spaghetti";

        // A combination of functional interfaces implemented by lambda expressions and method references is used here:
        // - findProduct() takes a Predicate<Product> to find the product with the specified name
        // - map() takes a Function<Product, BigDecimal> to get the price of the product
        // - ifPresentOrElse() takes a Consumer<Product> and a Runnable and calls one of them, depending on whether
        //      the Optional contains a value or is empty
        findProduct(products, product -> product.getName().equals(name))
                .map(Product::getPrice)
                .ifPresentOrElse(
                        price -> System.out.printf("The price of %s is $ %.2f%n", name, price),
                        () -> System.out.printf("%s is not available%n", name));
    }

}
