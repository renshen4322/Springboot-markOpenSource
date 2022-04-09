package com.mark.springbootmarkopensource.bean.design.observerMondel;

/**
 * ClassName:Client
 * Package:com.mark.springbootmarkopensource.bean.design.observerMondel
 * Description:
 *
 * @Date:2021/4/3 0003 18:21
 * @Author: mark //观察者模式
 */
public class Client {
    public static void main(String[] args) {
        //创建一个观察目标
        Subject subject = new ConcreateSubject();
        //创建观察者
        ConcreateObserver observer1 = new ConcreateObserver("张三");
        ConcreateObserver observer2 = new ConcreateObserver("李四");
        ConcreateObserver observer3 = new ConcreateObserver("王五");
        //添加观察者到观察目标
        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);
        ((ConcreateSubject) subject).setSubjectState("明天上午考试java");
        subject.notifyToAll();
        System.out.println("===========================================");
        subject.detach(observer3);
        ((ConcreateSubject) subject).setSubjectState("后天上午考试net!");
        subject.notifyToAll();
    }
}
