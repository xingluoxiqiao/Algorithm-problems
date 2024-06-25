package 代码随想录.day5;

import 代码随想录.ListNode;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Scanner;

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
