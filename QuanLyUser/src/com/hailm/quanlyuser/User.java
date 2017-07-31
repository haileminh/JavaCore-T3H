package com.hailm.quanlyuser;

public class User {
    private Account taiKhoan;

    private String ten, sdt;

    public User(Account taiKhoan, String ten, String sdt) {
        this.taiKhoan = taiKhoan;
        this.ten = ten;
        this.sdt = sdt;
    }

    public Account getTaiKhoan() {
        return taiKhoan;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }

    @Override
    public String toString() {
        return taiKhoan.getMaTK() + "-" + taiKhoan.getMatKhau() + "-" + ten + "-" + sdt;
    }

    
}
