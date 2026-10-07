package ppt;

import java.util.Scanner;

//给定一组举证A1-An 矩阵Ai的维度是pi-1*pi 不同加括号方式会使乘法次数不同
//目标：找到一种加括号方式 使得乘法次数最少 输出最少乘法次数
//输入：第一行：整数n 表示矩阵的个数 第二行：n+1个整数 表示矩阵维度p0-pn
//输出：最小乘法次数

public class dp_juzheng {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] p=new int[n+1];

        for(int i=0;i<n+1;i++){
            p[i]=sc.nextInt();
        }

        int[][] dp=new int[n][n];//表示从Ai乘到Aj的次数

        for(int i=0;i<n;i++){
            dp[i][i]=0;//矩阵自己乘自己=0
        }

        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;//重要 初始化为max

                for(int k=i;k<j;k++){//注意此处 断点应该为i-j-1
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+p[i]*p[k+1]*p[j+1]);
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
}
