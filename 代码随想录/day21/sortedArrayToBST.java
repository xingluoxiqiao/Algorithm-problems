package 代码随想录.day21;

import 代码随想录.TreeNode;

public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        //找中间节点作为当前节点，递归构建左右子树
        return build(nums,0,nums.length);
    }
    private TreeNode build(int[] nums,int start,int end){
        if(end <= start) return null;
        int mid = start + (end - start)/2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = build(nums,start,mid);
        cur.right = build(nums,mid + 1,end);
        return cur;
    }
}
