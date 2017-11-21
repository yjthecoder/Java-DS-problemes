package jiuzhang.java.elementary;
//Find Node in Linked List 
public class FindNodeInLinkedList {

    public ListNode findNode(ListNode head, int val) {
        // write your code here
        while (head != null) {
            if (head.val == val) {
                ListNode target = new ListNode(val);
                return target;
            }
            head = head.next;  //*Note： 到这里，循环条件肯定是第一次不满足，作为验证的方法！
        }
        
        return null;
    }
    //代码越来越简洁，对control 的把控也越来越好啦！！
    
    // *Note: 理解for loop 本质   for(初始变量设定； 循环体执行条件；执行完循环体必须执行的语句，除了break能跳过)
//    public ListNode findNode(ListNode head, int val) { 
//        for (ListNode node = head; node != null; node = node.next) {
//            if (node.val == val) {
//                return node;
//            }
//        }
//        return null;
//    }
}
