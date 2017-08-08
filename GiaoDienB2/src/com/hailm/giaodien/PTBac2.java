package com.hailm.giaodien;

public class PTBac2 {
    public static String giaiPTB2(int a, int b, int c) {
        String flag = "";
        int delta;
        delta = b * b - 4 * a * c;

        if (a == 0) {
            if (b == 0) {
                if (c == 0)
                    flag = "Phuong trinh vo nghiem.";
                else
                    flag = "Phuong trinh vo so nghiem.";

            } else

                flag = "Phuong trinh co nghiem kep: " + (-c / b);
        } else {
            if (delta < 0)
                flag = "Phuong trinh vo nghiem.";
            else if (delta > 0) {
                flag = "Phuong trinh co 2 nghiem \n x1: "
                        + (-b + Math.sqrt(delta)) / (2 * a) + "\n x2: "
                        + (-b - Math.sqrt(delta)) / (2 * a);
            } else {
                flag = "Phuong trinh co nghiem: " + (-b / (2 * a));
            }
        }
        return flag;
    }
}
