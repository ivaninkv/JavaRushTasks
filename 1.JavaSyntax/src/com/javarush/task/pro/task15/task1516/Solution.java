package com.javarush.task.pro.task15.task1516;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        boolean isCorrectPath = true;
        while (isCorrectPath) {
            Path path = Path.of(console.nextLine());
            if (Files.isDirectory(path)) {
                System.out.println(path + THIS_IS_DIR);
                continue;
            }
            if (Files.isRegularFile(path)) {
                System.out.println(path + THIS_IS_FILE);
                continue;
            }
            isCorrectPath = false;
        }
    }
}
