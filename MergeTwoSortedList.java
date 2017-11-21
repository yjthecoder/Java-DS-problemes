package jiuzhang.java.elementary;
// Merge Two Sorted Lists
public class MergeTwoSortedList {

    //下面的算法是对的，但是有不必要的空间复杂度（多用了储存单元）
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // corner case
        ListNode dummy1 = new ListNode(0);
        dummy1.next = l1;
        l1 = dummy1;
        ListNode dummy2 = new ListNode(0);
        dummy2.next = l2;
        l2 = dummy2;        
        ListNode dummy3 = new ListNode(0);
        ListNode l3 = dummy3;
        
        // *Note: 仅仅读取是不用dummy的，dummy的用途在于把对头结点的前插变成dummy的后插
        while (l1.next != null && l2.next != null) {
            if(l1.next.val <= l2.next.val ) {
                l3.next = l1.next;
                l1 = l1.next;
            } else {
                l3.next = l2.next;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        
        if (l1.next == null) {
            l3.next = l2.next;
        } else {
            l3.next = l1.next;
        }
        return dummy3.next;
    }
    
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // corner case
        ListNode dummy3 = new ListNode(0);
        ListNode l3 = dummy3;
        
        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val ) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        
        if (l1 == null) {
            l3.next = l2;
        } else {
            l3.next = l1;
        }
        return dummy3.next;
    }

}
