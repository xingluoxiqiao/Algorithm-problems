package 代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39 {
    // 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    // candidates 中的数字可以无限制重复被选取
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        back(0,candidates,target);
        return res;
    }
    private void back(int start,int[] candidates,int target){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<candidates.length&&target-candidates[i]>=0;i++){
            path.add(candidates[i]);
            back(i,candidates,target-candidates[i]);
            path.remove(path.size()-1);
        }
    }

}
