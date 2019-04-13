package com.example.springboot1.algorithm;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: GoReturn
 * @Package com.example.springboot1.algorithm
 * @Description 回溯问题，计算一字符串正读反读一致的最长子字符串
 * @date 2018/9/13 7:53
 */
public class GoReturn {

    public static void main(String[] args){
        System.out.println(getMaxlen("abca"));
    }

    public static int getMaxlen(String str){
        int len=str.length();
        System.out.println(len);
        int[][] dp = new int[len][len];
        for(int i=len-1;i>=0;i--){
            dp[i][i]=1;
            for(int r=i+1;r<len;r++){
                if(str.charAt(i)==str.charAt(r)){
                    dp[i][r]=dp[i+1][r-1]+2;
                }else{
                    dp[i][r]=Math.max(dp[i][r-1],dp[i+1][r]);
                    System.out.println(i+"dp[i][r-1] "+ r+"dp值"+dp[i][r-1]);
                    System.out.println(i+" dp[i+1][r]"+ r+"dp值"+dp[i+1][r]);
                    System.out.println(i+" "+ r+"dp值"+dp[i][r]);
                }
            }
        }
        return dp[0][len-1];
    }

}
