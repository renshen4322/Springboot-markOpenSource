package com.mark.springbootmarkopensource.bean.ComputeBeam;



public class Test888 {
    public static void main(String[] args) {
        int sum = 1;
        for(int i = 2; i <=100; i++){
            if(i%2!=0){
                sum += i;
            }else{
                sum -=i;
            }
        }
        System.out.println(sum);
    }

}
