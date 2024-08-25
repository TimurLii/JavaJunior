package org.example.lambda_1;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

//        PlainInterface plainInterface = Integer::sum;

//        PlainInterface plainInterface1 = Integer::compare;

//        System.out.println(plainInterface.action(2,2));
//
//        System.out.println(plainInterface1.action(1,4) );

//        List<String> list = Arrays.asList("kaka", "Mala", "sa");
//
//        List<String> collect = list.stream().filter(str -> str.length() > 2).toList();
//
//        collect.forEach(System.out::println);

        Arrays.asList(1,2,3,4,5).stream().map(el-> el*el).forEach(System.out::println);
    }
}
