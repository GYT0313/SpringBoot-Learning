package com.gyt3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?>  c = Class.forName("com.gyt3.Student");

//        Field[] fields = c.getFields();

        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("--------");

        Field address = c.getField("address");
        System.out.println(address);
        Field name = c.getDeclaredField("name");
        System.out.println(name);

        Constructor<?> constructor = c.getConstructor();
        Object o = constructor.newInstance();
        address.set(o, "西安");
        System.out.println(o);


    }
}
