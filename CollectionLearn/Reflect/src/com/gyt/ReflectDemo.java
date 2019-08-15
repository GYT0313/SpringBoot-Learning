package com.gyt;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.
        Class<Student> c1 = Student.class;
        System.out.println(c1);

        Class<Student> c2 = Student.class;
        System.out.println(c1 == c2);
        System.out.println("-------");

        // 2.
        Student s = new Student();
        Class<? extends Student> c3 = s.getClass();
        System.out.println(c1 == c3);
        System.out.println("-------");

        // 3.
        Class<?> c4 = Class.forName("com.gyt.Student");
        System.out.println(c1 == c4);

    }
}
