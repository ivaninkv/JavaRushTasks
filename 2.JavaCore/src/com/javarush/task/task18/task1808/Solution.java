package com.javarush.task.task18.task1808;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String sourceFileName = console.next();
        String outFileName1 = console.next();
        String outFileName2 = console.next();

        try (FileInputStream fis = new FileInputStream(sourceFileName)) {
            byte[] buffer2 = new byte[fis.available() / 2];
            byte[] buffer1 = new byte[fis.available() - buffer2.length];

            try (FileOutputStream fos = new FileOutputStream(outFileName1)) {
                fis.read(buffer1);
                fos.write(buffer1);
            }

            try (FileOutputStream fos = new FileOutputStream(outFileName2)) {
                fis.read(buffer2);
                fos.write(buffer2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
