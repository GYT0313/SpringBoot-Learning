package com.gyt2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        // 获取class对象
        Class<?> c = Class.forName("com.gyt2.Student");

        // 获取三个参数的构造方法
        Constructor<?> constructor = c.getConstructor(String.class, int.class, String.class);
        Object o = constructor.newInstance("林青霞", 20, "西安");
        System.out.println(o);

        // 获取一个参数的构造方法
        Constructor<?> declaredConstructor = c.getDeclaredConstructor(String.class);

        // 暴力反射  cannot access a member of class com.gyt2.Student with modifiers "private"
        declaredConstructor.setAccessible(true);

        Object instance = declaredConstructor.newInstance("林青霞");
        System.out.println(instance);
    }
}
