package com.javarush.task.pro.task18.task1803;

import java.util.Comparator;

/* 
Наставники JavaRush
*/

public class NameComparator implements Comparator<JavaRushMentor> {
    //напишите тут ваш код
    @Override
    public int compare(JavaRushMentor javaRushMentor1, JavaRushMentor javaRushMentor2) {
        return javaRushMentor1.getName().length() - javaRushMentor2.getName().length();
    }
}
