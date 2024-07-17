package 代码随想录.day25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsWithDup {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        back(nums,0,new boolean[nums.length]);
        return res;
    }
    private void back(int[] nums,int start,boolean[] used){
        res.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            back(nums,i+1,used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
