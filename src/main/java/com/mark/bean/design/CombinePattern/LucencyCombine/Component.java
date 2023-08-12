package com.mark.bean.design.CombinePattern.LucencyCombine;

import java.util.List;

/**
 * 抽像构件
 */
public abstract class Component {
    protected String name; //组件名称

    public Component(String name) {
        this.name = name;
    }

    protected abstract void operation();

    protected abstract void add(Component c);

    protected abstract void remove(Component c);

    protected abstract List<Component> getChild();

}
