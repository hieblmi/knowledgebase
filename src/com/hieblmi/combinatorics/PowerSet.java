package com.hieblmi.combinatorics;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("abcd".split("")));
        printSets(list);
    }

    private static void printSets(List<String> list) {
        int powerSetSize = (int) Math.pow(2, list.size());

        for(int i=0; i<powerSetSize; i++) {
            System.out.print("{");
            for(int j=0; j<list.size(); j++) {
                if((i & (1<<j)) > 0) {
                    System.out.print(list.get(j));
                }
            }
            System.out.println("}");
        }
    }
}
