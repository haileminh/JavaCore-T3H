package com.hailm.chuongtrinhtinh;

public class UCLN extends So{
    
    public int timUCLN() {
        while (soA != soB) {
            if (soA > soB)
                soA -= soB;
            else
                soB -= soA;
        }
        return soA;
    }

    @Override
    public void inKQ() {
       System.out.println("Uoc chung lon nhat: " + soA);
    }
    
    
   
}
