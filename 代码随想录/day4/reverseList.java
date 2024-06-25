package 代码随想录.day4;

import 代码随想录.ListNode;

import java.awt.desktop.AppReopenedListener;
import java.util.List;

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
