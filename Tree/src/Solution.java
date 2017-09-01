public class Solution {

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.right;
        Mirror(root.left);
        root.right = root.left;
        Mirror(temp);
        root.left = temp;
    }
}