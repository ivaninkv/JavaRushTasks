package com.javarush.task.task16.task1632;

import java.util.Scanner;

public class SumInputThread extends Thread {
    @Override
    public void run() {
        Scanner console = new Scanner(System.in);
        String line;
        int sum = 0;
        while (!(line = console.nextLine()).equals("N")) {
            int number = 0;
            try {
                number = Integer.parseInt(line);
            } catch (Exception e) {

            }
            sum += number;
        }
        System.out.println(sum);
    }
}
