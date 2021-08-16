package com.javarush.task.pro.task09.task0915;

import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        String packagePath = "java.util.stream";
        String[] tokens = getTokens(packagePath, "\\.");
        System.out.println(Arrays.toString(tokens));
    }

    public static String[] getTokens(String query, String delimiter) {
        //напишите тут ваш код
//        String[] resultArray = new String[0];
        String[] resultArray = new String[6];
        int i = 0;
        StringTokenizer st = new StringTokenizer(query, delimiter);
        while (st.hasMoreTokens()) {
//            resultArray = Arrays.copyOf(resultArray, resultArray.length + 1);
//            resultArray[resultArray.length - 1] = st.nextToken();
            resultArray[i] = st.nextToken();
            i++;
        }
        return resultArray;
    }
}
