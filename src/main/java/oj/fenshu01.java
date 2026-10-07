package oj;

import java.util.Scanner;

//分数背包
public class fenshu01 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int W=sc.nextInt();

        int[] v=new int[n];
        int[] w=new int[n];

        for(int i=0;i<n;i++){
            v[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++){
            w[i]=sc.nextInt();
        }

        double remain=W;
        double max=0;

        for(int i=0;i<n;i++){
            if(remain<=0) break;

            if(w[i]<=remain){
                remain-=w[i];
                max+=v[i];
            }else{
                double fen=remain/w[i];
                max+=v[i]*fen;

                break;
            }
        }

        System.out.printf("%.2f\n",max);//!!!注意此处
    }
}
