package com.hailm.quanlyuser;

public class Account {
    private String maTK, matKhau;

    public Account(String maTK, String matKhau) {
        this.maTK = maTK;
        this.matKhau = matKhau;
    }

    public String getMaTK() {
        return maTK;
    }

    public String getMatKhau() {
        return matKhau;
    }
}
