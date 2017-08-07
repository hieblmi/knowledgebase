package com.hieblmi.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortArrays {
    public static void main(String[] args) {

        List<Integer> a = new LinkedList<>(Arrays.asList(1, 2));
        List<Integer> b =  new LinkedList<>(Arrays.asList(2, 3));
        List<Integer> c =  new LinkedList<Integer>(Arrays.asList(3, 4));
        List<Integer> d =  new ArrayList<Integer>();

        for(int i=0;i<a.size()+b.size(); i++) {
            int min = a.get(0) < b.get(0) ? a.remove(0) : b.remove(0);
            d.add(min);
        }

        for(int i=0, c_i=0; i<d.size(); i++) {
            if(d.get(i) > c.get(c_i)) {
                d.add(i, c.remove(c_i));
            }
        }

        if(c.size() > 0) {
            d.addAll(c);
        }

        System.out.printf(d.toString());
    }
}
