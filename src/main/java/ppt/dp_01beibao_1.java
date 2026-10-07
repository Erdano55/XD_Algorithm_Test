package ppt;

import java.util.Scanner;

//0-1 背包问题（一维数组滚动优化版）
public class dp_01beibao_1 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
        int W=in.nextInt();

        int[] v=new int[n];
        int[] w=new int[n];

        for(int i=0;i<n;i++){
            w[i]= in.nextInt();
            v[i]= in.nextInt();
        }

        int[] dp=new int[W+1];//dp[j]: 容量为j时的最大价值

        for(int i=0;i<n;i++){//外层循环只能取一次的东西
            for(int j=W;j>=w[i];j--){//内层限制条件（重量）反向循环
                dp[j]=Math.max(dp[j],dp[j-w[i]]+v[i] );
            }
        }

        System.out.println(dp[W]);
    }
}
