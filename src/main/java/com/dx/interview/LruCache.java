package com.dx.interview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author dx
 * @Date 2021/1/8 19:21
 * @Description TODO 基于LinkedHashMap实现LRU LinkedHashMap默认按插入顺序排序，可按照访问顺序排序实现LRU
 */
public class LruCache extends LinkedHashMap {

    /**
     * LRU中最大元素数量
     */
    private int maxSize;

    /**
     * 构造器
     * 1. 根据LRU中的最大值计算初始元素数量
     * 2. 设置为true 按照元素访问顺序排序
     */
    public LruCache(int maxSize){
        super((int)Math.ceil(maxSize/0.75) + 1, 0.75f, true);
        this.maxSize = maxSize;
    }

    /**
     * 重写 removeEldestEntry 方法 【核心】
     * 钩子方法 当put的时候调用此方法
     * 当size大于最大容量时开始删除最久未访问的数据
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxSize;
    }

    public static void main(String[] args) {
        System.out.println(5/2);
    }
}
