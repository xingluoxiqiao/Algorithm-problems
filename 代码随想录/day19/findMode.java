package 代码随想录.day19;

import 代码随想录.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class findMode {
    public static int[] findMode(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return new int[]{};
        TreeNode cur = root;
        TreeNode pre = null;
        int max = 0;
        int count = 0;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                //这里需要重置count
                if (pre == null || cur.val != pre.val) {
                    count = 1;
                }else {
                    count++;
                }
                if(count == max){
                    res.add(cur.val);
                }else if(count > max){
                    max = count;
                    res.clear();
                    res.add(cur.val);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("1,0,1,0,0,1,1,0");
        int[] out = findMode(root);
        for(int num : out){
            System.out.print(num + " ");
        }
    }
}
