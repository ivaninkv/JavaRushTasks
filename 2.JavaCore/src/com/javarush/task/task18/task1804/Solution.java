package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = new Scanner(System.in).next();
        Map<Integer, Integer> resultMap = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            while (fis.available() > 0) {
                int readByte = fis.read();
                resultMap.put(readByte, resultMap.getOrDefault(readByte, 0) + 1);
            }
        }

        Optional<Integer> minValue = resultMap.values().stream()
                .min(Comparator.naturalOrder());
        resultMap.entrySet().stream()
                .filter(v -> v.getValue().equals(minValue.get()))
                .forEach(s -> System.out.print(s.getKey() + " "));
    }
}
