import java.util.*;

/**
 * ************************************************************************************
 * *
 * <p>
 * Project:PACKAGE_NAME
 * ClassName: testSolution
 * Description: test Method
 * Author: Zhao Wenqing
 * Date:  2024/1/31 10:26
 *************************************************************************************/
public class testSolution {

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return head;
        int sum = 0;
        ListNode current = head;
        while (current != null) {
            sum += current.val;
            if (sum == 0)
                return removeZeroSumSublists(current.next);
            current = current.next;
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }

    public String mySubstring(Integer[] arr, String s) {
        if (arr.length == 0 || arr[0] == null) return "";
        int max = 0, min = arr[0];
        for (Integer integer : arr) {
            if ((integer != null) && integer > max) max = integer;
            if ((integer != null) && integer < min) min = integer;

        }
        return s.substring(min, max + 1);
    }


}
