package com.hailm.chuongtrinhtinh;

public abstract class So {
    protected int soA;
    protected int soB;

    public void nhapTT(int gtriSoA, int gtriSoB) {
        soA = gtriSoA;
        soB = gtriSoB;
    }
    
    public abstract void inKQ();
}
