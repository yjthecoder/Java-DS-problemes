package jiuzhang.java.elementary;
//Remove Nth Node From End of List
public class RemoveNthNodeFromListEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (n <= 0) {
            return null;  //Note: 从参数入手判断corner case
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        // 加入dummy节点的意义在于每一个元素节点都成为了valid 的‘下一个节点’，dummy.next也起到了表头的作用
        // 这样只需考虑对于指定位置的下一个节点怎么操作就可以了， 就算是原来的head是null也没事，因为并不会用.在其上
        
        ListNode preTarget = dummy;
        for (int i = 0; i < n; i++){
            head = head.next;
        }
        
        while (head.next != null) {
            preTarget = preTarget.next;
            head = head.next;
        }
        
        preTarget.next = preTarget.next.next;
        return dummy.next;
    }    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
