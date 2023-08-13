package com.mark.bean.design.Decorator3Pattern;

public class Client {
    public static void main(String[] args) {

        DQ icecream = new IceCream(); //无参，被装饰对象
        Decorator cookies = new Cookies();
        Decorator blueBerry = new BlueBerry();
        Decorator chocolateChip = new ChocolateChip();
        //装饰动作
        cookies.setComponent(icecream);
        blueBerry.setComponent(cookies);
        chocolateChip.setComponent(blueBerry);
        //调用抽象方法，面向对象编程
        chocolateChip.operation();
    }
}
