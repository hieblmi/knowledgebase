package com.hieblmi.basics;

import java.util.Arrays;

public class SortArrays {
    public static void main(String[] args) {

        int[] a = {1, 2};
        int[] b = {2, 3};
        int[] c = {3, 5};
        int[] d = new int[a.length + b.length + c.length];

        int i,j,k,l;

        i=j=k=l=0;

        for(;l<d.length; l++) {

            // check for end. if not use...

            int min = Math.min(Math.min(a[i], b[j]), c[k]);
            if(a[i] == min) i++;
            if(b[j] == min) j++;
            if(c[k] == min) k++;
            d[l] = min;
        }

        System.out.printf(Arrays.toString(d));

    }
}
