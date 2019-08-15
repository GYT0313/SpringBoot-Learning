package com.gyt;

public class BoxDemo {
    public static void main(String[] args) {
        Box box = new Box();

        Producer producer = new Producer(box);
        Consumer consumer = new Consumer(box);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}
