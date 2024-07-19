package 代码随想录.day04;

import 代码随想录.ListNode;

public class reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp;
        ListNode cur = head;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
