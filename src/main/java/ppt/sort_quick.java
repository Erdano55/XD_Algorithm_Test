package ppt;

import java.util.Random;
import java.util.Scanner;


//快排
public class sort_quick {
    private static final Random random=new Random();//注意此处自己定义一个Random
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] temps=sc.nextLine().split(" ");
        int n=temps.length;
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(temps[i]);
        }

        kuaisusort(arr,0,n-1);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]);

            if(i!=n-1){
                System.out.print(" ");
            }
        }

        System.out.println();
    }

    public static void kuaisusort(int[] arr,int left,int right){
        if(left>=right) return;//递归结束条件 left>=right

        int jizhun=partition(arr,left,right);
        kuaisusort(arr,left,jizhun-1);
        kuaisusort(arr,jizhun+1,right);
    }

    public static int partition(int[] arr, int left, int right) {
        int randomIndex = left + random.nextInt(right-left+1);//获得left right中的一个随机数
        swap(arr,randomIndex,left);

        int jizhun=arr[left];
        int i=left;
        int j=right;

        while(i<j){//注意此处是i<j
            while(i<j && arr[j]>=jizhun){//注意此处是while而不是if！！！
                j--;
            }

            while(i<j && arr[i]<=jizhun){
                i++;
            }

            if(i<j){//如果这个时候ij位置还是合法的 进行交换
                swap(arr,i,j);
            }
        }

        swap(arr,left,i);//把left放到正确的位置i上 并返回i
        return i;
    }

    public static void swap(int[] arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}
