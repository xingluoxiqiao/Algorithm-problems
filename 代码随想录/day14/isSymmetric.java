package 代码随想录.day14;

import 代码随想录.TreeNode;

public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if(left == null && right != null) return false;
        else if(left != null && right == null) return false;
        else if(left == null && right ==null) return true;
        else if(left.val != right.val) return false;
        return compare(left.left,right.right) && compare(left.right, right.left);
    }
}
