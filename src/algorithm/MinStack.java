package algorithm;

import java.util.Stack;

public class MinStack {

    Stack<Long> stack = null;
    long minValue;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Long>();
    }

    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(0L);
            minValue = x;
        }else {
            stack.push(x-minValue);
            minValue = x < minValue ? x : minValue;
        }

    }

    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        long tmp = stack.pop();
        minValue = tmp < 0 ? minValue - tmp : minValue;
    }

    public int top() {
        long top =  stack.peek();
        return top > 0 ? (int)(top+minValue) : (int)minValue;
    }

    public int getMin() {
        return (int)minValue;
    }


    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        int result = obj.getMin();
        System.out.println(result);
        obj.pop();
        int result2 = obj.getMin();
        System.out.println(result2);

    }

}
