package com.mark.springbootmarkopensource.bean.ComputeBeam;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * ClassName:ConvertNumUtil
 * Package:com.mark.springbootmarkopensource.bean.ComputeBeam
 * Description:
 *
 * @Date:2021/6/21 0021 1:29
 * @Author: mark
 */
public class ConvertNumUtil {
    private static String S64BASE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@#";

    public static String to64String(long i) {
        BigDecimal divide = new BigDecimal(64);
        BigDecimal decimal = new BigDecimal(i);
        String res = "";
        // 循环取余
        while (BigDecimal.ZERO.compareTo(decimal) != 0) {
            BigDecimal[] divRes = decimal.divideAndRemainder(divide);// 返回数组：[0] 商值(this / val) ， [1] 余数(this % val)
            decimal = divRes[0];
            res = S64BASE.charAt(divRes[1].intValue()) + res;
        }
        return res;
    }

}
