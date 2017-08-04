package com.hieblmi.basics;

public class SetPermutation {

    public static void main(String[] args) {
        printPermutations("", "abc");
        printPermutations("", "abcd");
    }

    private static void printPermutations(String prefix, String set) {
        if(set.length() == 0) {
            System.out.println(prefix);
        } else {
            for(int i=0; i<set.length(); i++) {
                printPermutations(prefix + set.charAt(i), set.substring(0,i) + set.substring(i+1, set.length()));
            }
        }
    }
}
