package com.mark.bean.design.Flyweigh2tPattern;

public class UnSharedConcreteFlyweight implements FlyWeight {

    private String intrinsicState; //内部状态
    private String extrinsicState;//外部状态

    public UnSharedConcreteFlyweight(String extrinsicState) {
        this.extrinsicState = extrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        intrinsicState = "系统管理";
        this.extrinsicState = "超级会员" + extrinsicState;// extrinsicState表示外部状态;
        System.out.println(this.extrinsicState + "正在进行" + intrinsicState + ", 非共享具体享元对象的hashcode 为" + this.hashCode());
    }
}
