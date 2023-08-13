package com.mark.bean.design.Decorator2Parttern;

/**
 *具体构件的子类，表示被装饰对象
 */
public class Coffee extends Order{

    public Coffee(){
        setPrice(5.0f);
        setDes("咖啡");
    }
    @Override
    public float cost() {
        return 5.0f;
    }
}
