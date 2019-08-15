package com.gyt;

import java.io.*;

public class ObjectStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io\\oos.txt"));
//        Student s = new Student("李小龙", 15);
//        oos.writeObject(s);
//        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io\\oos.txt"));
        Object o = ois.readObject();
        System.out.println(o);
        ois.close();
    }
}
