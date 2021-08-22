package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        //напишите тут ваш код
        grades.put("Вася", 4.0);
        grades.put("Петя", 4.1);
        grades.put("Миша", 4.2);
        grades.put("Саша", 4.3);
        grades.put("Коля", 4.4);
    }
}
