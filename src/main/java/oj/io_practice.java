package oj;

import java.util.LinkedList;
import java.util.Queue;

//树的类构造 建树函数 打印函数
public class io_practice {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st=new StringTokenizer(br.readLine());
//
//        int n=Integer.parseInt(st.nextToken());
//        int a=Integer.parseInt(st.nextToken());
//
//
//        PrintWriter out=new PrintWriter(System.out);
//        out.print(n);
//        out.println(a);
//        out.printf("%d +%d",n,a);
//
//        out.flush();
//        out.close();
//    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val=val;
        }

        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }

    public static TreeNode buildTree(String[] arr){
        if(arr.length==0 || arr[0].equals("null")){
            return null;
        }

        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        int i=1;
        while (i<arr.length){
            TreeNode cur=queue.poll();

            if(i< arr.length && !arr[i].equals("null")){
                cur.left=new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(cur.left);
            }
            i++;

            if(i< arr.length && !arr[i].equals("null")){
                cur.right=new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(cur.right);
            }
            i++;
        }

        return root;
    }

    public static void printtree(TreeNode root){
        if(root==null){
            return;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            System.out.print(cur.val + " ");

            if(cur.left !=null){
                queue.offer(cur.left);
            }

            if(cur.right !=null){
                queue.offer(cur.right);
            }
        }
    }


    public static void main(String[] args){

    }

}
