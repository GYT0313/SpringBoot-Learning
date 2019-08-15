package com.gyt7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(10);
//        arrayList.add(20);
//        arrayList.add(30);

        Class<? extends ArrayList> c = arrayList.getClass();
        Method add = c.getMethod("add", Object.class);
        add.invoke(arrayList, "hello");
        add.invoke(arrayList, "world");
        arrayList.add(10);

        System.out.println(arrayList);

    }
}
