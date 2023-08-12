package com.mark.bean.design.CombinePattern.SafeCombine;

/**
 * 叶子构件
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    protected void operation() {
        System.out.println(name);
    }
}
