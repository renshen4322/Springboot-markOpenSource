package com.mark.bean.design.FlyweightPattern;

import java.util.Hashtable;

/**
 * 共享单车工厂
 */
public class BikeFactory {

    private Hashtable<String, Bike> hashtable = new Hashtable<String, Bike>(); //享元池

    public Bike getBike(String key) {
        if (!hashtable.contains(key)) {
            ConcreteBike concreteBike = new ConcreteBike(key);
            hashtable.put(key, concreteBike);
            return concreteBike;
        } else {
            return hashtable.get(key);
        }
    }

    public int getBikeCount() {
        return hashtable.size();
    }
}
