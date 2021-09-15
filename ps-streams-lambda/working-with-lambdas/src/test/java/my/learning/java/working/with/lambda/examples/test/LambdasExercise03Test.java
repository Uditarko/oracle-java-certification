/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.working.with.lambda.examples.test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import static my.learning.java.working.with.lambdas.Category.CLEANING;
import static my.learning.java.working.with.lambdas.Category.FOOD;
import static my.learning.java.working.with.lambdas.Category.OFFICE;
import static my.learning.java.working.with.lambdas.Category.UTENSILS;
import my.learning.java.working.with.lambdas.Product;
import my.learning.java.working.with.lambdas.exercises.LambdaExercise03;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author uditarko
 */
public class LambdasExercise03Test {
    

    private static final List<Product> TEST_PRODUCTS = Arrays.asList(
            new Product(OFFICE, "Pencils", new BigDecimal("5.79")),
            new Product(FOOD, "Apples", new BigDecimal("1.29")),
            new Product(UTENSILS, "Plates", new BigDecimal("12.95")),
            new Product(FOOD, "Spaghetti", new BigDecimal("2.79")),
            new Product(FOOD, "Coffee", new BigDecimal("7.49")),
            new Product(CLEANING, "Detergent", new BigDecimal("3.79")));

    private LambdaExercise03 exercise = new LambdaExercise03();

    @Test
    @DisplayName("Exercise 3: Use a shopping cart")
    void useShoppingCart() {
        LambdaExercise03.ShoppingCartFactory factory = exercise.getShoppingCartFactory();

        assertThat(factory)
                .describedAs("Exercise 3: Your getShoppingCartFactory() does not return a shopping cart factory.")
                .isInstanceOf(LambdaExercise03.ShoppingCartFactory.class);

        LambdaExercise03.ShoppingCart shoppingCart = factory.newShoppingCart();

        assertThat(shoppingCart)
                .describedAs("Exercise 3: Your ShoppingCartFactory does not create a shopping cart.")
                .isInstanceOf(LambdaExercise03.ShoppingCart.class);

        for (Product product : TEST_PRODUCTS) {
            shoppingCart.add(product);
        }

        assertThat(shoppingCart.getTotalAmount())
                .describedAs("Exercise 3: Your shopping cart does not return the correct total amount.")
                .isEqualTo(new BigDecimal("34.10"));
    }
}
