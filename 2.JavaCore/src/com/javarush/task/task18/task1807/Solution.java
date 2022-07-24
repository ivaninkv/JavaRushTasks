package com.javarush.task.task18.task1807;

import java.io.FileInputStream;
import java.util.Scanner;

/*
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = new Scanner(System.in).next();
        int commaCount = 0;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            while (fis.available() > 0) {
                if (fis.read() == 44) {
                    commaCount++;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(commaCount);
    }
}
