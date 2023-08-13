package com.mark.bean.design.Decorator2Parttern;

/**
 * //装饰基类
 */
public abstract class Decorator extends Order {

    private Order order;//聚合


    public Decorator(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

   public String getDes(){
        return super.getDes()+" "+getPrice()+" && "+order.getDes();
   }




}
