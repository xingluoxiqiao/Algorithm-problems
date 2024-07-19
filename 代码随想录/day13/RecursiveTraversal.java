package 代码随想录.day13;

import 代码随想录.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecursiveTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        //前
        preorderRecursiveTraversal(root,res);
        //中
        //inorderRecursiveTraversal(root,res);
        //后
        //postorderRecursiveTraversal(root,res);
        return res;
    }

    public void preorderRecursiveTraversal(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        preorderRecursiveTraversal(root.left,res);
        preorderRecursiveTraversal(root.right,res);
    }

    public void inorderRecursiveTraversal(TreeNode root, List<Integer> res){
        if(root == null) return;
        inorderRecursiveTraversal(root.left,res);
        res.add(root.val);
        inorderRecursiveTraversal(root.right,res);
    }

    //后序遍历
    public void postorderRecursiveTraversal(TreeNode root,List<Integer> res){
        if(root == null) return;
        postorderRecursiveTraversal(root.left,res);
        postorderRecursiveTraversal(root.right,res);
        res.add(root.val);
    }



}
