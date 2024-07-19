package 代码随想录.day20;

import 代码随想录.TreeNode;

public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        if(p.val < root.val &&  q.val > root.val) return root;
        else if(p.val > root.val && q.val < root.val) return root;
        else if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return null;
    }
}
