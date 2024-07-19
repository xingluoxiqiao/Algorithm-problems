package 代码随想录.day15;

import 代码随想录.TreeNode;

public class isBalanced {
    public static boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    private static int getHeight(TreeNode node){
        if(node == null) return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if(left == -1) return -1;
        if(right == -1) return -1;
        //每个节点都必须是平衡的
        if(Math.abs(left - right) >= 2) return -1;
        return Math.max(left,right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("1,2,2,3,null,null,3,4,null,null,4");
        System.out.println(isBalanced(root));
    }
}
