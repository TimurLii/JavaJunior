package org.example.HW;

import java.util.Arrays;
import java.util.OptionalDouble;

public class HW1 {
    public static void main(String[] args) {
//
//        Напишите программу, которая использует Stream API для обработки списка чисел.
//                Программа должна вывести на экран среднее значение всех четных чисел в списке.


        int [] arr = new int []{23, 30, 16 ,29, 26 ,9 ,4, 17, 20, 1, 14, 19, 18, 2 ,11};
//        int[] arr = new int[]{20, 11, 14, 18, 5, 23, 4, 22, 19, 8, 30, 25, 3, 13, 6};

        OptionalDouble average = Arrays.stream(arr).filter(el -> el % 2 == 0).average();
        System.out.println(average);
    }


}
