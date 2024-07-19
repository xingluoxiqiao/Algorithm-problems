package 代码随想录.day18;

import 代码随想录.TreeNode;

import java.util.Stack;

public class isValidBST {
    //二叉搜索树中序遍历是有序数组
    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return true;
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(pre != null && pre.val >= cur.val){
                    return false;
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("5,1,4,null,null,3,6");
        isValidBST(root);
    }
}
