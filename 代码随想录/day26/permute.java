package 代码随想录.day26;

import java.util.ArrayList;
import java.util.List;

public class permute {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        back(nums,new boolean[nums.length]);
        return res;
    }
    private void back(int[] nums,boolean[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            back(nums,used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
