package 代码随想录.day26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class findSubsequences {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        back(nums,0);
        return res;
    }
    private void back(int[] nums,int start){
        if(path.size() >= 2){
            res.add(new ArrayList<>(path));
        }
        //每个for循环是同层，这里在循环外定义set，对同树层去重
        HashSet<Integer> set = new HashSet<>();
        for(int i = start; i < nums.length; i++){
            if(!path.isEmpty() && path.get(path.size() -1 ) > nums[i] || set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            back(nums,i+1);
            path.remove(path.size() - 1);
        }
    }
}
