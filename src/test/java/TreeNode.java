import java.util.ArrayList;

/**
 * ************************************************************************************
 * *
 * <p>
 * Project:PACKAGE_NAME
 * ClassName: TreeNode
 * Description: create and test treeNode
 * Author: Zhao Wenqing
 * Date:  2024/2/27 11:13
 *************************************************************************************/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    public String toString() {
        return Integer.toString(val);
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    private static int[] StrToIntArray(String str) {
        // str = str.substring(1, str.length()-1 );
        String[] strs = str.split(",");
        int[] arr = new int[strs.length];

        for (int i = 0; i < arr.length; i++) {
            if (strs[i].equals("null")) {
                arr[i] = Integer.MAX_VALUE;
            } else {
                arr[i] = Integer.parseInt(strs[i]);
            }
        }

        return arr;
    }

    static TreeNode mkTree(String str) {

        int[] arr = StrToIntArray(str);
        TreeNode[] nodes = new TreeNode[arr.length + 1];
        for (int i = 1; i < nodes.length; i++) {
            if (arr[i - 1] != Integer.MAX_VALUE) {
                nodes[i] = new TreeNode(arr[i - 1]);
            } else {
                nodes[i] = null;
            }
        }

        TreeNode node = null;
        for (int i = 1; i < nodes.length / 2; i++) {
            node = nodes[i];
            if (node == null) continue;
            node.left = nodes[2 * i];
            node.right = nodes[2 * i + 1];
        }
        return nodes[1];
    }

    //前序遍历（根->左->右）
    public ArrayList<Integer> beforeTraverse(TreeNode treeNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (treeNode == null) {
            arrayList.add(null);
        } else if (treeNode.left == null && treeNode.right == null) {
            arrayList.add(treeNode.val);
        } else {
            arrayList.add(treeNode.val);
            arrayList.addAll(beforeTraverse(treeNode.left));
            arrayList.addAll(beforeTraverse(treeNode.right));
        }
        return arrayList;
    }

    //后序遍历（左->右->根）
    public ArrayList<Integer> afterTraverse(TreeNode treeNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (treeNode == null) arrayList.add(null);
        else if (treeNode.left == null && treeNode.right == null)
            arrayList.add(treeNode.val);
        else {
            arrayList.addAll(afterTraverse(treeNode.left));
            arrayList.addAll(afterTraverse(treeNode.right));
            arrayList.add(treeNode.val);
        }
        return arrayList;
    }

    //层序遍历
    public ArrayList<Integer> sequenceTraverse(TreeNode treeNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<TreeNode> nodes = new ArrayList<>();
        nodes.add(treeNode);
        arrayList.add(treeNode.val);
        while (nodes.size() > 0) {
            ArrayList<TreeNode> subNodes = new ArrayList<>();
            for (TreeNode value : nodes) {
                if (value.left != null || value.right != null){
                    if(value.left!=null){
                        subNodes.add(value.left);
                        arrayList.add(value.left.val);
                    }else arrayList.add(null);
                    if (value.right!=null){
                        subNodes.add(value.right);
                        arrayList.add(value.right.val);
                    }else arrayList.add(null);
                }
            }
            nodes = subNodes;
        }
        return arrayList;
    }

}
