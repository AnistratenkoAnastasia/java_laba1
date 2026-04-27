package com.example;


public class App {
    public static void main(String[] args) {
        Container container = new Container();

        container.add(10);
        container.add(20);
        container.add(30);

        for (int i=1;i<4;++i)
            System.out.println(container.getInOrder(i));

        container.add(20);
        container.deleteLastByValue(20);

        System.out.println();
        for (int i=1;i<4;++i)
            System.out.println(container.getInOrder(i));

        container.clear();
    }
}
