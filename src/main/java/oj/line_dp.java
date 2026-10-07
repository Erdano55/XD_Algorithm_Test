package oj;

import java.util.Scanner;

//流水线调度
public class line_dp {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[] a1=new int[n];
        int[] a2=new int[n];

        for(int i=0;i<n;i++){
            a1[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++){
            a2[i]=sc.nextInt();
        }

        int[] t1=new int[n-1];
        int[] t2=new int[n-1];

        for(int i=0;i<n-1;i++){
            t1[i]=sc.nextInt();
        }

        for(int i=0;i<n-1;i++){
            t2[i]=sc.nextInt();
        }

        int e1=sc.nextInt();
        int e2= sc.nextInt();
        int x1=sc.nextInt();
        int x2=sc.nextInt();

        int[] dp1=new int[n];//注意 此处dp[i]表示到线1上这个点所用的最短时间
        int[] dp2=new int[n];

        dp1[0]=a1[0]+e1;
        dp2[0]=a2[0]+e2;

        for(int i=1;i<n;i++){
            //到这个线这个点 要么是从同线上一个点来 要么是从另一条线上一个点来
            dp1[i]=Math.min(dp1[i-1]+a1[i],dp2[i-1]+t2[i-1]+a1[i]);
            dp2[i]=Math.min(dp2[i-1]+a2[i],dp1[i-1]+t1[i-1]+a2[i]);
        }

        int res=Math.min(dp1[n-1]+x1,dp2[n-1]+x2);

        System.out.println(res);
    }
}
