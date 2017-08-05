package com.hailm.filemanager.main;

import com.hailm.filemanager.FileManager;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager("D:/ThuMuc/abc");
        fileManager.findByExtension("xlsx");
        fileManager.sortByNameSize();
        fileManager.listAllFiles();
//        fileManager.readFile();
        fileManager.readFile2();
        fileManager.writeFile("Lê Minh Hải", true);
        fileManager.writeFile2("Lê Minh Hải", true);
        fileManager.readFile2();
        fileManager.copyFile("D:/ThuMuc/abc/abc.text", "D:/ThuMuc/bcd");
        fileManager.downloadFile("http://www.baomoi.com/phong-canh-thien-nhien-the-gioi-dep-dieu-ki/c/20479915.epi", "D:/ThuMuc/bcd");
    }
}
