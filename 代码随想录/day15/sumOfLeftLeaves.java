package 代码随想录.day15;


import 代码随想录.TreeNode;

public class sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        int leftValue = sumOfLeftLeaves(root.left);
        if(root.left != null && root.left.left == null && root.left.right == null){
            leftValue += root.left.val;
        }
        return leftValue + sumOfLeftLeaves(root.right);
    }
}
