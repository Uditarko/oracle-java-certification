/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.streams.basics.test;

import java.util.ArrayList;
import java.util.List;
import my.learning.java.streams.basics.Product;
import my.learning.java.streams.basics.exercises.BasicStreamsExercise04;
import static my.learning.java.streams.basics.test.TestData.DETERGENT;
import static my.learning.java.streams.basics.test.TestData.DISH_BRUSH;
import static my.learning.java.streams.basics.test.TestData.FORKS;
import static my.learning.java.streams.basics.test.TestData.PENCILS;
import static my.learning.java.streams.basics.test.TestData.PLATES;
import static my.learning.java.streams.basics.test.TestData.SCOURER;
import static my.learning.java.streams.basics.test.TestData.SPAGHETTI;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author uditarko
 */
public class BasicStreamsExercise04Test {
        private static final List<Product> TEST_PRODUCTS_1 = List.of(PENCILS, DISH_BRUSH, PLATES, SCOURER, SPAGHETTI, FORKS, DETERGENT);
    private static final List<Product> TEST_PRODUCTS_2 = List.of(PENCILS, PLATES, SPAGHETTI, FORKS);

    private BasicStreamsExercise04 exercise = new BasicStreamsExercise04();

    @Test
    @DisplayName("Find cheapest cleaning product")
    void findCheapestCleaning() {
        assertThat(exercise.findCheapestCleaning(new ArrayList<>(TEST_PRODUCTS_1)))
                .describedAs("Exercise 4: Your solution did not find the cheapest cleaning product.")
                .contains(SCOURER);

        assertThat(exercise.findCheapestCleaning(new ArrayList<>(TEST_PRODUCTS_2)))
                .describedAs("Exercise 4: Your solution found something, but an empty result was expected.")
                .isNotPresent();
    }

}
