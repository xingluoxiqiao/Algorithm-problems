package 代码随想录.day18;

import 代码随想录.TreeNode;

public class constructMaximumBinaryTree {
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
       return helper(nums,0,nums.length);
    }
    private static TreeNode helper(int[] nums,int start,int end){
        if(end - start < 1) return null;
        if(end - start == 1) return new TreeNode(nums[start]);
        int max = nums[start];
        int maxIndex = start;
        for(int i = start+1; i < end; i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode cur = new TreeNode(max);
        cur.left = helper(nums,start,maxIndex);
        cur.right = helper(nums,maxIndex+1,end);
        return cur;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,2,1,6,0,5};
        constructMaximumBinaryTree(input);
    }
}
