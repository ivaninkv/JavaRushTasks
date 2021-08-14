package com.javarush.task.pro.task09.task0906;

/*
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 8;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1000";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        //напишите тут ваш код
        if (decimalNumber <= 0) {
            return "";
        }
        StringBuilder binaryNumber = new StringBuilder();
        while (decimalNumber > 0) {
            binaryNumber.insert(0, decimalNumber % 2);
            decimalNumber /= 2;
        }
        return binaryNumber.toString();
    }

    public static int toDecimal(String binaryNumber) {
        //напишите тут ваш код
        if (binaryNumber == null || binaryNumber.isEmpty()) {
            return 0;
        }
        int decimalNumber = 0;
        for (int i = 0; i < binaryNumber.length(); i++) {
            int number = Character.getNumericValue(binaryNumber.charAt(binaryNumber.length() - i - 1));
            decimalNumber += number * Math.pow(2, i);
        }
        return decimalNumber;
    }
}
