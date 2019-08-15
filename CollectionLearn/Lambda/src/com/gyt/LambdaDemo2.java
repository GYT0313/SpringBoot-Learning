package com.gyt;

public class LambdaDemo2 {
    public static void main(String[] args) {
        useAddable((int x, int y) -> {
            return x + y;
        });
        useAddable((x, y) -> {
            return x + y;
        });

        useFlyable((s) -> {
            System.out.println(s);
        });

        useFlyable(s -> {
            System.out.println(s);
        });

        useFlyable(s -> System.out.println(s));


        useAddable((x, y) -> x + y);

        useFlyable(System.out::println);
    }

    private static void useFlyable(Flyable f) {
        f.fly("晴天");
    }

    private static void useAddable(Addable a) {
        System.out.println(a.add(10, 20));
    }
}
