package com.example.springboot1.algorithm;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: FindOverHalfNum
 * @Package com.example.springboot1.algorithm
 * @Description 找出数组中出现次数超过一半的数
 * @date 2018/9/13 9:02
 */
public class FindOverHalfNum {
    public static int question(int[] a){
        int temp = a[a.length-1];
        int count =1 ;
        for(int i = a.length-2;i >= 0;i--){
            if(a[i]==temp){
                count++;
            }else{
                count--;
                if(count==0){
                    temp=a[i];
                    count=1;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args){
        int[] a={1,2,1};
        System.out.println(question(a));
    }
}
