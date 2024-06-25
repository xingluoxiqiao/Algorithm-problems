package 代码随想录.day4;

import 代码随想录.ListNode;

public class removeElementFromLinkList {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0,head);
        if(head == null) return null;
        ListNode pre = dummyNode;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                pre.next = pre.next.next;
            }else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
