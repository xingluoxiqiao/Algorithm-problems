package 代码随想录.day15;

import 代码随想录.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;


public class findBottomLeftValue {
    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> stack = new ArrayDeque<TreeNode>() {
        };
        stack.offer(root);
        int res = 0;
        while(!stack.isEmpty()){
            int size = stack.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = stack.poll();
                if(i == 0){
                    res = cur.val;
                }
                if(cur.left != null) stack.offer(cur.left);
                if(cur.right != null) stack.offer(cur.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("1,2,3,4,null,5,6,null,null,7");
        System.out.println(findBottomLeftValue(root));
    }
}
