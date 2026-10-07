package ppt;

import java.util.Scanner;

//堆排序
public class sort_heap {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] t=sc.nextLine().split(" ");
        int n=t.length;

        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(t[i]);
        }

        heapsort(arr);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]);

            if(i!=n-1){
                System.out.print(" ");
            }
        }

        System.out.println();
    }

    private static void heapsort(int[] arr) {
        if(arr==null || arr.length<=1){
            return;
        }

        int n=arr.length;

        for(int i=n/2-1;i>=0;i--){
            heap(arr,n,i);
        }

        for(int i=n-1;i>0;i--){
            int t=arr[0];
            arr[0]=arr[i];
            arr[i]=t;

            heap(arr,i,0);
        }


    }

    private static void heap(int[] arr, int n, int i) {
        int max=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<n && arr[left]>arr[max]){
            max=left;
        }

        if(right<n && arr[right]>arr[max]){
            max=right;
        }

        if(max!=i){
            int t=arr[max];
            arr[max]=arr[i];
            arr[i]=t;

            heap(arr,n,max);
        }
    }
}
