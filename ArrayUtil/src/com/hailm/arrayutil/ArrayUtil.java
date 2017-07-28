package com.hailm.arrayutil;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtil {
    private int array[];
    private int n;
    Random rd;

    public ArrayUtil(int n) {
        this.n = n;
        rd = new Random();
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rd.nextInt(50);
        }
    }

    public void printArrUtil() {
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    public void findTriangle() {
        System.out.println("Bộ ba điểm hợp thành 1 tam giác là: ");
        for (int i = 0; i < array.length - 2; i++) {
            int a = array[i];
            int b = array[i + 1];
            int c = array[i + 2];
            
            if ((a + b) > c && (a + c) >b  && (b  + c ) > a) {
                System.out.println("_ "+a + "," + b + "," + c);
            }
        }
    }
    
    public int findSecondSmallestElement(){
        System.out.print("Số nhỏ thứ 2 của dãy là: ");
        Arrays.sort(array);
        int secondMin = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[i + 1]) {
                secondMin = array[i + 1];
                break;
            }
        }
        
        return secondMin;
    }

}
