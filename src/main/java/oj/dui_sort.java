package oj;

import java.util.Scanner;


//堆排序
public class dui_sort {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        int n=in.nextInt();

        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }

        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]);

            if(i!=n-1){
                System.out.print(" ");
            }
        }

        System.out.println();
    }

    public static void heapify(int[] arr,int n,int i){
        if(arr==null || arr.length<=1){
            return;
        }

        int largest=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<n && arr[left]>arr[largest]){//注意此处的判断条件 l和r要在范围内
            largest=left;
        }

        if(right<n && arr[right]>arr[largest]){
            largest=right;
        }

        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;

            heapify(arr,n,largest);//因为交换了largest和i对应的数字 largest往下可能改变
        }
    }
}
