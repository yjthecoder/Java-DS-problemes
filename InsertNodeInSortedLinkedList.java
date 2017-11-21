package jiuzhang.java.elementary;
//Insert Node in Sorted Linked List 
public class InsertNodeInSortedLinkedList {
    public ListNode insertNode(ListNode head, int val) {
        // write your code here
// *Note: merge edge case in general solution after testing
//        if (head == null) {
//            newNode.next = head;
//            return newNode;
//        }
        // make new node
        ListNode newNode = new ListNode(val);
        
        //add dummy node
        ListNode oldHead = head;
        ListNode preHead = new ListNode(0); // dummy
        preHead.next = head;
        
        while (head != null) {
            if (val < head.val) {
                //insert before head
                newNode.next = head;
                preHead.next = newNode;
                break;
            }
            preHead = preHead.next;
            head = head.next;
        }
        //traverse and insert at right place
        
        //no insert while traversing means insert at end
        preHead.next = newNode;
        
        //insert at beginning or not
        return newNode.next == oldHead ? newNode : oldHead;
    }
    
    
    // *Note: 头结点思想，更加简洁
    public ListNode insertNode2(ListNode head, int val) { 
        ListNode node = new ListNode(val);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy; // 强行把head往前挪一个，这样在首元素结点前面插入就不是特例了
        
        // find the last element <= val， 使得head执向插入位置之前一个节点，或者最后一个节点
        // *Node: 取反建立循环条件方法get!! move the head until it reaches last node or the first node bigger than val
        while (head.next != null && head.next.val <= val) {
            head = head.next;
        }
        //*Note：链表总是后插容易，故而设置前面dummy节点，使得头节点的前插变成dummy的后插
        node.next = head.next;
        head.next = node;
        
        return dummy.next;
    }
    
    
    

}
