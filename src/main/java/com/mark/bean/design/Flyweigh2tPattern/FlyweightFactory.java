package com.mark.bean.design.Flyweigh2tPattern;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory { //享元工厂，它的主要职责是创建对象

    private Map<String,FlyWeight> map = new HashMap<>();

    public FlyWeight getFlyweight(String key){
        FlyWeight flyWeight;
        if(map.get(key)!=null){
            return map.get(key);
        }else{
            if("UnShared".equals(key)){
                flyWeight = new UnSharedConcreteFlyweight(key);//非共享的享元对象
            }else{
                flyWeight = new ConcreteFlyweight(key); //共享的享元对象
            }
            map.put(key,flyWeight);
            return flyWeight;
        }
    }
}
