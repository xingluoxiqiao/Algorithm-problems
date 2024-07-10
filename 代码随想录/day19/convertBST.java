package 代码随想录.day19;


import 代码随想录.TreeNode;

public class convertBST {
    static int sum;
    //中序（左中右）是从小到大，逆中序累加即可
    public static TreeNode convertBST(TreeNode root) {
        sum = 0;
        helper(root);
        return root;
    }
    private static void helper(TreeNode root){
        if(root == null) return;
        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("4,1,6,0,2,5,7,null,null,null,3,null,null,null,8");
        System.out.println(TreeNode.treeToLevelOrderString(convertBST(root)));
    }
}
