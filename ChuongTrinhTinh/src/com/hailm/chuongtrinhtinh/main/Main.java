package com.hailm.chuongtrinhtinh.main;

import com.hailm.chuongtrinhtinh.BCNN;
import com.hailm.chuongtrinhtinh.UCLN;

public class Main {
    public static void main(String[] args) {
        UCLN ucln = new UCLN();
        BCNN bcnn = new BCNN();
        ucln.nhapTT(12, 8);
        ucln.timUCLN();
        ucln.inKQ();

        bcnn.nhapTT(12, 8);
        bcnn.timBCNN();
        bcnn.inKQ();
    }
}
