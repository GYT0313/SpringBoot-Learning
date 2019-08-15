package com.gyt;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\CompanyProject\\jindouyun");
        getAllFile(file);
    }

    public static void getAllFile(File file) {
        File[] files = file.listFiles();
        if(files != null) {
            for (File f : files) {
                if(f.isDirectory()) {
                    getAllFile(f);
                } else {
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }
}
