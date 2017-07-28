package com.hailm.arrayutil.main;

import com.hailm.arrayutil.ArrayUtil;

public class Main {
    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil(10);
        
        arrayUtil.printArrUtil();
        arrayUtil.findTriangle();
        
       System.out.println(arrayUtil.findSecondSmallestElement());
    }
}
