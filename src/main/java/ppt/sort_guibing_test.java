package ppt;
import java.util.Scanner;

//归并排序的思想在于分治，递归将数组划为两半直到两边都只剩一个，此时对其按大小合并，然后返回
public class sort_guibing_test {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] t=sc.nextLine().split(" ");
        int n=t.length;

        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(t[i]);
        }

        guibingsort(arr,0,n-1);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]);

            if(i!=n-1){
                System.out.print(" ");
            }
        }

        System.out.println();
    }

    private static void guibingsort(int[] arr, int left, int right) {
        if(left>=right){//注意递归结束的条件 当只剩下一个数的时候 此时没办法再划分了 return
            return;
        }

        int mid=left+(right-left)/2;
        guibingsort(arr,left,mid);
        guibingsort(arr,mid+1,right);

        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        //带哨兵
        int n1=mid-left+1;//新建两个数组存储左边和右边部分的数字 将最后一个元素设置为MAX 这样就不用循环判断条件
        int n2=right-mid;

        int[] L=new int[n1+1];
        int[] R=new int[n2+1];

        for(int i=0;i<n1;i++){
            L[i]=arr[left+i];//注意这里的赋值
        }

        for(int i=0;i<n2;i++){
            R[i]=arr[mid+1+i];
        }

        L[n1]=Integer.MAX_VALUE;
        R[n2]=Integer.MAX_VALUE;

        int i=0;
        int j=0;

        for(int k = left; k <=right; k++){
            if(L[i]<=R[j]){
                arr[k]=L[i++];//注意此处不需要k++ 因为for循环里k会自动++
            }else{
                arr[k]=R[j++];
            }
        }

    }
}
