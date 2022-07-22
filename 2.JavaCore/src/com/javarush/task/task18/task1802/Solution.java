package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        int minByte = Integer.MAX_VALUE;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            while (fis.available() > 0) {
                int readByte = fis.read();
                minByte = Math.min(minByte, readByte);
            }
        }
        System.out.println(minByte);
    }
}
