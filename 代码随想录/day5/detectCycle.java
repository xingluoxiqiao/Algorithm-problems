package 代码随想录.day5;

import 代码随想录.ListNode;

public class detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                ListNode node1 = slow;
                ListNode node2 = head;
                while(node1 != node2){
                    node1 = node1.next;
                    node2 = node2.next;
                }
                return node1;
            }
        }
        return null;
    }
}
