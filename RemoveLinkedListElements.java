package jiuzhang.java.elementary;
//Remove Linked List Elements
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        // write your code here
//        if (head == null) {
//            return null;
//        }
        // 上面的corner case merge 进了 general solution， 因为加了dummy，首元素操作已经不再是特例
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next; //当跨过当前元素之后，head已经指在了下一个测试目标之前了，无需在向后移动！
            } else {
                head = head.next;  // *Note: 这里错了之前，每一次循环之后，要保证head总是指向要检测元素的前一个
            }
        }
        //*Note: 这里插入一段对循环的分析，刚刚出循环时候必定是循环条件第一次不满足的时候
        // 对于这题也就是， head此时指向最后一个元素，也就是最后一个元素之前的元素都被循环体处理过了！
        
        return dummy.next;
    }
}
