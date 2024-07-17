package 代码随想录.day25;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        back(nums,0);
        return res;
    }
    private void back(int[] nums,int start){
        res.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            back(nums,i+1);
            path.remove(path.size() - 1);
        }
    }
}

