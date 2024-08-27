package org.example.HW;

import java.lang.reflect.Method;
import java.util.Arrays;

public class HW2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class string  = Class.forName("java.lang.String");
        Method[] methods = string.getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);

    }
}
