package com.gyt;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
//        myStore();
        myLoad();
    }

    private static void myLoad() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader("io\\fw.txt"));
        System.out.println(prop);
    }

    private static void myStore() throws IOException {
        Properties prop = new Properties();

        prop.setProperty("it01", "林青霞");
        prop.setProperty("it02", "张曼玉");
        prop.setProperty("it03", "王祖贤");

        FileWriter fw = new FileWriter("io\\fw.txt");
        prop.store(fw, null);
        fw.close();
    }

}
