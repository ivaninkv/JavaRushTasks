package com.javarush.task.task18.task1826;

/*
Шифровка
*/

import java.io.*;

public class Solution {
    private static final int offset = 64;

    public static void main(String[] args) {
        switch (args[0]) {
            case "-e":
                writeWithOffset(args[1], args[2], offset);
                break;
            case "-d":
                writeWithOffset(args[1], args[2], offset * -1);
                break;
        }
    }

    private static void writeWithOffset(String inputFileName, String outputFileName, int offset) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFileName))) {
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFileName))) {
                while (bis.available() > 0) {
                    bos.write(bis.read() + offset);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
