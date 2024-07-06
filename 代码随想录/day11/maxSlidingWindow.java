package 代码随想录.day11;

import java.util.ArrayDeque;
import java.util.Queue;

public class maxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        //存放元素索引
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        //结果集索引
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            //超出范围
            while(!queue.isEmpty() && queue.peek() < i - k + 1){
                queue.poll();
            }
            //保证单调
            while(!queue.isEmpty() && nums[queue.peekLast()] <  nums[i]){
                queue.pollLast();
            }
            queue.offer(i);
            if(i >= k - 1){
                res[idx++] = nums[queue.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1,2,0,5};
        int[] res = maxSlidingWindow(nums,3);
        for(int i : res){
            System.out.print(i+" ");
        }
    }


}
