package oj;

import java.util.Scanner;

//归并排序
public class guibing_sort {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }

        sort(arr,0,n-1);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]);

            if(i!=n-1){
                System.out.print(" ");
            }
        }
    }

    public static void sort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }

        int mid=left+(right-left)/2;

        sort(arr,left,mid);
        sort(arr,mid+1,right);

        merge(arr,left,mid,right);
    }

//    public static void merge(int[] arr,int left,int mid,int right){
//        int i=left;
//        int j=mid+1;
//        int k=0;
//
//        int[] temp=new int[right-left+1];
//
//        while(i<=mid && j<=right){
//            if(arr[i]<=arr[j]){
//                temp[k++]=arr[i++];
//            }else{
//                temp[k++]=arr[j++];
//            }
//        }
//
//        while(i<=mid){
//            temp[k++]=arr[i++];
//        }
//
//        while(j<=right){
//            temp[k++]=arr[j++];
//        }
//
//        for(int t = 0; t <temp.length; t++){
//            arr[left+ t]=temp[t];
//        }
//    }

    public static void merge(int[] arr,int left,int mid,int right){
        //将arr left到right部分排序
        int n1=mid-left+1;
        int n2=right-mid;

        int[] L=new int[n1+1];//注意此处应该多初始化一个数 因为末尾要添加上哨兵
        int[] R=new int[n2+1];

        for(int i=0;i<n1;i++){
            L[i]=arr[left+i];
        }

        for(int j=0;j<n2;j++){
            R[j]=arr[mid+1+j];
        }

        L[n1]=Integer.MAX_VALUE;
        R[n2]=Integer.MAX_VALUE;

        int t=0;
        int x =0;

        for(int i=left;i<=right;i++){//注意 此处索引不应该从0 而是从left开始 到right结束
            if(L[t]<=R[x]){
                arr[i]=L[t];
                t++;
            }else{
                arr[i]=R[x];
                x++;
            }
        }
    }
}
