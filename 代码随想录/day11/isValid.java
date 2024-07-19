package 代码随想录.day11;

import java.util.Stack;

public class isValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '[' || c == '{' || c == '('){
                stack.push(c);
            }else if(c == ']') {
                if(!stack.empty() && stack.peek() == '[') stack.pop();
                else return false;
            }else if(c == '}') {
                if(!stack.empty() && stack.peek() == '{') stack.pop();
                else return false;
            }else if(c == ')') {
                if(!stack.empty() && stack.peek() == '(') stack.pop();
                else return false;
            }
        }
        return stack.empty();
    }
}
