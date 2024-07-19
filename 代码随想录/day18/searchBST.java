package 代码随想录.day18;

import 代码随想录.TreeNode;

public class searchBST {
    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val > val) return searchBST(root.left,val);
        else if(root.val < val) return searchBST(root.right,val);
        else return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("4,2,7,1,3");
        searchBST(root,2);
    }
}
