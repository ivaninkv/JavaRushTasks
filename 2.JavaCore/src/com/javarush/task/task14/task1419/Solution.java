package com.javarush.task.task14.task1419;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        // 2
        try {
            int[] myArray = null;
            System.out.println(myArray[1]);
        } catch (Exception e) {
            exceptions.add(e);
        }

        // 3
        try {
            int[] myArray = new int[1];
            System.out.println(myArray[1]);
        } catch (Exception e) {
            exceptions.add(e);
        }

        // 4
        try {
            String s = "str";
            System.out.println(s.charAt(100));
        } catch (Exception e) {
            exceptions.add(e);
        }

        // 5
        try {
            Object i = Integer.valueOf(42);
            String s = (String) i;
        } catch (Exception e) {
            exceptions.add(e);
        }

        // 6
        try {
            File infile = new File("notExistsFile.txt");
            Scanner inputFile = new Scanner (infile);
        } catch (Exception e) {
            exceptions.add(e);
        }

        // 7
        try {
            Integer.parseInt("null") ;
        } catch (Exception e) {
            exceptions.add(e);
        }

        // 8
        try {
            throw new NoSuchMethodException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        // 9
        try {
            throw new NegativeArraySizeException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        // 10
        try {
            throw new ClassNotFoundException();
        } catch (Exception e) {
            exceptions.add(e);
        }

    }
}
