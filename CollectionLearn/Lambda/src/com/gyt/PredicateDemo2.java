package com.gyt;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateDemo2 {
    public static void main(String[] args) {
        String[] arr = {"林青霞,30", "柳岩,34", "张曼玉,33", "王祖贤,37", "貂蝉,31"};
        ArrayList<String> arrayList = new ArrayList<>();
        for (String person : arr) {
            if (use(person, s -> s.split(",")[0].length() > 2,
                    s -> Integer.parseInt(s.split(",")[1]) >= 33)) {
                arrayList.add(person);
            }
        }

        for (String p : arrayList) {
            System.out.println(p);
        }

    }

    private static boolean use(String s, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.and(pre2).test(s);
    }
}
