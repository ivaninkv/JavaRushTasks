package com.javarush.task.pro.task13.task1318;

/* 
Следующий месяц, пожалуйста
*/


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(getNextMonth(Month.JANUARY));
        System.out.println(getNextMonth(Month.JULY));
        System.out.println(getNextMonth(Month.DECEMBER));
    }

    public static Month getNextMonth(Month month) {
        //напишите тут ваш код
        List<Month> monthList = Arrays.asList(Month.values());
        Collections.rotate(monthList, -1);
        return monthList.get(month.ordinal());
    }
}
