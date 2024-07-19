package 代码随想录.day16;

import 代码随想录.TreeNode;

public class hasPathSum {
    public boolean hasPathSum(TreeNode cur, int targetSum) {
        if(cur == null) return false;
        if(cur.right == null && cur.left == null){
            return cur.val == targetSum;
        }
        return hasPathSum(cur.left,targetSum - cur.val) || hasPathSum(cur.right,targetSum - cur.val);
    }
}
