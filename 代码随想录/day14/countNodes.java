package 代码随想录.day14;

import 代码随想录.TreeNode;

public class countNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftdepth = 0, rightdepth = 0;
        TreeNode left = root.left, right = root.right;
        while(left != null){
            left = left.left;
            leftdepth++;
        }
        while(right != null){
            right = right.right;
            rightdepth++;
        }
        if(rightdepth == leftdepth){
            return (2 << leftdepth) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
