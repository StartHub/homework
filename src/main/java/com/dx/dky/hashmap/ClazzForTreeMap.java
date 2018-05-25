package com.dx.dky.hashmap;

import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap 排序
 *  默认按自然顺序的升序排序
 *  特殊需求可自定义比较器构造TreeMap进行排序
 *
 * @author : dengxu
 * @create 2018-04-11 9:29
 **/
public class ClazzForTreeMap {

    public static void main(String[] args) {

//        Map<String, String> map = new TreeMap<>(new Comparator<String>() {
//
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1); //用正负表示大小值
//            }
//        });
        //以上4行可用下面一行lambda表达式代替
        Map<String, String> map = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
        map.put("zdef", "rfgh");
        map.put("asrg", "zfg");
        map.put("rgd", "dfgh");
        map.put("cbf", "gddf");
        map.put("caf", "kddf");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + ",:value:" + entry.getValue());
        }
    }
}
