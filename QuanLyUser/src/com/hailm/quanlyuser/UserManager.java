package com.hailm.quanlyuser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserManager {
    File fileSrc;

    List<User> listUser;
    private Comparator<User> sortDownByName = new Comparator<User>() {
        
        @Override
        public int compare(User user1, User user2) {
            int result = user1.getTen().compareTo(user2.getTen());
            return result;
        }
    };

    public UserManager() {
        listUser = new ArrayList<>();
        new File("D:/ThuMuc").mkdirs();
        fileSrc = new File("D:/ThuMuc/user.txt");
        try {
            if (fileSrc.exists() == false) {
                fileSrc.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signUp(User user) {
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getTaiKhoan().getMaTK() == user.getTaiKhoan()
                    .getMaTK()) {
                System.out.println("Tài khoản đã tồn tại.");
                return;
            }
        }
        listUser.add(user);
        System.out.println("Đăng kí thành công.");
        capnhat();

    }

    public void signIn(String TK, String MK) {
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getTaiKhoan().getMaTK() == TK
                    && listUser.get(i).getTaiKhoan().getMatKhau() == MK) {
                System.out.println("Đăng nhập thành công.");
            } else {
                System.out.println("Tài khoản hoặc mật khẩu không chính xác.");
            }
        }
    }

    public void searchByName(String name) {
        System.out.println("Danh sách user theo tên: " + name);
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getTen() == name) {
                System.out.println(listUser.get(i).toString());
            } else {
                System.out.println("Không tìm được user:" + name);
            }
        }
    }

    public void deleteUser(String maTK) {
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getTaiKhoan().getMaTK() == maTK) {
                listUser.remove(i);
                System.out.println("Xóa thành công mã tài khoản: " + maTK);
                capnhat();
                return;
            }
        }
        System.out.println("Tài khoản cần xóa ko tồn tại.");
    }

    private void capnhat() {
        try {
            FileOutputStream fOut = new FileOutputStream(fileSrc);
            for (int i = 0; i < listUser.size(); i++) {
                String text = listUser.get(i).toString();
                byte buff[] = text.getBytes();
                fOut.write(buff);
            }
            fOut.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void sortUser() {
        listUser.sort(sortDownByName);
        System.out.println(listUser.toString());
    }
}
