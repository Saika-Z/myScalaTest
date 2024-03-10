import java.util.*;

/**
 * ************************************************************************************
 * *
 * <p>
 * Project:PACKAGE_NAME
 * ClassName: runTestCode
 * Description: test runCode
 * Author: Zhao Wenqing
 * Date:  2024/1/21 09:09
 *************************************************************************************/
public class runTestCode {

    public static void main(String[] args) {
        /*
         * ArrayList<String> arrayList = new ArrayList<String>();
         * arrayList.add("cha");
         * arrayList.add("r");
         * arrayList.add("act");
         * arrayList.add("ers");
         * int size = new testSolution().maxLength(arrayList);
         * int [][] name = new int[][]{{0,1,0},{1,1,1},{0,1,0}};
         * int numSubmatrixSumTarget = new testSolution().numSubmatrixSumTarget(name,
         * 0);
         * int [] intn = new int []{0,1,0};
         * int fin = new testSolution().subarraySum(intn, 1);;
         */
        /*TreeNode treeNode = TreeNode.mkTree("1,2,3,4,5");
        ArrayList<Integer> integers1 =new TreeNode().beforeTraverse(treeNode);
        ArrayList<Integer> integers2 =new TreeNode().afterTraverse(treeNode);
        ArrayList<Integer> integers3 =new TreeNode().sequenceTraverse(treeNode);
        System.out.printf("前序: %s\n",integers1.toString());
        System.out.printf("后序: %s\n",integers2.toString());
        System.out.printf("层序: %s\n",integers3.toString());*/
        //int score = new testSolution().bagOfTokensScore(new int[]{26}, 51);
        ListNode listNode = ListNode.createListNode(new int[]{3, 2, 0, -1});
        System.out.println(new testSolution().hasCycle(listNode));



       /* ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        ListNode.printListNode(listNode);

        ListNode listNode1 = new testSolution().removeNthFromEnd(listNode, 2);
        ListNode.printListNode(listNode1);*/
    }

}
