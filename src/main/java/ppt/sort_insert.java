package ppt;

import java.util.Scanner;

//插入排序
//和斗地主相似，左边为排好序的队列，每次从右边未排序的队列中选一个插入有序队列中，直至全部有序
public class sort_insert {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] t=sc.nextLine().split(" ");
        int n=t.length;

        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(t[i]);
        }

        insertsort(arr);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]);

            if(i!=n-1){
                System.out.print(" ");
            }
        }

        System.out.println();


    }

    private static void insertsort(int[] arr) {
        if(arr==null || arr.length<=1){
            return;
        }

        for(int i=1;i< arr.length;i++){//从第二个数开始 左边依次有序 每次插入新的数
            int charu=arr[i];
            int j=i-1;

            while (j>=0 && arr[j]>charu){//注意 此处是和charu的数比较 而不是arr[i] 因为arr[i]会随着i变化
                arr[j+1]=arr[j];
                j--;
            }

            arr[j+1]=charu;
        }

    }
}
