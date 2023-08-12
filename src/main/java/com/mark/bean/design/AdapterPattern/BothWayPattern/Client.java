package com.mark.bean.design.AdapterPattern.BothWayPattern;

public class Client {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.setCat(new ConcreteCat());
        adapter.setDog(new ConcreteDog());

        System.out.println("猫学狗");
        adapter.catchMouse();

        System.out.println("==============");
        System.out.println("狗学猫");
        adapter.gnawBone();
    }
}
