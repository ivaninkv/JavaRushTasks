package com.javarush.task.task18.task1827;

/*
Прайсы
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;
        if (args.length > 0 && args[0].equals("-c")) {
            fileName = new Scanner(System.in).next();
            int itemId = 1;
            try (FileReader fr = new FileReader(fileName)) {
                while (fr.ready()) {
                    char[] charId = new char[8];
                    fr.read(charId);
                    int readedId = Integer.parseInt(String.valueOf(charId).trim());
                    if (readedId > itemId) {
                        itemId = readedId;
                    }
                    fr.skip(42 + System.lineSeparator().length());
                }
            }

            try (FileWriter fw = new FileWriter(fileName, true)) {
                fw.write(System.lineSeparator());
                fw.write(String.format("%-8.8s", ++itemId));
                fw.write(String.format("%-30.30s", args[1]));
                fw.write(String.format("%-8.8s", args[2]));
                fw.write(String.format("%-4.4s", args[3]));
                fw.write(System.lineSeparator());
            }
        }
    }
}
