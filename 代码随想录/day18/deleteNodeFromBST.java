package 代码随想录.day18;

import 代码随想录.TreeNode;

public class deleteNodeFromBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode newRoot = root;
        TreeNode pre = null;
        while (root != null) {
            if (root.val < key) {
                pre = root;
                root = root.right;
            } else if (root.val > key) {
                pre = root;
                root = root.left;
            } else {
                break;
            }
        }
        //说明要删除的是根结点
        if(pre == null) return deleteOneNode(root);
        //要删除的节点在左边
        if (pre.left !=null && pre.left.val == key){
            pre.left = deleteOneNode(root);
        }
        //要删除的节点在右边
        if (pre.right !=null && pre.right.val == key){
            pre.right = deleteOneNode(root);
        }
        return newRoot;
    }
    //删除当前节点，返回当前节点的右子节点，并且将当前节点的左子树移动到右子树最左侧
    private TreeNode deleteOneNode(TreeNode root){
        if(root == null) return null;
        if(root.right == null) return root.left;
        TreeNode cur = root.right;
        while(cur.left != null){
            cur = cur.left;
        }
        cur.left = root.left;
        return root.right;
    }

}
