package 代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40 {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used=new boolean[candidates.length];
        Arrays.sort(candidates);
        Arrays.fill(used,false);
        back(0,candidates,target,used);
        return res;
    }
    private void back(int start,int[] candidates,int target,boolean[] used){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<candidates.length&&target-candidates[i]>=0;i++){
            if(used[i]) break;
            path.add(candidates[i]);
            used[i]=true;
            back(i+1,candidates,target-candidates[i],used);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }

}
