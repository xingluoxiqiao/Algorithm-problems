package 代码随想录.day05;

import 代码随想录.ListNode;

public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while(p != q){
            p = p == null? headB : p.next;
            q = q == null? headA : q.next;
        }
        return p;
    }
}
