package jiuzhang.java.elementary;

import java.util.Stack;
//Implement Queue by Two Stacks
public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MyQueue() {
        // do initialization if necessary
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) { //必须理解本质，而不仅仅是顺序步骤操作,本质是倒到有一个stack为空的时候在另一个顶端操作
                                    
        // write your code here
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }
}
