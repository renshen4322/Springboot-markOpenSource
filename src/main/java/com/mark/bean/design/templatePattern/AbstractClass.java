package com.mark.bean.design.templatePattern;

/**
 * ClassName:AbstractClass
 * Package:com.mark.springbootmarkopensource.bean.design.templatePattern
 * Description:
 *
 * @Date:2021/4/3 0003 22:42
 * @Author: mark
 */
abstract class AbstractClass {
    protected abstract void primitiveOperation1();

    protected abstract void primitiveOperation2();

    protected abstract void primitiveOperation3();

    public final void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        if(isEvaluate()) {
            primitiveOperation3();
        }
    }
    public abstract boolean isEvaluate();//钩子方法是否评价
}
