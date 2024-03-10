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

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = head.next;
            fast = head.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
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
