package ppt;

import java.util.Scanner;

//0-1 背包问题（二维 DP 版）
public class dp_01beibao_2 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
        int W=in.nextInt();

        int[] v=new int[n+1];//注意此处索引从1开始 方便后面v-1式子
        int[] w=new int[n+1];

        for(int i=1;i<=n;i++){
            w[i]= in.nextInt();
            v[i]= in.nextInt();
        }

        int[][] dp=new int[n+1][W+1];//前i个物品 在背包重量为j的时候 的最大价值

        for(int i=1;i<=n;i++){
            for(int j=0;j<=W;j++){
                dp[i][j]=dp[i-1][j];//不选时=前i-1个物品 背包容量j时的最大价值

                if(w[i]<=j){//如果j大于等于w 那么可以选 此时比较取max
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-w[i]]+v[i]);//注意 此处取的是dp[i-1][j-w[i]]+v[i]
                }
            }
        }

        System.out.println(dp[n][W]);
    }
}
