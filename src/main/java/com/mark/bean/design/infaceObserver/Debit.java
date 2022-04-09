package com.mark.bean.design.infaceObserver;

/**
 * ClassName:Debit
 * Package:com.mark.springbootmarkopensource.bean.design.infaceObserver
 * Description:
 *
 * @Date:2021/4/3 0003 18:47
 * @Author: mark
 */
interface Debit { //借贷方接口
     void borrow(Credit credit);
     void notifyCredits();
}
