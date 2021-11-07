package com.javarush.task.task14.task1408;

/*
Куриная фабрика
*/

import static com.javarush.task.task14.task1408.Country.*;

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(BELARUS);
        hen.getCountOfEggsPerMonth();
        System.out.println(new BelarusianHen().getDescription());
        System.out.println(new RussianHen().getDescription());
        System.out.println(new MoldovanHen().getDescription());
        System.out.println(new UkrainianHen().getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            switch (country) {
                case BELARUS: return new BelarusianHen();
                case UKRAINE: return new UkrainianHen();
                case MOLDOVA: return new MoldovanHen();
                case RUSSIA: return new RussianHen();
            }
            return null;
        }
    }
}
