package com.gyt;

public class FlyableDemo {
    public static void main(String[] args) {
        useFlyable(new Flyable() {
            @Override
            public void fly(String s) {
                System.out.println(s);
                System.out.println("飞机");
            }
        });

        useFlyable((String s) -> {
            System.out.println(s);
            System.out.println("火车");
        });
    }

    private static void useFlyable(Flyable f) {
        f.fly("风和日丽");
    }
}
