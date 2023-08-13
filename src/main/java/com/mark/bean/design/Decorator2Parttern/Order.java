package com.mark.bean.design.Decorator2Parttern;

public abstract class Order { //订单作为抽象构件

    private String des; //订单描述

    private float price; //订单单价

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract  float cost(); //抽象方法：计算费用

}
