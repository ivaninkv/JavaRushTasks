package com.javarush.task.task16.task1632;

public class InfinityThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
