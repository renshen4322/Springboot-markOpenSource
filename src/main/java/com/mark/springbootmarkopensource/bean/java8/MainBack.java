package com.mark.springbootmarkopensource.bean.java8;

/**
 * ClassName:MainBack
 * Package:com.mark.springbootmarkopensource.bean.java8
 * Description:
 *
 * @Date:2019/3/24 0024 9:41
 * @Author: mark
 */
public class MainBack {
    public static void main(String[] args) {
      Integer test = new Integer("456");
        System.out.println(test);
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));


    }
    public static boolean isPalindrome(String s) {
        if(s.length() == 0) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while(l < r){
            //确定指定的字符是否为字母或数字
            if(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }else if(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }else{
                if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }
}
