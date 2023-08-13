package com.mark.bean.design.FlyweightPattern;

/**
 * 具体享元角色
 */
public class ConcreteBike extends Bike {

    private String name;//单车名称

    public ConcreteBike(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void use(User user) {
        System.out.println(user.getName() + "骑走了" + name + "单车");
    }
}
