package com.mark.bean.design.AdapterPattern.BothWayPattern;

public class Adapter implements Cat,Dog{
    private Cat cat;
    private Dog dog;
    @Override
    public void catchMouse() {
        dog.gnawBone();
    }

    @Override
    public void gnawBone() {
        cat.catchMouse();
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
