package com.javarush.task.task16.task1632;

public class MessageThread extends Thread implements Message {
    @Override
    public void showWarning() {
        this.interrupt();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
        }
    }
}
