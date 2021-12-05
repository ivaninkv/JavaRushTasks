package com.javarush.task.task16.task1632;

public class HurrahThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Ура");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
