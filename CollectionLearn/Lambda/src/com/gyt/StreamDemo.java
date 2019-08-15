package com.gyt;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");
        
        ArrayList<String> newList = new ArrayList<>();
        
        for (String s : list) {
            if (s.startsWith("张")) {
                newList.add(s);
            }
        }

        System.out.println(newList);

        ArrayList<String> newList2 = new ArrayList<>();

        for (String s : newList) {
            if (s.length() >= 3) {
                newList2.add(s);
            }
        }

        System.out.println(newList2);

        System.out.println("---------");

        // Stream
//        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(s -> System.out.println(s));

        list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .forEach(System.out::println);

        int sum = Stream.of("10", "20", "30").mapToInt(Integer::parseInt).sum();
        System.out.println(sum);
    }

}
