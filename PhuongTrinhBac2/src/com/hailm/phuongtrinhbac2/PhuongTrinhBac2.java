package com.hailm.phuongtrinhbac2;

public class PhuongTrinhBac2 {
    private double soA, soB, soC, delta, x1, x2;
    String cauTraLoi = "";

    public void nhapTT(double gTriSoA, double gTriSoB, double gTriSoC) {
        // Gan gia tri soA, soB, soC
        soA = gTriSoA;
        soB = gTriSoB;
        soC = gTriSoC;
    }

    public void tinhDelta() {
        // Tinh delta
        delta = soB * soB - 4 * soA * soC;
    }

    public void bienLuan() {
        // Bien luan
        if (soA == 0) {
            if (soB == 0) {
                if (soC == 0)
                    cauTraLoi = "Phuong trinh vo nghiem.";
                else
                    cauTraLoi = "Phuong trinh vo so nghiem.";

            } else
               x1 = x2 = (-soC / soB);
        } else {
            if (delta < 0)
                cauTraLoi = "Phuong trinh vo nghiem.";
            else if (delta > 0) {
                x1 = (-soB + Math.sqrt(delta)) / (2 * soA);
                x2 = (-soB - Math.sqrt(delta)) / (2 * soA);
            } else {
                System.out.println("Phuong trinh co nghiem kep x1= x2 ="
                        + (-soB / (2 * soA)));
            }
        }
    }

    public void inKetQua() {
        // in ket qua
        if (cauTraLoi != "") {
            System.out.println(cauTraLoi);
        }else {
            System.out.println("Phuong trinh co nghiem x1 = " + x1);
            System.out.println("Phuong trinh co nghiem x2 = " + x2);
        }
    }
}
