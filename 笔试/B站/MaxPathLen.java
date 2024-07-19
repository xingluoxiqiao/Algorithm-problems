package 笔试.B站;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 给定一个二叉树的 root ，返回最长的路径的长度，这个路径中的每节点具有相同值。
 * 这条路径可以经过也可以不经过根节点。两个节点之间的路径长度 由它们之间的边数表示。
 * 树的节点数的范围是 [0,10^4] -1000 <= Node.val <= 1000
 * 树的深度将不超过 18 层
 *
 *输入：
 * 7
 * 5 4 5 1 1 null 5
 *输出：
 * 2
 */

public class MaxPathLen {
    private static int res = 0;
    //从当前节点到叶子节点的最大长度
    public int maxPathLen(TreeNode root){
        if(root == null) return 0;
        int left = maxPathLen(root.left);
        int right = maxPathLen(root.right);

        int leftNum = 0, rightNum = 0;
        if(root.left != null && root.left.val == root.val){
            leftNum = left + 1;
        }
        if(root.right != null && root.right.val == root.val){
            rightNum = right + 1;
        }
        res = Math.max(leftNum+rightNum,res);
        return Math.max(rightNum,leftNum);
    }

    private TreeNode stringToTreeNode(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        String[] parts = input.split(" ");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String input = sc.nextLine();
        MaxPathLen maxPathLen = new MaxPathLen();
        TreeNode root = maxPathLen.stringToTreeNode(input);
        maxPathLen.maxPathLen(root);
        System.out.println(res);
    }
    class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(){}
        public TreeNode(int val){
            this.val = val;
        }
    }
    
}
