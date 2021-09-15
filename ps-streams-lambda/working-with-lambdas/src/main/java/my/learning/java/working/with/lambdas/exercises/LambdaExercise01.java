/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.working.with.lambdas.exercises;

import java.util.Collections;
import java.util.List;
import my.learning.java.working.with.lambdas.Product;

/**
 *
 * @author uditarko
 */
public class LambdaExercise01 {

    /**
     * Exercise 1: Sort a list of products by name using a lambda expression.
     *
     * @param products The list of products to sort.
     */
    public void sortProductsByName(List<Product> products) {
        // TODO: Use a lambda expression to sort the list of products by name
        // products.sort(<lambda expression>);
         
        Collections.sort(products, (p1,p2)-> p1.getName().compareTo(p2.getName()));
    }

}
