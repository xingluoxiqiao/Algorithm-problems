package 代码随想录.day17;

import 代码随想录.TreeNode;

import java.util.Stack;

public class getMinimumDifference {
    public static int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return 0;
        TreeNode pre = null;
        TreeNode cur = root;
        int min = Integer.MAX_VALUE;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if(pre != null) {
                    min = Math.min(min, Math.abs(cur.val - pre.val));
                }

                //始终需要更新
                pre = cur;
                cur = cur.right;
            }

        }
        return min;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("1,null,3,2");
        System.out.println(getMinimumDifference(root));
    }
}
