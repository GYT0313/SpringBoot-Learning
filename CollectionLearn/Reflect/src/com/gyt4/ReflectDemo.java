package com.gyt4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("com.gyt3.Student");

        Constructor<?> constructor = c.getConstructor();
        Object o = constructor.newInstance();

        Field name = c.getDeclaredField("name");
        Field age = c.getDeclaredField("age");
        Field address = c.getDeclaredField("address");

        name.setAccessible(true);
        age.setAccessible(true);
        address.setAccessible(true);

        name.set(o, "林青霞");
        age.set(o, 12);
        address.set(o, "西安");

        System.out.println(o);
    }
}
