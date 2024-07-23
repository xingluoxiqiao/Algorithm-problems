package 代码随想录.day32;

import 代码随想录.TreeNode;

public class minCameraCover {
    //无覆盖
    static int NO_CAMERA = 0;
    //有摄像头
    static int HAVE_CAMERA = 1;
    //有覆盖
    static int WITH_CAMERA = 2;
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if(minCame(root) == 0){
            res++;
        }
        return res;
    }

    private int minCame(TreeNode root){
        //空节点应默认为有覆盖
        if(root == null) return WITH_CAMERA;
        int left = minCame(root.left);
        int right = minCame(root.right);
        //左右只要一个无覆盖，父节点应有摄像头
        if(left == NO_CAMERA || right == NO_CAMERA) {
            res++;
            return HAVE_CAMERA;
        }
            //左右都有覆盖，父节点为无覆盖（爷爷节点会有摄像头）
        else if(left == WITH_CAMERA && right == WITH_CAMERA) {
            return NO_CAMERA;
        }
        //左右至少有一个摄像头，父节点为被覆盖
        else return WITH_CAMERA;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("0,0,null,0,0");
        System.out.println(new minCameraCover().minCameraCover(root));
    }
}
