/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.streams.basics.test;

import java.util.ArrayList;
import java.util.List;
import my.learning.java.streams.basics.Product;
import my.learning.java.streams.basics.exercises.BasicStreamsExercise06;
import static my.learning.java.streams.basics.test.TestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author uditarko
 */
public class BasicStreamsExercise06Test {

    private static final List<Product> TEST_PRODUCTS = List.of(PENCILS, APPLES, PLATES, SPAGHETTI);

    private BasicStreamsExercise06 exercise = new BasicStreamsExercise06();

    @Test
    @DisplayName("Format a list of products")
    void formatProductList() {
        assertThat(exercise.formatProductList(new ArrayList<>(TEST_PRODUCTS)))
                .describedAs("Exercise 6: Your solution does not return the correct result.")
                .isEqualTo("OFFICE     Pencils          $   5.79\n"
                        + "FOOD       Apples           $   1.29\n"
                        + "UTENSILS   Plates           $  12.95\n"
                        + "FOOD       Spaghetti        $   2.79");
    }

}
