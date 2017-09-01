/**
 * Created by hahaha.
 */

public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode tn = reConstructBinaryTree(pre, in);
        print(tn);
    }

    static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int pStart, int pEnd, int[] in, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[pStart]);

        for (int i = iStart; i <= iEnd; i++) {
            if (in[i] == root.val) {
                root.left = reConstructBinaryTree(pre, pStart + 1, pStart + i - iStart, in, iStart, i - 1);
                root.right = reConstructBinaryTree(pre, pStart + i + 1 - iStart, pEnd, in, i + 1, iEnd);
                break;
            }
        }

        return root;
    }

    private static void print(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        print(treeNode.left);
        System.out.print(treeNode.val + " ");
        print(treeNode.right);
    }
}
