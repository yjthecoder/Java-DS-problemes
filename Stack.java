package jiuzhang.java.elementary;

public class Stack {
    //*Note: good way, it is hard to keep track of previous node, why not operate at the beginning of the list
    // beginning of list is the top of the stack, do push as insert element at the head of list
    // And also use the dummy to make preInsersion of the head to postInsertion of the dummy
    
    class ListNode {
        private int val;
        public ListNode next;
        ListNode(int val){
            this.val = val;
        }        
    }
    
    ListNode dummy;
    
    Stack() {
        dummy = new ListNode(-1); //dummy always point to the head of the list
    }
    
    
    public void push(int x) {
        // write your code here
        ListNode node = new ListNode(x);
        node.next = dummy.next;
        dummy.next = node;
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        dummy.next = dummy.next.next;
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (isEmpty()) {
            return -1;
        }
        return dummy.next.val;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return dummy.next == null;
    }
    
//    
//    //bad way
//    /*
//     * @param x: An integer
//     * @return: nothing
//     */
//    class ListNode {
//        private int val;
//        public ListNode next;
//        ListNode(int val){
//            this.val = val;
//        }
//    }
//    
//    private ListNode dummy, tail;
//    
//    private int size;
//    
//    Stack() {
//        size = 0;
//        dummy = new ListNode(0);
//        tail = null;
//    }
//    
//     
//    public void push(int x) {
//        // write your code here
//        if (this.size == 0) {
//            dummy.next = new ListNode(x);
//            tail = dummy.next;
//        } else {
//            tail.next = new ListNode(x);
//            tail = tail.next;
//        }
//        size++;
//    }
//
//    /*
//     * @return: nothing
//     */
//    public void pop() {
//        // write your code here
//        ListNode preTail = dummy;
//        while (preTail.next.next != null) {     //*Note: this take to much time
//            preTail = preTail.next;
//        }
//        tail = preTail;
//        preTail.next = null;
//        size--;
//    }
//
//    /*
//     * @return: An integer
//     */
//    public int top() {
//        // write your code here
//        if (this.isEmpty()) {
//            return -1;
//        }
//        return tail.val;
//    }
//
//    /*
//     * @return: True if the stack is empty
//     */
//    public boolean isEmpty() {
//        // write your code here
//        return size == 0;
//    }
    
}
