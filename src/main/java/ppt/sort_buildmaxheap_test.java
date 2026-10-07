package ppt;

import java.util.Scanner;

//构建最大堆并输出堆数组
public class sort_buildmaxheap_test {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=n/2-1;i>=0;i--){
            heap(arr,n,i);
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]);

            if(i!=n-1){
                System.out.print(" ");
            }
        }

        System.out.println();
    }

    public static void heap(int[] arr,int n,int i){
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
            int t=arr[largest];
            arr[largest]=arr[i];
            arr[i]=t;

            heap(arr,n,largest);
        }
    }
}
