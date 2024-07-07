package 代码随想录.day11;

import java.util.*;

public class topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        //维护结果集
        //设置优先级队列从大到小存储 o1 - o2 为从小到大，o2 - o1 反之
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        int[] res = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(var entry : map.entrySet()){
            int[] temp = new int[2];
            temp[0] = entry.getKey();
            temp[1] = entry.getValue();
            queue.offer(temp);
            if(queue.size() > k){
                queue.poll();
            }
        }
        for(int i = 0; i < k; i++){
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
