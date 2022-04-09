package com.mark.springbootmarkopensource.bean.design.infaceObserver;

/**
 * ClassName:Credit
 * Package:com.mark.springbootmarkopensource.bean.design.infaceObserver
 * Description:
 *
 * @Date:2021/4/3 0003 18:51
 * @Author: mark
 */
public interface Credit { //放贷方接口（抽象放贷方）
     void takeMoney(Debit debit); //借贷方通知
}
