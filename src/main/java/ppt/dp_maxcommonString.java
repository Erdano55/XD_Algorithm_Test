package ppt;

import java.util.Scanner;

/**
 *
 * 给定两个字符串 X 和 Y，请找出它们最长的公共子串的长度以及该子串本身。
 * 子串定义：字符串中连续的一段字符序列（与子序列不同，子串要求连续）。
 */
public class dp_maxcommonString {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String s1=sc.next();
        String s2=sc.next();

        String res=getmaxcommmonString(s1,s2);

        if(res==""){
            System.out.println(0);
            System.out.println();
        }else{
            System.out.println(res.length());
            System.out.println(res);
        }
    }

    private static String getmaxcommmonString(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();

        int[][] dp=new int[m+1][n+1];//表示已i j结尾的最长公共子串串长；

        int maxlen=0;
        int endindex=0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;

                    if(dp[i][j]>maxlen){
                        maxlen=dp[i][j];
                        endindex=i;
                    }
                }else{
                    dp[i][j]=0;
                }
            }
        }

        if(maxlen==0){
            return "";
        }

        return s1.substring(endindex-maxlen,endindex);


    }
}
