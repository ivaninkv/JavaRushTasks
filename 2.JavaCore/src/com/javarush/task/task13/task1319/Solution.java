package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Scanner console = new Scanner(System.in);
        String filePath = console.nextLine();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            String line;
            while (!(line = console.nextLine()).equals("exit")) {
                bw.write(line);
                bw.newLine();
            }
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
