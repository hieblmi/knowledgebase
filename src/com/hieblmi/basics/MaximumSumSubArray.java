package com.hieblmi.basics;

/**
 *    O(n)
 */

public class MaximumSumSubArray {

    private static int[] a = {-2,-3,4,-1,-2,1,5,-3};
    private static int[] b = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    public static void main(String args[]) {

        int currentMax = Integer.MIN_VALUE;
        int valueTillHere = 0;
        int k = 2;

        for(int i=0; i<b.length; i++) {
            valueTillHere = valueTillHere + b[i];
            if(valueTillHere > currentMax)
                currentMax = valueTillHere;
            if(valueTillHere < 0)
                valueTillHere = 0;
        }
        System.out.println(currentMax);
    }
}
