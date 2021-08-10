package com.javarush.task.pro.task08.task0803;

import java.util.Arrays;
import java.util.Scanner;

/* 
Минимальный элемент массива
*/

public class Solution {

    public static void main(String[] args) {
        int[] intArray = getArrayOfTenElements();
        System.out.println(min(intArray));
    }

    public static int min(int[] ints) {
        //напишите тут ваш код
        int minValue = ints[0];
        for (int i = 0; i < ints.length; i++) {
            minValue = Math.min(minValue, ints[i]);
        }
        return minValue;
    }

    public static int[] getArrayOfTenElements() {
        //напишите тут ваш код
        int[] array = new int[10];
        Scanner console = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = console.nextInt();
        }
        return array;
    }
}
