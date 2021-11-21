package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //напишите тут ваш код
        String paramStrings = url.split("\\?")[1];
        String[] params = paramStrings.split("&");
        ArrayList<String> listObj = new ArrayList<>();
        for (String param : params) {
            System.out.print(param.split("=")[0] + " ");
            if (param.toLowerCase().contains("obj")) {
                listObj.add(param);
            }
        }

        System.out.println();

        for (String obj : listObj) {
            String objValue = obj.split("=")[1];
            try {
                alert(Double.parseDouble(objValue));

            } catch (Exception e) {
                alert(objValue);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
