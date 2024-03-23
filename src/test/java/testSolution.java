import java.util.*;

/**
 * ************************************************************************************
 * *
 * <p>
 * Project:PACKAGE_NAME
 * ClassName: testSolution
 * Description: test Method
 * Author: Zhao Wenqing
 * Date: 2024/1/31 10:26
 *************************************************************************************/
public class testSolution {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0, list1);
        ListNode workList1 = null, workList2 = null;
        b += 1;
        while (dummy.next != null) {
            a -= 1;
            b -= 1;
            dummy = dummy.next;
            if (a == 0) workList1 = dummy;
            if (b == 0) {
                workList2 = dummy;
                break;
            }

        }
        if (workList1 == null) workList1 = list1;
        workList1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = workList2.next;
        return list1;
    }

    public String mySubstring(Integer[] arr, String s) {
        if (arr.length == 0 || arr[0] == null)
            return "";
        int max = 0, min = arr[0];
        for (Integer integer : arr) {
            if ((integer != null) && integer > max)
                max = integer;
            if ((integer != null) && integer < min)
                min = integer;

        }
        return s.substring(min, max + 1);
    }

    public void reorderList(ListNode head) {
        ListNode current = head;

        List<Integer> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        arr.add(head.val);
        int i = 1, j = list.size() - 1;
        while (i <= j) {
            arr.add(list.get(j));
            if (i != j)
                arr.add(list.get(i));
            i += 1;
            j -= 1;

        }

        for (int k = 1; k < arr.size(); k++) {
            head.next = new ListNode(arr.get(k));
            head = head.next;
        }
        // Your runtime beats 10.79 % of java submissions
        // Your memory usage beats 99.35 % of java submissions (46.6 MB)
        /*
          if (head.next == null || head.next.next == null)
                      return;
                  ListNode slow = head;
                  ListNode fast = head.next.next;
                  while (fast != null && fast.next != null) {
                      slow = slow.next;
                      fast = fast.next.next;
                  }
                  fast = null;
                  ListNode curr = slow.next;
                  while (curr != null) {
                      ListNode temp1 = curr.next;
                      curr.next = fast;
                      fast = curr;
                      curr = temp1;
                  }
                  slow.next = fast;
                  fast = head;
                  slow = slow.next;
                  curr = slow;
                  ListNode temp2 = fast.next;
                  ListNode temp1 = slow.next;
                  while (fast.next != curr) {
                      temp2 = fast.next;
                      temp1 = slow.next;
                      fast.next = slow;
                      slow.next = temp2;
                      fast = temp2;
                      slow = temp1;
                  }
                  fast.next = slow;
                  // Your runtime beats 88.69 % of java submissions
                  // Your memory usage beats 10.03 % of java submissions (48.7 MB)
*/
    }

}
