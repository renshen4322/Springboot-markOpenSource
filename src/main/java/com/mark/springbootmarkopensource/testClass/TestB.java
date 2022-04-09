package com.mark.springbootmarkopensource.testClass;

/**
 * ClassName:TestB
 * Package:com.mark.springbootmarkopensource.testClass
 * Description:
 *
 * @Date:2021/5/13 0013 22:53
 * @Author: mark
 */
public class TestB extends TestA{
    static {
        System.out.print("a");
    }
    public TestB(){
        System.out.print("b");
    }

}
