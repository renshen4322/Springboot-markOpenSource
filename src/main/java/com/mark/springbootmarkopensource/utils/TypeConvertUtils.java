package com.mark.springbootmarkopensource.utils;

import java.math.BigDecimal;

/**
 * ClassName:TypeConvertUtils
 * Package:com.xinan.mini.patient.utils
 * Description:
 *
 * @Date:2021/11/2 15:26
 * @Author: mark
 */
public class TypeConvertUtils {

    /**
     *  BigDecimal转double
     * @param decimal
     * @return
     */
    public static Double getBigDecimalToDouble (BigDecimal decimal){
        BigDecimal big = new BigDecimal(String.valueOf(decimal));
        double d = big.doubleValue();
        return d;
    }

    /**
     * doublel转BigDecimal
     * @param d
     * @return
     */
    public static BigDecimal getDoubleToBigDecimal(Double d){
        BigDecimal big = new BigDecimal(Double.toString(d));
        return big;
    }

    /**
     * BigDecimal乘以整数
     * @param itemQuantity
     * @param itemPrice
     * @return
     */
    public static BigDecimal calculateCost(Integer itemQuantity, BigDecimal itemPrice) {
        BigDecimal itemCost = BigDecimal.ZERO;
        BigDecimal totalCost = BigDecimal.ZERO;
        itemCost = itemPrice.multiply(new BigDecimal(itemQuantity));
        totalCost = totalCost.add(itemCost);
        return totalCost;
    }
}
