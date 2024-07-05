package 代码随想录.day13;

import 代码随想录.TreeNode;

import java.util.ArrayDeque;

public class maxDepth {
    public int maxDepth(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if(root == null) return 0;
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }
}
