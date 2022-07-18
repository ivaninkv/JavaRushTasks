package com.javarush.task.task17.task1714;

/*
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach b1 = new Beach("Beach1", 10, 5);
        Beach b2 = new Beach("Beach2", 11, 5);
        System.out.println(b1.compareTo(b2));
    }

    @Override
    public synchronized int compareTo(Beach o) {
        int result = 0;
        float deltaDistance = this.getDistance() - o.getDistance();
        if (deltaDistance > 0) {
            result--;
        } else if (deltaDistance < 0) {
            result++;
        }

        int deltaQuality = this.getQuality() - o.getQuality();
        if (deltaQuality > 0) {
            result++;
        } else if (deltaQuality < 0) {
            result--;

        }

        return result;
    }
}
