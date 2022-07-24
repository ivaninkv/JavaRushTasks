package com.javarush.task.task18.task1809;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/*
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String sourceFileName = console.next();
        String destFileName = console.next();

        try (FileInputStream fis = new FileInputStream(sourceFileName)) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            try (FileOutputStream fos = new FileOutputStream(destFileName)) {
                for (int i = buffer.length - 1; i >= 0; i--) {
                    fos.write(buffer[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
