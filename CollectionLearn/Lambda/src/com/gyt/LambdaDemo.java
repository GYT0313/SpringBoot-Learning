package com.gyt;

public class LambdaDemo {
    public static void main(String[] args) {
//        new Thread(new MyRunnable()).start();

        // 匿名类
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("多线程");
//            }
//        }).start();

        new Thread( () -> {
            System.out.println("多线程");
        } ).start();

    }
}
