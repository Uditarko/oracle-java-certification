/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.streams.basics.test;

import java.math.BigDecimal;
import java.util.Optional;
import my.learning.java.streams.basics.Product;
import my.learning.java.streams.basics.exercises.BasicStreamsExercise03;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author uditarko
 */
public class BasicStreamsExercise03Test {
    

    private BasicStreamsExercise03 exercise = new BasicStreamsExercise03();

    @Test
    @DisplayName("Find product cheaper than the price limit")
    void findProductCheaperThan() {
        Optional<Product> result = exercise.findProductCheaperThan(TestData.getProducts(), new BigDecimal("4.00"));
        assertThat(result)
                .describedAs("Exercise 3: Your solution did not find any products cheaper than $ 4.00.")
                .isPresent();
        assertThat(result.get().getPrice())
                .describedAs("Exercise 3: Your solution returned a product that is not less than $ 4.00.")
                .isLessThan(new BigDecimal("4.00"));

        assertThat(exercise.findProductCheaperThan(TestData.getProducts(), new BigDecimal("1.00")))
                .describedAs("Exercise 3: There are no products cheaper than $ 1.00, expected an empty result.")
                .isNotPresent();
    }

}
