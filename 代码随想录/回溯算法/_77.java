package 代码随想录.回溯算法;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//你可以按 任何顺序 返回答案。
public class _77 {
    ArrayList<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        back(1,n,k);
        return res;
    }
    private void back(int start,int n,int k){
        if(path.size()==k){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i=start;i<=n-(k-path.size())+1;i++){
            path.add(i);
            back(i+1,n,k);
            path.remove(path.size()-1);
        }
    }
}
