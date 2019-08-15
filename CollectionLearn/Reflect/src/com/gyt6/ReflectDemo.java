package com.gyt6;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("com.gyt3.Student");

        Constructor<?> constructor = c.getConstructor();
        Object o = constructor.newInstance();

        Method method1 = c.getMethod("method1");
        method1.invoke(o);

        Method method2 = c.getMethod("method2", String.class);
        method2.invoke(o, "林青霞");

        Method method3 = c.getMethod("method3", String.class, int.class);
        Object o1 = method3.invoke(o, "林青霞", 30);
        System.out.println(o1);

//        Method function = c.getMethod("function");
        Method function = c.getDeclaredMethod("function");
        function.setAccessible(true);
        function.invoke(o);


    }
}
