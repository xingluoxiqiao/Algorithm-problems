package 代码随想录.day22;

import java.util.ArrayList;
import java.util.List;

public class combine{
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        back(1,n,k);
        return res;
    }
    private void back(int start, int n, int k){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        //剪枝操作，k-path.size()是还差几个元素，而i表示的是从哪个元素开始，因此需要保证剩余元素足够，否则推出本次遍历
        for(int i = start; i <= n - (k-path.size())+1; i++){
            path.add(i);
            back(i + 1,n,k);
            path.remove(path.size() - 1);
        }
    }
}
