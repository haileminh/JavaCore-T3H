package com.hailm.filemanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Comparator;

import javax.xml.crypto.Data;

public class FileManager {
    File fileSrc;

    private Comparator<File> sortDownByNameAndSize = new Comparator<File>() {

        @Override
        public int compare(File file1, File file2) {
            int result = file1.getName().compareTo(file2.getName());
            if (result == 0) {
                result = (int) (file1.length() - file2.length());
            }
            return result;
        }
    };

    public FileManager(String pathSrc) {
        fileSrc = new File(pathSrc);
    }

    public void findByExtension(String extension) {
        System.out.println(
                "Danh sách các file có đuôi mở rộng " + extension + ": ");
        try {
            File subFile[] = fileSrc.listFiles();
            for (int i = 0; i < subFile.length; i++) {
                if (subFile[i].isFile()
                        && subFile[i].getName().contains(extension)) {
                    System.out.println(subFile[i].toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sortByNameSize() {
        System.out.println();
        System.out.println("Danh sách đã được sắp xếp theo tên và kích thước.");
        File subFile[] = fileSrc.listFiles();
        Arrays.sort(subFile, sortDownByNameAndSize);
        for (int i = 0; i < subFile.length; i++) {
            System.out.println(subFile[i].getName());
        }
    }

    public void listAllFiles() {
        System.out.println();
        System.out.println("Thông tin file: ");
        File subFile[] = fileSrc.listFiles();
        for (int i = 0; i < subFile.length; i++) {
            if (subFile[i].isFile()) {
                System.out.println("Tên file: " + subFile[i].getName() + "-"
                        + subFile[i].getPath() + "-" + subFile.length / 1024F
                        + "KB");
            }
        }
    }

    public void readFile() {
        System.out.println("ĐỌc file");
        try {
            int data;
            FileInputStream fIn = new FileInputStream(fileSrc + "/abc.text");
            data = fIn.read();
            while (data > 0) {
                char kyTu = (char) data;
                System.out.println("Data: " + kyTu);
                data = fIn.read();
            }
            // do {
            // data = fIn.read();
            // System.out.println("Data: " + data);
            // } while (data > 0);

            fIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile2() {
        System.out.println("Đọc file 2:");
        try {
            FileInputStream fIn = new FileInputStream(fileSrc + "/abc.text");
            byte buff[] = new byte[1024];
            int lenght = fIn.read();

            while (lenght > 0) {
                String text = new String(buff, 0, lenght);
                System.out.println(text);
                lenght = fIn.read(buff);
            }
            fIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String text, boolean isAppend) {
        try {
            FileOutputStream fOut = new FileOutputStream(fileSrc + "/abc.text",
                    isAppend);

            for (int i = 0; i < text.length(); i++) {
                char kyTu = text.charAt(i);
                int data = (int) kyTu;
                fOut.write(data);
            }
            fOut.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void writeFile2(String text, boolean isAppend) {
        try {
            FileOutputStream fOut = new FileOutputStream(fileSrc + "/abc.text",
                    isAppend);
            // Ghi file
            byte buff[] = text.getBytes();

            fOut.write(buff);
            // Dong file
            fOut.close();
            System.out.println("Đã ghi xong file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void copyFile(String pathSrc, String pathDest) {
        File fileSrc = new File(pathSrc);

        if (fileSrc.exists() == false) {
            return;
        }

        new File(pathDest).mkdirs();

        pathDest = pathDest + "/" + fileSrc.getName();
        File fileDest = new File(pathDest);

        try {
            FileInputStream fIn = new FileInputStream(fileSrc);
            FileOutputStream fOut = new FileOutputStream(fileDest);
            
            byte buff[] = new byte[1024];
            int length = fIn.read(buff);
            while (length > 0) {
                fOut.write(buff, 0, length);
                length = fIn.read(buff);
            }
            fIn.close();
            fOut.close();
            System.out.println("Copy file thanh cong ");
                    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void downloadFile(String link, String pathDest){
        try {
            URLConnection conn = new URL(link).openConnection();
            InputStream input =conn.getInputStream();
            new File(pathDest).mkdirs();
            
            String fileName = link.substring(link.lastIndexOf("/") + 1);
            pathDest = pathDest + "/" + fileName;
            
            File fileDest = new File(pathDest);
            
            FileOutputStream fOut = new FileOutputStream(fileDest);
            byte buff[] = new byte[1024];
            
            int length = input.read(buff);
            while (length > 0) {
                fOut.write(buff, 0, length);
                length = input.read(buff);
            }
            input.close();
            fOut.close();
            System.out.println("Dowload file thanh cong ");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
