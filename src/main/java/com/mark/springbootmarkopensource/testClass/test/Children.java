package com.mark.springbootmarkopensource.testClass.test;

import java.time.LocalDateTime;

public class Children extends Father{
    Father father;
    public Children(String name){
        System.out.print("c");
        this.name = name;
        father = new Father(name);
    }

    public Children(){
        System.out.print("d");
    }

    public static void main(String[] args) {
        new Children("孙权");    }

}
