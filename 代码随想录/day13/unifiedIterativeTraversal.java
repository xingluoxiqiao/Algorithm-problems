package 代码随想录.day13;

import 代码随想录.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class unifiedIterativeTraversal {
    //用栈来遍历元素，注意入栈顺序与出栈顺序相反
    //前序，出栈中左右，入栈右左中
    //其他两种类似，注意入栈顺序即可
   public List<Integer> unifiedIterativeTraversal(TreeNode root){
       Stack<TreeNode> stack = new Stack<>();
       List<Integer> res = new ArrayList<>();
       if(root == null) return res;
       stack.push(root);
       while(!stack.isEmpty()){
           TreeNode cur = stack.peek();
           if(cur != null){
               stack.pop();
               if(cur.right !=null) stack.push(cur.right);
               if(cur.left !=null) stack.push(cur.left);
               stack.push(cur);
               stack.push(null);
           }else{
               stack.pop();
               res.add(stack.pop().val);
           }
       }
       return res;
   }

}
