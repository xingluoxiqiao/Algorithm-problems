package 代码随想录.day15;

import 代码随想录.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root){
        List<String> res =new ArrayList<>();
        back(root,"",res);
        return res;
    }
    private static void back(TreeNode cur, String s, List<String> res){
        if(cur == null) return;
        if(cur.left == null && cur.right == null) {
            res.add(new StringBuilder(s).append(cur.val).toString());
        }
        String temp = new StringBuilder(s).append(cur.val).append("->").toString();
        back(cur.left,temp,res);
        back(cur.right,temp,res);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("1,2,3,null,5");
        List<String> res = binaryTreePaths(root);
        for(String s : res){
            System.out.println(s);
        }
    }
}
