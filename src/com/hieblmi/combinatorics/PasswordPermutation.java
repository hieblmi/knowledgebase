package com.hieblmi.combinatorics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by michi on 8/3/17.
 */
public class PasswordPermutation {

    private static Map<Character, Character> map;
    private static PasswordPermutation p = new PasswordPermutation();

    PasswordPermutation() {
        map = new HashMap<Character, Character>();
        map.put('a', '@');
        map.put('e', '3');
        map.put('i', '1');
        map.put('o', '0');
        map.put('u', 'V');
    }

    public static void main(String[] args) {
        p.printPasswordPermutations("", "password", 0, false);
    }

    private static void printPasswordPermutations(String prefix, String password, int currentPosition, boolean isObfuscated) {

        if (prefix.length() == password.length()) {
            if (isObfuscated) {
                System.out.println(prefix);
            }
        } else {
            Character c = password.charAt(currentPosition);
            if (map.keySet().contains(c)) {
                printPasswordPermutations(prefix + map.get(c), password, currentPosition + 1, true);
            }
            printPasswordPermutations(prefix + c, password, currentPosition + 1, isObfuscated);
        }
    }
}
