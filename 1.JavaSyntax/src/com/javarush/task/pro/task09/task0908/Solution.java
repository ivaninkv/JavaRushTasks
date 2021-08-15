package com.javarush.task.pro.task09.task0908;

/*
Двоично-шестнадцатеричный конвертер
*/

import java.util.Arrays;

public class Solution {
    private static final String binSymbols = "01";
    private static final String hexSymbols = "0123456789abcdef";
    private static final String[] hexArray = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
            "1000", "1001", "1010", "1011", "1100", "1101", "1100", "1110", "1111"};

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        //напишите тут ваш код
        if (binaryNumber == null ||
                binaryNumber.equals("") ||
                binaryNumber.replaceAll("[" + binSymbols + "]", "").length() != 0) {
            return "";
        }
        StringBuilder hexNumber = new StringBuilder();
        if (binaryNumber.length() % 4 != 0) {
            binaryNumber = "0".repeat(4 - binaryNumber.length() % 4) + binaryNumber;
        }
        for (int i = 0; i < binaryNumber.length(); i += 4) {
            String str = binaryNumber.substring(i, i + 4);
            hexNumber.append(getHexSymbolByBin(str));
        }
        return hexNumber.toString();
    }

    public static String toBinary(String hexNumber) {
        //напишите тут ваш код
        if (hexNumber == null ||
                hexNumber.equals("") ||
                hexNumber.replaceAll("[" + hexSymbols + "]", "").length() != 0) {
            return "";
        }
        StringBuilder binaryNumber = new StringBuilder();
        for (int i = 0; i < hexNumber.length(); i++) {
            binaryNumber.append(getBinSymbolByHex(Character.toString(hexNumber.charAt(i))));
        }
        return binaryNumber.toString();
    }

    private static String getBinSymbolByHex(String hexSymbol) {
        return hexArray[hexSymbols.indexOf(hexSymbol)];
    }

    private static String getHexSymbolByBin(String binSymbol) {
        String hexSymbol = "";
        for (int i = 0; i < hexArray.length; i++) {
            if (hexArray[i].equals(binSymbol)){
                hexSymbol = hexSymbols.substring(i, i+1);
            }
        }
        return hexSymbol;
    }
}
