package com.example;

public class Container {
    private static class Node {
        private int data;
        private Node next;
    }
    private Node head;

    public void add(int x) {
        Node node = new Node();
        node.data = x;
        node.next = head;
        head = node;
    }

    public Node getByValue(int x) {
        Node node = head;
        while (node != null) {
            if (node.data == x)
                return node;
            node = node.next;
        }
        return null;
    }

    public Node getInOrder(int n) {
        if (n <= 0) return null;
        Node node = head;
        for (int i=1;i<n;++i) {
            if (node != null) {
                node = node.next;
            }
            else return null;
        }
        return node;
    }

    public void deleteByValue(int x) {
        if (head.data == x)
            head = head.next;

        Node node = head;
        boolean flag = false;
        while (node.next != null && !flag) {
            if (node.next.data == x) {
                node.next = node.next.next;
                flag = true;
            }
            node = node.next;
        }
    }

    public void deleteInOrder(int n) {
        if (n>0) {
            if (n == 1)
                head = head.next;
            else {
                Node node = head;
                for (int i=1;i<n-1;++i) {
                    if (node.next != null)
                        node = node.next;
                    else node = null;
                }
                if (node != null)
                    node.next = node.next.next;
            }
        }
    }
}
