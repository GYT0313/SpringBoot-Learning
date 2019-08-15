package com.gyt;

public class MyRunnableDemo {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread t1 = new Thread(myRunnable, "高铁");
        Thread t2 = new Thread(myRunnable, "飞机");

        t1.start();
        t2.start();
    }
}