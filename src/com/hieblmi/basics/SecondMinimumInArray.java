package com.hieblmi.basics;

public class SecondMinimumInArray {

    public static void main(String[] args) {
        int[] a = {5,3,4,1,7};

        int min = Integer.MAX_VALUE-1;
        int min2 = Integer.MAX_VALUE;

        for(int i=0; i<a.length; i++) {
            if(a[i]<min) {
                min2 = min;
                min = a[i];
            }
        }

        System.out.println(min2);
    }
}
