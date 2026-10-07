package ppt;

import java.util.Scanner;
//最长公共子序列 关键在于dp[i][j] = text1 的前 i 个字符 和 text2 的前 j 个字符 的最长公共子序列长度
//如果两个字符相同 dp[i][j]=dp[i-1][j-1]+1; 如果不同dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
public class dp_LCS_test {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();

        int n1=s1.length();
        int n2=s2.length();

        int[][] dp=new int[n1+1][n2+1];//dp[i][j] = text1 的前 i 个字符 和 text2 的前 j 个字符 的最长公共子序列长度

        for(int i=1;i<=n1;i++){//注意此处索引是从1开始的 表示前1个字符
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n1][n2]);
    }
}
