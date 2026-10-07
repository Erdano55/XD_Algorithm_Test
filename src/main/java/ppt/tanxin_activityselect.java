package ppt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//活动选择问题：每次选择最早结束的活动 所以按照结束时间排序 在不冲突的情况下 继续选择剩下的活动
public class tanxin_activityselect {
    static class activity{
        int start;
        int end;
        int index;

        activity(int start,int end,int index){
            this.start=start;
            this.end=end;
            this.index=index;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        List<activity> as=new ArrayList<>();

        for(int i=0;i<n;i++){
            int start=sc.nextInt();
            int end=sc.nextInt();

            as.add(new activity(start,end,i+1));
        }

        as.sort((a,b)->{//优先按结束时间排序 结束时间同按开始时间排序
            if(a.end!=b.end){
                return a.end-b.end;
            }
            return a.start-b.start;
        });

        List<Integer> selected=new ArrayList<>();

        selected.add(as.get(0).index);//第一个活动肯定放进去
        int lastend=as.get(0).end;

        for(int i=1;i<n;i++){
            if(as.get(i).start>=lastend){//如果后面活动开始时间>前面结束时间 加进来 更新结束时间
                selected.add(as.get(i).index);
                lastend=as.get(i).end;
            }
        }

        System.out.println(selected.size());
    }
}
