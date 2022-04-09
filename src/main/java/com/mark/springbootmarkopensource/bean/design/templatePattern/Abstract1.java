package com.mark.springbootmarkopensource.bean.design.templatePattern;

/**
 * ClassName:Abstract1
 * Package:com.mark.springbootmarkopensource.bean.design.templatePattern
 * Description:
 *
 * @Date:2021/4/3 0003 23:18
 * @Author: mark
 */
interface Abstract1 {
    void primitiveOperation1();

    void primitiveOperation2();

    void primitiveOperation3();

    default void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        if (isEvaluate()) {
            primitiveOperation3();
        }
    }
    default  void test(){
        System.out.println("***********************%%%%%%%%%%%%%%%%%$$$$$$$$$$$$$$");
    }
    boolean isEvaluate();//钩子方法是否评价

}
