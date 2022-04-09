package com.mark.springbootmarkopensource.testClass.test;

public class Father {

    String name;
    public Father(){
        System.out.print("a");
    }

    public Father(String name){
        System.out.print("b");
        this.name= name;
    }
}
