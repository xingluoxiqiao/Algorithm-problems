package 代码随想录.day05;

import 代码随想录.ListNode;

public class removeNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode fast = head;
        ListNode slow = dummy;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        while (fast != null){
            fast =fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode realHead = ListNode.arrayToLinkedList();
        removeNthFromEnd(realHead,2);
        ListNode.toString(realHead);
    }
}
