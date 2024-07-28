package 代码随想录.day30;

import java.util.Arrays;

public class eraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int res = 0;
        int maxRight = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            if(cur[0] >= maxRight){
                maxRight = cur[1];
                continue;
            }else {
                maxRight = Math.min(cur[1],maxRight);
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        };
        System.out.println(new eraseOverlapIntervals().eraseOverlapIntervals(points));
    }

}
