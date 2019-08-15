package com.gyt;

public class EatableDemo {
    public static void main(String[] args) {
        Etable e = new EatableImpl();
        useEatable(e);

        useEatable(new Etable() {
            @Override
            public void eat() {
                System.out.println("一天一香蕉");
            }
        });

        useEatable(() -> {
            System.out.println("一天一梨子");
        });
    }

    private static void useEatable(Etable e) {
        e.eat();
    }
}
