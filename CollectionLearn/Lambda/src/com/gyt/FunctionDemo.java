package com.gyt;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        use("100" , s -> Integer.parseInt(s));
        use("100", Integer::parseInt);
    }

    private static void use(String s, Function<String, Integer> fun) {
        System.out.println(fun.apply(s));
    }
}
