/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.working.with.functional.interfaces.test;

import java.util.function.Predicate;
import static my.learning.java.working.with.functional.interfaces.Category.FOOD;
import my.learning.java.working.with.functional.interfaces.Product;
import my.learning.java.working.with.functional.interfaces.exercises.FunctionalInterfacesExercise01;
import static my.learning.java.working.with.functional.interfaces.test.TestData.APPLES;
import static my.learning.java.working.with.functional.interfaces.test.TestData.COFFEE;
import static my.learning.java.working.with.functional.interfaces.test.TestData.DETERGENT;
import static my.learning.java.working.with.functional.interfaces.test.TestData.SPAGHETTI;
import static my.learning.java.working.with.functional.interfaces.test.TestData.PENCILS;
import static my.learning.java.working.with.functional.interfaces.test.TestData.PLATES;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author uditarko
 */
public class FunctionalInterfacesExercise01Test {
    

    private FunctionalInterfacesExercise01 exercise = new FunctionalInterfacesExercise01();

    @Test
    @DisplayName("Filter products")
    void filterProducts() {
        assertThat(exercise.filterProducts(TestData.getProducts(), (Predicate<Product>) product -> product.getCategory() == FOOD))
                .describedAs("Exercise 1: When searching for FOOD products, only those should be returned.")
                .containsExactly(APPLES, SPAGHETTI, COFFEE);

        assertThat(exercise.filterProducts(TestData.getProducts(), (Predicate<Product>) product -> product.getCategory() != FOOD))
                .describedAs("Exercise 2: When searching for non-FOOD products, only those should be returned.")
                .containsExactly(PENCILS, PLATES, DETERGENT);
    }

}
