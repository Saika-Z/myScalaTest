import java.util.*;

/**
 * ************************************************************************************
 * *
 * <p>
 * Project:PACKAGE_NAME
 * ClassName: runTestCode
 * Description: test runCode
 * Author: Zhao Wenqing
 * Date: 2024/1/21 09:09
 *************************************************************************************/
public class runTestCode {

    public static void main(String[] args) {
        /*
         * TreeNode treeNode = TreeNode.mkTree("1,2,3,4,5");
         * ArrayList<Integer> integers1 =new TreeNode().beforeTraverse(treeNode);
         * ArrayList<Integer> integers2 =new TreeNode().afterTraverse(treeNode);
         * ArrayList<Integer> integers3 =new TreeNode().sequenceTraverse(treeNode);
         * ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
         * ListNode.printListNode(listNode);
         * ListNode listNode1 = new testSolution().removeNthFromEnd(listNode, 2);
         * ListNode.printListNode(listNode1);
         * System.out.printf("前序: %s\n",integers1.toString());
         * System.out.printf("后序: %s\n",integers2.toString());
         * System.out.printf("层序: %s\n",integers3.toString());
         */
        // ListNode l1 = ListNode.createListNode(new int[]{0, 1, 13, 6, 9, 5});
        // ListNode l2 = ListNode.createListNode(new int[]{1000000,1000001,1000002});
        // ListNode listNode = new testSolution().mergeInBetween(l1, 3, 4, l2);
        // ListNode.printListNode(listNode);
        // new testSolution().numSubarraysWithSum(new int[]{0,0,0,0,0},0);
        char[][] arc= new char [][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
       boolean s = new testSolution().exist(arc,"ABCCED");
    }

}
