package jiuzhang.java.elementary;
//Reverse Linked List 

// Analysis, all the single list nature is the node only contain information of its next
// if you need its previous, you need to use a separate dummy node to keep track of it (moving along with it)

// when re-wiring the node, the KEY is whenever you want to rewire something, make sure it got stored else where if you want
// to use it later

// mentally check the last node to avoid edge cases
public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode prev = null;
        ListNode curNext = null;
        
        while (head != null) { //this means the last node will be processed by the loop body
            curNext = head.next; // prepare re-wiring
            head.next = prev; // do the re-wiring
            prev = head; // prepare for the next node, *Note that head and head.next are different fields, 
                         // change one but the other remain old value, even when they belong to the same node
            head = curNext;
        }
        
        return prev;
    }
    
    public ListNode reverse2(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
