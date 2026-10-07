package ppt;

import java.util.Scanner;

//分数背包问题（贪心）：物品可分割，求最大价值
public class tanxin_fenshubeibao_test {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double W=sc.nextInt();//!!!注意 此处设置为double类型

        int[] v =new int[n];
        int[] w =new int[n];
        double max=0.0;

        for(int i=0;i<n;i++){
            v[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++){
            w[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++){
            if(W<=0) break;

            if(W>= w[i]){
                max+= v[i];
                W-= w[i];
            }else{
                double fen=W/ w[i];//注意此处顺序不要写反
                max+=fen* v[i];
                break;
            }
        }

        System.out.printf("%.2f",max);


    }
}
