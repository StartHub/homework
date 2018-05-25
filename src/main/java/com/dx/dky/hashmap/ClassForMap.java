package com.dx.dky.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class ClassForMap {

    public static void main(String[] args) {
        System.out.println();

        Map map = new HashMap();

        for (int i = 0; i < 80; i++) {
            map.put(i, i);
        }

        System.out.println(map.size());

        Iterator iterator = map.entrySet().iterator();
        if(iterator.hasNext()){
            System.out.println(iterator);
        }
    }



}
