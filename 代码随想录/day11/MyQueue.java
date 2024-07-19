package 代码随想录.day11;

import java.util.Stack;

public class MyQueue {
    //push使用
    Stack<Integer> stack1;
    //pop使用，所有元素都在这里
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack1.push(x);
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        return stack2.pop();
    }

    public int peek() {
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
