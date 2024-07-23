package 代码随想录.day32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int minLeft = intervals[0][0];
        int maxRight = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            if(cur[0] > maxRight){
                list.add(new int[]{minLeft,maxRight});
                minLeft = cur[0];
                maxRight = cur[1];
            }else if(cur[1] > maxRight){
                maxRight = cur[1];
            }
        }
        list.add(new int[]{minLeft,maxRight});
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        int[][] res = new merge().merge(intervals);
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

    }
}
