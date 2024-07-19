package 代码随想录.day20;

import 代码随想录.TreeNode;

//不要被题目唬住了，脑筋急转弯，见缝插针即可
public class insertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
            //这里的返回值很巧妙
            return new TreeNode(val);

        if (root.val < val){
            root.right = insertIntoBST(root.right, val); // 递归创建右子树
        }else if (root.val > val){
            root.left = insertIntoBST(root.left, val); // 递归创建左子树
        }
        return root;
    }

    // 迭代法
    public TreeNode insertIntoBST2(TreeNode root,int val){
        if(root == null) return new TreeNode(val);
        TreeNode pre = root;
        TreeNode newRoot = root;
        while(root != null){
            pre = root;
            if(root.val > val){
                root = root.left;
            } else if(root.val <val){
                root = root.right;
            }
        }
        if(pre.val > val){
            pre.left = new TreeNode(val);
        }else if(pre.val < val){
            pre.right = new TreeNode(val);
        }
        return newRoot;
    }
}
