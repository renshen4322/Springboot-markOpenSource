package com.mark.bean.design.observerMondel;

/**
 * ClassName:ConcreateSubject
 * Package:com.mark.springbootmarkopensource.bean.design.observerMondel
 * Description:
 *
 * @Date:2021/4/3 0003 18:07
 * @Author: mark
 */
public class ConcreateSubject extends Subject {  //具体目标
    private String subjectState;  //具体状态
    public String getSubjectState() {
        return subjectState;
    }
    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }

    @Override
    public void attach(Observer observer) {
        getObservers().add(observer);
    }

    @Override
    public void detach(Observer observer) {
        getObservers().remove(observer);
    }
}
