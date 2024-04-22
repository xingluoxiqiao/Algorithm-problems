package 代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _216 {
//    找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
//    说明：
//    所有数字都是正整数。
//    解集不能包含重复的组合。
//    示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
//    示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
    List<Integer> path=new ArrayList<>();
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        back(n,k,1,0);
        return res;

    }
    private void back(int n,int k,int start,int target){
        if(path.size()==k&&target==n){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<=9;i++){
            path.add(i);
            back(n,k,i+1,target+i);
            path.remove(path.size()-1);
        }
    }



    //剪枝
    public List<List<Integer>> _combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        return res;
    }

    private void backTracking(int targetSum, int k, int startIndex, int sum) {
        // 减枝
        if (sum > targetSum) {
            return;
        }

        if (path.size() == k) {
            if (sum == targetSum) res.add(new ArrayList<>(path));
            return;
        }

        // 减枝 9 - (k - path.size()) + 1
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracking(targetSum, k, i + 1, sum);
            //回溯
            path.remove(path.size()-1);
            //回溯
            sum -= i;
        }
    }
}
