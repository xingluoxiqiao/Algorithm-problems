package 代码随想录.day26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteUnique {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        back(nums,new boolean[nums.length]);
        return res;
    }
    private void back(int[] nums,boolean[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            //use[i-1]==true是树枝去重，false是树层去重更彻底
            //但一定得保持稳定，不能一会是false，一会是true，所以不能去掉
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                back(nums, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
