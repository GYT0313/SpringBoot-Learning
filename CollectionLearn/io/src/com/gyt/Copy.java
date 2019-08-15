package com.gyt;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author guyt
 * @version 1.0.0
 * @className: Copy
 * @description: 多级目录复制
 * 1、递归遍历源目录, 获取每个文件路径
 * 2、根据每个文件的路径创建目录
 * 3、根据文件路径复制文件
 * @date 2019/8/13
 */
public class Copy {
    // 源目录
    private static String source = "E:\\Spring\\commons-logging-1.2-bin";
    // 当前项目路径
    private static String obj = "io";


    /**
     * @return void
     * @method: getAllFile
     * @author guyt
     * @description: 遍历目录
     * @param[file]
     * @date 2019/8/13
     */
    private static void getAllFile(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    getAllFile(f);
                } else {
                    // E:\Spring\commons-logging-1.2-bin\commons-logging-1.2\apidocs\allclasses-frame.html
                    String sourceFilePath = f.getAbsolutePath();
                    StringBuilder relativePath = new StringBuilder();
                    // io\commons-logging-1.2\apidocs\allclasses-frame.html
                    relativePath.append(obj)
                            .append(sourceFilePath.split(source.replace("\\", "\\\\"))[1]);
                    // 复制文件
                    copyFile(sourceFilePath, relativePath.toString());
                }
            }
        }
    }

    /**
     * @return void
     * @method: copyFile
     * @author guyt
     * @description: 复制文件
     * @param[sourceFilePath, relativePath]
     * @date 2019/8/13
     */
    private static void copyFile(String sourceFilePath, String relativePath) {
        // io\commons-logging-1.2\apidocs\
        String directory = relativePath.substring(0, relativePath.lastIndexOf("\\"));
        // 创建目录
        makeDirectory(directory);

        // 字节缓冲流复制文件
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(sourceFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(relativePath));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return void
     * @method: makeDirectory
     * @author guyt
     * @description: 创建目录
     * @param[directory]
     * @date 2019/8/13
     */
    private static void makeDirectory(String directory) {
        File file = new File(directory);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // io\commons-logging-1.2-bin
        obj += source.substring(source.lastIndexOf("\\"));
        // 创建源目录的根目录
        makeDirectory(obj);
        // 递归创目录文件
        getAllFile(new File(source));
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + "ms");
    }
}
