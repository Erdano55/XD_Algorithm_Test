package ppt;

import java.util.Scanner;
//最长回文子序列长度
public class dp_maxhuiwen_test_ {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();

        int n=str.length();
        int[][] dp=new int[n][n];//此处表示索引i到索引j处的最大回文子串

        for(int i=0;i<n;i++){//长度为1时回文长度=1
            dp[i][i]=1;
        }

        for(int len=2;len<=n;len++){//一个串max回文长度取决于其子串的max回文长度 所以从短len开始比较
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;

                if(str.charAt(i)==str.charAt(j)){
                    if(len==2){
                        dp[i][j]=2;
                    }else{
                        dp[i][j]=dp[i+1][j-1]+2;
                    }
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);//不同 只能舍弃一个取最大
                }

            }
        }

        System.out.println(dp[0][n-1]);
    }
}
