package 代码随想录.day30;

import java.util.Arrays;

public class findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b) ->
                //使用Integer内置比较方法，不会溢出
                Integer.compare(a[0], b[0]));
        int maxRight = points[0][1];
        int minLeft = points[0][0];
        int res = 1;
        for(int i = 1;i < points.length; i++){
            int[] cur = points[i];
            //讨论新的左边界和右边界
            //由于已经按左边界排序，新的左边界为现在左边界和cur[0]间较大者，新的右边界为现在右边界和cur[1]间较小者
            //无重叠进行计数
            if(cur[0] > maxRight){
                maxRight = cur[1];
                minLeft = cur[0];
                res++;
            } else {
                maxRight = Math.min(cur[1],maxRight);
                minLeft = Math.max(cur[0],minLeft);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {-2147483646,-2147483645},
                {2147483646,2147483647},
        };
        System.out.println(new findMinArrowShots().findMinArrowShots(points));
    }
}
