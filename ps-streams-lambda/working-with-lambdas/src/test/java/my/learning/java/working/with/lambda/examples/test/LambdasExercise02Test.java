/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.working.with.lambda.examples.test;

import java.util.Arrays;
import java.util.List;
import static my.learning.java.working.with.lambdas.Category.OFFICE;
import my.learning.java.working.with.lambdas.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author uditarko
 */
import static my.learning.java.working.with.lambdas.Category.CLEANING;
import static my.learning.java.working.with.lambdas.Category.FOOD;
import static my.learning.java.working.with.lambdas.Category.UTENSILS;
import my.learning.java.working.with.lambdas.exercises.LambdaExercise02;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class LambdasExercise02Test {
    

    private static final List<Product> TEST_PRODUCTS = Arrays.asList(
            new Product(OFFICE, "Pencils", new BigDecimal("5.79")),
            new Product(FOOD, "Apples", new BigDecimal("1.29")),
            new Product(UTENSILS, "Plates", new BigDecimal("12.95")),
            new Product(FOOD, "Spaghetti", new BigDecimal("2.79")),
            new Product(FOOD, "Coffee", new BigDecimal("7.49")),
            new Product(CLEANING, "Detergent", new BigDecimal("3.79")));

    private LambdaExercise02 exercise = new LambdaExercise02();

    @Test
    @DisplayName("Exercise 2: Find products by category")
    void findProductsByCategory() {
        List<Product> products = new ArrayList<>(TEST_PRODUCTS);

        List<Product> result = exercise.findProductsByCategory(products, FOOD);

        assertThat(products)
                .describedAs("Exercise 2: Your solution should not modify the original list.")
                .containsExactly(
                        new Product(OFFICE, "Pencils", new BigDecimal("5.79")),
                        new Product(FOOD, "Apples", new BigDecimal("1.29")),
                        new Product(UTENSILS, "Plates", new BigDecimal("12.95")),
                        new Product(FOOD, "Spaghetti", new BigDecimal("2.79")),
                        new Product(FOOD, "Coffee", new BigDecimal("7.49")),
                        new Product(CLEANING, "Detergent", new BigDecimal("3.79")));

        assertThat(result)
                .describedAs("Exercise 2: Your solution does not return the correct result.")
                .containsExactly(
                        new Product(FOOD, "Apples", new BigDecimal("1.29")),
                        new Product(FOOD, "Spaghetti", new BigDecimal("2.79")),
                        new Product(FOOD, "Coffee", new BigDecimal("7.49")));
    }
}
