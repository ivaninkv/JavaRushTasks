package com.javarush.task.pro.task10.task1012;

import java.util.Arrays;
import java.util.Objects;

/* 
Дефрагментация памяти
*/

public class Memory {

    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
        String[] memoryJR = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        executeDefragmentationJR(memoryJR);
        System.out.println(Arrays.toString(memoryJR));
    }

    public static void executeDefragmentation(String[] array) {
        // напишите тут ваш код
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && i > 0) {
                for (int j = 0; j < i; j++) {
                    if (array[j] == null) {
                        String tmp = array[j];
                        array[j] = array[i];
                        array[i] = tmp;
                    }
                }
            }
        }
    }

    public static void executeDefragmentationJR(String[] array) {
        // эталонное решение JavaRush
        // оно лучше по вычислительной сложности (2n вместо n^2), но хуже по памяти
        String[] temp = new String[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                temp[j] = array[i];
                j++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }
    }
}
