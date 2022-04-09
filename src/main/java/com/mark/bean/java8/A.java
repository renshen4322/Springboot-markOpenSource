package com.mark.bean.java8;

public class A {
    int principal = 0;
    int fee = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public A(String name,int principal, int fee) {
        super();
        this.name = name;
        this.principal = principal;
        this.fee = fee;
    }

    public A() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "A [principal=" + principal + ", fee=" + fee + "]";
    }
}
