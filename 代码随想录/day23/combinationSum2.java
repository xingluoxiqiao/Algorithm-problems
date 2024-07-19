package 代码随想录.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//每个数字在每个组合中只能用一次并且解集不能包含重复的集合
public class combinationSum2 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        //排序方便剪枝
        Arrays.sort(candidates);
        back(candidates,target,new boolean[candidates.length],0);
        return res;
    }
    private void back(int[] candidates, int target, boolean[] used, int start){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        //在起始索引处剪枝，如果后续的数已经过大了，可以跳出本次循环
        for(int i = start; i < candidates.length && target - candidates[i] >= 0; i++){
            //这里是继续剪枝，解集重复是candidate中两个相等的数的公共解集
            //两个数相等时，后面数的解集是前面数的解集的子集，如果前面的数没有取，后面的数也不用取
            //另外，这种操作避免了解集的重复，如果不跳出，其他组合中上一个数已经获得了全部的解集，这里再拿一遍就重复了
            if(i > 0 && candidates[i] == candidates[i-1] && !used[i-1]) continue;
            used[i] = true;
            path.add(candidates[i]);
            back(candidates,target - candidates[i],used,i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
