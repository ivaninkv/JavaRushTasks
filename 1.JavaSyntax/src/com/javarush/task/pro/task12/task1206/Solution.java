package com.javarush.task.pro.task12.task1206;

/* 
Анализ строк
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Думаю, это будет новой фичей." +
                "Только не говорите никому, что она возникла случайно.";

        System.out.println("Количество цифр в строке : " + countDigits(string));
        System.out.println("Количество букв в строке : " + countLetters(string));
        System.out.println("Количество пробелов в строке : " + countSpaces(string));
    }

    public static int countDigits(String string) {
        //напишите тут ваш код
        int countDigits = 0;
        for (int i = 0; i < string.length(); i++) {
            countDigits += Character.isDigit(string.charAt(i)) ? 1 : 0;
        }
        return countDigits;
    }

    public static int countLetters(String string) {
        //напишите тут ваш код
        int countLetters = 0;
        for (int i = 0; i < string.length(); i++) {
            countLetters += Character.isLetter(string.charAt(i)) ? 1 : 0;
        }
        return countLetters;
    }

    public static int countSpaces(String string) {
        //напишите тут ваш код
        int countSpaces = 0;
        for (int i = 0; i < string.length(); i++) {
            countSpaces += Character.isSpaceChar(string.charAt(i)) ? 1 : 0;
        }
        return countSpaces;
    }
}
