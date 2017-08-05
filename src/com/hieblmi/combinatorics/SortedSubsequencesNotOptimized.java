package com.hieblmi.combinatorics;

import java.util.*;

public class SortedSubsequencesNotOptimized {

    public static void main(String[] args) {
        String subSequence = getMaxSubSequences("banana", 2);

        System.out.println(subSequence);
    }

    private static String getMaxSubSequences(String s, int k) {

        int numberOfSequences = (int) Math.pow(2, s.length());
        String t = "";
        StringBuilder subSequence;
        Map<Character, Integer> counts;

        for (int i = 0; i < numberOfSequences; i++) {
            subSequence = new StringBuilder();
            counts = new HashMap<>();
            for (int j = 0; j < s.length(); j++) {
                if ((i & (1 << j)) > 0) {
                    if (updateCharacterCount(counts, s.charAt(j), k)) {
                        subSequence.append(s.charAt(j));
                    } else {
                        subSequence.delete(0, subSequence.length());
                        break;
                    }
                }
            }
            String ss = subSequence.toString();
            if ((ss.compareTo(t) > 0 || t.equals("")) && isCharacterCountOk(counts, k)) {

                t = ss;
            }

        }

        return t;
    }

    private static boolean updateCharacterCount(Map<Character, Integer> counts, char c, int k) {
        Integer i = counts.get(c);
        if (i == null) {
            counts.put(c, 1);
            return true;
        } else if (i > k) {
            return false;
        } else {
            counts.put(c, i + 1);
            return true;
        }
    }

    private static boolean isCharacterCountOk(Map<Character, Integer> counts, int k) {

        for (Character c:
             counts.keySet()) {
            if(counts.get(c) < k) {
                return false;
            }
        }

        return true;
    }
}
