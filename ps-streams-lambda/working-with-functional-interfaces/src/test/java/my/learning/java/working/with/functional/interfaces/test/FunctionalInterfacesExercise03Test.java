/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.working.with.functional.interfaces.test;

import my.learning.java.working.with.functional.interfaces.exercises.FunctionalInterfacesExercise03;
import static my.learning.java.working.with.functional.interfaces.exercises.FunctionalInterfacesExercise03.ArithmeticOperation.ADD;
import static my.learning.java.working.with.functional.interfaces.exercises.FunctionalInterfacesExercise03.ArithmeticOperation.DIVIDE;
import static my.learning.java.working.with.functional.interfaces.exercises.FunctionalInterfacesExercise03.ArithmeticOperation.MULTIPLY;
import static my.learning.java.working.with.functional.interfaces.exercises.FunctionalInterfacesExercise03.ArithmeticOperation.SUBTRACT;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author uditarko
 */
public class FunctionalInterfacesExercise03Test {

    private FunctionalInterfacesExercise03 exercise = new FunctionalInterfacesExercise03();

    @Test
    @DisplayName("Do calculations")
    void calculate() {
        assertThat(exercise.calculate(2.5, 1.0, ADD)).isEqualTo(3.5);
        assertThat(exercise.calculate(4.5, 2.5, SUBTRACT)).isEqualTo(2.0);
        assertThat(exercise.calculate(2.25, 3.0, MULTIPLY)).isEqualTo(6.75);
        assertThat(exercise.calculate(10.0, 4.0, DIVIDE)).isEqualTo(2.5);
    }

}
