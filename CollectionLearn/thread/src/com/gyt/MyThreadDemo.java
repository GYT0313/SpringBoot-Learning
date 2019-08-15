package com.gyt;

public class MyThreadDemo {
    public static void main(String[] args) {
//        MyThread my1 = new MyThread();
//        MyThread my2 = new MyThread();
//        my1.setName("高铁");
//        my2.setName("飞机");

        MyThread my1 = new MyThread("公交");
        MyThread my2 = new MyThread("出租");
        MyThread my3 = new MyThread("飞机");

        my1.setPriority(9);
        my2.setPriority(8);

        System.out.println(my1.getPriority());
        System.out.println(my2.getPriority());
        System.out.println(my3.getPriority());

//        my1.start();
//        my2.start();
//        my3.start();
    }
}
