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
            if (a == 0)
                workList1 = dummy;
            if (b == 0) {
                workList2 = dummy;
                break;
            }

        }
        if (workList1 == null)
            workList1 = list1;
        workList1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = workList2.next;
        return list1;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        char[] wordChar = word.toCharArray();
        if (wordChar.length > n * m)
            return false;
        int counts[] = new int[256];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                counts[board[i][j]]++;
            }
        }
        int len = wordChar.length;
        for(int i=0; i<len/2; i++)
        {
            if(counts[wordChar[i]]>counts[wordChar[len-1-i]]){
                for(int j=0; j<len/2; j++)
                {
                    char temp = wordChar[j];
                    wordChar[j]=wordChar[len-1-j];
                    wordChar[len-1-j]=temp;
                }
                break;
            }
        }
        for (char c : wordChar) {
            if (--counts[c] < 0)
                return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit(board, wordChar, 0, i, j, n, m, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean visit(char[][] board, char[] word, int start, int x, int y,
            int n, int m, boolean[][] visited) {
        if (start == word.length)
            return true;
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y])
            return false;
        if (word[start] != board[x][y])
            return false;
        visited[x][y] = true;
        boolean found = visit(board, word, start + 1, x + 1, y, n, m, visited)
                || visit(board, word, start + 1, x - 1, y, n, m, visited)
                || visit(board, word, start + 1, x, y + 1, n, m, visited)
                || visit(board, word, start + 1, x, y - 1, n, m, visited);
        visited[x][y] = false;
        return found;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        int index = 0, count = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            while (index <= i && mp.size() > k) {
                if (mp.get(nums[i]) == 1) {
                    mp.remove(nums[i]);
                } else {
                    mp.put(nums[i], mp.get(nums[i]) - 1);
                }
                index += 1;
            }
            System.out.printf("index:%d|i:%d\n", index, i);
            count += (i - index + 1);
        }
        System.out.printf("result : %d\n", count);
        return count;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] arr1 = new int[200];
        int[] arr2 = new int[200];

        for (int i = 0; i < s.length(); i++) {
            if (arr1[s.charAt(i)] != arr2[t.charAt(i)])
                return false;
            arr1[s.charAt(i)] += 1;
            arr2[t.charAt(i)] += 1;
        }
        return true;
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
         * if (head.next == null || head.next.next == null)
         * return;
         * ListNode slow = head;
         * ListNode fast = head.next.next;
         * while (fast != null && fast.next != null) {
         * slow = slow.next;
         * fast = fast.next.next;
         * }
         * fast = null;
         * ListNode curr = slow.next;
         * while (curr != null) {
         * ListNode temp1 = curr.next;
         * curr.next = fast;
         * fast = curr;
         * curr = temp1;
         * }
         * slow.next = fast;
         * fast = head;
         * slow = slow.next;
         * curr = slow;
         * ListNode temp2 = fast.next;
         * ListNode temp1 = slow.next;
         * while (fast.next != curr) {
         * temp2 = fast.next;
         * temp1 = slow.next;
         * fast.next = slow;
         * slow.next = temp2;
         * fast = temp2;
         * slow = temp1;
         * }
         * fast.next = slow;
         * // Your runtime beats 88.69 % of java submissions
         * // Your memory usage beats 10.03 % of java submissions (48.7 MB)
         */
    }

}
