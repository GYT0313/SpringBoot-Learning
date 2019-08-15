package com.gyt;

public class AddableDemo {
    public static void main(String[] args) {
        useAddable((int x, int y) -> {
            return x + y;
        });
    }

    private static void useAddable(Addable addable) {
        int add = addable.add(10, 20);
        System.out.println(add);
    }
}
