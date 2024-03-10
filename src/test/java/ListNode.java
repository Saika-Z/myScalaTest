/**
 * ************************************************************************************
 * *
 * <p>
 * Project:PACKAGE_NAME
 * ClassName: ListNode
 * Description: test sample ListNode
 * Author: Zhao Wenqing
 * Date:  2024/3/3 09:50
 *************************************************************************************/
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    static ListNode createListNode(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i <arr.length ; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    static void printListNode(ListNode node) {
        ListNode current = node;
        while (current != null) {
            System.out.printf("%d -> ", current.val);
            current = current.next;
        }
        System.out.println("Null");
    }
}
