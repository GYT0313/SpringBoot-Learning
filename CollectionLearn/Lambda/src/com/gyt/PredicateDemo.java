package com.gyt;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        boolean hello = checkString("hello", s -> s.length() > 8);
        System.out.println(hello);
    }

    private static boolean checkString(String s, Predicate<String> pre) {
//        return pre.test(s);
        return pre.negate().test(s);
    }
}
