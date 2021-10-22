package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        String line;
        ArrayList<Integer> integers = new ArrayList<>();
        Scanner console = new Scanner(System.in);
        String filePath = console.nextLine();
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            while ((line = bf.readLine()) != null) {
                int intValue = Integer.parseInt(line);
                if (intValue % 2 == 0) {
                    integers.add(intValue);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(integers);
        for (Integer value : integers) {
            System.out.println(value);
        }
    }
}
