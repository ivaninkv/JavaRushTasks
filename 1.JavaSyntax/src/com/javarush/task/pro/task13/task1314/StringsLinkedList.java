package com.javarush.task.pro.task13.task1314;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void add(String value) {
        if (first.next == null) {
            Node node = new Node();
            node.value = value;
            first.next = node;
        }
        if (last.prev == null) {
            last.prev = first.next;
            return;
        }

        Node node = new Node();
        node.value = value;

        Node lastNode = last.prev;
        lastNode.next = node;
        node.prev = lastNode;
        last.prev = node;
    }

    public String get(int index) {
        //напишите тут ваш код
        int i = 0;
        Node node = first.next;
        while (i <= index) {
            if (i == index) {
                return node.value;
            }
            node = node.next;
            if (node == null) {
                break;
            }
            i++;
        }

        return null;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
