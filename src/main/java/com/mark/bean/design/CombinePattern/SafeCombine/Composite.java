package com.mark.bean.design.CombinePattern.SafeCombine;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器构件
 */
public class Composite extends Component{

    private List<Component> components = new ArrayList<>(); //Composite 组合Component
    public Composite(String name){
        super(name);
    }

    protected void add(Component c){
        components.add(c);
    }

    protected List<Component> getChild(){
        return components;
    }

    protected void remove(Component c){
        components.remove(c);
    }

    @Override
    protected void operation() { //容器构件重写的抽象方法
        System.out.println("---"+name+"-----");
        for (Component c:components) {
            c.operation();
        }
    }
}
