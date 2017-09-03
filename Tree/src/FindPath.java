/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */

import java.util.ArrayList;

public class FindPath {

    private static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode node = new TreeNode();

        node.preOderPrint();
        ArrayList<ArrayList<Integer>> lists = findPath(node, 22);
        System.out.println(lists);
    }

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return lists;
        }

        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            lists.add(new ArrayList<>(list));
        }
        findPath(root.left, target);
        findPath(root.right, target);
        list.remove(list.size() - 1);
        return lists;
    }
}