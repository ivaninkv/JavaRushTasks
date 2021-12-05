package com.javarush.task.task16.task1632;

public class InterruptedThread extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}
