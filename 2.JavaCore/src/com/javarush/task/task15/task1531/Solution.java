package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        String result = n < 0 ? "0" : "";
        result = n == 0 ? "1" : result;

        if (result.equalsIgnoreCase("")) {
            BigInteger factorialSum = BigInteger.valueOf(1);
            for (int i = 1; i <= n; i++) {
                factorialSum = factorialSum.multiply(BigInteger.valueOf(i));
            }
            result = String.valueOf(factorialSum);
        }

        return result;
    }
}
