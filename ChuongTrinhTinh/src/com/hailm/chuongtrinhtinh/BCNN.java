package com.hailm.chuongtrinhtinh;

public class BCNN extends So{
    private int ketQua;
    private UCLN ucln;
  
    public void timBCNN(){
        ucln = new UCLN();
        ucln.nhapTT(soA, soB);
        ketQua = (soA * soB ) /(ucln.timUCLN());
    }
    
    @Override
    public void inKQ() {
       System.out.println("Boi chung nho nhat: " + ketQua);
    }
}
