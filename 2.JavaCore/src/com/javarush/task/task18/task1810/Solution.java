package com.javarush.task.task18.task1810;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        while (true) {
            String fileName = new Scanner(System.in).next();
            try (FileInputStream fis = new FileInputStream(fileName)) {
                if (fis.available() < 1000) {
                    throw new DownloadException();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
