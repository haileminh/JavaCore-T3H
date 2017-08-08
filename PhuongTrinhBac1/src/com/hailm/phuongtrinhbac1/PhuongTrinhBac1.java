package com.hailm.phuongtrinhbac1;

public class PhuongTrinhBac1 {
    private double soA, soB, x;

    public void nhapTT(double gTriSoA, double gTriSoB) {
        // gan gia tri cho 2 so A, B
        soA = gTriSoA;
        soB = gTriSoB;
    }

    public void tinhX() {
        // Tinh x
        x = -soB / soA;
       
    }

    public void inKetQua() {
        // in ket qua
        System.out.println("Phuong trinh co nghiem x = " + x);
    }
}
