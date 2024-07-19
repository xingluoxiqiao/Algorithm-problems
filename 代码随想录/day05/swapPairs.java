package 代码随想录.day05;

import 代码随想录.ListNode;

public class swapPairs {
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode temp = second.next;
        second.next = head;
        head.next = swapPairs(temp);
        return second;
    }

    public static void main(String[] args) {
        ListNode realHead = ListNode.arrayToLinkedList();
        ListNode res = swapPairs(realHead);
        ListNode.toString(res);
    }


}
