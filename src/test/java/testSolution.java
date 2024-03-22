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

}
