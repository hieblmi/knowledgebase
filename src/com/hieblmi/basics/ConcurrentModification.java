package com.hieblmi.basics;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModification {

    public static void main(String args[]) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        map.put(3,4);
        map.put(4,5);

        try {
            for (Integer i :
                    map.keySet()) {
                if (i == 2) {
                    map.remove(i);
                }
            }
        } catch(ConcurrentModificationException e) {
            System.out.println("Don't read and write on the same HashMap at the same time.");
        }

        map.put(2,3);

        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()) {
            int key = it.next();
            if(key == 2) {
                it.remove();
            }
            System.out.println(map.get(key));
        }

        return;
    }
}
