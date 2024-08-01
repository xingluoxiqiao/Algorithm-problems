package 代码随想录.day40;

import 代码随想录.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class rob3 {
    public int rob(TreeNode root) {
        int[] res = travsal(root);
        return Math.max(res[0],res[1]);
    }
    private int[] travsal(TreeNode root){
        if(root == null) return new int[]{0,0};
        //后序遍历
        int[] left = travsal(root.left);
        int[] right = travsal(root.right);
        int[] cur = new int[2];
        cur[0] = root.val + left[1] + right[1];
        cur[1] = Math.max(left[1],left[0]) + Math.max(right[1],right[0]);
        return cur;
    }


    //记忆化递归
    Map<TreeNode,Integer> map = new HashMap<>();
    public int rob2(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        if(map.containsKey(root)) return map.get(root);
        //抢父节点
        int money = root.val;
        if(root.left != null){
            money += rob2(root.left.left) + rob2(root.left.right);
        }
        if(root.right != null){
            money += rob2(root.right.left) + rob2(root.right.right);
        }
        //不抢父节点
        int money2 = rob2(root.left) + rob2(root.right);
        map.put(root,Math.max(money2,money));
        return Math.max(money2,money);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("3,2,3,null,3,null,1");
        System.out.println(new rob3().rob(root));
    }

}
