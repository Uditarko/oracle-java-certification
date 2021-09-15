/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.working.with.functional.interfaces.examples;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import my.learning.java.working.with.functional.interfaces.ExampleData;
import my.learning.java.working.with.functional.interfaces.Product;

/**
 *
 * @author uditarko
 */
public class FunctionalInterfacesExample03 {

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

        Function<Product, BigDecimal> productToPrice = Product::getPrice;
        Function<BigDecimal, String> priceToMessage = price -> String.format("The price of %s is $ %.2f%n", name, price);

        // Compose a new function out of the two functions above by using andThen(...)
        Function<Product, String> productToMessage = productToPrice.andThen(priceToMessage);

        // Alternative: use compose(...), which is the same as andThen(...) except that the order of the functions is reversed
//        Function<Product, String> productToMessage = priceToMessage.compose(productToPrice);
        findProduct(products, product -> product.getName().equals(name))
                .map(productToMessage)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.printf("%s is not available%n", name));
    }
}
