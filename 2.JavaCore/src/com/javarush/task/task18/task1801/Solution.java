package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.util.Scanner;

/*
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        String fileName = console.next();
        int maxByte = 0;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            while (fis.available() > 0) {
                int readByte = fis.read();
                maxByte = Math.max(readByte, maxByte);
            }
        }
        System.out.println(maxByte);
    }
}
