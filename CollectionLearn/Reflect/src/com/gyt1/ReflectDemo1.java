package com.gyt1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 获取class对象
        Class<?> c = Class.forName("com.gyt1.Student");
//        Constructor<?>[] constructors = c.getConstructors();
        Constructor<?>[] constructors = c.getDeclaredConstructors();
        for (Constructor con : constructors) {
            System.out.println(con);
        }
        System.out.println("---------");

        Constructor<?> con = c.getConstructor();
        Student s = (Student) con.newInstance();
        System.out.println(s);
    }
}
