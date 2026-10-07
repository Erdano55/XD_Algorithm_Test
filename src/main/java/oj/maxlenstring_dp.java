package oj;

import java.util.Scanner;

//最长公共子序列
public class maxlenstring_dp {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String s1=sc.next();
        String s2=sc.next();

        int m=s1.length();
        int n=s2.length();

        int[][] dp=new int[m+1][n+1];//dp[i][j] = text1 的前 i 个字符 和 text2 的前 j 个字符 的最长公共子序列长度

        //dp的i=1指向string的第一个字符 当i=0 和j=0 最长公共字符串长都=0 但因为数组默认是0 所以不用另外初始化
        for(int i=1;i<= m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[m][n]);
    }

}
