package com.javarush.task.pro.task15.task1506;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        try {
            List<String> lines = Files.readAllLines(Path.of(scanner.nextLine()));
            for (String str : lines) {
                System.out.println(str.replaceAll("[., ]", ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
