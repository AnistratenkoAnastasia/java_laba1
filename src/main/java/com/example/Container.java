package com.example;

public class Container {
    static class Node {
        private int data;
        private Node next;
    }
    private Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(int x) {
        Node node = new Node();
        node.data = x;
        node.next = head;
        head = node;
    }

    public Integer getInOrder(int n) {
        if (n <= 0) return null;
        if (isEmpty()) return null;
        
        Node node = head;
        for (int i=1;i<n;++i) {
            if (node.next == null)
                return null;
            node = node.next;
        }
        return node.data;
    }

    public void deleteFirstByValue(int x) {
        if (!isEmpty()) {
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
    }

    public void deleteLastByValue(int x) {
        if (!isEmpty()) {
            Node node = head;
            Node delNode = null;
            while (node.next != null) {
                if (node.next.data == x)
                    delNode = node;
                node = node.next;
            }
            if (delNode != null)
                delNode.next = delNode.next.next;
        }
    }

    public void deleteAllByValue(int x) {
        if (!isEmpty()) {
            while (head != null && head.data == x)
                head = head.next;

            Node node = head;
            while (node.next != null) {
                if (node.next.data == x)
                    node.next = node.next.next;
                node = node.next;
            }
        }
    }

    public void deleteInOrder(int n) {
        if (!isEmpty()) {
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

    public void clear() {
        head = null;
    }
}
