package 代码随想录.day22;

import java.util.ArrayList;
import java.util.List;

public class combinationSum3 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        back(k,n,1);
        return res;
    }
    private void back(int k, int target,int start){
        if(path.size() == k && target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= 9; i++){
            path.add(i);
            back(k,target - i, i+1);
            path.remove(path.size() - 1);
        }
    }
}
