/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.streams.basics;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import jdk.nashorn.api.tree.Tree;

/**
 *
 * @author uditarko
 */
public class Experiment {

    public static void main(String[] args) {
        Product p1 = new Product(Category.FOOD, "P1", new BigDecimal(1));
        Product p2 = new Product(Category.FOOD, "P2", new BigDecimal(2));
        Product p3 = new Product(Category.FOOD, "P3", new BigDecimal(3));
        Product p4 = new Product(Category.FOOD, "P4", new BigDecimal(4));
        Product p5 = new Product(Category.FOOD, "P5", new BigDecimal(5));

        Stream.Builder<Product> builder1 = Stream.builder();
        builder1.add(p1).add(p2).add(p3).add(p4).add(p5);
        System.out.println(builder1.build().reduce(BigDecimal.ZERO, (BigDecimal bd, Product p) -> bd.add(p.getPrice()), BigDecimal::add));

        Stream.Builder<Product> builder2 = Stream.builder();
        builder2.add(p1).add(p2).add(p3).add(p4).add(p5);
        ArrayList<BigDecimal> list1 = builder2.build().collect(ArrayList::new, (ArrayList t, Product p) -> t.add(p.getPrice()), (t1, t2) -> t1.addAll(t2));
        list1.stream().forEach(System.out::println);

        //the above can be done with reduce but we have to assume the lists are immutable
        //This is inefficient because of so many objects might be created if the list is long
        //also for each time the accumulator or combiner runs all the elements from the incoming as a\weel as new value or list have to copied
        Stream.Builder<Product> builder3 = Stream.builder();
        builder3.add(p1).add(p2).add(p3).add(p4).add(p5);
        ArrayList<BigDecimal> list2 = builder3.build().reduce(new ArrayList<BigDecimal>(), (ArrayList<BigDecimal> lp, Product p) -> {
            ArrayList<BigDecimal> tmp = new ArrayList<>(lp);
            tmp.add(p.getPrice());
            return tmp;
        }, (t1, t2) -> {
            ArrayList<BigDecimal> tmp2 = new ArrayList<>(t1);
            tmp2.addAll(t2);
            return tmp2;
        });
        list2.stream().forEach(System.out::println);

        //collectors create a map
        Stream.Builder<Product> builder4 = Stream.builder();
        builder4.add(p1).add(p2).add(p3).add(p4).add(p5);
        builder4.build().collect(Collectors.toMap((Product p) -> p.getCategory(), (Product p) -> p.getPrice(), BigDecimal::add));

        Stream.Builder<Product> builder5 = Stream.builder();
        builder5.add(p1).add(p2).add(p3).add(p4).add(p5);
        BigDecimal cheapLimit = new BigDecimal(2);
        BigDecimal expensiveLimit = new BigDecimal(4);
        //Stream.of(Category.values()).flatMap(c -> builder5.build().filter(p -> p.getCategory().equals(c))).collect(Collectors.toMap( (Product p) -> p.getCategory(), ));

        Function<Product, String> classifier = (p) -> {
            if (p.getPrice().compareTo(cheapLimit) < 0) {
                return "Cheap";
            } else if (p.getPrice().compareTo(expensiveLimit) > 0) {
                return "Costly";
            } else {
                return "Average";
            }
        };
        Map<String,List<Product>> result =builder5.build().collect(Collectors.groupingBy(classifier, Collectors.toList()));
        result.entrySet().stream().forEach(System.out::println);
    }
}
