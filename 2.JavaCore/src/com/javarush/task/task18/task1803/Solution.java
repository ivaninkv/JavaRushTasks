package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        Map<Integer, Integer> resultMap = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            while (fis.available() > 0) {
                int readByte = fis.read();
                resultMap.put(readByte, resultMap.getOrDefault(readByte, 0) + 1);
            }
        }

        Optional<Integer> maxValue = resultMap.values().stream()
                .max(Comparator.naturalOrder());
        resultMap.entrySet().stream()
                .filter(v -> v.getValue().equals(maxValue.get()))
                .forEach(s -> System.out.print(s.getKey() + " "));
    }
}
