package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/*
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = new Scanner(System.in).next();
        SortedSet<Integer> sortedSet = new TreeSet<>();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            while (fis.available() > 0) {
                sortedSet.add(fis.read());
            }
        }
        sortedSet.forEach(v -> System.out.print(v + " "));
    }
}
