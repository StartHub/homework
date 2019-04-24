package com.dx.dky.other.xiangyuan;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2019-03-26 16:12
 **/
public class FlyweightFactory {

    private Map<Object, Object> flyweights = new ConcurrentHashMap<>();

    public FlyweightFactory(){
        flyweights.put("A", new ConCreteFlyweight());
        flyweights.put("B", new ConCreteFlyweight());
        flyweights.put("C", new ConCreteFlyweight());
    }

    public Flyweight getFlyweight(String key){
        return (Flyweight) flyweights.get(key);
    }

}
