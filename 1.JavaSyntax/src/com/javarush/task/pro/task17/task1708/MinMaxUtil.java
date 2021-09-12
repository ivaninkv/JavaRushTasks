package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinMaxUtil {
    //напишите тут ваш код
    public static int min(int a, int b) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(a, b));
        return Collections.min(numbers);
    }

    public static int min(int a, int b, int c) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(a, b, c));
        return Collections.min(numbers);
    }

    public static int min(int a, int b, int c, int d) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(a, b, c, d));
        return Collections.min(numbers);
    }

    public static int min(int a, int b, int c, int d, int e) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(a, b, c, d, e));
        return Collections.min(numbers);
    }

    public static int max(int a, int b) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(a, b));
        return Collections.max(numbers);
    }

    public static int max(int a, int b, int c) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(a, b, c));
        return Collections.max(numbers);
    }

    public static int max(int a, int b, int c, int d) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(a, b, c, d));
        return Collections.max(numbers);
    }

    public static int max(int a, int b, int c, int d, int e) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(a, b, c, d, e));
        return Collections.max(numbers);
    }
}
