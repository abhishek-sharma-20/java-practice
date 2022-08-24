package com.java_topics;

import java.util.*;
import java.util.function.*;

public class Lamda {
    public static void main(String[] args) {

        List<String> stringList = List.of("Hello","World");
        //Consumer
        Consumer<String> stringConsumer = a->System.out.println(a.toUpperCase());

        stringList.forEach(stringConsumer);
        //Function
        Function<Integer,Integer> doubleFunction = n -> n*n;
        System.out.println(doubleFunction.apply(8));

        //Predicate
        Predicate<String> stringPredicate = n-> n.contains("Hello");
        System.out.println(stringPredicate.test("Hello World"));

        //Supplier
        Supplier<String> stringSupplier = ()-> "Hello World";

        System.out.println(stringSupplier.get());
        UnaryOperator<Integer> unaryOperator = a->a+1;
        System.out.println(unaryOperator.apply(10));
        BinaryOperator<Double> binaryOperator = Math::pow;
        System.out.println(binaryOperator.apply(2D,3D));

    }
}
