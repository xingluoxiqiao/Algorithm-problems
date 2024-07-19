package 代码随想录.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
    static List<Integer> path = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        //对数组排序，方便后序剪枝，
        Arrays.sort(candidates);
        back(candidates,target,0);
        return res;
    }
    private static void back(int[] candidates, int target, int start){
        //判断此时的target，防止无限循环
        //if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        //如果剩余元素均大于剩余target，直接退出本次循环
        //并且由于元素重复，需要控制重复次数，用当前target的值来控制
        for(int i = start; i < candidates.length && target - candidates[i] >= 0; i++){
            path.add(candidates[i]);
            back(candidates,target - candidates[i],i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{8,7,4,3};
        List<List<Integer>> res = combinationSum(candidates,11);
        for(List<Integer> list : res){
            for(int i : list){
                System.out.print(i + "->");
            }
            System.out.println();
        }
    }
}
