package 代码随想录.day04;

import 代码随想录.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyLinkedList {
    int size;
    ListNode dummyHead;

    public MyLinkedList() {
        dummyHead = new ListNode(0);
        size = 0;
    }

    public int get(int index) {
        if(index < 0 || index > size - 1) return -1;
        ListNode cur = dummyHead;
        for(int i = 0; i <= index; i++){
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size) return;
        size++;
        ListNode pre = dummyHead;
        for(int i = 0; i < index; i++){
            pre = pre.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index > size - 1) return;
        size--;
        if(index == 0) {
            dummyHead = dummyHead.next;
            return;
        }
        ListNode pre = dummyHead;
        for(int i = 0; i < index; i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = dummyHead.next;
        while(cur != null){
            sb.append(cur.val);
            if(cur.next != null){
                sb.append(" -> ");
            }
            cur = cur.next;
        }
        return sb.toString();
    }
































    public static void main(String[] args) {
        // 示例输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入操作名称数组，例如：[\"MyLinkedList\", \"addAtHead\", \"addAtTail\", \"addAtIndex\", \"get\", \"deleteAtIndex\", \"get\"]");
        String operationsInput = scanner.nextLine();

        System.out.println("请输入参数数组，例如：[[], [1], [3], [1, 2], [1], [1], [1]]");
        String paramsInput = scanner.nextLine();

        // 解析后的结果
        String[] operations = parseOperations(operationsInput);
        int[][] params = parseParams(paramsInput);

        MyLinkedList linkedList = null;

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "MyLinkedList":
                    linkedList = new MyLinkedList();
                    System.out.println("Initialize MyLinkedList");
                    break;
                case "addAtHead":
                    linkedList.addAtHead(params[i][0]);
                    System.out.println(linkedList.toString());
                    break;
                case "addAtTail":
                    linkedList.addAtTail(params[i][0]);
                    System.out.println(linkedList.toString());
                    break;
                case "addAtIndex":
                    linkedList.addAtIndex(params[i][0], params[i][1]);
                    System.out.println(linkedList.toString());
                    break;
                case "get":
                    int value = linkedList.get(params[i][0]);
                    System.out.println(linkedList.toString());
                    break;
                case "deleteAtIndex":
                    linkedList.deleteAtIndex(params[i][0]);
                    System.out.println(linkedList.toString());
                    break;
            }
        }
    }


    public static String[] parseOperations(String operationsInput) {
        // 去掉首尾的方括号和双引号，按逗号分割
        operationsInput = operationsInput.substring(1, operationsInput.length() - 1).replace("\"", "");
        return operationsInput.split(", ");
    }

    public static int[][] parseParams(String paramsInput) {
        // 去掉首尾的方括号
        paramsInput = paramsInput.substring(1, paramsInput.length() - 1);
        List<int[]> paramsList = new ArrayList<>();

        // 按每组参数进行分割
        String[] paramsGroups = paramsInput.split("],");
        for (String group : paramsGroups) {
            group = group.replace("[", "").replace("]", "").trim();
            if (group.isEmpty()) {
                paramsList.add(new int[]{});
            } else {
                String[] numbers = group.split(", ");
                int[] paramArray = new int[numbers.length];
                for (int i = 0; i < numbers.length; i++) {
                    paramArray[i] = Integer.parseInt(numbers[i]);
                }
                paramsList.add(paramArray);
            }
        }

        // 转换为int[][]数组
        int[][] params = new int[paramsList.size()][];
        for (int i = 0; i < paramsList.size(); i++) {
            params[i] = paramsList.get(i);
        }
        return params;
    }
    public static void printResult(String[] operations, int[][] params) {
        // 打印操作名数组
        System.out.print("String[] operations = {");
        for (int i = 0; i < operations.length; i++) {
            System.out.print("\"" + operations[i] + "\"");
            if (i < operations.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("};");

        // 打印参数数组
        System.out.print("int[][] params = {");
        for (int i = 0; i < params.length; i++) {
            System.out.print("{");
            for (int j = 0; j < params[i].length; j++) {
                System.out.print(params[i][j]);
                if (j < params[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("}");
            if (i < params.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("};");
    }
}
