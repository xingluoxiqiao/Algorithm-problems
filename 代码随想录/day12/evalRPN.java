package 代码随想录.day12;

import java.util.Stack;

public class evalRPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            }else if("/".equals(s)){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            }else if("+".equals(s)){
                stack.push(stack.pop() + stack.pop());
            }else if("-".equals(s)){
                stack.push( -stack.pop() + stack.pop());
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }
}
