package jiuzhang.java.elementary;

import java.util.List;
import java.util.ArrayList;

public class LinkedListToArrayList {
    public List<Integer> toArrayList(ListNode head) {
        // write your code here
        List<Integer> al = new ArrayList<Integer>();        
        while (head != null) { //*Note the difference of head.next == null v.s. head == null
            al.add(head.val);
            head = head.next;
        }
        return al;
    }
}
