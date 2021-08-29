package com.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        System.out.print("Source path: ");
        String source = console.nextLine();
        System.out.print("Destination path: ");
        String dest = console.nextLine();

        try (InputStream inputStream = Files.newInputStream(Path.of(source));
             OutputStream outputStream = Files.newOutputStream(Path.of(dest))
        ) {
            byte[] buffer = inputStream.readAllBytes();
            for (int i = 1; i < buffer.length; i += 2) {
                byte tmp = buffer[i - 1];
                buffer[i - 1] = buffer[i];
                buffer[i] = tmp;
            }
            outputStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
