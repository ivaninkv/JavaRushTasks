package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1984, Calendar.OCTOBER, 3);
    private static final String[] dayOfWeek = {"Воскресенье", "Понедельник", "Вторник", "Среда",
            "Четверг", "Пятница", "Суббота"};

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        //напишите тут ваш код
        return dayOfWeek[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }
}
