package com.hieblmi.basics;

public class ReverseStringWordByWord {

    private static final String s = "This is a string";

    public static void main(String args[]) {
        System.out.println(reverse(s));
    }

    private static String reverse(String s) {
        String[] sa = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=sa.length-1; i>=0; i--) {
            sb.append(sa[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
