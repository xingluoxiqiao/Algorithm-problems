package 代码随想录.day29;

import java.util.Arrays;
import java.util.LinkedList;

public class reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        //(h,k)表示身高，权值
        //优先按身高排列，其次考虑权值
        Arrays.sort(people,(a,b) ->{
            //身高相等时，按权值从小到大排列
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            //否则按身高从大到小排列
            return b[0] - a[0];
        });

        LinkedList<int[]> queue = new LinkedList<>();
        for(int[] p : people){
            //Linkedlist.add(index, value)，會將value插入到指定index裡。
            queue.add(p[1],p);
        }
        return queue.toArray(new int[people.length][]);
    }
}
