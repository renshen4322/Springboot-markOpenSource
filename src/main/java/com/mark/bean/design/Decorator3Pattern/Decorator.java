package com.mark.bean.design.Decorator3Pattern;

/**
 * 抽象装饰类
 */
public abstract class Decorator extends DQ {
    private DQ component; //维护一个抽象构件（父类对象）

    public void setComponent(DQ component) {
        this.component = component;
    }

    @Override
    protected void operation() {
        if (component != null) { //兼容最初的被装饰对象
            component.operation();
        }
    }
}
