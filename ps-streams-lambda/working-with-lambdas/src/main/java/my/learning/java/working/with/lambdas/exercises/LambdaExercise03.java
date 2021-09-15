/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.working.with.lambdas.exercises;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import my.learning.java.working.with.lambdas.Product;

/**
 *
 * @author uditarko
 */
public class LambdaExercise03 {

    public interface ShoppingCartFactory {

        ShoppingCart newShoppingCart();
    }

    /**
     * Exercise 3a: Implement interface ShoppingCartFactory using a method
     * reference.
     *
     * @return A new ShoppingCartFactory.
     */
    public ShoppingCartFactory getShoppingCartFactory() {
        // TODO: Implement interface ShoppingCartFactory by using a method reference
        // Note: Don't implement ShoppingCartFactory with an anonymous class
        return ShoppingCart::new ; // Replace 'null' by your solution
    }

    public static class ShoppingCart {

        private final List<Product> products = new ArrayList<>();

        public void add(Product product) {
            this.products.add(product);
        }

        /**
         * Exercise 3b: Calculate the total amount of the items in the shopping
         * cart.
         *
         * @return The total amount of the items in the shopping cart.
         */
        public BigDecimal getTotalAmount() {
            BigDecimal total = BigDecimal.ZERO;
            //total = BigDecimal.TEN;
            // TODO: This solution does not work. Can you explain why?
            //products.forEach(product -> total.add(product.getPrice()));
//Answer BigDecimal is immutable hence changing its value would make the variable total point to a new memory location in which case it cant be effectively Final 
            // TODO: Implement this method in whatever way you like (you don't have to use lambda expressions)
            total=products.stream().map(p -> p.getPrice()).reduce(total,(a,b) -> a.add(b));
//How does the above work?
            
            return total;
        }
    }
}
