package ppt;

import java.util.Map;
import java.util.PriorityQueue;

//哈夫曼编码：构建哈夫曼树并实现编码与解码
public class tanxin_haffmancode {
    static class Node {
        char c;
        int fre;
        Node left;
        Node right;

        Node(char c, int fre){
            this.c=c;
            this.fre=fre;
            this.left=null;
            this.right=null;
        }

        Node(int fre, Node left, Node right){
            this.c='\0';
            this.fre=fre;
            this.left=left;
            this.right=right;
        }

        public boolean ifleaf(){
            return left==null && right==null;
        }
    }

    public static Node buildTree(Map<Character,Integer> fremap){
        PriorityQueue<Node> heap=new PriorityQueue<>((a,b)->a.fre-b.fre);

        for(Map.Entry<Character,Integer> entry:fremap.entrySet()){
            heap.offer(new Node(entry.getKey(),entry.getValue()));
        }

        while(heap.size()>1){
            Node left=heap.poll();
            Node right=heap.poll();

            Node parent=new Node(left.fre+right.fre,left,right);
            heap.offer((parent));
        }

        return heap.poll();
    }

    public static void generateCode(Node root,String code,Map<Character,String> codemap){
        if(root==null) return;

        if(root.ifleaf()){
            codemap.put(root.c,code);
            return;
        }

        generateCode(root.left,code+"0",codemap);
        generateCode(root.right,code+"1",codemap);
    }

    public static String encode(String text,Map<Character,String> codemap){
        StringBuilder sb=new StringBuilder();

        for(char c:text.toCharArray()){
            sb.append(codemap.get(c));
        }

        return sb.toString();
    }

    public static String decode(String encode,Node root){
        StringBuilder sb=new StringBuilder();
        Node cur=root;

        for(char c:encode.toCharArray()){
            if(c=='0'){
                cur=cur.left;
            }else {
                cur=cur.right;
            }

            if(cur.ifleaf()){
                sb.append(cur.c);
                cur=root;//!!!不要忘记把cur置到根节点
            }
        }

        return sb.toString();
    }
}
