package com.hieblmi.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumKSubSequence {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(9, 2, 3, 1, 15, 6, 7));
        System.out.println(maxKSum(numbers, 3));
    }

    private static int maxKSum(List<Integer> numbers, int k) {

        return maxKSumRec(new ArrayList<>(), k, numbers);
    }

    private static int maxKSumRec(List<Integer> prefix, int k, List<Integer> suffix) {

        if (prefix.size() == k) {
            System.out.println(prefix.toString());
            return prefix.stream().mapToInt(i -> i.intValue()).sum();
        } else {
            int current = Integer.MIN_VALUE;
            for (int i = 0; i < suffix.size(); i++) {
                prefix.add(suffix.get(i));
                suffix.remove(i);
                int tmp = maxKSumRec(prefix, k, suffix);
                suffix.add(i, prefix.remove(prefix.size()-1));
                if(tmp > current) {
                    current = tmp;
                }
            }
            return current;
        }
    }


}
