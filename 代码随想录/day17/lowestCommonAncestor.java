package 代码随想录.day17;

import com.sun.source.tree.Tree;
import 代码随想录.TreeNode;

import java.time.temporal.Temporal;

public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //后序遍历，可以在中节点处理来自左右节点的信息
        //本题中，判断p，q是否在左右字树上，后序最合适

        //找到了p或q，或当前节点为null，返回
        if(root == null || root == q || root == p) return root;
        //遍历左右子树
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //最后根据左右子树的信息返回结果
        if(left != null && right == null) return left;
        else if(left == null && right !=null) return right;
        else if(left == null && right == null) return null;
        else return root;
    }
}
