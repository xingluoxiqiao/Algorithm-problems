package 代码随想录.day11;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
    int size;
    Queue<Integer> queue;

    public MyStack() {
        size = 0;
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
        size++;
    }

    public int pop() {
        int count = 0;
        while(count < size - 1){
            queue.add(queue.poll());
            count++;
        }
        size--;
        return queue.poll();
    }

    public int top() {
        int count = 0;
        while(count < size - 1){
            queue.add(queue.poll());
            count++;
        }
        int res = queue.poll();
        queue.add(res);
        return res;
    }

    public boolean empty() {
        return size == 0;
    }
}
