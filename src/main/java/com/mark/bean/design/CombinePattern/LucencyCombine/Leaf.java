package com.mark.bean.design.CombinePattern.LucencyCombine;

import java.util.List;

/**
 * 叶子构件
 */
public class Leaf extends Component{

    public Leaf(String name){
        super(name);
    }
    @Override
    protected void operation() {
        System.out.println(name);
    }

    @Override
    protected void add(Component c) {
        throw new UnsupportedOperationException(); //可以是空实现
    }

    @Override
    protected void remove(Component c) {
        throw new UnsupportedOperationException(); //可以是空实现
    }

    @Override
    protected List<Component> getChild() {
        throw new UnsupportedOperationException(); //可以是空实现
       // return null;
    }
}
