package 代码随想录;

import java.util.Scanner;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }

    public static void toString(ListNode node){
        StringBuilder sb = new StringBuilder();
        while(node != null){
            sb.append(node.val);
            if(node.next != null){
                sb.append("->");
            }
            node = node.next;
        }
        System.out.println(sb.toString());
    }
    public static ListNode arrayToLinkedList(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] vals = input.substring(1,input.length() - 1).split(",");
        ListNode head = new ListNode(Integer.parseInt(vals[0]));
        ListNode realHead = head;
        ListNode dummyHead = new ListNode(0,realHead);
        for(int i = 1; i < vals.length; i++){
            ListNode cur = new ListNode(Integer.parseInt(vals[i]));
            head.next = cur;
            head = cur;
        }
        ListNode.toString(dummyHead.next);
        return realHead;
    }

}
