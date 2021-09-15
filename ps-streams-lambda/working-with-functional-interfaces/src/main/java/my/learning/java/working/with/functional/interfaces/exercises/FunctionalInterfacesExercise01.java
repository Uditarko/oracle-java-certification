/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.working.with.functional.interfaces.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import my.learning.java.working.with.functional.interfaces.Product;

/**
 *
 * @author uditarko
 */
public class FunctionalInterfacesExercise01 {
    

    /**
     * Exercise 1: Filter a list of products.
     * <p>
     * Choose a standard functional interface for the parameter 'f'.
     * Which functional interface is appropriate here? (Function, Consumer, Supplier, Predicate, ...)
     * <p>
     * Implement the method.
     *
     * @param products List of products to filter. (Note: The method should not modify this list).
     * @param f        Determines which products should be in the result.
     * @return A filtered list of products.
     */
    public List<Product> filterProducts(List<Product> products, /* TODO: Replace 'Object' with a functional interface */ Predicate<Product> f) {
        List<Product> result = new ArrayList<>();

        // TODO: Implement this method. Loop through the list of products, call 'f' to determine if a product should be
        // in the result list, and put it in the result list if appropriate.

        products.stream().filter(f).forEach(product -> result.add(product));
        return result;
    }

}
