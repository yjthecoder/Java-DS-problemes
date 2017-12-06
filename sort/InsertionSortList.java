package jiuzhang.java.elementary.sort;
//173. Insertion Sort List
//Sort a linked list using insertion sort.

public class InsertionSortList {
    
    //fist try
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);  //dummy.next always points to current head
        dummy.next = head;
        ListNode cur = head.next;
        ListNode preCur = head;
        
        while (cur != null) {
            ListNode preScan = dummy;   // preScan and scan always starts from the beginning
            ListNode scan = dummy.next; //bug three
            while (scan.val <= cur.val && scan != cur) {
                preScan = preScan.next;
                scan = scan.next;
            }
            
            if (scan != cur) {     //bug two
                preScan.next = cur;
                preCur.next = cur.next;
                cur = cur.next;
                preScan.next.next = scan;
                continue;
            }
            
            preCur = preCur.next;
            cur = cur.next;
        }
        return dummy.next; // bug one
    }
    //Linked List general key points
    //1. if pre insert needed, always keep a pointer pointing at the previous node
    //2. make sure the rewiring is done before the shift of pointer of interest
    //3. 
    
    //general code practice
    //1. always write the general cases
    //2. always consider the inner loop
    //3. mapping visual to code, need to double check the pre and post condition
    //  ask your self, is the code express the status I described?
    
    
}
