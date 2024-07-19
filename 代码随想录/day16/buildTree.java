package 代码随想录.day16;

import 代码随想录.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class buildTree {
    static Map<Integer,Integer> map = new HashMap<>();
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        int len1 = inorder.length, len2 = postorder.length;
        return buildHelper(inorder,0,len1,postorder,0,len2);
    }
    private static TreeNode buildHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart >= inEnd || postStart >= postEnd) return null;
        int curIndex = map.get(postorder[postEnd - 1]);
        TreeNode cur = new TreeNode(inorder[curIndex]);
        int lenLeft = curIndex - inStart;
        cur.left = buildHelper(inorder,inStart,curIndex,postorder,postStart,postStart + lenLeft);
        cur.right = buildHelper(inorder,curIndex + 1,inEnd,postorder,postStart + lenLeft,postEnd - 1);
        return cur;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        buildTree(inorder,postorder);
     }
}
