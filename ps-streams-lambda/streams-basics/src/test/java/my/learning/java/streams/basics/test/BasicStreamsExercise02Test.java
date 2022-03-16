/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.streams.basics.test;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import static my.learning.java.streams.basics.Category.*;
import my.learning.java.streams.basics.Product;
import my.learning.java.streams.basics.exercises.BasicStreamsExercise02;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author uditarko
 */
public class BasicStreamsExercise02Test {
    

    private BasicStreamsExercise02 exercise = new BasicStreamsExercise02();

    @Test
    @DisplayName("Get product names for category")
    void getProductNamesForCategory() {
        assertThat(exercise.getProductNamesForCategory(TestData.getProducts(), OFFICE))
                .describedAs("Exercise 2a: Your solution does not return the correct result for the category OFFICE.")
                .containsExactly("Pencils");

        assertThat(exercise.getProductNamesForCategory(TestData.getProducts(), FOOD))
                .describedAs("Exercise 2a: Your solution does not return the correct result for the category FOOD.")
                .containsExactly("Apples", "Spaghetti");

        assertThat(exercise.getProductNamesForCategory(TestData.getProducts(), UTENSILS))
                .describedAs("Exercise 2a: Your solution does not return the correct result for the category UTENSILS.")
                .containsExactly("Plates", "Knives", "Forks");

        assertThat(exercise.getProductNamesForCategory(TestData.getProducts(), CLEANING))
                .describedAs("Exercise 2a: Your solution does not return the correct result for the category CLEANING.")
                .containsExactly("Detergent");
    }

    @Test
    @DisplayName("Categories to product names")
    void categoriesToProductNames() {
        assertThat(exercise.categoriesToProductNames(TestData.getProducts().stream().collect(Collectors.groupingBy(Product::getCategory)), Stream.of(FOOD, UTENSILS, CLEANING, OFFICE)))
                .describedAs("Exercise 2b: Your solution does not return the correct result.")
                .containsExactly("Apples", "Spaghetti", "Plates", "Knives", "Forks", "Detergent", "Pencils");
    }

}
