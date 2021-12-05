package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;

/*
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new InfinityThread());
        threads.add(new InterruptedThread());
        threads.add(new HurrahThread());
        threads.add(new MessageThread());
        threads.add(new SumInputThread());
    }

    public static void main(String[] args) {
        for (Thread thread : threads) {
            thread.start();
        }

        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threads.get(1).interrupt();
        MessageThread message = (MessageThread) threads.get(3);
        System.out.println(message.isAlive());
        message.showWarning();
        System.out.println(message.isAlive());
        message.interrupt();
        System.out.println(message.isAlive());
    }
}
