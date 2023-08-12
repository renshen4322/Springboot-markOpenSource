package com.mark.bean.design.CombinePattern.LucencyCombine;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器构件
 */
public class Composite extends Component {

    private List<Component> components = new ArrayList<>(); //Composite 组合 Component

    public Composite(String name) {
        super(name);
    }

    @Override
    protected void operation() {
        System.out.println("---"+name+"-----");
        for (Component c:components) { //遍历子组件
            c.operation();  //方法递归调用
        }
    }

    @Override
    protected void add(Component c) {
        components.add(c);
    }

    @Override
    protected void remove(Component c) {
        components.remove(c);
    }

    @Override
    protected List<Component> getChild() {
        return components;
    }
}
