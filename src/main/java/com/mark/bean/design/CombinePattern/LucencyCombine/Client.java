package com.mark.bean.design.CombinePattern.LucencyCombine;

/**
 * 透明组合模式实现
 */
public class Client {

    public static void main(String[] args) {
        Component university,computerCollege,infoEnginerrCollege;  //关联 Component
        //创建根容器组件
        university = new Composite("清华大学");
        //创建2个子容器组件
        computerCollege = new Composite("计算机学院");
        university.add(computerCollege);
        infoEnginerrCollege = new Composite("信息工程学院");
        university.add(infoEnginerrCollege);

        //创建叶子构件并添加到相应的容器组件中
        computerCollege.add(new Leaf("软件工程系"));
        computerCollege.add(new Leaf("网络工程系"));
        computerCollege.add(new Leaf("计算机科学与技术系"));

        infoEnginerrCollege.add(new Leaf("通信工程系"));
        infoEnginerrCollege.add(new Leaf("电子工程系"));
        university.operation(); //调用递归方法，遍历根容器组件
       // computerCollege.operation();//调用递归方法，遍历特定子容器组件
       // new Leaf("计算机科学与技术系").operation(); //调用递归方法，遍历叶子构件


    }
}
