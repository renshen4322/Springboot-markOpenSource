package com.mark.testClass.test;

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
